package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem41 {

	def getGoldbachList(range: Range): List[(Int, (Int, Int))] = {
		range.filter((
			number: Int) => number % 2 == 0).map { case (even: Int) => (even -> Problem40.IntExt(even).goldbach) }.sortBy { case (even: Int, (g1: Int, g2: Int)) => even }
	}.toList

	def printGoldbachList(range: Range): Unit = {
		print(getGoldbachList(range))
	}

	def main(args: Array[String]): Unit = {
		printGoldbachList(9 to 20)
	}
}
