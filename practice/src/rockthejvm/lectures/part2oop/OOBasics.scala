package com.practice
package rockthejvm.lectures.part2oop

import java.util.Date

object OOBasics extends App{

  //at every instantiation all de code block of the class will be executed
//  val person=new Person("John",26)
//  println(person.age)
//  println(person.x)
//  person.greet("Mauricio")


  val author=new Writer("Charles","Dickens",1812)
  val novel=new Novel("Great Expectations",1861,author)

//  println(novel.authorAge)
//  println(novel.isWrittenBy(author))

  val counter =new Counter
  counter.inc.print()
  counter.inc.inc.inc.inc.print()
  counter.inc(10).print()

}
//constructor
class Person (name:String,val age:Int) {
  // body
  val x=2
  println(1+4)

  def greet(name:String):Unit=println(s"${this.name} says: Hi, $name")

  //will refer to the class parameter
  //overloading with different signature
//  def greet():Unit=println(s"Hi i am $name")

  //multiple constructors by overloading
  def this(name:String)=this(name,0)
  def this()=this("John Doe")
//class parameters are NOT FIELDS we need to add keyword val


}


/*
* Novel and a Writer
*
* Writer: first name, surname, year
*   -Method fullname
*
* Novel: name, year of release, author
* -authorAge
* -isWrittenBy(author)
* -copy (new year of release) = new instance of Novel
* */

class Writer(firstName:String,surname:String,val year:Int){

  def showFullName():Unit=println(s"${this.firstName} ${this.surname}")
}

class Novel(val name:String,year:Int,author:Writer){
  def authorAge: Int =year-author.year
  def isWrittenBy(author:Writer): Boolean = author == this.author
  def copy(newYear:Int):Novel=new Novel(name,newYear,author);
}
/*
* Counter class
* -receive an int value
* -method current count
* -method to increment/decrement => new Counter
* -overload inc/dev to receive an amount
* */

class Counter(val count:Int=0){
  def inc=new Counter(count+1) //immutability
  def dec=new Counter(count-1)

  def inc(n:Int):Counter={
    if(n<=0) this
    else inc.inc(n-1)
  }
  def dec(n:Int):Counter={
    if(n<=0) this
    else dec.dec(n-1)
  }

  def print(): Unit =println(count)

}