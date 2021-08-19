package scala_impatient
import java.awt.geom.Point2D

//Q1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
//milesToKilometers.
object conversions{
  def inchesToCentimeters(inp:Double):Double=inp*2.54
  def gallonsToLiters(inp:Double):Double=inp*3.785
  def milesToKilometers(inp:Double):Double=inp/0.62137
}

//Q2. Make three objects extend a class for implementing q1
class UnitConversion{
  def conversion(inp:Double):Double={
    inp
  }
}
object inchesToCentimeters extends UnitConversion{
  override def conversion(inp: Double): Double = inp*2.54
}
object gallonsToLiters extends UnitConversion{
  override def conversion(inp: Double): Double = inp*3.785
}
object milesToKilometers extends UnitConversion{
  override def conversion(inp: Double): Double = inp/0.62137
}

//Q3. Define an Origin object that extends java.awt.Point. Why is this not actually a
//good idea? (Have a close look at the methods of the Point class.)
object Origin extends java.awt.Point{
//  override def equals(obj: Any): Boolean = super.equals(obj)
//  override def distance(pt: Point2D): Double = super.distance(pt)
//  override def toString: String = super.toString
}

//Q4. Define a Point class with a companion object so that you can construct Point
//instances as Point(3, 4), without using new.
class Point(val x:Int, y:Int)

object Point{
  def apply(x:Int,y:Int)= new Point(x,y)//not working without new
}

//Q5. Write a Scala application, using the App trait, that prints the command-line
//arguments in reverse order, separated by spaces. For example, scala Reverse
//Hello World should print World Hello.
object Reverse extends App{
  override def main(args: Array[String]): Unit = {
    println(args.reverse.mkString(" "))
  }
}

//Q6. Write an enumeration describing the four playing card suits so that the toString
//method returns ♣, ♦, ♥, or ♠.

//Q7. Implement a function that checks whether a card suit value from the preceding
//exercise is red.
object Cards extends Enumeration{
  val spade=Value("♠")
  val diamond=Value("♦")
  val club=Value("♣")
  val heart=Value("♥")

  def checkForRed(card:Cards.Value):Boolean = (card==heart||card==diamond)
}

//Q8. Write an enumeration describing the eight corners of the RGB color cube. As
//IDs, use the color values (for example, 0xff0000 for Red).
object rgbColorCube extends Enumeration{
  val black=Value(0x000000)
  val white=Value(0xffffff)
  val red=Value(0xff0000)
  val lime=Value(0x00ff00)
  val blue=Value(0x0000ff)
  val yellow=Value(0xffff00)
  val cyan=Value(0x00ffff)
  val magenta=Value(0xff00ff)
}

object chapter_6 {

  def main(args: Array[String])={

  }

}
