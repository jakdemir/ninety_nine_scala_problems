package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem03 {

  def nth[T](n: Int, list: List[T]): T = list match {
    case Nil => throw new Exception("Too deep on list")
    case _ => if (n == 0) list.head else nth(n - 1, list.tail)
  }
}
