package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 7/25/17.
 * min max part from the doc. too late to implement
 */
object Problem60 {

	def minHbalNodes(height: Int): Int = height match {
		case n if n < 1 => 0
		case 1 => 1
		case n => minHbalNodes(n - 1) + minHbalNodes(n - 2) + 1
	}

	def minHbalHeight(nodes: Int): Int =
		if (nodes == 0) 0
		else minHbalHeight(nodes / 2) + 1

	def maxHbalHeight(nodes: Int): Int =
		Stream.from(1).takeWhile(minHbalNodes(_) <= nodes).last

	def nodeCount[T](tree: Tree[T]): Int = tree match {
		case Empty => 0
		case Node(_, left, right) => 1 + nodeCount(left) + nodeCount(right)
	}

	implicit class TreeExt[T](tree: Tree[T]) {
		def hbalTreesWithNodes(count: Int, elem: T): List[Tree[T]] = {
			val maxHeight: Int = maxHbalHeight(count)

			val minHeight: Int = minHbalHeight(count)

			(minHeight to maxHeight).flatMap { height: Int => Problem59.TreeExt(Empty).hbalTrees(height, elem) }
			.filter { (
				p: Tree[T]) =>
				nodeCount(p) == count
			}
			.toList
		}
	}

	def main(args: Array[String]): Unit = {

		print(Empty.hbalTreesWithNodes(15, 'x').length)
	}
}
