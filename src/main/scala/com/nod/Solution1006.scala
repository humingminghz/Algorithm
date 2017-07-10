package com.nod

/**
  * www.51nod.com 第1006算法题 LCS相关
  */
object Solution1006 {
  def main(args: Array[String]): Unit = {
    val value = scala.io.Source.stdin.getLines().filter(_.nonEmpty).take(2)
    val s1 = value.next()
    val s2 = value.next()
    val path = Array.ofDim[Int](s1.length + 1, s2.length + 1)

    // 获取最长字符串组
    for(i <- 1 to s1.length ){
      for(j <- 1 to s2.length){
        if(i == 0 || j == 0){
          path(i)(j) = 0
        }
        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
          path(i)(j) = path(i - 1)(j - 1) + 1
        }else if(path(i - 1)(j) >= path(i)(j -1)){
          path(i)(j) = path(i - 1)(j)
        }else {
          path(i)(j) = path(i)(j - 1)
        }
      }
    }
    path.foreach(x => {
      x.foreach(y => print(s"$y\t"))
      println
    })
    printLCS(path, s1, s2, s1.length, s2.length)
  }

  def printLCS(path : Array[Array[Int]], s1 : String, s2 : String, s1Index : Int, s2Index : Int):Unit ={
    // 打印
    if(!(s1Index == 0 || s2Index == 0)){
      if(s1.charAt(s1Index -1) == s2.charAt(s2Index -1)){
        printLCS(path, s1, s2, s1Index - 1, s2Index -1)
        print(s1.charAt(s1Index -1))
      }else if(path(s1Index - 1)(s2Index) >= path(s1Index)(s2Index -1)){
        printLCS(path, s1, s2, s1Index - 1, s2Index)
      }else{
        printLCS(path, s1, s2, s1Index, s2Index - 1)
      }
    }
  }
}
