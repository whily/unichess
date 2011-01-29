/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Check for popCount.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
 */

import org.scalatest.junit.JUnit3Suite
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import org.scalacheck.Arbitrary._

import net.whily.unichess.engine.PopCount._

class PopCountSuite extends JUnit3Suite with Checkers {
  def testPopCount() {
    def naivePopCount(x: Long): Long = {
      var count = 0L
      var y = x
      for (i ← 0 until 64) {
        count = count + (y & 1L)
        y = y >> 1
      }
      count
    }

    assert(popCount(-1L) === 64)
    check((x: Long) ⇒ popCount(x) == naivePopCount(x))
  }
}


