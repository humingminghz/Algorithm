package com.nod


/**
  * 求最大连续整数和
  */
object Solution1138 {

  // start i = (2n - k^2 + k)/2k   k start from 2 less than n/2
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.getLines()
    val n = input.next().toInt
    val n2 = n / 2

    if(n2 <=1){
      println("No Solution")
    }else{
      var result = 0
      var k = 2

      val loop = new scala.util.control.Breaks()

      loop.breakable{
        for(j <- 2 to n2){
          var resultID = 0.0
          val nd = n.toDouble
          val kd = j.toDouble
          resultID = (2.0*nd - kd*kd +kd)/(2.0*kd)
          val intResult = resultID.toInt.toDouble

          if((resultID - intResult) == 0 && resultID > 0){
            k = j
            result = resultID.toInt
            loop.break()
          }
        }
      }

      if(result != 0){
        for(i <- 0 until k){
          println(result + i)
        }

      }else{
        println("No Solution")
      }

    }

  }
}
