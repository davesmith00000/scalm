lazy val root = (project in file("."))
  .dependsOn(scalm)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := "3.0.0",
    name := "mario",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
lazy val scalm = ProjectRef(file("../.."), "scalm")
