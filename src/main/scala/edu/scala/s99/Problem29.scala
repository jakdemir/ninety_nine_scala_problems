package edu.scala.s99

/**
 * Created by jak on 7/11/17.
 */
object Problem29 {

	def lsortFreq[A](list: List[List[A]]): List[List[A]] = {
		list.groupBy { (f: List[A]) => f.size
		}.toList.sortBy { case (count: Int, sublist: List[List[A]]) => sublist.length }.flatMap { case (count: Int, sublist: List[List[A]]) => sublist }
	}

	def main(args: Array[String]): Unit = {
		print(lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
	}
}
