package edu.scala.s99

/**
 * Created by jak on 7/28/16.
 */
object Problem20 {

  def removeAt(index: Int, list: List[Symbol]): (List[Symbol], Symbol) = (index, list) match {
    case (_, Nil) => throw new NoSuchElementException("List is empty or you tried to out of index")
    case (0, head :: tail) => (tail, head)
    case (_, head :: tail) => (head :: removeAt(index - 1, tail)._1, removeAt(index - 1, tail)._2) //Efficiency vs Simplicity - Direct function
  }

  def main(args: Array[String]) {
    print(removeAt(1, List('a, 'b, 'c, 'd)))
  }
}
