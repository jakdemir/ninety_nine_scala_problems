package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 8/2/17.
 */
object Problem61B {

	implicit class TreeExt[T](tree: Tree[T]) {
		def leaflist(): List[T] = tree match {
			case Empty => Nil
			case Node(value, left, right) => {
				if (left == Empty && right == Empty) {
					List(value)
				} else {
					left.leaflist() ::: right.leaflist()
				}
			}
		}
	}

}
