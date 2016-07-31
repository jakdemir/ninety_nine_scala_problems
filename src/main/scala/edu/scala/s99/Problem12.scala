package edu.scala.s99

/**
 * Created by jak on 7/26/16.
 */
object Problem12 {
  def decode(encoded: List[(Int, Symbol)]): List[Symbol] = encoded match {
    case Nil => Nil
    case (count: Int, letter: Symbol) :: tail => if (count > 0) {
      letter :: decode((count - 1, letter) :: tail)
    } else {
      decode(tail)
    }
  }

  def main(args: Array[String]) {
    println(decode(List((4, 'a), (2, 'c), (2, 'a), (3, 'e))))
  }
}