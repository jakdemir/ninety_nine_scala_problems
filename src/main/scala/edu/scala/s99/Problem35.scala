package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem35 {

	implicit class IntExt(i: Int) {
		def primeFactors(): List[Int] = {
			primeFactorsInner(i, 2)
		}

		private def primeFactorsInner(goal: Int, current: Int): List[Int] = {
			if (current > goal) {
				Nil
			} else if (goal % current == 0) {
				current :: primeFactorsInner(goal / current, current)
			} else {
				primeFactorsInner(goal, current + 1)
			}
		}
	}

	def main(args: Array[String]): Unit = {
		print(315.primeFactors())
	}

}
