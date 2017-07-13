package com.nod

/**
  * www.51nod.com 背包问题 DP方法
  */
object Solution1085 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines()
    val values = scala.collection.mutable.ArrayBuffer[(Int, Int)]()
    val pack = input.next().toString.split(" ")
    val N = pack(0).toInt
    val W = pack(1).toInt
    val result = Array.ofDim[Int](N + 1,W + 1)


    while(input.hasNext){
      val inputValue = input.next().split(" ")
      values.append((inputValue(0).toInt, inputValue(1).toInt))
    }

  for(i <- 1 to N){
    result(i)(0) = 0

    for(j <- 1 to W){
      if(values(i - 1)._1 > j){
        result(i)(j) = result(i -1)(j)
      }else{
        val tmp = result(i -1)(j - values(i - 1)._1) + values(i - 1)._2
        if(result(i -1)(j) >= tmp){
          result(i)(j) = result(i -1)(j)
        }else{
          result(i)(j) = tmp
        }
      }
    }
  }
//    result.foreach(x => {
//      x.foreach(y => print(s"$y\t"))
//      println()
//    })
    println(result(N)(W))
    }
}

