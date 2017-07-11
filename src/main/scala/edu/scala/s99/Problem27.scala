package edu.scala.s99

/**
 * Created by jak on 7/10/17.
 */
object Problem27 {

	def group[A](ints: List[Int], itemList: List[A]): List[List[List[A]]] = {
		if (ints.isEmpty) {
			List[List[List[A]]](List())
		} else {
			Problem26.kCombinations(ints.head, itemList).flatMap { (elem: List[A]) =>
				group(ints.tail, itemList.diff(elem)).map {(bigger: List[List[A]]) => elem :: bigger}
			}
		}
	}

	def main(args: Array[String]): Unit = {
		print(group(List(2, 3), List(1, 2, 3, 4, 5)))
	}

}
