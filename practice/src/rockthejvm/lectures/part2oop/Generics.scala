package com.practice
package rockthejvm.lectures.part2oop

object Generics extends App {

  class MyList[A]{
    //use the type A
    def add[B>:A](element:B):MyList[B]= ???
    /*
    * A=Cat
    * B=Dog=Animal
    * */
  }
  class MyMap[Key,Value]

  val listOfIntegers=new MyList[Int]
  val listOfStrings=new MyList[String]

  //generic Methods
  object MyList{
    def empty[A]:MyList[A]= ???
  }
  val emptyListOfIntegers=MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1.- yES -> List[Cat] extends List[Animal]
  class CovariantList[+A]
  val animal:Animal=new Cat
  val animalList:CovariantList[Animal]=new CovariantList[Cat]
  // animalList.add(new Dog) === HARD QUESTION => we return a list of animals

  //2. no = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList:InvariantList[Animal]=new InvariantList[Animal]

  //3.- Hell, no! CONTRAVARIANCE //No sense
  class ContravariantList[-A]
  val contravariantList:ContravariantList[Cat]=new ContravariantList[Animal]
  //better
  class Trainer[-A]
  val trainer:Trainer[Cat]=new Trainer[Animal]

  //bounded Types //only accepts variant A subtypes of Animal
  //lower bounded type something which is a super type of ...
  //class Cage[A>:Animal](animal:A)
  class Cage[A<:Animal](animal:A)
  val cage=new Cage(new Dog)

  //even if compiler doesn't complain it won't run
  class Car
  //generic type need proper bounded type
//  val newCage=new Cage(new Car)

  //expand MyList to be generic

}
