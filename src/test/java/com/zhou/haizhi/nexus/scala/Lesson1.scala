package com.zhou.haizhi.nexus.scala

import scala.collection.parallel.immutable

object Lesson1 {
  def main(args: Array[String]): Unit = {
    //if
    var a = 3
    if (a < 0) {
      println(s"$a<0")
    } else {
      println(s"$a>0")
    }

    //while
    while (a < 10) {
      a += 1
      println(a)
    }
    println(s"end add ... ")

    //for loop
    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    for (elem <- list) {
      println(elem)
    }

    //获取一个范围数组
    val seqs: Range.Inclusive = 1 to 10
    for (elem <- seqs if elem % 2 == 0) {
      println(elem)
    }
    println(seqs)
    println(seqs.end)

    println("---------------99乘法表------------------")
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        print(s"$i*$j=${i * j}\t")
      }
      println()
    }
    println("---------scala 新写法------")
    for (i <- 1 to 9; j <- 1 to i) {
      print(s"$i*$j=${i * j}\t")
      if (i == j) println()
    }

    //yield回收代码最后的返回值
    val ints = for (i <- 1 to 10) yield {
      var x = 8
      i + x
      //这里可以对数据做一些定制化操作
    }
    println(ints)
  }
}
