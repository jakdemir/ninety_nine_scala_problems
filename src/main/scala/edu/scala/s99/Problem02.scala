package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem02 {
  def penultimate[T](list: List[T]): T = list match {
    case Nil => throw new Exception("Trying to penultimate a non-penultimate list")
    case head1 :: head2 :: Nil => head1
    case _ => penultimate(list.tail)
  }

  def main(args: Array[String]) {
    print(penultimate(List(4)))
  }
}
