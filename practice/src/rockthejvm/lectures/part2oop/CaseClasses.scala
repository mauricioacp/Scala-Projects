package com.practice
package rockthejvm.lectures.part2oop

object CaseClasses extends App {

  /*
  * Equals, HashCode, toString ...
  * */

  //light weight data holding classes with minimal hustle

  case class Person(name:String,age:Int)

  //1. class parameter are fields
  val jim = new Person("Jim",34)
//  println(jim.name)

  //2. sensible toString
  // println(instance) = println(instance.toString) //syntactic sugar
  println(jim)

  //3. equals and hashCode implemented out of the box
  val jim2=new Person("Jim",34)
  println(jim.equals(jim2))

  //4. Case Classes handy copy method
  val jim3=jim.copy(age=45)
  println(jim3)

  //5. Case Classes have Companion Objects
  val thePerson=Person
  val mary=Person("Mary",25)

  //6. Case Classes are serializable
  //Akka

  //7. Case Classes have extractor patterns = CCs can be used in Pattern Matching
  case object UnitedKingdom{
    def name:String = "The UK of GB and NI"
  }

  /*
  * Expand MyList - use case classes and case Objects
  * */


}
