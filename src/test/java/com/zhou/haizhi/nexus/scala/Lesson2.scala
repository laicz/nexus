package com.zhou.haizhi.nexus.scala

object Lesson2 {
  def main(args: Array[String]): Unit = {
    def fun01(): Unit = {
      println("Hello , world -> fun01")
    }

    def fun02(x: Int): Int = {
      println("Hello , world -> fun02")
      x * 3;
    }

    def fun03(x: Int): Int = {
      if (x == 1) {
        x
      } else {
        x * fun03(x - 1)
      }
    }

    def fun04(a: Int = 6, b: String = "abc"): Unit = {
      println(s"a=$a  , b=$b ")
    }

    val varFun01 = fun01()
    println("-----------------------")
    println(varFun01)
    println("--------fun02-------")
    var varFun02 = fun02(2);
    println("------")
    println(varFun02)
    println("递归")
    println(fun03(8))
    println("默认值")
    fun04(b = "dds")

    //方法作为参数
    def compute(x: Int, y: Int, f: (Int, Int) => Int): Unit = {
      val result = f(x, y)
      println(result)
    }
    //使用
    compute(1, 3, (x: Int, y: Int) => x + y)
    compute(1, 3, (x, y) => x + y)
    compute(1,3,_+_)
    compute(1,3,_*_)
    compute(1,3,_-_)
  }
}
