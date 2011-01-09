/**
 * Author: 
 *   Yujian Zhang <yujian{dot}zhang[at]gmail(dot)com>
 * Description:
 *   Definition related to bitboard.
 * License: 
 *   GNU General Public License v2
 *   http://www.gnu.org/licenses/gpl-2.0.html
 * Copyright (C) 2010-2011 Yujian Zhang
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
import Square._

// Little endian mapping of files.
object File extends Enumeration {
  type File = Value
  val FileA, FileB, FileC, FileD, FileE, FileF, FileG, FileH = Value
  implicit def fileToInt(x: File): Int = x.id
}
import File._

// Little endian mapping of ranks.
object Rank extends Enumeration {
  type Rank = Value
  val Rank1, Rank2, Rank3, Rank4, Rank5, Rank6, Rank7, Rank8 = Value
  implicit def rankToInt(x: Rank): Int = x.id
}
import Rank._

/// **********************************************************************
/// Position definition.

object Piece extends Enumeration {
  type Piece = Value
  val Occupied, Pawn, Knight, Bishop, Rook, Queen, King = Value
  implicit def pieceToInt(x: Piece): Int = x.id
}
import Piece._

object PieceV {
  val EmptyV  = 0
  val PawnV   = 1
  val KnightV = 3
  val BishopV = 3 
  val RookV   = 5
  val QueenV  = 9
  val KingV   = 99 
}
import PieceV._

object Color extends Enumeration {
  type Color = Value
  val Black, White = Value
  implicit def colorToInt(x: Color) = x.id
}
import Color._

object BitBoard {
  type BitBoard = Long
}
import BitBoard._

/* Bitboards for one side. */
abstract class Pieces {
  val pieces: Array[BitBoard]  // Size is 7
}

/** Defined according to FEN definition in
 *  http://en.wikipedia.org/wiki/Forsyth-Edwads_Notation
 */
abstract class Position {
  var allPieces: Array[Pieces]  // Size is 2
  var activeColor: Color
  var castlingAvailability: Int
  var enPassantTarget: Int
  var halfMoveCloce: Int
  var fullMoveNumber: Int

  def toFEN: String
}


