name := "knolkart"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

lazy val root = (project in file("."))
  .aggregate(userManagement,inventoryManagement,checkoutManagement,dashboard,apiResources)

lazy val userManagement = (project in file("userManagement")).settings()
lazy val inventoryManagement = (project in file("inventoryManagement")).settings()
lazy val checkoutManagement = (project in file("checkoutManagement")).settings()
lazy val dashboard = (project in file("dashboard")).settings()
lazy val apiResources = (project in file("apiResources"))
  .dependsOn(userManagement)
  .settings()


