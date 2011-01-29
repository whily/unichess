/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Test for Attack.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
 */

import org.scalatest.junit.JUnit3Suite

import net.whily.unichess.engine.{King, Knight}
import net.whily.unichess.engine.Square._

class KingAttackSuite extends JUnit3Suite {
  def testKingAttack() {
    assert(King.attacks(A1) === 0x302L)
    assert(King.attacks(C1) === 0xe0aL)
    assert(King.attacks(G2) === 0xe0a0e0L)
    //assert(King.attacks(D5) === 0x1c141c000000L)
  }
}

class KnightAttackSuite extends JUnit3Suite {
  def testKnightAttack() {
    assert(Knight.attacks(A1) === 0x20400L)
    assert(Knight.attacks(B1) === 0x50800L)
    assert(Knight.attacks(C1) === 0xa1100L)
    assert(Knight.attacks(D2) === 0x14220022L)
    //assert(Knight.attacks(E3) === 0x2a4400442aL)
    //assert(Knight.attacks(F4) === 0x508800885000L)
  }
}
