package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem40 {

	implicit class IntExt(i: Int) {
		def goldbach: (Int, Int) = {
			Problem39.listPrimesInRange(1 to i).foldLeft[List[(Int, Int)]](Nil) { (accumulator: List[(Int, Int)],
				current: Int) =>
				if (i > 2 && Problem39.listPrimesInRange(1 to i).contains(i - current) && current <= (i - current)) {
					accumulator ::: List((current, i - current))
				} else {
					accumulator
				}
			}.head
		}
	}

	def main(args: Array[String]): Unit = {
		print(28.goldbach)

	}

}
