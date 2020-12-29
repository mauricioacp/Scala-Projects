package com.practice
package rockthejvm.lectures.part2oop

object Objects extends App {


  //Scala does not have class level functionality ("static")
  object Person{
    //type + its only instance
    //"static"/"class" - level functionality
    val N_EYES=2
    def canFly:Boolean=false
    //factory method (its purpose is to create person given parameters)
    def apply(mother:Person, father:Person):Person=new Person("Bobbie")
  }
  class Person(val name:String){
    //instance level functionality


  }
  //COMPANIONS (same scope same name)

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = SINGLETON INSTANCE
  val mary=Person
  val john=Person
  println(mary==john) //true

  //Scala class = multiple instances
  val person1=new Person("Mary")
  val person2=new Person("John")
  println(person1==person2) //false

  val bobbie=Person(person1,person2)

  //Scala Applications =Scala object with
  //def main(args:Array[String]):Unit


}
