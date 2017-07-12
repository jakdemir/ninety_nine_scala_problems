package edu.scala.s99

/**
 * Created by jak on 7/11/17.
 */
object Problem28 {

	def lsort[A](list: List[List[A]]) : List[List[A]] = {
		list.sortBy{(f: List[A]) => f.size}
	}

	def main(args: Array[String]): Unit = {
		print(lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
	}
}
