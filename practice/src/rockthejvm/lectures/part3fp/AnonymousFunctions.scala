package com.practice
package rockthejvm.lectures.part3fp

object AnonymousFunctions extends App {

  //  val doubler = new Function[Int,Int] {
  //    override def apply(x: Int): Int = x*2
  //  }

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  //Multiple parameters
  val adder = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething = () => 3

  // careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (string: String) => string.toInt }

  //MOAR syntactic sugar
  val niceIncrementer : Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
  * 1. MyList: replace all FunctionX calls with lambdas
  * 2- Rewrite the "special adder" as an anonymous function
  * */

  val superAdd=(x: Int) => (y:Int) => x + y
  println(superAdd(3)(4))

}
