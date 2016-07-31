package edu.scala.s99

import scala.util.Random

/**
 * Created by jak on 7/28/16.
 */
object Problem24 {

  // Duplicates are NOT ok
  def lotto(count: Int, range: Int): List[Int] = {
    lottoInner(count, range, List())
  }

  def lottoInner(count: Int, range: Int, results: List[Int]): List[Int] = {
    if (count > 0) {
      val random = Random.nextInt(range)
      if (results.contains(random)) {
        lottoInner(count, range, results)
      } else {
        lottoInner(count - 1, range, random :: results)
      }
    } else {
      results
    }
  }

  def main(args: Array[String]) {
    print(lotto(6, 49))
    //    scala&gt; lotto(6, 49)
    //    res0: List[Int] = List(23, 1, 17, 33, 21, 37)
  }
}
