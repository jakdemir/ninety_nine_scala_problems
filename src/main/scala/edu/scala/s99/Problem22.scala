package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem22 {
  def range(start: Int, end: Int): List[Int] = {
    if (start == end) {
      List(start)
    } else if (start < end) {
      start :: range(start + 1, end)
    } else {
      throw new Exception("Start shouldn't be bigger then end")
    }
  }

  def main(args: Array[String]) {
    print(range(4, 9))
    //    scala&gt; range(4, 9)
    //    res0: List[Int] = List(4, 5, 6, 7, 8, 9)
  }
}
