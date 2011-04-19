/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Attack maps.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
 */

package net.whily.unichess.engine

import Shift.{eastOne, soutOne, westOne, nortOne}
import Square.Square

trait SimpleAttack {
  private var attacksArray = createAttacksArray()

  def attacks(sq: Square): Long = attacksArray(sq)

  /**
   * Calculate the squares attacked by the piece(s).
   *
   * @param  pieces BitBoard indicating the piece positions (as '1')
   * @return        BitBoard indicating the squares attacked (as '1')
   */
  def attacksCore(pieces: Long): Long

  // Create attack array given the working function.
  private def createAttacksArray(): Array[Long] = {
    val attacksArray = new Array[Long](64)
    for (sq ← 0 until 64) {
      attacksArray(sq) = attacksCore(1L << sq)
    }
    attacksArray
  }
}

object King extends SimpleAttack {
  // Based on http://chessprogramming.wikispaces.com/King+Pattern
  def attacksCore(king: Long): Long = {
    val attacks = eastOne(king) | westOne(king)
    val moreKings = king | attacks
    attacks | nortOne(moreKings) | soutOne(moreKings)
  }
}

object Knight extends SimpleAttack {
  // Based on http://chessprogramming.wikispaces.com/Knight+Pattern
  def attacksCore(knights: Long): Long = {
    var east = eastOne(knights)
    var west = westOne(knights)
    var attacks = (east | west) << 16
    attacks = attacks | ((east | west) >>> 16)
    east = eastOne(east)
    west = westOne(west)
    attacks = attacks | ((east | west) << 8)
    attacks | ((east | west) >>> 8)
  }
}

