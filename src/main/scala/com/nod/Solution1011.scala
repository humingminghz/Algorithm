package com.nod

/**
  * Created by Administrator on 2017/7/10.
  */
object Solution1011 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.mkString.trim.split(" ").take(2)
    val v1 = input(0).toInt
    val v2 = input(1).toInt
    println(v1 + " " + v2)
  }
}
