package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem06 {
  def isPalindrome[T](list: List[T]): Boolean = {
    Problem05.reverse(list) == list
  }
}
