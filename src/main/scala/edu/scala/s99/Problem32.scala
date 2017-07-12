package edu.scala.s99

/**
 * Created by jak on 7/11/17.
 */
object Problem32 {

	def gcd(a: Int, b: Int): Int = {
		gcdInner(a, b, 2)
	}

	def gcdInner(a: Int, b: Int, current: Int): Int = {
		if (current > math.max(a, b)) {
			1
		} else if (a % current == 0 && b % current == 0) {
			current * gcdInner(a / current, b / current, current)
		} else {
			gcdInner(a, b, current + 1)
		}
	}

	def main(args: Array[String]): Unit = {
		print(gcd(3, 2))
	}

}
