package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 7/25/17.
 */
object Problem59 {

	implicit class TreeExt[T](tree: Tree[T]) {
		def hbalTrees(height: Int, elem: T): List[Tree[T]] = (height, elem) match {
			case (0, _) => List(Empty)
			case (1, _) => List(Node(elem, Empty, Empty))
			//case (2, _) => List(Node(elem, Node(elem, Empty, Empty), Empty), Node(elem, Empty, Node(elem, Empty, Empty)), Node(elem, Node(elem, Empty, Empty), Node(elem, Empty, Empty))) //Yes this is ugly
			case (_, _) =>

				val treeList_1 = hbalTrees(height - 1, elem)
				val treeList_2 = hbalTrees(height - 2, elem)

				treeList_1.flatMap { origin: Tree[T] =>
					treeList_1.map {
						other: Tree[T] => Node(elem, origin, other)
					}
				} ::: treeList_1.flatMap { origin: Tree[T] =>
					treeList_2.flatMap {
						other: Tree[T] => List(Node(elem, origin, other), Node(elem, other, origin))
					}
				}

				//eqHeightTree ::: neqHeightTree

		}
	}

	def main(args: Array[String]): Unit = {
		print(Empty.hbalTrees(3, "x"))
	}
}
