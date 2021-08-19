package scala_impatient
import scala.collection.mutable
import java.util.Scanner

object chapter_4 {

  //Q1. create a new map with 10% discount
  def q1:mutable.Map[String,Int]={
    val gizmo_prices=mutable.Map("ipad"->1000000, "nintendo switch"->34000, "xbox series x"->50000)
    val discounted_prices=gizmo_prices.clone()
    for((k,v)<-discounted_prices) discounted_prices(k)=v-v/10
    discounted_prices
  }

  //Q2. read a file, count occurrences of all words
  def q2:mutable.HashMap[String,Int]={
    var word_freq=new mutable.HashMap[String,Int]
    val file=new Scanner(getClass.getResourceAsStream("mytextfile.txt"))
    try{
    while(file.hasNext){
      word_freq(file.next())=word_freq.getOrElse(file.next(),0)+1
    }}
    finally {
    file.close()}
    word_freq
  }


  def main(args: Array[String]): Unit={
//    println(q1)
//    println(q2)//doesn't work

  }

}
