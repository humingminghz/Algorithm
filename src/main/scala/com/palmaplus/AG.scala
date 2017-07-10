package com.palmaplus

import scala.collection.mutable

/**
  * Created by Administrator on 2017/5/24.
  */
object AG {
  val data = Array(5, 2, 7, 4, 9, 1, 10, 3, 8, 6)
  var dataList = List(1,2,3,4,5)

  def main(args: Array[String]): Unit = {
//    sort(0, data.length - 1)
//    data.foreach(x => println(x))

   val st = mutable.Stack[Int]()
    st.pushAll(data)
    while(st.size > 0){
      println(st.pop())
    }
  }

  def sort(start: Int, end: Int): Unit = {

    var i = start
    var j = end


    if(start > end ){
      return
    }
    val tmp = data(start)
    while (i != j) {
      while (i < j && data(j) >= tmp) {
        j -= 1
      }

      while (i < j && data(i) <= tmp) {
        i += 1
      }

      if (i != j) {
        val t = data(i)
        data(i) = data(j)
        data(j) = t
      }
    }
    data(start) = data(i)
    data(i) = tmp

    sort(start, i - 1)
    sort(i + 1, end)
  }
}
