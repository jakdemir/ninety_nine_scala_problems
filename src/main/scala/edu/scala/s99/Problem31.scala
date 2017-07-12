package edu.scala.s99

/**
 * Created by jak on 7/11/17.
 */

object Problem31 {

	implicit class IntImp(i: Int) {
		def isPrime = {
			primeInner(i, 2)
		}

		def primeInner(i: Int, next: Int): Boolean = {
			if (i < 2) {
				false
			} else if (next >= i) {
				true
			} else {
				!(i % next == 0) && primeInner(i, next + 1)
			}
		}
	}

	def main(args: Array[String]): Unit = {

		print(1.isPrime)
	}
}
