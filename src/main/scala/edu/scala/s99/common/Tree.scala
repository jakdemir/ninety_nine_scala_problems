package edu.scala.s99.common

/**
 * Created by jak on 7/14/17.
 */

class Tree[+T]

case class Node[T](val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T] {
	override def toString = "T(" + elem.toString + " " + left.toString + " " + right.toString + ")"
}

case object Empty extends Tree[Nothing] {
	override def toString = "_"
}

object Node {
	def apply[T](value: T): Node[T] = Node(value, Empty, Empty)
}