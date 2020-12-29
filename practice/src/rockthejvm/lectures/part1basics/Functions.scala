package com.practice
package rockthejvm.lectures.part1basics

object Functions extends App {

  //:String is the return // = is the implementation
  def aFunction(a:String,b:Int):String = {
    a+" "+b //concatenation
  }

  println(aFunction("Hello",3)) //expression

  def aParamaterlessFunction():Int=42
//  println(aParamaterlessFunction())
//  println(aParamaterlessFunction)

  //recursive function
  //they always need explicit return Type or compiler will complain
  def aRepeatedFunction(aString:String,n:Int):String={
    if(n==1) aString
    else aString + aRepeatedFunction(aString,n-1)
  }

//  println(aRepeatedFunction("hello",3)) //hello hello hello

  //WHEN YOU NEED LOOPS USE RECURSION

  def aFunctionWithSideEffects(aString:String):Unit=println(aString)

  def aBigFunction(n:Int):Int={

      def aSmallerFunction(a:Int,b:Int):Int=a+b //auxiliary function

    aSmallerFunction(n,n-1) //determine the return type of aBigFunction
    //auxiliary stuff...
  }


  /*
  * 1. A greeting function (name,age)=> "Hi, my name is $name and I am $age years old"
  * 2. A factorial function 1 * 2 * 3 .. n //recursive
  * 3. A fibonacci function
  *   f(1)=1
  *   f(2)=1
  *   f(n)=f(n-1) + f(n+2)
  * 4. Test if a number is prime
  * */

  //1
  def greeting(name:String,age:Int): Unit =println(s"Hi my name is ${name} and I am ${age} years old")

  //2
  def factorial(n:Int):Int={
    if(n<=0) 1
    else n * factorial(n-1)
  }

  println(factorial(6)) //720

  //3
  def fibonacci(n:Int):Int={
    if(n<=2) 1 else fibonacci(n-1)+ fibonacci(n-2)
  }

  //1 1 2 3 5 8 13 21
  println(fibonacci(8))

  //4
  def isPrime(n:Int):Boolean={
    //does n have any divisors until t
    def isPrimeUntil(t:Int):Boolean =
      if(t<=1)true //there are no divisors between 2 and 1
      else n % t !=0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println(isPrime(37))
  println(isPrime(37*17))
}

