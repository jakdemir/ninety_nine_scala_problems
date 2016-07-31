package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem17 {

  def split(index: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = (index, list) match {
    case (_, Nil) => (Nil, Nil)
    case (0, _) => (Nil, list)
    case (_, head :: tail) => (head :: split(index - 1, tail)._1, split(index - 1, tail)._2)
  }

  def main(args: Array[String]) {
    print(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}
