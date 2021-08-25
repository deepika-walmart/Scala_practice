package scala_impatient

object Aug24_gettingStartedWithFP {

    /*
    Exercise 2.1. Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
    The first two Fibonacci numbers are 0 and 1. The nth number is always the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5.
    Your definition should use a local tail-recursive function.
     */
    def fibonacci(n: Int):Int={
      @annotation.tailrec
      def fib(n:Int, a:Int, b:Int):Int={
        if (n==0) b
        else fib(n-1,b,b+a)
      }
      fib(n-2,0,1) //fibonacci(5) gives 5 (0,1,1,2,3)
    }

  /*
  Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function:
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
   */
  def isSorted[A](as:Array[A],ordered: (A,A) => Boolean):Boolean={
    @annotation.tailrec
    def check(n:Int):Boolean={
      if(n+1>=as.length) true
      else if (!ordered(as(n),as(n+1))) false
      else check(n+1)
    }
    check(0)
  }


    def main(args:Array[String]): Unit ={
    print("Test")
    }

}
