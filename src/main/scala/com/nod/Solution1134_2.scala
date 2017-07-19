package com.nod

/**
  * www.51nod.com 1134 效率更高方案
  */
object Solution1134_2 {
  def main(args: Array[String]): Unit = {
    val values = scala.io.Source.stdin.getLines()
    val input: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer[Int]()
    values.next()
    while(values.hasNext){
      input.append(values.next().toInt)
    }

    val arrayOut = new Array[Int](input.length + 1)
    var len = 1

    for(i <- input.indices){
      if(i == 0){
        arrayOut(1) = input(i)
      }else{
        val pos = findPosition(arrayOut, 1, len, input(i))
        arrayOut(pos) = input(i)
        if(pos > len){
          len = pos
        }
      }
    }

    println(len)

  }

  def findPosition(ArrayOut : Array[Int], start : Int, end : Int, currentValue : Int):Int = {
    var pos = 0
    var left = start
    var right = end

    if(ArrayOut(right) < currentValue){
      pos = right + 1
    }else{
      while(left < right){
        val mid = (left + right)/2

        if(ArrayOut(mid) >= currentValue){
          right = mid
        }else{
          left = mid + 1
        }
      }
      pos = left
    }

    pos
  }
}
