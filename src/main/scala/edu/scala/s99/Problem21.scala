package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem21 {

  def insertAt(newSymbol: Symbol, cursor: Int, list: List[Symbol]): List[Symbol] = (cursor, list) match {
    case (_, Nil) => list :+ newSymbol // act over offset as last
    case (0, _) => newSymbol :: list
    case _ => list.head :: insertAt(newSymbol, cursor - 1, list.tail)
  }

  def main(args: Array[String]) {
    print(insertAt('new, 1, List('a, 'b, 'c, 'd)))
  }
}
