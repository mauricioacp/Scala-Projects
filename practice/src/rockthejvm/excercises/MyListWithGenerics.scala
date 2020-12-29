package com.practice
package rockthejvm.excercises

import java.util.NoSuchElementException
//Convariant List
abstract class MyListWithGeneric[+A] {

  /*
   1. head - first element of the list
   2. tails - pointer to remainder of the list
   3.isEmpty - is this list Empty
   4. add(int) - new list with the added element
   5. toString - string representation of the list
    */


  def head: A
  def tails: MyListWithGeneric[A]
  def isEmpty: Boolean
  def add[B >: A](element: B) : MyListWithGeneric[B]
  def printElements : String
  //polymorphic call
  override def toString: String = "[" + printElements + "]"

  //higher order function - functions which take in parameters are functions or return functions
  def map[B](transformer: A=>B):  MyListWithGeneric[B]
  def filter(predicate: A => Boolean) : MyListWithGeneric[A]
  //def flatMap[B](transformer: (A => MyListWithGeneric[B]): MyListWithGeneric[B]
}

object EmptyGeneric extends MyListWithGeneric[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tails: MyListWithGeneric[Nothing] = throw  new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element:B) : MyListWithGeneric[B] = new ConsGeneric(element, EmptyGeneric)
  override def printElements: String = ""
  def map[B](transformer: Nothing => B):  MyListWithGeneric[B] = EmptyGeneric
  def filter(predicate: Nothing => Boolean) : MyListWithGeneric[Nothing] = EmptyGeneric
  //def flatMap[B](transformer: (Nothing => MyListWithGeneric[B]): MyListWithGeneric[B] = EmptyGeneric

}

class ConsGeneric[+A](h: A , t: MyListWithGeneric[A]) extends MyListWithGeneric[A] {
  def head: A = h
  def tails: MyListWithGeneric[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element:B) : MyListWithGeneric[B] = new ConsGeneric(element, this)

  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean) : MyListWithGeneric[A] =
    if(predicate(h)) new ConsGeneric(h , t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B):  MyListWithGeneric[B] =
    new ConsGeneric(transformer(h),t.map(transformer))
}

/*trait  MyPredicate[-T] { // Function1 (T => Boolean)
  def test(element:T) : Boolean
//}

trait MyTransformer[-A,B] { //Function1(A => B)
  def transform( type1: A ) : B
}*/

//}



object classTestGeneric extends App {
  val listOfIntegers: MyListWithGeneric[Int] = new ConsGeneric(1,new ConsGeneric(2,new ConsGeneric(3,EmptyGeneric)))
  val listOfStrings: MyListWithGeneric[String] = new ConsGeneric("Hello", new ConsGeneric("Scala",EmptyGeneric))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

//  println(listOfIntegers.map(Int => Int) = (element : Int) => element * 2 ).toString
  // this can also be written as
  //  println(listOfIntegers.map(elem =>  element * 2 ).toString
  //Even shorter notation
  println(listOfIntegers.map(_ * 2 ).toString)



//  println(listOfIntegers.filter(Int => Boolean) = (element: Int) => element%2 == 0).toString
  //println(listOfIntegers.filter(elem => element%2 == 0).toString
  //println(listOfIntegers.filter(_%2 == 0).toString



}