package edu.scala.s99

/**
 * @author Jak Akdemir
 * @since 7/29/16.
 */
object Problem26 {

  /** Generates k Combinations of given `list` where there are `l!/((l-k)! * k!)` sub-lists
    * @param k number of elements gets selected from list
    * @param list domain for selection of elements         
    * @return List of all possible k selection-list from given domain-list
    *
    * @see   A good article about combinatorial field with optimistic programming http://vkostyukov.net/posts/combinatorial-algorithms-in-scala/
    *
    * @note For Dr. Scheme implementation
    *       https :// lists.racket - lang.org / users / archive / 2005 -June / 009010.html
    *       Give these n objects an order, and then when "generate permutations", only allow "smaller" objects be placed before "bigger" ones.
    *
    *       (define(combinations k nlst)
    *       (cond((zero ? k)
    *       ' (()))
    *       ((null ? nlst)
    *       ' ())
    *       ( else
    *       (append(map(lambda(k - 1)
    *       (cons(car nlst) k -1))
    *       (combinations(-k 1) (cdr nlst)) )
    *       (combinations k (cdr nlst))) ) ) )
    *
    * @example {{{
    *                     kCombinations(3, List(1, 2, 3, 4, 5, 6))
    *                     List(List(1, 2, 3), List(1, 2, 4), List(1, 2, 5) ... List(4, 5, 6))
    *          }}}
    */

  def kCombinations[A](k: Int, list: List[A]): List[List[A]] = {
    if (k == 0) {
      List[List[A]](List())
    } else if (list.isEmpty) {
      List()
    } else {
      kCombinations(k - 1, list.tail).map { (elem: List[A]) => list.head :: elem } ::: kCombinations(k, list.tail)
    }
  }

  def main(args: Array[String]): Unit = {
    print(kCombinations(3, List(1, 2, 3, 4, 5, 6)))
  }
}
