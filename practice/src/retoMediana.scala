package com.practice

import scala.util.Random

object retoMediana extends App {


  //Crear un grupo de funciones para hallar la media, la mediana y la moda de una lista de números
  //devolviendo la respuesta dentro de un tipo map

  var numberList = List(5, 4, 7, 12, 45, 1, 3, 4, 6, 8, 10)

  def media(lista: List[Int]): Int = sum(lista)/lenght(lista)

  def sum(list: List[Int]): Int = {
    if (list.isEmpty) 0
    else list.head + sum(list.tail)
  }

  def lenght(list: List[Int]): Int = {
    def calculate(list: List[Int], acc: Int=1): Int = {
      if (list.isEmpty) 0
      else acc + calculate(list.tail,1)
    }
    calculate(list)
  }


  def mediana(seq: Seq[Int]): Int = {
    val sortedSeq = seq.sortWith(_ < _)

    if (seq.size % 2 == 1) sortedSeq(sortedSeq.size / 2)
    else {
      val (up, down) = sortedSeq.splitAt(seq.size / 2)
      (up.last + down.head) / 2
    }
  }

//  def media = (size: Int, length: Int) => size / length

  println(media(numberList))


}


