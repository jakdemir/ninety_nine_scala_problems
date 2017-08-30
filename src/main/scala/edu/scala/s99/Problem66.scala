package edu.scala.s99


object Problem66 {

	//TODO Boring3 http://aperiodic.net/phil/scala/s-99/p65.scala
	sealed abstract class Tree[+T] {
		def bounds: List[(Int,Int)]
		def layoutBinaryTree3: Tree[T] =
			layoutBinaryTree3Internal(bounds.map(_._1).reduceLeft(_ min _) * -1 + 1, 1)
		def layoutBinaryTree3Internal(x: Int, depth: Int): Tree[T]
	}

	case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
		def bounds: List[(Int,Int)] = {
			def lowerBounds = (left.bounds, right.bounds) match {
				case (Nil, Nil) => Nil
				case (lb, Nil)  => lb.map((b) => (b._1 - 1, b._2 - 1))
				case (Nil, rb)  => rb.map((b) => (b._1 + 1, b._2 + 1))
				case (lb, rb) => {
					val shift = lb.zip(rb).map((e) => (e._1._2 - e._2._1) / 2 + 1).reduceLeft(_ max _)
					lb.map(Some(_)).zipAll(rb.map(Some(_)), None, None).map(_ match {
						case (Some((a, b)), Some((c, d))) => (a - shift, d + shift)
						case (Some((a, b)), None)         => (a - shift, b - shift)
						case (None, Some((c, d)))         => (c + shift, d + shift)
						case (None, None) => throw new Exception  // Placate the compiler; can't get here.
					})
				}
			}
			(0, 0) :: lowerBounds
		}
		def layoutBinaryTree3Internal(x: Int, depth: Int): Tree[T] = bounds match {
			case _ :: (bl, br) :: _ => PositionedNode(
				value, left.layoutBinaryTree3Internal(x + bl, depth + 1),
				right.layoutBinaryTree3Internal(x + br, depth + 1), x, depth)
			case _ => PositionedNode(value, End, End, x, depth)
		}
	}


	case class PositionedNode[+T](val value: T, val left: Tree[T], val right: Tree[T], x: Int, y: Int) extends Tree[T] {
		def bounds: List[(Int,Int)] = List()

		def layoutBinaryTree3Internal(x: Int, depth: Int): Tree[T]= {
			PositionedNode(value, left, right, x, y)
		}

		override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
	}

	case object End extends Tree[Nothing] {
		def bounds: List[(Int,Int)] = Nil
		def layoutBinaryTree3Internal(x: Int, depth: Int) = End
	}

	def main(args: Array[String]): Unit = {
		println(Node('a', Node('b', End, Node('c', End, End)), Node('d', End, End)).layoutBinaryTree3)
	}
}
