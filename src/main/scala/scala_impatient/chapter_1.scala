package scala_impatient
import scala.math._
import scala.util.Random

object chapter_1 {

  def main(args:Array[String])={

    //q1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?

    //Q2. In the Scala REPL, compute the square root of 3, and then square that value.
    //By how much does the result differ from 3? (Hint: The res variables are your
    //friend.)
    val res0=math.sqrt(3) //res0 will be the used by REPL to store this operation
    val res1=res0*res0
    val res2=3-res1 //res2: Double = 4.440892098500626E-16 is the output obtained

    //Q3. Are the res variables val or var?
    //Ans: val

    //Q4. Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
    //What does this operation do? Where can you find it in Scaladoc?
    val res3="crazy"*3 //"crazycrazycrazy"
    val res4="crazy".repeat(3)

    //Q5. What does 10 max 2 mean? In which class is the max method defined?
    val res5=10 max 2 //outputs 10, gives maximum of two numbers, it is defined for Int,Long, Float, Double types

    //Q6. Using BigInt, compute 2^1024
    BigInt(2).pow(1024)

    //Q7. What do you need to import so that you can get a random prime as
    //probablePrime(100, Random), without any qualifiers before probablePrime and Random?
    import scala.BigInt.probablePrime
    import scala.util.Random
    probablePrime(100,Random)

    //Q8. One way to create random file or directory names is to produce a random
    //BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
    //Poke around Scaladoc to find a way of doing this in Scala.
    Random.alphanumeric.take(100).mkString.toLowerCase

    //Q9. How do you get the first character of a string in Scala? The last character?
    var s:String="Hello"
    s(0)
    s(s.length-1)

    //Q10. What do the take, drop, takeRight, and dropRight string functions do? What
    //advantage or disadvantage do they have over using substring?
    s.take(2)//takes first 2 characters
    s.drop(1) //returns a string with the first character dropped out
    s.takeRight(2) //takes last 2 elements
    s.dropRight(1) //drops last 1 character and returns a new string
  }

}
