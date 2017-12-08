package com.nod

object Solution1137 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines()

    val size = input.next().toInt

    val matrix1 = Array.ofDim[Int](size, size)
    val matrix2 = Array.ofDim[Int](size, size)
    val result = Array.ofDim[Int](size, size)

    for(i <- 0 until size){
      val lineNumbers = input.next().split(" ")
      for(j <-0 until size){
        matrix1(i)(j) = lineNumbers(j).toInt
      }
    }

    for(i <- 0 until size){
      val lineNumbers = input.next().split(" ")
      for(j <-0 until size){
        matrix2(i)(j) = lineNumbers(j).toInt
      }
    }

    for(i <- 0 until size){
      for(j <- 0 until size){
        val a1 = matrix1(i)
        val a2 = Array.ofDim[Int](size)
        for(k <-0 until size){
          a2(k) = matrix2(k)(j)
        }

        val value = getSum(a1, a2)
        result(i)(j) = value
      }
    }

    result.foreach(x => {
      x.foreach(y => print(y + "\t"))
      println
    })

  }

  def getSum(a1 : Array[Int], a2 : Array[Int]): Int ={
    var result = 0

    for(i <- a1.indices){
      result += a1(i) * a2(i)
    }
    result
  }
}
