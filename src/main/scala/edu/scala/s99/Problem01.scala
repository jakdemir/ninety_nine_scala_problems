package edu.scala.s99

/**
 * Created by jak on 7/1/16.
 *
 * P01 (*) Find the last element of a list.
 * Example:
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8R
 *
 */
object Problem01 {

  def last[T](list: List[T]): T = list match {
    case Nil => throw new Exception("Trying to get last element of emtpy list")
    case head :: Nil => head
    case head :: tail => last(tail)
  }
  
}