package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 8/2/17.
 */
object Problem63 {

	implicit class TreeExt[T](tree: Tree[T]) {
		def completeBinaryTree(nodeCount: Int, value: T): Tree[T] = {
			completeBinaryTreeLevel(nodeCount, value, 1)
		}

		private def completeBinaryTreeLevel(nodeCount: Int, value: T, level: Int): Tree[T] = {
			if (level > nodeCount) {
				Empty
			} else {
				Node(value, completeBinaryTreeLevel(nodeCount, value, Math.pow(2, level).toInt), completeBinaryTreeLevel(nodeCount, value, Math.pow(2, level).toInt + 1))
			}
		}
	}

	def main(args: Array[String]): Unit = {
		println(TreeExt(Empty).completeBinaryTree(4, "x"))
	}

}
