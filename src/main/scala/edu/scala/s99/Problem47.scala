package edu.scala.s99

import edu.scala.s99.Problem46.{table2}

/**
 * Created by jak on 7/13/17.
 */
object Problem47 {

	implicit class BooleanExt(a: Boolean) {
		def or(b: Boolean) = {
			Problem46.or(a, b)
		}

		def and(b: Boolean) = {
			Problem46.and(a, b)
		}

		def not(a: Boolean) = {
			Problem46.not(a)
		}

		def truth2(a: Boolean, b: Boolean) = {
			a and (a or not(b))
		}

	}

	def main(args: Array[String]): Unit = {
		//ugly
		table2(true.truth2)
	}

}
