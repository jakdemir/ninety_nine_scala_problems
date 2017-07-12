package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem37 {

	implicit class IntExt(i: Int) {
		def totient = {
			Problem36.IntExt(i).primeFactorMultiplicity.foldLeft[Int](1) { case (accumulator: Int, (number: Int, count: Int)) => (number - 1) * Math.pow(number, count - 1).toInt * accumulator }
		}
	}

	def main(args: Array[String]): Unit = {
		print(10.totient)
	}
}
