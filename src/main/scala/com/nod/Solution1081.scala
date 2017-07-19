package com.nod

/**
  * www.51nod.com 1081 子段求和.
  */
object Solution1081 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines()
    val values = scala.collection.mutable.ArrayBuffer[Long]()
    val sum = scala.collection.mutable.ArrayBuffer[Long]()
    val number = input.next().toInt
    for(i<- 0 until number){
      values.append(input.next().toLong)
      if(i == 0){
        sum.append(values(i))
      }else{
        sum.append(sum(i - 1) + values(i))
      }
    }

    val resultCount = input.next()

    while(input.hasNext){
      val condition = input.next().toString.split(" ")
      val start = condition(0).toInt
      val end = condition(1).toInt
      var resultValue  = 0L
      if(start == 1){
        resultValue = sum(start + end - 2)
      }else{
        resultValue = sum(start + end - 2) - sum(start - 2)
      }

      println(resultValue)
    }
  }

}
