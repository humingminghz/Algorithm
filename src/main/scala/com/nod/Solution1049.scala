package com.nod


/**
  * www.51nod.com 最大子序列和计算
  */
object Solution1049 {
  val values: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer[Int]()
  var maxValue: Long = 0L
  var tmpValue: Long = 0L

  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines().filter(_.nonEmpty)
    val linesNumber = input.next().toString.toLong
    while(input.hasNext){
      values.append(input.next().toString.toInt)
    }

    getSum(values.length - 1)
    println(maxValue)
  }

  def getSum(index : Int):Unit ={
    if(index >= 0){
      getSum(index - 1)
      if(tmpValue + values(index).toLong > 0L){
        tmpValue = tmpValue + values(index).toLong
        if(tmpValue > maxValue){
          maxValue = tmpValue
        }
      }else if(tmpValue + values(index).toLong <= 0L){
        tmpValue = 0L
      }
    }
  }
}
