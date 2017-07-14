package edu.scala.s99

import scala.annotation.tailrec

/**
 * Created by jak on 7/13/17.
 */
object Problem49 {

	@tailrec
	def grayInner(i: Int, current: Int, accumulate: List[String]): List[String] = {
		if (current == i) {
			accumulate
		} else {
			val cur0: List[String] = accumulate.map { case (code: String) => "0" + code }
			val cur1: List[String] = accumulate.reverse.map { case (code: String) => "1" + code }
			grayInner(i, current + 1, cur0 ::: cur1)
		}
	}

	def gray(i: Int): List[String] = {
		grayInner(i, 1, List("0", "1"))
	}

	def main(args: Array[String]): Unit = {
		print(gray(3))
	}
}
