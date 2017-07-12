package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem33 {

	implicit class IntExt(x: Int) {
		def isCoprimeTo(y: Int): Boolean = {
			Problem32.gcd(x, y) == 1
		}
	}

	def main(args: Array[String]): Unit = {
		print(6.isCoprimeTo(4))
	}
}
