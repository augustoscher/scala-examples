package com.augustoscher

object CharCounter extends App {
  val text = "Daniela".replaceAll(" ", "").toLowerCase
  val map = text.foldLeft(Map[Char, Int]()) {
    (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
  }
  val sortedArray = map.toArray.sortWith((e1, e2) => (e1._2 < e2._2))
  val mostCommonCharacterTuple = sortedArray(sortedArray.length - 1)
  val result = mostCommonCharacterTuple._1
  println(s"The most common char from $text is: $result")
}