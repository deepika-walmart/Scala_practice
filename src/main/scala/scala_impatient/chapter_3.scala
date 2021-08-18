package scala_impatient
import scala.collection.mutable.ArrayBuffer
import scala.util._
import scala.io.StdIn._

object chapter_3 {

  def q1_randomArray(n: Int):Array[Int]={
    val a=new Array[Int](n)
    for (i<- 0 until n) a(i)=Random.nextInt(n)
    a
  }

  def q2_swapArrayElements(a: Array[Int]): Array[Int] ={
    for (i<- 0 until(a.length,2) if i+1<a.length) {
      val t=a(i)
      a(i)=a(i+1)
      a(i+1)=t
    }
    a
  }

  def q3_swapArrayYield(a:Array[Int])= {
    for (i <- a.indices) yield a(
      if(i%2 ==0)
        if(i+1<a.length)
          i+1
        else
          i
      else i-1
    )
  }

  //Q4 : Given an array of integers, produce a new array that contains all positive
  //values of the original array, in their original order, followed by all values that
  //are zero or negative, in their original order.

  def q4(a:Array[Int]): Array[Int] ={
    var j:Int=0
    val b=new Array[Int](a.length)
    for (i<- a.indices if a(i)>0) {
      b(j)=a(i)
      j+=1
    }
    for (i<-a.indices if a(i)<=0) {
      b(j)=a(i)
      j+=1
    }
    b
  }

  //Q5: Calculate the average
  def q5(a: Array[Double]):Double={
  a.sum/a.length
  }

  //Q6-I reverse sort the array
  def q6_I(a: Array[Int]):Array[Int]={
    a.sorted.reverse
  }

  //Q6-II reverse sort the ArrayBuffer
  def q6_II(a: ArrayBuffer[Int]):ArrayBuffer[Int]={
    a.sorted.reverse
  }

  //Q7-remove duplicates
  def q7(a:Array[Int]):Array[Int]=a.distinct

  //Q8-drop all negatives except the first one use 'drop'
  def q8(a:ArrayBuffer[Int]):ArrayBuffer[Int]={
    var b=for(i<-a.indices if a(i)<0) yield a(i)
    b=b.drop(1)
    for (i<-b.indices.reverse) a-=b(i)
    a
  }

  def main(args:Array[String]): Unit ={
    print("Q 1,2,3. Input size for a random array: ")
    val a=q1_randomArray(readInt())
    for (i<-a) print(i+" ")
    println("")

    val b=q2_swapArrayElements(a)
    for (i<-b) print(i+" ")
    println("")

//    println("Original Array: ")
//    for (i<-a) print(i+" ")
//    println("\nnew array:")

    val c=q3_swapArrayYield(a)
    for (i<-c) print(i+" ")
    println("")

    //Input new Array for q4
    val x=readLine().split(" ").map(_.toInt)
    val d=q4(x)
    for (i<-d) print(i+" ")
    println(" ")

    //Input an array of type double for q5
    println("Q5: Input a single line with elements of double type separated by single space")
    val e=readLine().split(" ").map(_.toDouble)
    val avg:Double= q5(e)
    println("Calculated Average: "+avg)

    //Input array of type int for reverse sor (Q6)
    println("Q6: Input a single line with elements of type Int separated by single space")
    var f: Array[Int] =readLine().split(" ").map(_.toInt)
    f=q6_I(f)
    print("Reverse sorted array: ")
    for (i <- f) print(i+" ")
    println("")
    val arrbuff=q6_II(collection.mutable.ArrayBuffer(f:_*))
    print("Reverse sorted ArrayBuffer: ")
    for(i<-arrbuff) print(i+" ")
    println("")

    //Q7 Input array with duplicate elements
    f=readLine().split(" ").map(_.toInt)
    print("Array with removed duplicates: ")
    for (i<- q7(f)) print(i+" ")
    println("")

    //Q8 Drop duplicates
    println("Input an integer array with any no. of integers separated by single space")
    f=readLine().split(" ").map(_.toInt)
    print("Array with all negatives removed except the first one: ")
    for (i<- q8(collection.mutable.ArrayBuffer(f:_*))) print(i+" ")
    println("")

    //Q9


  }
}
