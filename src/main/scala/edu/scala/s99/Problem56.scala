package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 7/17/17.
 */
object Problem56 {

	implicit class TreeExt[T](tree: Tree[T]) {
		def isSymmetric(): Boolean = tree match {
			case Empty => true
			case (node: Node[T]) => isMirror(node.left, node.right)
		}

		def isMirror[T](left: Tree[T], right: Tree[T]): Boolean = (left, right) match {
			case (Empty, Empty) => true
			case (left: Node[T], right: Node[T]) => isMirror(left.left, right.right) && isMirror(left.right, right.left)
			case (_, _) => false
		}
	}

	def main(args: Array[String]): Unit = {

		//print(Node('1', Node('2', Node('3', Node('4'), Empty), Empty), Node('2', Node('3', Node('4', Node('5'), Empty), Empty), Empty)).isSymmetric())

		println(Problem55.cBalancedAll(5, 'x')(0).isSymmetric())
		println(Problem55.cBalancedAll(5, 'x'))

	}

}
