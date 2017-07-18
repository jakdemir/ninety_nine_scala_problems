package edu.scala.s99

/**
 * Created by jak on 7/17/17.
 */
object Sandbox {

	def main(args: Array[String]): Unit = {
		println(List(1, 3, 4).filter((x: Int) => x > 5) reduceLeft (_ + _))

	}
}
