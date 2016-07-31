package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem16 {

  def drop(count: Int, list: List[Symbol]): List[Symbol] = {
    dropInner(count, count, list)
  }

  def dropInner(num: Int, counter: Int, list: List[Symbol]): List[Symbol] = (counter, list) match {
    case (_, Nil) => Nil
    case (1  , _) => dropInner(num, num, list.tail)
    case (_, head :: tail) => head :: dropInner(num, counter - 1, tail)
  } 

  def main(args: Array[String]) {
    print(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}
