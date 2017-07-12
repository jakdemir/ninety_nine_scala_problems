package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem36 {

	implicit class IntExt(i: Int) {
		def primeFactorMultiplicity: List[(Int, Int)] = {
			Problem35.IntExt(i).primeFactors().groupBy { (number: Int) => number
			}.map { case (number: Int, value: List[Int]) => (number, value.size) }.toList.sortBy { case (number: Int,
			count: Int) =>
				1 / count
			}
		}
	}

	def main(args: Array[String]): Unit = {
		print(315.primeFactorMultiplicity)
	}
}
