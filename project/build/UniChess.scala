/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Configuration for sbt.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
 */

import sbt._

class UniChess(info: ProjectInfo) extends DefaultProject(info) {
  val scalaToolsSnapshots = ScalaToolsSnapshots

  val scalatest = "org.scalatest" % "scalatest" % "1.2"
  val specs = "org.specs" % "specs" % "1.4.3"
  val scalacheck = "org.scala-tools.testing" % "scalacheck_2.8.0-SNAPSHOT" % 
                    "1.8-SNAPSHOT"
}
