package edu.scala.s99

object Problem64 {

	sealed abstract class Tree[+T] {
		def layoutBinaryTree: Tree[T] = layoutBinaryTreeInternal(1, 1)._1

		def layoutBinaryTreeInternal(x: Int, depth: Int): (Tree[T], Int)
	}

	case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
		// TODO Boring: http://aperiodic.net/phil/scala/s-99/p64.scala
		def layoutBinaryTreeInternal(x: Int, depth: Int): (Tree[T], Int) = {
			val (leftTree, currentX) = left.layoutBinaryTreeInternal(x, depth + 1)
			val (rightTree, nextX) = right.layoutBinaryTreeInternal(currentX + 1, depth + 1)
			(PositionedNode(value, leftTree, rightTree, currentX, depth), nextX)
		}
	}

	case class PositionedNode[+T](val value: T, val left: Tree[T], val right: Tree[T], x: Int, y: Int) extends Tree[T] {
		def layoutBinaryTreeInternal(x: Int, depth: Int): (Tree[T], Int) = {
			(PositionedNode(value, left, right, x, y), depth)
		}

		override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
	}

	case object End extends Tree[Nothing] {
		def layoutBinaryTreeInternal(x: Int, depth: Int) = (End, x)
	}

	def main(args: Array[String]): Unit = {
		println(Node('a', Node('b', End, Node('c', End, End)), Node('d', End, End)).layoutBinaryTree)
	}
}
