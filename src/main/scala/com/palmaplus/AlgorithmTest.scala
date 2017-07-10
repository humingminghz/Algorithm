package com.palmaplus

import scala.collection.mutable

/**
  * Created by Administrator on 2017/5/8.
  */
object AlgorithmTest {
  val valuesToSort = Array(12, 1,2,3,4,5,6,7,8,9,10)
  def main(args: Array[String]): Unit = {

    val path = Array.ofDim[Int](5,5)

    // 构建线路地图
    path(0) = Array[Int](0,2,6,4)
    path(1) = Array[Int](Int.MaxValue,0,3,Int.MaxValue)
    path(2) = Array[Int](7, Int.MaxValue,0,1)
    path(3) = Array[Int](5, Int.MaxValue, 12,0)

    floyd(path, path.length)

    Dijkstra(path, 0 ,path.length)
    Bellman_Ford(path, 0, path.length)
    spfa(path, 0, path.length)
    prim(path, 0, path.length)
  }

  /**
    * 最小生成树 prim算法
    */
  def prim(path : Array[Array[Int]],  start : Int, length : Int):Unit ={
    val result = mutable.ListBuffer[Int]()
    result.append(start)
    if(start >= length){
      return
    }

    val nodes = mutable.Set[Int]()

    for(i <- 0 until length){
      if(i != start){
        nodes.add(i)
      }
    }

    // 找到每次最小边 组成最小生成树
    var smallNode = start
    while(nodes.nonEmpty){
      var tmp = Int.MaxValue
      var tmpNode = smallNode
      nodes.foreach(node => {
        if(path(smallNode)(node) < tmp){
          tmp = path(smallNode)(node)
          tmpNode = node
        }
      })
      smallNode = tmpNode
      nodes.remove(smallNode)
      result.append(smallNode)
    }

    result.foreach(println)

  }

  /**
    * SPFA最短路径算法, Bellman_ford的优化
    */
  def spfa(path : Array[Array[Int]], start : Int, length : Int):Unit ={
    val waitingQueue = mutable.Queue[Int]()
    val dist = new Array[Int](length)

    for(i<- 0 until length){
      dist(i) = path(start)(i)
      if(dist(i) < Int.MaxValue){
        waitingQueue.enqueue(i)
      }
    }

    while(waitingQueue.nonEmpty){
      val node = waitingQueue.dequeue()

      for(i<- 0 until length){
        if(dist(i) > dist(node) + path(node)(i)){
          dist(i) = dist(node) + path(node)(i)
          path(start)(i) = dist(i)

          if(!waitingQueue.contains(i)){
            waitingQueue.enqueue(i)
          }
        }
      }
    }

    dist.foreach(x => print(s"$x\t"))
    println
  }




  /**
    * Bellman_Ford最短路径算法
    * start节点到 其余节点最短路径 + 负边权解决
    */
  def Bellman_Ford(path : Array[Array[Int]], start : Int, length : Int):Unit ={
    val dist = new Array[Int](length)

    for(i <- 0 until length){
      dist(i) = path(start)(i)
    }

    for(k <- 0 until length){
      for(j <- 0 until length){
        if(dist(j) > dist(k) + path(k)(j)){
          dist(j) = dist(k) + path(k)(j)
          path(k)(j) = dist(j)
        }
      }
    }

    var flag = false
    for(k <- 0 until length){
      for(j <- 0 until length){
        if(dist(j) > dist(k) + path(k)(j)){
          flag = true  // 正常情况下上面同样循环后应该到节点0 都是最小值了， 如果又出现可以松弛的边 说明有负环
        }
      }
    }

    if(flag){
      println("出现负环  无法计算")
    }else{
      dist.foreach(x => print(s"$x\t"))
    }

    println
  }

  /**
    * Dijkstra最短路径算法
    * start节点到其余 节点的最短路径
    */
  def Dijkstra(path : Array[Array[Int]], start : Int, length : Int):Unit={

    val dist = new Array[Int](length)
    val isSelected = new Array[Boolean](length)
    isSelected(start) = true
    dist.map(_ => 0)
    // 初始化当前路径长度
    for(i <- 0 until length){
      dist(i) = path(start)(i)
    }

    for(_ <- 0 until length){
      var tmp = Int.MaxValue
      var node = start
      // 查找剩余节点最近路径
      for(j <- 1 until length){
        if(!isSelected(j) && dist(j) < tmp){
          tmp = dist(j)
          node = j
        }
      }
      isSelected(node) = true

      for(k <- 0 until length){

        if(!isSelected(k) && (dist(k) > dist(node) + path(node)(k))){
          dist(k) = dist(node) + path(node)(k)
          path(start)(k) = dist(k)
        }

      }
    }
    dist.foreach(x => {
      print(s"$x\t")
    })

    println
  }

  /**
    * Floyd 最短路径
    *
    * @param path 顶点路径集合
    * @param length 顶点数目
    */
  def floyd(path : Array[Array[Int]], length : Int):Unit ={
    println("Source: ")
    printPath(path)

    for(k <- 0 until length){
      for(i <- 0 until length){
        for(j <- 0 until length){
          if(path(i)(k) != Int.MaxValue && path(k)(j) != Int.MaxValue){
            if((path(i)(k) + path(k)(j)) < path (i)(j)){
              path(i)(j) = path(i)(k) + path(k)(j)
            }
          }
        }
      }
    }

    println("Result: ")
    printPath(path)
  }

  /**
    * 打印二维数组
    * @param path
    */
  def printPath(path : Array[Array[Int]]): Unit ={
    path.foreach(p => {
      p.foreach(x => print(s"$x\t"))
      println()
    })
  }


  /**
    * Dynamic Programing Sample 1 动态规划算法示例
    * @param target 目标值
    */
  def DP1(target : Int):Unit ={
    val coins = Array(1,3,5) // 1  3 5块的硬币
    val bestNumber = mutable.ArrayBuffer[Int]()
    //初始化最佳值
    for(i <- 0 to target){
      bestNumber.append(i)
    }

    //计算每种硬币的每种子集的最佳值
    for(j <- 1 to target){
      for(k <- 0 to 2){
        if((j >= coins(k)) && (bestNumber(j - coins(k)) +1 < bestNumber(j) )){
          bestNumber(j) = bestNumber(j - coins(k)) +1
        }
      }
    }

    bestNumber.foreach(println)

  }

  /**
    * 快速排序算法
    * @param startIndex
    * @param endIndex
    */
  def quickSort(startIndex : Int, endIndex : Int): Unit ={
    val tmp = valuesToSort(startIndex)
    var i = startIndex
    var j = endIndex

    if(startIndex < endIndex){
      while(i < j){
        if(valuesToSort(j) < tmp){
          valuesToSort(i) = valuesToSort(j)

          while(i < j && valuesToSort(i) < tmp){
            i += 1
          }

          if(valuesToSort(i) >= tmp){
            valuesToSort(j) = valuesToSort(i)
          }else if(i == j){
            valuesToSort(j) = tmp
          }

        }
          j -= 1
      }

      quickSort(startIndex, i - 1)
      quickSort(i + 1, endIndex)
    }

  }

  /**
    * 最大堆
    */
  def heapSort():Unit ={

    val half = (valuesToSort.length - 1) / 2

    for( i <- (half until valuesToSort.length - 1).reverse){
      maxHeap(valuesToSort.length - 1  , i)
      swapData(0, valuesToSort.length -1 - i)
    }

  }

  def maxHeap(size : Int, index : Int): Unit ={

    val left = index * 2 +1
    val right = index * 2 + 2

    var current = index

    if(right < size){
      if(valuesToSort(index) < valuesToSort(right)){
        swapData(index, right)
        current = right
      }
    }

    if(left < size){
      if(valuesToSort(index) < valuesToSort(left)){
        swapData(index, left)
        current = left
      }
    }

    if(current != index){
      maxHeap(size,current)
    }

  }

  def swapData(indexA : Int, indexB : Int):Unit ={
    val tmp = valuesToSort(indexA)
    valuesToSort(indexA) = valuesToSort(indexB)
    valuesToSort(indexB) = tmp
  }

}
