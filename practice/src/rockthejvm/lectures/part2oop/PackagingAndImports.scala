package com.practice
package rockthejvm.lectures.part2oop

import rockthejvm.playground.{King, Queen => Princess}

import java.util.Date
//import rockthejvm.playground._//
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val writer= new Writer("Mauricio","RockTheJVM",2018)

  //import the package
//  val queen=new rockthejvm.playground.Queen //fully qualified name
  val queen=new Princess

  //packages are in hierarchy
  //matching folder structure in the file system

  //package object
  sayHello()
  println(SPEED_OF_LIGHT)

  //imports
  val king=new King

  // 1. use FQ names
  val date = new Date()
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
