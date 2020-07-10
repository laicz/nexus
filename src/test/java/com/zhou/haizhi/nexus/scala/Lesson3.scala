package com.zhou.haizhi.nexus.scala

import java.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Lesson3 {
  def main(args: Array[String]): Unit = {

    //集合
    val arrayList = new util.ArrayList[String]()
    arrayList.add("");

    //数组
    val ints = Array(1, 2, "ddd")
    println(ints(1))
    ints(1) = 99
    println(ints(1))

    //数组加类型约定
    val ints2 = Array[Int](1, 23)

    //链表
    //scala中collections中有两个包：immutable(不可变),multable(可变),默认是immutable
    val list = List(1, 2, 3, 4, 5)
    println("----------for loop----------")
    for (elem <- list) {
      println(elem)
    }
    println("----------for each---------")
    list.foreach(println)

    println(s"2 +: list = ${2 +: list}")
    println(s"list +: 3 = ${2 +: list}")

    val douleInt = List(77, 88)
    println(s"list ++: doubleInt = ${list ++: douleInt}")
    println(s"list :++ doubleInt = ${list ++: douleInt}")

    //可变链表
    val list02 = new ListBuffer[Int]()
    list02.+=(11)
    list02.+=(12)
    list02.+=(13)
    println("-------mutable list-----")
    list02.foreach(println)

    // set
    println("---------------set--------------")
    //默认不可变
    val set01 = Set(1, 2, 3)
    set01.foreach(println)
    var b = set01 + 5 + 6 + 7
    println(s"set01 + 之后 => $b")
    println(s"b - 5 = ${b - 5}")
    val d = mutable.Set(2, 5)
    println(s"b ++ d=${b ++ d}")
    println(s"b -- d=${b -- d}")
    //可变
    val set02 = mutable.Set(1, 23, 3)
    set02.add(7)
    set02.foreach(println)

    //tuple
    println("-------tuple-------")
    val tuple02 = new Tuple2(11, "dsfs")
    val tuple03 = Tuple3(22, 11, "rrwe")
    var tuple04: (Int, Int, String, Int) = (1, 2, "gdf", 78)
    val tuple05 = ((x: Int) => x + 8, 2, "string")
    println(tuple02._1)
    println(tuple05._1(10))

    val iterator = tuple05.productIterator
    while (iterator.hasNext) {
      println(iterator.next())
    }

    //map
    println("----------map----------")
    val map01: Map[String, String] = Map(("a", "b"), ("d", "2"), "d" -> "b")
    println(map01.get("a"))
    println(map01.getOrElse("noting", "is nothing "))
    //可变
    println("可变map")


    println("数组....")
    var int02 = new Array[Int](2)
    int02(1) = 2

    var listStr = List(
      "hello world",
      "hello zmb",
      "hello zmj"
    )
    val strings: List[String] = listStr.flatMap((str: String) => str.split(" ")).distinct
    println(strings)
    val tuples = listStr.flatMap((str: String) => str.split(" ")).map((_, 1))
    println(tuples)
    //以上代码有什么问题？内存扩大了N倍，每一步计算内存都留有对象数据，有什么线程的技术解决数据计算中间状态占用内存这一问题？
    //基于迭代器的源码分析
    val iterator1: Iterator[String] = listStr.iterator

  }
}
