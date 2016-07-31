package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem14 {
  def duplicate(list: List[Symbol]): List[Symbol] = {
    duplicateInner(list, List())
  }

  def duplicateInner(list: List[Symbol], acc: List[Symbol]): List[Symbol] = list match {
    case Nil => acc.reverse
    case head :: tail => if (acc.contains(head)) {
      duplicateInner(tail, acc)
    } else {
      duplicateInner(tail, head :: acc)
    }
  }
}
