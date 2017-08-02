package edu.scala.s99

import edu.scala.s99.common.{Empty, Node, Tree}

/**
 * Created by jak on 8/2/17.
 */
object Problem62B {

	implicit class TreeExt[T](tree: Tree[T]){
		def atLevel(level: Int) : List[T] = tree match {
			case Empty => Nil
			case Node(value, left, right) => if (level == 1) {
				List(value)
			}else{
				left.atLevel(level - 1) ::: right.atLevel(level - 1)
			}
		}
	}
}
