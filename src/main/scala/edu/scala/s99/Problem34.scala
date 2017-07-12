package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem34 {

	implicit class IntExt(i: Int) {
		def totient: Int = {
			1.to(i).filter { f: Int => Problem33.IntExt(i).isCoprimeTo(f) }.size
		}
	}

	def main(args: Array[String]): Unit = {
		print(6.totient)
	}
}
