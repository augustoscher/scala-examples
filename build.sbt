lazy val sprayVersion = "1.3.6"

lazy val compileDependencies = Seq(
  "io.spray" %% "spray-json" % sprayVersion,
)

lazy val rootSettings = Seq(
  organization := "com.augustoscher",
  scalaVersion := "2.13.10",
  name := "scala-examples",
  libraryDependencies ++= compileDependencies 
)

lazy val root = (project in file("."))
  .settings(rootSettings: _*)
