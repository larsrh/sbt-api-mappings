sbtPlugin := true

scalaVersion := "2.12.3"

name := "sbt-api-mappings"

organization := "info.hupel"

description := "A Sbt plugin that fills apiMappings for common Scala libraries."

homepage := Some(url(raw"""https://github.com/ThoughtWorksInc/${name.value}"""))

startYear := Some(2015)

scalacOptions += "-deprecation"

libraryDependencies += "com.thoughtworks.extractor" %% "extractor" % "2.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

scriptedBufferLog := false
