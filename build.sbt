name := """play-api-sample"""
organization := "jp.koty"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.postgresql"       % "postgresql"             % "42.2.18",
  "com.typesafe.play"    %% "play-slick"            % "5.0.0",
  "com.typesafe.play"    %% "play-slick-evolutions" % "5.0.0",
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "jp.oty.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "jp.oty.binders._"
// fork := true // required for "sbt run" to pick up javaOptions

// javaOptions += "-Dplay.editor=http://localhost:63342/api/file/?file=%s&line=%s"