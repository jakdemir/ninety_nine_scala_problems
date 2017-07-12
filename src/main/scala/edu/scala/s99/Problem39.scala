package edu.scala.s99

/**
 * Created by jak on 7/12/17.
 */
object Problem39 {
	def listPrimesInRange(list: Range): List[Int] = {
		list.filter { (f: Int) => Problem31.IntImp(f).isPrime }.toList
	}

	def main(args: Array[String]): Unit = {
		print(listPrimesInRange(7 to 31))
	}
}
