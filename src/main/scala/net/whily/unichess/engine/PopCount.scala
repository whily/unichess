/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Population count. See
 *     http://chessprogramming.wikispaces.com/Population+Count
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
 */

package net.whily.unichess.engine

object PopCount {
  // Return true if BB is empty.
  def emptyBB(x: Long): Boolean = x == 0L

  // Return true if BB is not empty.
  def notEmptyBB(x: Long): Boolean = x != 0L

  // Return true if population count of BB is 1.
  def singleBB(x: Long): Boolean = (x != 0L) && ((x & (x - 1L)) == 0L)

  // Return true if population count ≤ 1.
  def emptyOrSingleBB(x: Long): Boolean = (x & (x - 1L)) == 0L

  // Return true if population count > 1.
  def twoOrMoreBB(x: Long): Boolean = (x & (x - 1L)) != 0L
  
  // Count the number of 1's in BitBoard. Use SWAR algorithm.
  def popCount(x: Long): Long = {
    val k1 = 0x5555555555555555L
    val k2 = 0x3333333333333333L
    val k4 = 0x0f0f0f0f0f0f0f0fL
    val kf = 0x0101010101010101L
    var y = x
    y = y        - ((y >> 1)  & k1)
    y = (y & k2) + ((y >> 2)  & k2)
    y = (y       +  (y >> 4)) & k4
    (y * kf) >> 56   
  }
}


