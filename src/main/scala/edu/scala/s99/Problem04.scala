package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem04 {
  def length[T](list: List[T]): Int = list match {
    case Nil => 0
    case _ => length(list.tail) + 1
  }
}
