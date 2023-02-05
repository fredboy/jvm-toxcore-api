organization  := "org.toktok"
name          := "tox4j-api"
version       := "0.2.3"
scalaVersion  := "2.12.17"

bintrayVcsUrl := Some("https://github.com/TokTok/jvm-toxcore-api")

resolvers += Resolver.mavenLocal

publishMavenStyle := true
publishM2Configuration := publishM2Configuration.value.withOverwrite(true)

// Build dependencies.
libraryDependencies ++= Seq(
  "org.jetbrains" % "annotations" % "23.1.0"
)

// Test dependencies.
libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.17.0",
  "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0"
) map (_ % Test)

import im.tox.sbt.Scalastyle
Scalastyle.projectSettings
