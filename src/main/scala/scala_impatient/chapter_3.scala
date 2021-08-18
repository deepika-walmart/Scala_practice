package scala_impatient
import scala.collection.mutable.ArrayBuffer
import scala.util._
import scala.io.StdIn._

object chapter_3 {

  def q1_randomArray(n: Int):Array[Int]={
    var a=new Array[Int](n)
    for (i<- 0 to n-1) a(i)=Random.nextInt(n)
    a
  }

  def q2_swapArrayElements(a: Array[Int]): Array[Int] ={
    for (i<- 0 until(a.length,2) if (i+1<a.length)) {
      val t=a(i)
      a(i)=a(i+1)
      a(i+1)=t
    }
    a
  }

  def q3_swapArrayYield(a:Array[Int])= {
    for (i <- 0 until (a.length)) yield a(
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
    var b=new Array[Int](a.length)
    for (i<- a.indices if (a(i)>0)) {
      b(j)=a(i)
      j+=1
    }
    for (i<-a.indices if (a(i)<=0)) {
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

  def main(args:Array[String]): Unit ={
    print("Q 1,2,3. Input size for a random array: ")
    var a=q1_randomArray(readInt())
    for (i<-a) print(i+" ")
    println("")

    var b=q2_swapArrayElements(a)
    for (i<-b) print(i+" ")
    println("")

//    println("Original Array: ")
//    for (i<-a) print(i+" ")
//    println("\nnew array:")

    var c=q3_swapArrayYield(a)
    for (i<-c) print(i+" ")
    println("")

    //Input new Array for q4
    var x=readLine().split(" ").map(_.toInt)
    var d=q4(x)
    for (i<-d) print(i+" ")
    println(" ")

    //Input an array of type double for q5
    println("Q5: Input a single line with elements of double type separated by single space")
    var e=readLine().split(" ").map(_.toDouble)
    var avg:Double= q5(e)
    println("Calculated Average: "+avg)

    //Input array of type int for reverse sor (Q6)
    println("Q6: Input a single line with elements of type Int separated by single space")
    var f=readLine().split(" ").map(_.toInt)
    f=q6_I(f)
    print("Reverse sorted array: ")
    for (i <- f) print(i+" ")
    println("")
    var arrbuff=q6_II(collection.mutable.ArrayBuffer(f:_*))
    print("Reverse sorted ArrayBuffer: ")
    for(i<-arrbuff) print(i+" ")
    println("")

    //Q7 Input array with duplicate elements
    f=readLine().split(" ").map(_.toInt)
    print("Array with removed duplicates: ")
    for (i<- q7(f)) print(i+" ")
    println("")
  }
}
