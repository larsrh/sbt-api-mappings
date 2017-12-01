# sbt-api-mappings

[![Build Status](https://travis-ci.org/larsrh/sbt-api-mappings.svg?branch=fork-3.0.x)](https://travis-ci.org/ThoughtWorksInc/sbt-api-mappings)

**sbt-api-mappings** is an sbt plugin that fills `apiMappings` for common Scala libraries.

_Note:_ This is a fork of [sbt-api-mappings](https://github.com/ThoughtWorksInc/sbt-api-mappings).

## Motivation

Sometimes when you wrote Scaladoc for your own classes, you may want to reference to documentation in some other libraries.

For example:

``` scala
/**
 * My own class, which works with [[scala.Option]] and [[scalaz.Monad]].
 */
class MyClass(optionMonad: scalaz.Monad[Option])
```

Unfortunately when use run `doc` command in Sbt, you will receive a warning and the link would not be created.

```
/path/to/MyClass.scala:3: Could not find any member to link for "scala.Option".
```

This plugin resolves the problem.

### Usage

Add the following lines in your `project/plugins.sbt`:

``` sbt
addSbtPlugin("info.hupel" % "sbt-api-mappings" % "latest.release")
```
