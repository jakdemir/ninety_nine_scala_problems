package edu.scala.s99

/**
 * Created by jak on 7/8/16.
 */
object Problem09 {
  def pack(list: List[Any]): List[List[Any]] = {
    packTailR(list, List())
  }

  def packTailR(list: List[Any], result: List[List[Any]]): List[List[Any]] = list match {
    case Nil => result
    case head :: tail => result match {
      case List() => packTailR(tail, List(List(head)))
      case _ => if (result.last.contains(head)) packTailR(tail, result.init ::: List(result.last ::: List(head))) else packTailR(tail, result ::: List(List(head)))
    }
  }

  def main(args: Array[String]) {
    print(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
