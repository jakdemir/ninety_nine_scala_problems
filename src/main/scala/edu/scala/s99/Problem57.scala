package edu.scala.s99

import edu.scala.s99.common._

/**
 * Created by jak on 7/18/17.
 */
object Problem57 {

	implicit class TreeExt(tree: Tree[Int]) {
		def addValue(value: Int): Tree[Int] = tree match {
			case Empty => Node(value, Empty, Empty)
			case Node(treeValue, left, right) => if (value > treeValue) {
				Node(treeValue, left, right.addValue(value))
			} else {
				Node(treeValue, left.addValue(value), right)
			}
		}
	}

	def main(args: Array[String]): Unit = {
		println(Empty.addValue(3).addValue(4).addValue(2))
	}

}
