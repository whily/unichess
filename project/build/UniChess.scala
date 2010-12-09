import sbt._

class UniChess(info: ProjectInfo) extends DefaultProject(info) {
  val scalaToolsSnapshots = ScalaToolsSnapshots

  val scalatest = "org.scalatest" % "scalatest" % "1.2"
  val specs = "org.specs" % "specs" % "1.4.3"
  val scalacheck = "org.scala-tools.testing" % "scalacheck_2.8.0-SNAPSHOT" % "1.7-SNAPSHOT"
}
