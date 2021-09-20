package com.augustoscher

object Basics extends App {

  // defining constant (cant reassign)
  val aInt: Int = 500 // const int aInt = 500; (java)
  val aTest = 40

  // don't need type
  val aBool = true

  // string and string interpolation
  val aString = "I love scala"
  val aComposedString = s"Somebody says: $aString"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3
  val ifExpression = if (aTest >= 40) 41 else 39
  val chainedIfExpression =
    if (aTest > 43) 44
    else if (aTest > 44) 45
    else if (aTest > 500) 501
    else 0

  // code blocks
  val aCodeBlock = {
    val aLocalValue = 4
    // value for entire block is the value of the last expression
    aLocalValue + 3
  }
  println(aCodeBlock) // 7

  // functions
  def myFunc(s: String, y: Int): String = s"The value of s is: $s and y is: $y"
  println(myFunc("xunda", 10))

  def myFunc2(s: String, y: Int): String = {
    s"The value of s is: $s and y is: $y"
  }
  println(myFunc2("xunda2", 11))

  // recursive
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)
  /*
    factorial(5) = 5 * factorial(4) = 5 * 24 = 120
    factorial(4) = 4 * factorial(3) = 4 * 6 = 24
    factorial(3) = 3 * factorial(2) = 3 * 2 = 6
    factorial(2) = 2 * factorial(1) = 2 * 1 = 2
    factorial(1) = 1
   */
  println(factorial(5))

  // Unit type = no meaningful value. Is the same of void of Java
  // println("") returns Unit type value
  // Type of side effects
  def funcReturningVoid(): Unit  = {
    println("xunda")
  }
  funcReturningVoid()

  val theUnit = ()
  println(theUnit) // like void

  def isValidUrl(url: String): Boolean = {
    val isValid = url.length <= 10
    if(!isValid)
      println("Invalid URL")

    isValid
  }

  val isValidURL = isValidUrl("iasudhaiudhaiudhiuasdhauidhaiudhaid")
  println(isValidURL)
  println(isValidUrl("iasudha"))
}
