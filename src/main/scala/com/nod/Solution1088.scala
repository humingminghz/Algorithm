package com.nod

/**
  * www.51nod.com 最长回文字符串
  */
object Solution1088 {
  def main(args: Array[String]): Unit = {
    val input = scala.io.Source.stdin.mkString.trim().toArray

    var maxLength = 0

    var start = 0
    var end = 0

    // 奇数的情况下
    for(i <- input.indices){
      var j = i
      var k = i
      var tmpLength = 1
      if(i -1 >= 0 && i + 1 < input.length -1){
        var flag = true
        while(flag && (j -1 >=0 && k + 1 <= input.length -1)){
          if(input(j - 1) == input(k + 1)){
            tmpLength += 2
            if(maxLength < tmpLength){
              maxLength = tmpLength
            }
          }else{
            tmpLength = 1
            flag = false
          }

          j -= 1
          k += 1
        }
      }
    }

    // 偶数的情况下
    for(i <- input.indices){
      var j = i
      var k = i
      var tmpLength = 0
      var flag = true

      while(flag &&(j >= 0 && k + 1 <= input.length - 1)){

        if(input(j) == input(k + 1)){
          tmpLength += 2
          if(tmpLength > maxLength){
            maxLength = tmpLength
          }
        }else{
          flag = false
        }
        j -= 1
        k += 1
      }
    }

    if(maxLength == 1){
      println(0)
    }else{
      println(maxLength)
    }

  }
}
