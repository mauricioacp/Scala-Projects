package com.practice
package rockthejvm.lectures.part1basics

object ValuesVariablesTypes extends App {

  val x:Int=1000000000
  val aString:String="hello"
  val aBoolean:Boolean=false
  val aCharacter:Char='a'
  val aShort:Short=10000
  val aLong:Long=1000000000000000000L
  //a lot of decimals...
  val aFloat:Float=2.123456F
  val aDouble:Double=3.14

  //variables are inmutables
  var aVariable:Int=4

  aVariable=5//side effects

}
