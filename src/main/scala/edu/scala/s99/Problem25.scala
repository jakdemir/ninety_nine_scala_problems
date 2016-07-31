package edu.scala.s99

import Problem23.randomSelect

/**
 * Created by jak on 7/28/16.
 */
object Problem25 {

  def randomPermute(list: List[Symbol]): List[Symbol] = {
    randomSelect(list.length, list)
  }

  def main(args: Array[String]) {
    print(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    //    randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
    //    res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

  }

}
