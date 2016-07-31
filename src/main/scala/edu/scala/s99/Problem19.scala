package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem19 {

  def rotate(counter: Int, list: List[Symbol]): List[Symbol] = (counter, list) match {
    case (_, Nil) => Nil
    case (0, _) => list
    case (x, head :: tail) if x < 0 => rotate(list.length + counter, list) //no better solution in 
    case (x, head :: tail) if x > 0 => rotate(counter - 1, tail :+ head)
  }

  def main(args: Array[String]) {
    print(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  }
}
