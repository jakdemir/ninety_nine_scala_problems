package edu.scala.s99

/**
 * Created by jak on 7/11/16.
 */
object Problem11 {
  def encodeModified(list: List[Any]): List[Any] = {
    encodeModifiedInner(Problem10.encode(list))
  }

  private def encodeModifiedInner(list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case (count, letter) :: tail => if (count == 1) List(letter) ::: encodeModifiedInner(tail) else List((count, letter)) ::: encodeModifiedInner(tail)
  }

}
