package com.practice
package rockthejvm.lectures.part3fp

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + "Is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  //print all combinations between tow lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  //List("a1","a2"..."d4")
  //2 loops is same as = flatmap ... and map
  //iterating
  //  val combinations=numbers.flatMap(n=> chars.map(c=> "" + c + n))
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  //foreach
  list.foreach(println)

  //for-comprehensions
  val forCombinations = for {
    n <- numbers if (n % 2 == 0)
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations) //same as combinations

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1.  MyList supports for comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2.  A small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter
   */



}
