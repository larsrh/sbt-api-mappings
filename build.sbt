sbtPlugin := true

organization := "info.hupel"
name := "sbt-api-mappings"

scalacOptions += "-deprecation"

homepage := Some(url("https://github.com/larsrh/sbt-api-mappings"))

licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

libraryDependencies ++= Seq(
  "com.thoughtworks.extractor" %% "extractor" % "2.1.0",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

resolvers += Resolver.sonatypeRepo("releases")

pomExtra := (
  <developers>
    <developer>
      <id>larsrh</id>
      <name>Lars Hupel</name>
      <url>http://lars.hupel.info</url>
    </developer>
    <developer>
      <id>Atry</id>
      <name>杨博</name>
      <timezone>+8</timezone>
      <email>pop.atry@gmail.com</email>
    </developer>
  </developers>
  <scm>
    <connection>scm:git:github.com/larsrh/sbt-api-mappings.git</connection>
    <developerConnection>scm:git:git@github.com:larsrh/sbt-api-mappings.git</developerConnection>
    <url>https://github.com/larsrh/sbt-api-mappings</url>
  </scm>
)


credentials += Credentials(
  Option(System.getProperty("build.publish.credentials")) map (new File(_)) getOrElse (Path.userHome / ".ivy2" / ".credentials")
)

scriptedLaunchOpts += s"-Dproject.version=${version.value}"

scriptedBufferLog := false


// Release stuff

import ReleaseTransformations._

releaseVcsSign := true

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeRelease")
)

publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
