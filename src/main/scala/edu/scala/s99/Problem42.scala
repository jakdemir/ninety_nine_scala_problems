package edu.scala.s99

/**
 * Created by jak on 7/13/17.
 */
object Problem42 {

	def getGoldbachListLimited(range: Range, limit: Int) = {
		Problem41.getGoldbachList(range).filter { case (number: Int, (g1: Int, g2: Int)) => Math.min(g1, g2) > limit }
	}

	def printGoldbachListLimited(range: Range, limit: Int) = {
		print(getGoldbachListLimited(range, limit))
	}

	def main(args: Array[String]): Unit = {
		printGoldbachListLimited(4 to 2000, 50)
	}
}
