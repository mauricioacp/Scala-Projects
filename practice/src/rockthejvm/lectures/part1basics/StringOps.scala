package com.practice
package rockthejvm.lectures.part1basics

object StringOps extends App {

  val str:String="Hello, i am learning Scala"
  //Java functions available on Scala
  //str.charAt(2)
  //str.substring(7,11)
  //str.split(" ").toList
  //str.startsWith("Hello") //boolean
  //str.replace(" ","-")
//  println(str.toLowerCase())
//  println(str.length())

  //Scala Utilities
  val aNumberString="45"
  println(aNumberString.toInt)
  //pre appending //post appending
//  println('a'+:aNumberString:+'z')
//  println(aNumberString.reverse)
//  println(aNumberString.take(1))

  //Scala specific: String interpolator

  //S-Interpolator
  val name="Mauricio"
  val age=12
  val greeting=s"Hello, my name is $name and i am $age years old"
  val anotherGreeting=s"Hello, my name is $name and i am ${age+1} years old"

  //F-Interpolator
  val speed=1.2f
  //2 decimals precision
  val myth=f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-Interpolator //back slashes will be printed as string
  println(raw"This is a \n newline")
  val escaped="This is a \n newline"
  //Printed on two lines
  println(raw"$escaped")




}
