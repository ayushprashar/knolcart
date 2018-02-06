name := "knolkart"

version := "0.1"

scalaVersion := "2.12.4"

coverageEnabled := true

lazy val root = (project in file("."))
  .aggregate(userManagement,inventoryManagement,checkoutManagement,dashboard,apiResources)

lazy val userManagement = (project in file("userManagement")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test
)
lazy val inventoryManagement = (project in file("inventoryManagement")).settings(libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17"
,"org.scalatest" %% "scalatest" % "3.0.4" % Test))
lazy val checkoutManagement = (project in file("checkoutManagement")).settings(libraryDependencies ++= Seq())
lazy val dashboard = (project in file("dashboard")).settings(libraryDependencies ++= Seq())
lazy val apiResources = (project in file("apiResources"))
  .dependsOn(userManagement)
  .settings(libraryDependencies ++= Seq())


