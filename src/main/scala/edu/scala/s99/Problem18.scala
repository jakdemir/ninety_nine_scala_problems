package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem18 {

  def slice(start: Int, end: Int, list: List[Symbol]): List[Symbol] = (start, end, list) match {
    case (_, _, Nil) => Nil
    case (_, 0, _) => Nil
    case (0, _, head :: tail) => head :: slice(start, end - 1, tail)
    case (_, _, head :: tail) => slice(start - 1, end - 1, tail)
  }

  def main(args: Array[String]) {
    print(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //res0: List[Symbol] = List('d, 'e, 'f, 'g)
  }

}
