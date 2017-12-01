libraryDependencies += Defaults.sbtPluginExtra("info.hupel" % "sbt-api-mappings" % (version in ThisBuild).value, (sbtBinaryVersion in update).value, (scalaBinaryVersion in update).value)
