package com.nod

/**
  * www.51nod.com 1066算法题 Bash游戏
  */
object Solution1066 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines().filter(_.nonEmpty)
    val values = scala.collection.mutable.ArrayBuffer[String]()
    val linesNumber = input.next().toString.toInt
    while(input.hasNext){
      values.append(input.next().toString)
    }

    for(i <- 0 until linesNumber){
      val currentValues = values(i).split(" ")
      val total = currentValues(0).toInt
      val max = currentValues(1).toInt

      val rest = total % (max + 1)
      if(rest == 0){
        println("B")
      }else{
        println("A")
      }
    }
  }
}
