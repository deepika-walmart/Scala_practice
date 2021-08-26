/*
Learning to create contexts and RDDs.
RDDs can be created through : using local file system, using pre-existing collection, using another RDD

 */

package spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SparkContext_RDD {
  def main(args:Array[String])={
    val conf = new SparkConf().setAppName("SparkContext_RDD").setMaster("local")
    val sc=new SparkContext(conf)
    val data=Array(1,2,3,4,5)
    val distData=sc.parallelize(data) //creating RDDs from existing collection the program
    println(distData.reduce((a, b) => a + b))
  }
}
