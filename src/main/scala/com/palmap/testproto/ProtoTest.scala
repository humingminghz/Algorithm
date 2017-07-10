package com.palmap.testproto

import com.palmaplus.test.MyProto

/**
  * Created by Administrator on 2017/5/9.
  */
object ProtoTest {

  def main(args: Array[String]): Unit = {

  val builder = MyProto.MyObject.newBuilder()
    val builderB = MyProto.MyObject.newBuilder()

    builder.setId(123)
    builder.setName("myName")
    builder.setSex("male")

    builderB.setId(456)
    builderB.setName("2nd")
    builderB.setSex("female")

    val myObject = builder.build()
    val secondObject = builderB.build()

    val byteData = myObject.toByteArray
    val byteData2 = secondObject.toByteArray

//    val newObject = MyProto.MyObject.parseFrom(byteData)

    val cBuilder = MyProto.MyObject.newBuilder().clear().mergeFrom(byteData2, 0 , byteData2.length)

    val newBuilder = cBuilder.mergeFrom(byteData, 0 , byteData.length)


    val result = newBuilder.build()

    println(result)

//    println("newObject")
//
//    println(newObject)


  }


}
