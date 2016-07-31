package edu.scala.s99

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class ProblemSuite extends FunSuite {

  trait ListGroup {
    val listNil = Nil
    val list1 = List(1)
    val list2 = List(1, 2)
    val list3 = List(1, 2, 3)
    val listExample1 = List(1, 1, 2, 3, 5, 8)
    val listExample2 = List(1, 2, 3, 2, 1)
    val listExample3 = List(List(1, 1), 2, List(3, List(5, 8)))
    val listExample4 = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val listExample4Encoded = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val listExample5 = List('a, 'b, 'c, 'a, 'd, 'e)
    val listExample6 = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    val listExample7 = List('a, 'b, 'c, 'd, 'e)
    val listExample8 = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd, 'e)
  }

  test("P01: last on Lists") {
    new ListGroup {
      intercept[Exception] {
        Problem01.last(listNil)
      }
      assert(Problem01.last(list1) === 1)
      assert(Problem01.last(list3) === 3)
      assert(Problem01.last(listExample1) == 8)
    }
  }

  test("P02: penultimate on Lists") {
    new ListGroup {
      intercept[Exception] {
        Problem02.penultimate(listNil)
      }
      intercept[Exception] {
        Problem02.penultimate(list1)
      }
      assert(Problem02.penultimate(list2) === 1)
      assert(Problem02.penultimate(list3) === 2)
      assert(Problem02.penultimate(listExample1) == 5)

    }
  }

  test("P03: nth on Lists") {
    new ListGroup {
      intercept[Exception] {
        Problem03.nth(0, listNil)
      }
      intercept[Exception] {
        Problem03.nth(1, list1)
      }
      assert(Problem03.nth(0, list2) === 1)
      assert(Problem03.nth(2, list3) === 3)
      assert(Problem03.nth(2, listExample1) === 2)

    }
  }

  test("P04: length on Lists") {
    new ListGroup {
      assert(Problem04.length(listNil) === 0)
      assert(Problem04.length(list1) === 1)
      assert(Problem04.length(list2) === 2)
      assert(Problem04.length(list3) === 3)
      assert(Problem04.length(listExample1) === 6)
    }
  }


  test("P05: reverse on Lists") {
    new ListGroup {
      assert(Problem05.reverse(listNil) === Nil)
      assert(Problem05.reverse(list1) === List(1))
      assert(Problem05.reverse(list2) === List(2, 1))
      assert(Problem05.reverse(list3) === List(3, 2, 1))
    }
  }

  test("P06: isPalindrome on Lists") {
    new ListGroup {
      assert(Problem06.isPalindrome(listNil) === true)
      assert(Problem06.isPalindrome(list1) === true)
      assert(Problem06.isPalindrome(list2) === false)
      assert(Problem06.isPalindrome(list3) === false)
      assert(Problem06.isPalindrome(listExample2) === true)
    }
  }

  test("P07: flatten on Lists") {
    new ListGroup {
      assert(Problem07.flatten(listExample3) === listExample1)
      assert(Problem07.flatten(listExample3) !== listNil)
      assert(Problem07.flatten(listNil) === listNil)
      assert(Problem07.flatten(list1) === list1)
    }
  }

  test("P08: compress on Lists") {
    new ListGroup {
      assert(Problem08.compress(listExample4) === listExample5)
      assert(Problem08.compress(listNil) === listNil)
      assert(Problem08.compress(list1) === list1)
      assert(Problem08.compress(list2) === list2)
      assert(Problem08.compress(listExample2) === listExample2)
      assert(Problem08.compress(listExample1) === List(1, 2, 3, 5, 8))
    }
  }

  test("P09: pack on Lists") {
    new ListGroup {
      assert(Problem09.pack(listExample4) === listExample6)
      assert(Problem09.pack(listExample5) === List(List('a), List('b), List('c), List('a), List('d), List('e)))
      assert(Problem09.pack(listNil) === listNil)
      assert(Problem09.pack(list1) === List(list1))
    }
  }

  test("P10 encode on Lists") {
    new ListGroup {
      assert(Problem10.encode(listExample4) === List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    }
  }

  test("P11 encodeModified on Lists") {
    new ListGroup {
      assert(Problem11.encodeModified(listExample4) === List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
    }
  }

  test("P12 Decode a run-length encoded list.") {
    new ListGroup {
      assert(Problem12.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
        List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    }
  }

  test("P13 encodeDirect a list.") {
    new ListGroup {
      assert(Problem13.encodeDirect(listExample4) === listExample4Encoded)
    }
  }

  test("P14 Duplicate the elements of a list") {
    new ListGroup {
      assert(Problem14.duplicate(listExample4) === listExample7)
      assert(Problem14.duplicate(listExample8) === listExample7)

    }
  }

  test("P15 Duplicate the elements of a list") {
    new ListGroup {
      assert(Problem15.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
      assert(Problem15.duplicateN(0, Nil) === List())
      assert(Problem15.duplicateN(0, listExample4) === List())
    }
  }

  test("P16 Duplicate the elements of a list") {
    new ListGroup {
      assert(Problem16.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
      assert(Problem16.drop(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List())

    }
  }

  test("P17 Duplicate the elements of a list") {
    new ListGroup {
      assert(Problem17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===(List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i,
        'j, 'k)))
    }
  }

  test("P18 Extract a slice from a list") {
    new ListGroup {
      assert(Problem18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g))
    }
  }

  test("P19 Rotate a list _N_ places to the left.") {
    new ListGroup {
      assert(Problem19.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
      assert(Problem19.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
    }
  }

  test("P20 Remove the _K_th element from a list") {
    new ListGroup {
      assert(Problem20.removeAt(1, List('a, 'b, 'c, 'd)) ===(List('a, 'c, 'd), 'b))
      intercept[NoSuchElementException](Problem20.removeAt(10, List('a, 'b, 'c, 'd)))
      intercept[NoSuchElementException](Problem20.removeAt(10, List()))
    }
  }

  test("P21 Insert an element at a given position into a list") {
    new ListGroup {
      assert(Problem21.insertAt('new, 1, List('a, 'b, 'c, 'd)) === List('a, 'new, 'b, 'c, 'd))
    }
  }

  test("P22 Create a list containing all integers within a given range") {
    new ListGroup {
      assert(Problem22.range(4, 9) === List(4, 5, 6, 7, 8, 9))
      assert(Problem22.range(-2, 2) === List(-2, -1, 0, 1, 2))
      assert(Problem22.range(2, 2) === List(2))
      intercept[Exception](Problem22.range(2, -2))
    }
  }

  test("P23 Extract a given number of randomly selected elements from a list.") {
    new ListGroup {
      assert(Problem23.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)).length === 3)
    }
  }
  test("P24 Lotto: Draw _N_ different random numbers from the set 1.._M_.") {
    new ListGroup {
      assert(Problem24.lotto(6, 49).length === 6)
      assert(Problem24.lotto(6, 49).filter((ball: Int) => ball > 49).length === 0)
    }
  }

  test("P25 Generate a random permutation of the elements of a list") {
    new ListGroup {
      assert(Problem25.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)).length === 6)
    }
  }

  test("P26 Generate the combinations of _K_ distinct objects chosen from the _N_ elements of a list.") {
    new ListGroup {
      assert(Problem26.kCombinations(3, List(1, 2, 3, 4, 5, 6)) === List(List(1, 2, 3), List(1, 2, 4), List(1, 2, 5), List(1, 2, 6), List(1, 3, 4), List(1, 3, 5), List(1, 3, 6), List(1, 4, 5), List(1, 4, 6), List(1, 5, 6), List(2, 3, 4), List(2, 3, 5), List(2, 3, 6), List(2, 4, 5), List(2, 4, 6), List(2, 5, 6), List(3, 4, 5), List(3, 4, 6), List(3, 5, 6), List(4, 5, 6))
      )
    }
  }


}
