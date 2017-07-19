package com.nod

/**
  * www.51nod.com 1134 最长递增子序列 DP 量大会timeout 更高效率在1134_2
  */
object Solution1134 {

  def main(args: Array[String]): Unit = {
    val values = scala.io.Source.stdin.getLines()
    val input: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer[Int]()

    values.next()
    while(values.hasNext){
      input.append(values.next().toInt)
    }
    val maxLens = new Array[Int](input.length)

    var max = 0
    for(i <- input.indices){

      for(j <- 0 until i){
        if(input(i) > input(j) && maxLens(j) >= maxLens(i)){
          maxLens(i) = maxLens(j) + 1
        }

        if(max < maxLens(i)){
          max = maxLens(i)
        }
      }
    }
    println(max + 1)
  }

}
