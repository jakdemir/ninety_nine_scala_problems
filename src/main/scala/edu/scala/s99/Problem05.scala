package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem05 {
  def reverse[T](list: List[T]): List[T] = list match {
    case Nil => Nil
    case _ => reverse(list.tail) ::: List(list.head)
  }
}
