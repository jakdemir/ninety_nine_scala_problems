package edu.scala.s99

/**
 * Created by jak on 7/13/17.
 */
object Problem46 {

	def and(a: Boolean, b: Boolean): Boolean = {
		if (a == true) {
			b
		} else {
			a
		}
	}

	def nand(a: Boolean, b: Boolean): Boolean = {
		!and(a, b)
	}

	def or(a: Boolean, b: Boolean): Boolean = {
		if (a == true) {
			true
		} else {
			b
		}
	}

	def not(a: Boolean) = {
		if (a == true) {
			false
		} else {
			true
		}
	}

	def xor(a: Boolean, b: Boolean): Boolean = {
		a != b
	}

	def truth1(a: Boolean, b: Boolean): Boolean = {
		and(a, (or(a, b)))
	}

	def table2(truth: (Boolean, Boolean) => Boolean) = {
		val a: List[Boolean] = List(false, true)
		val res = a.flatMap { case (b: Boolean) => a.map { case (inner: Boolean) => ((b, inner) -> truth(b, inner)) } }
		print(res)
	}

	def main(args: Array[String]): Unit = {
		table2(truth1)
	}
}
