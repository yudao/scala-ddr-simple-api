name := "scala-ddr-simple-api"

version := "1.0"

organization := "net.yudao"

description := "SBT plugin for port the W3C DDR simple api in scala"

scalaVersion := "2.10.0"

sbtVersion := "0.13.0"

logLevel := Level.Warn

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.7" % "test"
)
