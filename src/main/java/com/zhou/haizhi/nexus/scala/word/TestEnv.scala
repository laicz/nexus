package com.zhou.haizhi.nexus.scala.word

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TestEnv {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("test").setMaster("local[*]"))
    val rdd: RDD[String] = sc.parallelize(Array("a","b"))
    val result: RDD[(String, Int)] = rdd.map((_, 1)).reduceByKey(_ + _)
    result.collect().foreach(println)
    sc.stop()
  }
}
