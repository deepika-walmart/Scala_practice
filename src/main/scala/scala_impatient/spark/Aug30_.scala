package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

trait getContext{
  def spark_context():SparkContext=new SparkContext(new SparkConf().setAppName("Aug30_").setMaster("local"))
}

object allFunctions{
  def getTotalLength():(Int,Int)=>Int = (a:Int,b:Int)=>a+b
}

class Aug30_  extends getContext {
val sc=spark_context()
  val rdd=Collection_RDD_length()

  def Ext_RDD_length(fileName:String):Int={
//    val sc=spark_context(fileName)
//    val sc=new SparkContext(new SparkConf().setAppName("Aug30_").setMaster("local"))
    val lines = sc.textFile(fileName)
    val lineLengths = lines.map(s => s.length)
    lineLengths.reduce(allFunctions.getTotalLength())
  }


  //create a RDD using collections and use external function
  def Collection_RDD_length():RDD[Int]={
//    val sc=spark_context(fileName)
    val data=Array(1,2,3,4,5,5,6)
    val distData=sc.parallelize(data) //creating RDDs from existing collection the program
    println(distData.reduce(allFunctions.getTotalLength()))
      distData
  }

  //print elements of RDDs and count by keys
  def RDD_keyValuePairs():Unit={
    val newRDD=this.rdd.map(s=>(s,1))
    newRDD.reduceByKey(allFunctions.getTotalLength()).take(5).foreach(println)
  }


}

