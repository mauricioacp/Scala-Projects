package com.practice
package rockthejvm.lectures.part2oop

object Inheritance extends App {

  //single class inheritance
  sealed class Animal{
    val creatureType="Wild"
    def eat=println("nomnom")
  }

  class Cat extends Animal{
    def crunch={
      eat
      println("crunch crunch")
    }
  }
  val cat=new Cat
  cat.crunch

  //Constructors
  class Person (name:String,age:Int){
    def this(name:String)=this(name,0)
  }
  class Adult (name:String,age:Int,idCard:String) extends Person(name)

  //overriding
//  class Dog (override val creatureType :String) extends Animal{
//    override def eat: Unit = println("crunch, crunch")
////    override val creatureType = "Domestic"
//  }

  class Dog (dogType:String) extends Animal{
    override val creatureType: String = dogType
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog=new Dog("K9")
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal:Animal=new Dog("K9")
  unknownAnimal.eat

  //overriding vs Overloading
  //super
  //preventing overrides
  //1 - use final on member
  //2 - use final on the entire class
  //3 - seal the class = extends classes in THIS FILE ONLY prevents extension on other files


}
