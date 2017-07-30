lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "wheels.airt",
      scalaVersion := "2.12.3",
      version := "0.0.1"
    )),
    name := "dsl-gr",
    scalacOptions ++= Seq("-deprecation"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.3" % Test
    )
  )
