import scala.sys.process._
import scala.language.postfixOps
import sbt.Credentials

lazy val scalm =
  (project in file("scalm"))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalaVersion := "3.0.0",
      version := "0.0.1-SNAPSHOT",
      name := "scalm",
      organization := "davesmith00000",
      libraryDependencies ++= Seq(
        ("org.scala-js" %%% "scalajs-dom" % "1.1.0").cross(CrossVersion.for3Use2_13),
        "org.typelevel" %%% "cats-core"   % "2.6.1"
      ),
      publishTo := sonatypePublishTo.value
    )

lazy val indigoTools =
  (project in file("indigo-tools"))
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalaVersion := "3.0.0",
      name := "indigo-tools",
      scalaJSUseMainModuleInitializer := true,
      scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
    )
    .dependsOn(scalm)

lazy val root =
  (project in file("."))
    .settings(
      code := { "code ." ! }
    )
    .enablePlugins(ScalaJSPlugin)
    .aggregate(scalm, indigoTools)

lazy val code =
  taskKey[Unit]("Launch VSCode in the current directory")

addCommandAlias(
  "buildTools",
  List(
    "compile",
    "indigoTools/fastOptJS"
  ).mkString(";", ";", "")
)
