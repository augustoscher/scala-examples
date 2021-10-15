package com.augustoscher

object Collections extends App {

//  array
val a1 = Array(1, 2, 3, 4, 5, 6)
println(a1(2)) // 3

// map
val a2 = a1 map (_ * 3)

// filter
val a3 = a1.filter(_ % 2 == 0)
val a4 = a1 filter (_ % 2 == 0)

  
}
