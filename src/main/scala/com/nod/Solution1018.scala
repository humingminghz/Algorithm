package com.nod

/**
  * www.51nod.com 1018算法题 快速排序
  */
object Solution1018 {

  val input: scala.collection.mutable.ArrayBuffer[Int] = scala.collection.mutable.ArrayBuffer[Int]()
  def main(args: Array[String]): Unit = {
    val value = scala.io.Source.stdin.getLines().filter(_.nonEmpty)

    val totalNumber = value.next().toInt

    while(value.hasNext){
      input.append(value.next().toInt)
    }

    val i = 0
    val j = totalNumber - 1
    adjustArray(i, j)

    input.foreach(println)
  }

  def adjustArray(i : Int, j : Int): Unit ={
    var ii = i
    var jj = j

    val tmp = input(i)

    while(ii < jj){

      while(ii < jj && input(jj) > tmp){
        jj = jj - 1
      }

      if(ii < jj && input(jj) <= tmp){
        input(ii) = input(jj)
      }

      while(ii < jj && input(ii) < tmp){
        ii += 1
      }

      if(ii < jj && input(ii) > tmp){
        input(jj) = input(ii)
      }

      if (ii == jj){
        input(jj) = tmp
      }

    }
    if(i < ii -1){
      adjustArray(i, ii - 1)
    }

    if(ii + 1 < j){
      adjustArray(ii + 1, j)
    }

  }

}
