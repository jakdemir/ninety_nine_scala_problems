package edu.scala.s99

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

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


}
