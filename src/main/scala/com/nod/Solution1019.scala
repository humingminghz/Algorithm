package com.nod

/**
  * www.51nod.com 1019题 逆序数计算
  */
object Solution1019 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines().filter(_.nonEmpty)
    val values = scala.collection.mutable.ArrayBuffer[Int]()
    val linesNumber = input.next().toString.toInt
    while(input.hasNext){
      values.append(input.next().toString.toInt)
    }

    var totalCount = 0
    for(i <- values.indices){
      val currentValue = values(i)
      for(j <- i + 1 until values.length){
        if(currentValue > values(j)){
          totalCount += 1
        }
      }
    }

    println(totalCount)
  }
}
