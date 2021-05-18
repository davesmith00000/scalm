import sbt.Credentials

enablePlugins(ScalaJSBundlerPlugin)

name := "scalm"
organization := "org.julienrf"

Compile / npmDependencies += "snabbdom" -> "0.6.7"
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "1.1.0"
)

scalaVersion := "2.13.6"

publishTo := sonatypePublishTo.value

// scalacOptions ++= Seq("-Xsource:3")

inThisBuild(List(
  licenses := Seq("BSD-3-Clause" -> url("http://opensource.org/licenses/BSD-3-Clause")),
  homepage := Some(url("https://github.com/julienrf/scalm")),
  developers := List(Developer("julienrf", "Julien Richard-Foy", "julien@richard-foy.fr", url("http://julien.richard-foy.fr"))),
  scmInfo := Some(ScmInfo(url("https://github.com/julienrf/scalm"), "scm:git:git@github.com:julienrf/scalm.git")),
  pgpPublicRing := file("./travis/local.pubring.asc"),
  pgpSecretRing := file("./travis/local.secring.asc"),
  pgpPassphrase := sys.env.get("PGP_PASS").map(_.toArray),
  credentials ++= (
    for {
      username <- sys.env.get("SONATYPE_USER")
      password <- sys.env.get("SONATYPE_PASSWORD")
    } yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)
    ).toList
))
