package edu.scala.s99

/**
 * Created by jak on 7/13/17.
 */
object Problem50 {

	class SymbolFrequency(var symbol: String, var frequency: Int) {
		override def toString: String = {
			s"$symbol:$frequency"
		}
	}

	class Tree[+T]

	case class Node[T](val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T]

	case object Empty extends Tree[Nothing]

	def generateHuffmanTree(list: List[Node[SymbolFrequency]]): Node[SymbolFrequency] = {
		if (list.size == 1) {
			list.head
		} else {
			val sortedList = list.sortBy { case (sf: Node[SymbolFrequency]) => sf.elem.frequency }
			generateHuffmanTree(Node(new SymbolFrequency("", sortedList.head.elem.frequency + sortedList.tail.head.elem.frequency), sortedList.head, sortedList.tail.head) :: sortedList.tail.tail)
		}
	}

	def getSortedFrequencyTree(): List[Node[SymbolFrequency]] = {
		val sfa: Node[SymbolFrequency] = Node(new SymbolFrequency("a", 5), Empty, Empty)
		val sfb: Node[SymbolFrequency] = Node(new SymbolFrequency("b", 9), Empty, Empty)
		val sfc: Node[SymbolFrequency] = Node(new SymbolFrequency("c", 12), Empty, Empty)
		val sfd: Node[SymbolFrequency] = Node(new SymbolFrequency("d", 13), Empty, Empty)
		val sfe: Node[SymbolFrequency] = Node(new SymbolFrequency("e", 16), Empty, Empty)
		val sff: Node[SymbolFrequency] = Node(new SymbolFrequency("f", 45), Empty, Empty)

		val symbolList: List[Node[SymbolFrequency]] = List[Node[SymbolFrequency]](sfa, sfb, sfc, sfd, sfe, sff)
		symbolList.sortBy { case (sf: Node[SymbolFrequency]) => sf.elem.frequency }
	}

	def getSymbolBitInner(symbol: String, tree: Tree[SymbolFrequency], symbolBinary: String): String = tree match {
		case Node(elem, left, right) => if (left == Empty && right == Empty) {
			println(s"symbol: " + elem.symbol + ", symbolBinary: " + symbolBinary)
			symbolBinary
		} else {
			getSymbolBitInner(symbol, left, symbolBinary + "1")
			getSymbolBitInner(symbol, right, symbolBinary + "0")
		}
		case _ => ""
	}

	def getSymbolBit(symbol: String, tree: Tree[SymbolFrequency]): String = {
		getSymbolBitInner(symbol, tree, "")
	}

	def printHuffmanCodingsInner(tree: Tree[SymbolFrequency], symbolBinary: String): String = tree match {
		case Node(elem, left, right) => if (left == Empty && right == Empty) {
			println(s"symbol: " + elem.symbol + ", symbolBinary: " + symbolBinary)
			symbolBinary
		} else {
			printHuffmanCodingsInner(left, symbolBinary + "0")
			printHuffmanCodingsInner(right, symbolBinary + "1")
		}
		case _ => ""
	}

	def printHuffmanCodings(tree: Tree[SymbolFrequency]): String = {
		printHuffmanCodingsInner(tree, "")
	}

	def main(args: Array[String]): Unit = {
		printHuffmanCodings(generateHuffmanTree(getSortedFrequencyTree()))
	}
}
