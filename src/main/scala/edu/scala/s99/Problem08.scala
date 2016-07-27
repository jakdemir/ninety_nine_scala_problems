package edu.scala.s99

/**
 * Created by jak on 7/8/16.
 */
object Problem08 {

  def compress[T](list: List[T]):List[T] = {
    compressTailR(list, List())
  }
  
  def compressTailR[T](list: List[T], result: List[T]):List[T] = list match {
    case Nil => result
    case head :: tail => result match {
      case Nil => compressTailR(tail, result ::: List(head))
      case _ => if (result.last == head) compressTailR(tail, result) else compressTailR(tail, result ::: List(head))
    }  
  }

  def main(args: Array[String]) {
    print(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
