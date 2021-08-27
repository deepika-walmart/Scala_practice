/*
- Scala has built-in support for pattern matching.
- case statement acts like a function that maps one value to other (A => B, e.g. Int=> String)
- Pattern matching returns a value always
- variable shadowing can be prevented using backquote
 */
package scala_impatient

object Aug26_FP_PatternMatching {

//most basic PM function
 def matchTest(n:Int):String=n match{
  case 1 => "one"
  case 2 => "two"
  case _ => "many"
 }

  //Pattern matching can return complex values as well
  def rgbValues(color:String):(Int,Int,Int)= color match{
    case "red" => (255,0,0)
    case "green" => (0,0,255)
    case _ => (0,0,0)
  }

  //We can use complex expressions for matching
  def goldilocks1(expr: (String,String)): String=expr match{
    case ("porridge" , "Papa") => "Papa eats porridge"
    case ("porridge", "Mama") => "Mama eats porridge"
    case _ => "Sorry?"
  }
  def goldilocks2(expr: Any):Any=expr match{
    case ("porridge" , "Papa") => "Papa eats porridge"
    case ("porridge", "Mama") => "Mama eats porridge"
    case _ => "Sorry?"
  }

  //wildcard parts of expression
  def goldilocks3(expr:Any):Any=expr match{
    case ("A" , _) => "for Apple"
    case ("B", "ball") => "for ball"
    case _ => "I don't know any further"
  }

  //substitute parts of expressions
  def goldilocks4(expr: (String,String)):String=expr match{
    case ("A" , bear) =>"A for "+bear
    case ("B" , bear) =>"B for "+bear
    case _=> "Sorry?"
  }

  //use backquote for prevention in variable shadowing
  val alphabet="A"
  def goldilocks5(expr: (String,String)):String=expr match {
    case (`alphabet`,_) => "Apple"
    case ("B", "Bat") => "bat"
    case _ => "Sorry?"
  }

  // use method parameters in the match expression
  def patternTest(i:Int,j:Int):Boolean=j match{
    case`i` =>true
    case _ => false
  }


}
