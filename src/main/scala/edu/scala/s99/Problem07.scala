package edu.scala.s99

/**
 * Created by jak on 7/7/16.
 */
object Problem07 {
  def flatten(list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case head :: tail => head match {
      case y: List[_] => flatten(y) ::: flatten(tail)
      case _ => head :: flatten(tail)  
    }

  }


  def main(args: Array[String]) {
    print(flatten(List(1, 2, 3) :: List(1, 2)))
  }
}
