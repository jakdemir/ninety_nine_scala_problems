package edu.scala.s99

import edu.scala.s99.common._

/**
 * Created by jak on 7/14/17.
 */
object Problem55 {

	def cBalanced[T](nodeCount: Int, elem: T): Tree[T] = {
		if (nodeCount > 0) {
			Node(elem, cBalanced(nodeCount / 2, elem), cBalanced((nodeCount - 1) / 2, elem))
		} else {
			Empty
		}
	}

	def cBalancedAll[T](nodeCount: Int, elem: T): List[Tree[T]] = {
		if (nodeCount <= 0) {
			List(Empty)
		} else if (nodeCount % 2 == 1) {
			val res = cBalancedAll(nodeCount / 2, elem)
			res.flatMap { case (node: Tree[T]) => res.map(sub => Node(elem, node, sub)) }
		}
		else {
			val res_0 = cBalancedAll((nodeCount - 1) / 2, elem)
			val res_1 = cBalancedAll(((nodeCount - 1) / 2) + 1, elem)

			res_0.flatMap { case (node: Tree[T]) => res_1.flatMap((
				sub: Tree[T]) => List(Node(elem, node, sub), Node(elem, sub, node)))
			}
		}
	}

	def main(args: Array[String]): Unit = {
		println(cBalancedAll(3, "x"))
	}

}
