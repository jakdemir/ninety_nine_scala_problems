package edu.scala.s99

/**
 * Created by jak on 7/26/16.
 */
object Problem13 {
  def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = {
    encodeDirectInner(list, List())
  }

  def encodeDirectInner(list: List[Symbol], result: List[(Int, Symbol)]): List[(Int, Symbol)] =
    list match {
      case Nil => result
      case head :: tail => result match {
        case Nil => encodeDirectInner(tail, (1, head) :: result)
        case _ => if (result.last._2 == head) {
          encodeDirectInner(tail, result.init ::: List((result.last._1 + 1, result.last._2)))
        } else {
          encodeDirectInner(tail, result ::: List((1, head)))
        }
      }
    }

  def main(args: Array[String]) {
    print(Problem13.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }
}
