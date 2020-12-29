package com.practice
package rockthejvm.lectures.part3fp

object WhatsAFunction extends App {

  //DREAM: use functions as first class elements
  //problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  //function types =Function1[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  //  val adder:Function2[Int,Int,Int]= new Function2[Int,Int,Int] {
  //    override def apply(a: Int, b: Int): Int = a+b
  //  }
//  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //Function types Function2[A,B,R] === (A,B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  * 1.a function which takes 2 strings and concatenates them
  * 2. transform the MyPredicate and MyTransformer into function types
  * 3. define a function which takes an int and returns another function which takes an int and returns an int
  *   -what's the type of this function
  *   -how to do it
  * */

  val concatenator: (String, String) => String = (a: String, b: String) => a + b

  val anotherConcatenator: Function2[String, String, String]= new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

//  val predicate:Function1[Any,Boolean]=new Function[Any,Boolean]{
//    override def apply(v1: Any): Boolean =
//  }

  //Function1[Int, Function1[Int,Int]]
  val specialFunction:(Int) => ((Int) => Int)= (x: Int) => (y: Int) => x + y

  val superAdder:Function1[Int,Function1[Int,Int]]=new Function1[Int,Function1[Int,Int]]{
    override def apply(x: Int): Int => Int = new Function1[Int,Int] {
      override def apply(y: Int): Int = x+y
    }
  }

  val adder= superAdder(3)
  println(adder(4))
  println(superAdder(3)(4)) // curried function

  //We want to work with functions:
  // pass functions as parameters
  // use functions as values

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}