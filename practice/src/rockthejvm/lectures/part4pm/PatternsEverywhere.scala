package com.practice
package rockthejvm.lectures.part4pm

object PatternsEverywhere extends App {

  //big idea #1
  try {

  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  //catches are actually MATCHES
  /*
    try {
      //code
    } catch (e) {
      e match {
      case e:RuntimeException => "runtime"
      case npe:NullPointerException => "npe"
      case _ => "something else"
      }
    }
   */

  //big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ?!
  } yield 10 * x

  //generators are also based on PATTERN MATCHING
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: colon operators, ....

  //big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(a)
  //multiple value definition based on Pattern Matching
  //ALL THE POWER IS AVAILABLE

  val head :: tail = list
  println(head)
  println(tail)

  //big idea #4 - NEW
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal

  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + "is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }


}
