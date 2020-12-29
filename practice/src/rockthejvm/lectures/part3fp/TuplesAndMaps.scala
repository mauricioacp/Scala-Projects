package com.practice
package rockthejvm.lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  //tuples = finite ordered "lists"
  //val aTuple = Tuple2(2, "Hello, Scala") //Tuple2 [Int,String] = (Int,String)
  val aTuple = (2, "Hello, Scala") //Tuple2 [Int,String] = (Int,String)

  println(aTuple._1) //2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) //("Hello, Scala",2)

  //Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("Daniel" -> 789), ("Jim", 9000)).withDefaultValue(-1)
  //a->b is syntactic sugar for (a,b)
  println(phoneBook)

  //map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary")) //NoSuchElementException if no default value

  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  //functionals on maps
  //map, flatmap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys
  println(phoneBook.filterKeys(x => x.startsWith("J")).toMap)
  //mapValues
  println(phoneBook.mapValues(number => number * 10).toMap)

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
  * 1. What would happen if i had tow original entries "Jim" -> 555 and "JIM" -> 900?
  *
  *   !!! careful with mapping keys
  * 2. Overly simplified social network based on maps
  *   Person = String
  *   - add a person to the network
  *   - remove
  *   - unfriend
  *
  *   -number of friends of a given person
  *   -person with most friends
  *   -how many people have NO friends
  *   -if there is a social connection between 2 people (direct or not)
  * */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  //  println(network)
  //  println(friend(network, "Bob", "Mary"))
  //  println(unfriend(friend(network,"Bob","Mary"),"Bob","Mary"))
  //  println(remove(friend(network,"Bob","Mary"),"Bob"))

  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob")) // 2

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(pair => pair._2.isEmpty)

  //    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(netWork: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person.equals(target)) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ netWork(person))
      }
    }
    bfs(b, Set(), netWork(a) + a)
  }

  println(socialConnection(testNet,"Mary","Jim"))
  println(socialConnection(network,"Mary","Bob"))

}
