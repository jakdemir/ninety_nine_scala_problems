package edu.scala.s99

/**
 * Created by jak on 7/8/16.
 */
object Problem10 {
  def encode(list: List[Any]): List[Any] = {
    encodeInner(Problem09.pack(list))
  }

  private def encodeInner(list: List[List[Any]]): List[Any] = list match {
    case Nil => Nil
    case head :: tail => (head.length, head.head) :: encodeInner(tail)
  }
}
