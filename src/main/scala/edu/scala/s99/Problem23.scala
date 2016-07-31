package edu.scala.s99

import scala.util.Random


/**
 * Created by jak on 7/28/16.
 */
object Problem23 {
  
  def randomSelect(count: Int, list: List[Symbol]): List[Symbol] = {
    if (count == 0) {
      Nil
    } else {
      val (remainderList, removed) = Problem20.removeAt(Random.nextInt(list.length), list)
      removed :: randomSelect(count - 1, remainderList)
    }

  }

  def main(args: Array[String]) {
    print(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
  }

}
