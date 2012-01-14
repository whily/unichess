/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Definition related to bitboard.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2012 Yujian Zhang
 */

package net.whily.unichess.engine

/// **********************************************************************
/// For details on definitions of square, files and ranks, please refer
///   http://chessprogramming.wikispaces.com/Square+Mapping+Considerations

// Little endian rank-file (LERF) mapping.
object Square extends Enumeration {
  type Square = Value
  val A1, B1, C1, D1, E1, F1, G1, H1,
      A2, B2, C2, D2, E2, F2, G2, H2,
      A3, B3, C3, D3, E3, F3, G3, H3,
      A4, B4, C4, D4, E4, F4, G4, H4,
      A5, B5, C5, D5, E5, F5, G5, H5,
      A6, B6, C6, D6, E6, F6, G6, H6,
      A7, B7, C7, D7, E7, F7, G7, H7,
      A8, B8, C8, D8, E8, F8, G8, H8 = Value
  implicit def squareToInt(x: Square): Int = x.id
}

// Little endian mapping of files.
object File extends Enumeration {
  type File = Value
  val FileA, FileB, FileC, FileD, FileE, FileF, FileG, FileH = Value
  implicit def fileToInt(x: File): Int = x.id
}

// Little endian mapping of ranks.
object Rank extends Enumeration {
  type Rank = Value
  val Rank1, Rank2, Rank3, Rank4, Rank5, Rank6, Rank7, Rank8 = Value
  implicit def rankToInt(x: Rank): Int = x.id
}

// BitBoard shifts.
object Shift {
  private val notAFile  = 0xfefefefefefefefeL
  private val notABFile = 0xfcfcfcfcfcfcfcfcL
  private val notHFile  = 0x7f7f7f7f7f7f7f7fL
  private val notGHFile = 0x3f3f3f3f3f3f3f3fL

  // One step shift, post shift masks.
  // http://chessprogramming.wikispaces.com/General+Setwise+Operations#OneStepOnly
  def soutOne(b: Long): Long = b >>> 8
  def nortOne(b: Long): Long = b <<  8
  def eastOne(b: Long): Long = (b & notHFile) <<  1
  def noEaOne(b: Long): Long = (b & notHFile) <<  9
  def soEaOne(b: Long): Long = (b & notHFile) >>> 7
  def westOne(b: Long): Long = (b & notAFile) >>> 1
  def soWeOne(b: Long): Long = (b & notAFile) >>> 9
  def noWeOne(b: Long): Long = (b & notAFile) <<  7

  // Knight moves: http://chessprogramming.wikispaces.com/Knight+Pattern
  def noNoEa(b: Long): Long = (b & notHFile)  << 17
  def noEaEa(b: Long): Long = (b & notGHFile) << 10
  def soEaEa(b: Long): Long = (b & notGHFile) >>> 6
  def soSoEa(b: Long): Long = (b & notHFile)  >>> 15
  def noNoWe(b: Long): Long = (b & notAFile)  << 15
  def noWeWe(b: Long): Long = (b & notABFile) << 6
  def soWeWe(b: Long): Long = (b & notABFile) >>> 10
  def soSoWe(b: Long): Long = (b & notAFile)  >>> 17
}

/// **********************************************************************
/// Position definition.

object Piece extends Enumeration {
  type Piece = Value
  val Occupied, Pawn, Knight, Bishop, Rook, Queen, King = Value
  implicit def pieceToInt(x: Piece): Int = x.id
}
import Piece.Piece

// In unit of centipawns.
object PieceV {
  val EmptyV  = 0
  val PawnV   = 100
  val KnightV = 300
  val BishopV = 300
  val RookV   = 500
  val QueenV  = 900
  val KingV   = 9900 
}

object Color extends Enumeration {
  type Color = Value
  val Black, White = Value
  implicit def colorToInt(x: Color) = x.id
}
import Color.Color

/* Bitboards for one side. */
abstract class Pieces {
  val pieces: Array[Long]  // Size is 7
}

/**
 * Defined according to FEN definition in
 *  http://en.wikipedia.org/wiki/Forsyth-Edwads_Notation
 */
abstract class Position {
  var allPieces: Array[Pieces]  // Size is 2
  var activeColor: Color
  var castlingAvailability: Int
  var enPassantTarget: Int
  var halfMoveClock: Int
  var fullMoveNumber: Int

  def toFEN: String
}


