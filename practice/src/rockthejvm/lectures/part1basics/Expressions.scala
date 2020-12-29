package com.practice
package rockthejvm.lectures.part1basics

object Expressions extends App {

  val x=1+2 //Expression

  // + - * / & | ^ << >> >>> (right shift with zero extension)
  // == != > >= < <=
//  println(!(1==x))

  var aVariable= 2
  aVariable+=3 //also works with -= *= /= ...side effects
  println(aVariable)

  //Instructions (DO) vs Expressions (Value)

  //If expression
  val aCondition= true
  val aConditionValue=if(aCondition) 5 else 3 //expression
//  println(aConditionValue)

  //NEVER WRITE THIS AGAIN THIS IS IMPERATIVE PROGRAMMING
  var i = 0
  while (i<10){ //UNIT
//    println(i)
    i+=1
  }

  //Everything in scala is an Expression!

  val aWeirdValue= (aVariable=3) //Unit == void //nothing meaningfull
  println(aWeirdValue)

  //side effects: println(), whiles, reassigning // return Unit

  //Code Blocks

  val aCodeBlock= { //is an expression //reduced scope
    val y=2
    val z=y+1

    if(z>2) "hello" else "goodbye" //the last expression assigns the value

  }

  //Instructions are executed (think java) expressions are evaluated (Scala)

  //1. Difference between "hello world" (String) vs println("hello world") -> side effect (Unit)

  //2.
  val someValue={ //boolean
    2<3
  }

  val someOtherValue={ //Int //42
    if(someValue) 239 else 986 //irrelevant
    42
  }



}
