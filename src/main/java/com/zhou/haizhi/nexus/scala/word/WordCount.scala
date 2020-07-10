package com.zhou.haizhi.nexus.scala.word

import org.apache.commons.lang.RandomStringUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def getHdfsPath(): String = "/book/sdf"

  def main(args: Array[String]): Unit = {
    val userName: String = System.getenv("HADOOP_USER_NAME")
    println(s"set hadoop user name $userName")
    System.setProperty("HADOOP_USER_NAME", userName)
    val sparkConf: SparkConf = new SparkConf().setAppName("ScalaWordCountDemo").setMaster("local[4]")
    val sparkContext = new SparkContext(sparkConf)
    //取到一行数据
    val lines: RDD[String] = sparkContext.textFile("file:///Users/haizhi/Desktop/word.txt")

    //切分压平
    val words: RDD[String] = lines.flatMap(_.split(" "))

    //按单词或者组合
    val wordAndOne: RDD[(String, Int)] = words.map((_, 1))

    //按key进行聚合
    val reduceByKey: RDD[(String, Int)] = wordAndOne.reduceByKey(_ + _)

    //排序
    val sorted: RDD[(String, Int)] = reduceByKey.sortBy(_._2, false)

    //将结果保存到hdfs中
    var path: String = getHdfsPath()
    println(s"save path => $path")
    sorted.saveAsTextFile(path);
  }
}
