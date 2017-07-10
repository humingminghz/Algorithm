package com.palmap.testproto

import com.mongodb.BasicDBObject
import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject

import scala.io.Source
import scala.util.Sorting

/**
  * Created by Administrator on 2017/5/9.
  */
object MongoTest {

  def main(args: Array[String]): Unit = {


//    val s = scala.io.StdIn.readLine()
    val sum = Source.stdin.mkString.trim.split(" ").filter(_.nonEmpty).map(_.toInt).sum
    println(sum)

//    val mongoClient =  MongoClient("10.0.25.15",27017)
//    val db = mongoClient.getDB("MM")
//    val findQuery = new BasicDBObject("_id", 0)
//    findQuery.put("age", 16)
//    findQuery.put("name", "herName")
//    val testCollection = db("test")
//
//    val result = testCollection.find(findQuery)
//    result.foreach(x => println(x.get("name") + " " + x.get("age")))

//    val testCollection = db.getCollection("test")
//    val javaCollection = db("test")
//
//
//
//    val locationSetJava = scala.collection.mutable.Set[String]()
//    locationSetJava.add("13000")
//    locationSetJava.add("14000")
//
//    val javaTimeBefore = System.currentTimeMillis()
//
//    val javaFindQuery = new BasicDBObject("name", "hmm").append("age", 50)
//    val javaUpdateQuery = new BasicDBObject("$inc", new BasicDBObject("age" , 1))
//      .append("$addToSet", new BasicDBObject("locations", new BasicDBObject("$each", locationSetJava)))
//
//    javaCollection.update(javaFindQuery, javaUpdateQuery, upsert = true)
//    val javaTimeAfter = System.currentTimeMillis()
//
//    println("javaTimeAfter - javaTimeBefore: " + (javaTimeAfter - javaTimeBefore))
//
//    val locationSet = scala.collection.mutable.Set[String]()
//    locationSet.add("11000")
//    locationSet.add("12000")
//
//    val timeBefore = System.currentTimeMillis()
//    val findQuery =  MongoDBObject("name" -> "hmm" , "age" -> 60)
//    val updateQuery = MongoDBObject("$inc" -> MongoDBObject("age" -> 1), "$addToSet" -> MongoDBObject("locations" -> MongoDBObject("$each" -> locationSet)))
//
//    testCollection.update(findQuery, updateQuery, true, true)
//    val timeAfter = System.currentTimeMillis()
//    println("timeAfter - timeBefore: " + (timeAfter - timeBefore))



//    val result = testCollection.find(findQuery).toArray


//    result.toArray.foreach(x => println(x))



//    println(Long.MaxValue)

//    val myMap: mutable.Map[Int, Int] = scala.collection.mutable.Map[Int, Int]()
//    myMap.put(1,11)
//    myMap.put(2,22)
//    myMap.put(3,33)
//
//    println(myMap(2))

//    val mongoClient =  MongoClient("10.0.23.19",27017)
//    val db = mongoClient("MM")
////    db.collectionNames().foreach(x => println(x))
//
//    println("now connecting")
//    val coll = db("test")
//
//    val query1 = MongoDBObject( "age" -> 220)
//    val update1 = MongoDBObject("name" -> "myName", "age" -> 330)
//
//    coll.update(query1,update1)
//    coll.find(query1).foreach(x => println("name " + x.get("name") + "," + "age " +  x.get("age")))

//    coll.insert(query1)
//    coll.find(query1).foreach(x => println(" new name " + x.get("name") + "," + "age " +  x.get("age")))
  }

}
