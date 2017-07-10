package com.nod

/**
  * 51nod 1005 大数加法
  */
object Solution1005 {
  def main(args: Array[String]): Unit = {
    val AArray = new Array[Int](10000)
    val BArray = new Array[Int](10000)
    val resultArray = new Array[Int](10000)
    var isPlus = true
    var isA_B = true
    val value = scala.io.Source.stdin.getLines().filter(_.nonEmpty).take(2)
    var valueA = value.next().toCharArray
    var valueB = value.next().toCharArray
    var isNegative = false
    var isZero = false

    if(valueA(0).toString.equals("-")  && valueB(0).toString.equals("-")){
      isPlus = true
      isNegative = true
    }else if(valueA(0).toString.equals("-")) {
      val method = getNegative(valueA, valueB)
      isNegative = method._1
      isPlus = method._2
      isA_B = method._3
      isZero = method._4
    }else if( valueB(0).toString.equals("-")){
      val method = getNegative(valueB, valueA)
      isNegative = method._1
      isPlus = method._2
      isA_B = !method._3
      isZero = method._4
    }

    var j = 0
    for(i <- valueA.indices.reverse){
      if( !valueA(i).toString.contains("-")){
        AArray(9999 - j) = valueA(i).toString.toInt
      }
      j += 1
    }

    j = 0

    for(i <- valueB.indices.reverse){
      if( !valueB(i).toString.contains("-")) {
        BArray(9999 - j) = valueB(i).toString.toInt
      }
      j += 1
    }

    var plusOne = 0
    var reduceOne = 0
    var isFalse = false
    var reduceTmp = 0
    for(i <- (0 to 9999).reverse){
      if(isPlus){
        val tmpResult = AArray(i) + BArray(i)

        if(tmpResult + plusOne < 10 ){
          resultArray(i) = tmpResult + plusOne
          plusOne = 0
        }else{
          val valueWithPlus = (tmpResult + plusOne).toString
          plusOne = 1
          resultArray(i) = valueWithPlus.substring(1,valueWithPlus.length).toInt
        }
      }else {
        if(isZero){
          println(0)
          return
        }else if(isA_B){
          val tmp = subduction(AArray, BArray)
          for(i <- tmp.indices.reverse){
            resultArray(i) = tmp(i)
          }
        }else{
          val tmp = subduction(BArray, AArray)
          for(i <- tmp.indices.reverse){
            resultArray(i) = tmp(i)
          }
        }
      }
    }

    var canPrint = false
    if(isNegative){
      print("-")
    }
    resultArray.foreach( x => {
      if(x != 0 || canPrint){
        print(x)
        canPrint = true
      }
    })

    if(!canPrint){
      print(0)
    }

  }

  def subduction(A : Array[Int], B : Array[Int]):Array[Int] = {
    val result = new Array[Int](A.length)

    var takeOne = 0
    for(i <- B.indices.reverse){
      var tmp = A(i) - B(i) - takeOne
      if(tmp < 0){
        tmp += 10
        takeOne = 1
      }else{
        takeOne = 0
      }
      result(i) = tmp
    }

    result
  }

  def getNegative(valueA : Array[Char], valueB : Array[Char]): (Boolean, Boolean, Boolean, Boolean) ={
    var isNegative = false
    var isPlus = false
    var isA_B = false
    var isZero = false

    if(valueA.length - 1 > valueB.length){
      isNegative = true
      isPlus = false
      isA_B = true
    }else if(valueA.length - 1 < valueB.length){
      isNegative = false
      isPlus = false
      isA_B = false
    }else if(valueA.length -1  == valueB.length){
      var loop = true
      var i = 0
      while(loop){
        if(valueA(i + 1) < valueB(i)){
          isNegative = false
          loop = false
          isPlus = false
          isA_B = false
        }else if(valueA(i + 1) > valueB(i)){
          isNegative = true
          isA_B = true
          isPlus = false
          loop = false
        }else{
          if(i + 1 == valueA.length - 1){
            isZero = true
            loop = false
            isPlus = false
          }
        }
        i+= 1
      }
    }
    (isNegative, isPlus, isA_B, isZero)
  }
}
