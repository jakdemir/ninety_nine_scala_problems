package edu.scala.s99

import edu.scala.s99.common._

/**
 * Created by jak on 7/18/17.
 */
object Problem58 {

	implicit class TreeExt[T](tree: Tree[T]) {
		def symmetricBalancedTrees(count: Int, elem: T): List[Tree[T]] = {
			Problem55.cBalancedAll(count, elem).filter((elem: Tree[T]) => Problem56.TreeExt(elem).isSymmetric())
		}
	}

	def main(args: Array[String]): Unit = {
		println(Empty.symmetricBalancedTrees(5, 'x'))
	}
}
