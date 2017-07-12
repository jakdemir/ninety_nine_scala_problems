package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem40 {

	implicit class IntExt(i: Int) {
		def goldbach = {
			Problem39.listPrimesInRange(1 to i).map { case (current: Int) => if (Problem39.listPrimesInRange(1 to i).contains(i - current) && current <= (i - current)) {
				(current, i - current)
			}
			}.filter(tuple => tuple != ()).head
		}
	}

	def main(args: Array[String]): Unit = {
		print(28.goldbach)
	}
}

