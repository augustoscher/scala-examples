package com.augustoscher

object Maps extends App {

  case class Summary(id: Long, generatedTitle: String, highlight: String)
  val sum1 = Summary(1, "some title", "some summary")
  val sum2 = Summary(2, "some title2", "some summary2")
  val sum3 = Summary(3, "some title3", "some summary3")

  val m1 = Map(1 -> sum1, 2 -> sum2, 3 -> sum3) 

  println(m1.get(2))
  val title2 = m1.get(2).map(_.generatedTitle).getOrElse("") 
  println(title2)

  val title34 = m1.get(34).map(_.generatedTitle).getOrElse("no title found") 
  println(title34)
}
