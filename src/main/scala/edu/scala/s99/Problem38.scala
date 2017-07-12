package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem38 {
	def main(args: Array[String]): Unit = {
		val P37start = System.nanoTime()
		Problem37.IntExt(100900).totient
		val P37end = System.nanoTime()

		val P34start = System.nanoTime()
		Problem34.IntExt(100900).totient
		val P34end = System.nanoTime()

		print("P34: " + (P34end - P34start) + ", P37: " + (P37end - P37start))
	}
}
