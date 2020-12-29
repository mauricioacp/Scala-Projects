package com.practice
package rockthejvm.lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Computing factorial of ${n} - i fist need factorial of ${n + 1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of ${n}")
      result
    }
  }

  //  println(factorial(5000))//stackoverflow
  //this is how we achieve the iteration vs recursion in FP
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //Tail Recursion
    }

    factHelper(n, 1)
  }

  //  println(anotherFactorial(5000))

  //When you need loops use tail recursion

  /*
  * 1. Concatenate a string n times
  * 2. Is Prime function tail recursive
  * 3. Fibonacci tail recursive
  * You need as many accumulators as you have recursive calls on your code path
  * you can use 1 or more accumulators
  * */

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)

  //  println(concatenateTailRec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    }

    isPrimeTailRec(n / 2, isStillPrime = true)
  }

//  println(isPrime(2003))
//  println(isPrime(629))

  def fibonacci(n:Int):Int={
    @tailrec
    def fibTailRec(i:Int, last:Int, nextToLast:Int):Int=
      if(i>=n)last
      else fibTailRec(i+1,last+nextToLast,last)

    if(n<=2)1
    else fibTailRec(2,1,1)

  }

  //Call by value
  //Value x Is computed before call, same value used everywhere
  def myFunction(x:Int):Unit=println(x)

  //Call by value
  //Expression is passed literally
  //Expression is evaluated at every use within function definition
  calledByName(System.nanoTime())


  def calledByName(x: =>Long):Unit={
    println(s"by name ${x}")
    println(s"by name ${x}")
  }


  println(factorial(10,2))
  println(factorial(10))
  @tailrec
  //Default arguments
  def factorial(x:Int, acc:Int=1):Int = {
    if(x<=1)acc
    else factorial(x-1,x*acc)
  }


}




















