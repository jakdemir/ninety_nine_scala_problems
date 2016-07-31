package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem15 {

  //*** Direct but expensive solution
  def duplicateN(count: Int, list: List[Symbol]): List[Symbol] = list match {
    case Nil => Nil
    case head :: tail => count match {
      case 0 => Nil
      case _ => head :: duplicateN(count - 1, List(head)) ::: duplicateN(count, tail)
    }
  }
}
