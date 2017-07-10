package com.nod

/**
  * www.51nod.com 1011算法题 最大公约数
  */
object Solution1011 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.mkString.trim.split(" ").take(2)
    val v1 = input(0).toInt
    val v2 = input(1).toInt

    if(v1 == v2){
      println(v1)
    }else if(v1 > v2){
      println(gcd(v1, v2))
    }else{
      println(gcd(v2, v1))
    }
  }

  def gcd(v1 : Int, v2 : Int):Int ={
    val tmp = v1%v2
    var result = 0
    if(tmp != 0){
      result = gcd(v2, tmp)
    }else{
      result = v2
    }
    result
  }

}
