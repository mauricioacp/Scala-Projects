package com.practice
package rockthejvm.lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 4, 3, 2)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) //index 2
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // :: is a class
  val prepended2 = 42 +: aList :+ // +: infix operator prepending :+ append
    println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("- | -"))

  //arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  //mutation
  numbers(2) = 0 //index 2 //syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  //arrays and sequences
  val numberSequence: Seq[Int] = numbers //implicit conversion
  println(numberSequence)

  //vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  //vectors vs lists

  val maxRuns = 1000
  val maxCapacity=1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times=for{
      it<-1 to maxRuns
    }  yield {
      val currentTime=System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime()-currentTime
    }

    //the average time it takes this collection to be updated
    //at a random index with a random value
    times.sum * 1.0 / maxRuns
  }


  val numbersList=(1 to maxCapacity).toList
  val numbersVector=(1 to maxCapacity).toVector

  /*
  list has the property thaay it saves the reference to the tail
  if it tries to update the first element list is incredibly efficient
  BUT if you try to update an element in the middle of the list it's probably
  not going to be so efficient
  --- Keeps reference to tail ---
  --- updating an element in the middle takes long ---
  */
  println(getWriteTime(numbersList))
  /*
  a vector needs to traverse the whole 32 branch tree an then replace
  that entire chunk.
  --- depth of the tree is small
   */
  println(getWriteTime(numbersVector))

}
