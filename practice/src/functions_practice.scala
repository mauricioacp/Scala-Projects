package com.practice

object functions_practice extends App {


  //List
  val a1=Seq(1,2,3) //creating a list
  val a2=a1.appended(4) //returns a new list // a1 keeps inmutable
  val a3=a1:+5//appended alias
  //Best practice
  val a4=a1:+(6)//appended alias - menos syntactic sugar
  val b=a1 appended 4 //other way we can add parenthesis (4)

  //anonymous function
  (x:Int)=>x*x

  //Set
  val c1=Set(1,2,3)
  val c2=c1.incl(4)//adding element returns a new Immutable Set
  val c3=c1+4 //friendlier syntax
  c2(4)//Boolean... like contains returns true or false if its found on the Set

  //Map
  val m1=Map((1,"Hola"))
  val m2=Map(1->"Hola") //Simplified syntax for calling Map structure
  val m3=m1+(2->"Hello") //Add new entry returns a new Map
  //view is lazy way of looking into values
  val m4=m2.view.mapValues(s=>s+"!")
  m4.foreach(println)

  //Map function
  c2.map(x=>x+1)//normal map

  //Tuples
  val tupleEx=(1,"Tor",false)

  case class Persona(id:Int,name:String,active:Boolean)

  val example:Persona=Persona.tupled(tupleEx)






//  def isGreater(a: Int): Int =>  Boolean = {
//    (b: Int) =>
//      a < b
//  }
//
//  val f = isGreater(10)
//  f(20)
}
