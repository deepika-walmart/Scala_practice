/*
Higher order functions - Functions that take other functions as arguments
Tail position - At recursion stages where a function is calling itself
Tail position elimination - A condition that puts an end to recursive calls to a function
tailrec - Compiler doesn't tell us if the elimination was ever met. using this annotation makes compiler output an error message
          if the elimination of tail recursion couldn't be reached.
Monomorphic functions - Functions that work for only one data type.
Type parameters - Random generic type names that can be used to denote the type of data
Anonymous functions - defined inline
 */

object FP_HOF_TailCalls {
  /*
  Exercise 2.1. Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
  The first two Fibonacci numbers are 0 and 1. The nth number is always the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5.
  Your definition should use a local tail-recursive function.
   */
  def fibonacci(n: Int):Int={
    @annotation.tailrec
    def fib(n:Int, a:Int, b:Int):Int=n match {
      case 0=>b
      case _=>fib(n-1,b,b+a)
    }
    fib(n-2,0,1) //fibonacci(5) gives 3 (0,1,1,2,3)
  }

  /*
  Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function:
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
   */
  def isSorted[A](as:Array[A],ordered: (A,A) => Boolean):Boolean={
    @annotation.tailrec
    def check(n:Int):Boolean=n match {
      case a if n+1>=as.length => true
      case b if !ordered(as(n),as(n+1)) => false
      case _ => check(n+1)
    }
    check(0)
  }

  /*
  Let’s look at another example, currying,[9] which converts a function f of two arguments into a function of one
  argument that partially applies f. Here again there’s only one implementation that compiles. Write this implementation.
  def curry[A,B,C](f: (A, B) => C): A => (B => C)
   */
//  def curry[A,B,C](f: (A, B) => C): A => (B => C)=


def main(args:Array[String])={
  println("")
}
}

