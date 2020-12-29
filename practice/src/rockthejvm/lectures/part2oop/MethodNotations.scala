package com.practice
package rockthejvm.lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is $name and i like $favoriteMovie"

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def learns(thing:String) = s"$name is learning $thing"

    def learnsScala: String = this learns("Scala")

    def apply(times: Int): String = s"${this.name} watched ${this.favoriteMovie} $times times "
  }

  val mary = new Person("Mary", "Inception", 4)
  //Infix notation = operator notation (Syntactic sugar)
  println(mary likes "Inception")
  println(mary.likes("Inception")) //equivalent

  //"Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary.hangOutWith(tom))

  println(1 + 2)
  println(1.+(2)) //same

  //ALL OPERATORS ARE METHODS
  //Akka actors have ! ?

  //Prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  //unary_ prefix only works with - + ~ !

  //same
  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary isAlive)
  println(mary.isAlive)

  //define apply method
  println(mary.apply())
  println(mary())

  /*
  * 1. Overload the + operator
  *   mary + "the rock star" => new person "Mary (the rockstar)"
  *
  * 2. Add and age to the person class default 0 value
  *   Add an unary + operator => new person with the age + 1
  *
  * 3. Add a "learns" method in the person class => Mary learns Scala
  *   Add a learnsScala method, calls learns method with "Scala".
  *   Use it in postFix notation
  *
  * 4. Overload the apply method
  *   mary.apply(2)=> "Mary watched Inception 2 times"
  * */

  //1
  println((mary + "the RockStar") ())
  //2
  println((+mary).age)
  //3
  println(mary learnsScala)
  //4
  println(mary(3))

}
