package com.nod

/**
  * www.51nod.com No.1174 区间最大值 用线段树实现
  */
class Solution1174 {
  def main(args: Array[String]): Unit = {
    val values = scala.io.Source.stdin.getLines()
    val totalNumbers = values.next().toInt
    val inputNumbers: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer[Int]()
    val pairNumbers: scala.collection.mutable.ArrayBuffer[String] = scala.collection.mutable.ArrayBuffer[String]()

    // 初始化所有数字
    for(_<- 0 until totalNumbers){
      inputNumbers.append(values.next().toInt)
    }

    val totalPairs = values.next().toInt
    // 初始化要查询的区间
    for(_<- 0 until totalPairs){
      pairNumbers.append(values.next())
    }




  }
}
