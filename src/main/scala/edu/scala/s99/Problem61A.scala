package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 8/2/17.
 */
object Problem61A {

	implicit class TreeExt[T](tree: Tree[T]) {
		def leafCount(): Int = tree match {
			case Empty => 0
			case Node(_, left, right) => {
				if (left == Empty && right == Empty) {
					1
				} else {
					left.leafCount + right.leafCount
				}
			}
		}
	}

}
