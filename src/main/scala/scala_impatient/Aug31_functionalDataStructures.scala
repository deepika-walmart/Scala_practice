/*
Functional Data Structures are immutable since mostly pure functions are used.
trait -> an abstract interface which may contain some functions. We use it to define a data type.
sealed trait -> all implementations/functions regarding this trait should be included in the same file.
+ -> '+' in front of a type parameter(say A) means that A is covariant. simply, subtypes of A can be further used.
Companion object -> used to support implementation by defining several methods for operations to be performed.
Variadic function -> accepts 0 or more arguments of the mentioned type parameter (e.g.: A*).
Seq -> interface in scala library, which is implemented by sequential data structures e.g.: List, Stack,Queue.
_* -> it is used to pass a seq to the apply method.
Data sharing -> sharing/using the same data without creating a copy of it.
 */


package scala_impatient

//an example from the book "Functional Programming in Scala"
 trait Aug31_functionalDataStructures[+A] //name the dataset whatever is convenient, declares a datatype
//implementations of the data structure "Aug31_functionalDataStructures"
case object Nil extends Aug31_functionalDataStructures[Nothing]  //initializes an empty data structure
case class Cons[+A](head:A,tail:Aug31_functionalDataStructures[A]) extends Aug31_functionalDataStructures[A] //gets you a non-empty data structure

//a companion object for operating on "Aug31_functionalDataStructures"
object Aug31_functionalDataStructures{
  def sum(h:Aug31_functionalDataStructures[Int]):Int= h match {
    case Nil => 0
    case Cons(x,xs) => x+sum(xs)
  }

  //a variadic function for constructing the data structure
  def apply[A](as: A*):Aug31_functionalDataStructures[A]=if (as.isEmpty) Nil
  else Cons(as.head,apply(as.tail:_*))


//  Exercise 3.1: What will be the result of the following match expression?
    def fn():Unit={
      val x:Int = Aug31_functionalDataStructures(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }}
//    Ans: 3

  /*
  Exercise 3.2: Implement the function tail for removing the first element of your data structure. Note that the function takes constant time.
   What are different choices you could make in your implementation if the data structure is Nil? We’ll return to this question in the next chapter.
   */
  def tail[A](ds: Aug31_functionalDataStructures[A]):Aug31_functionalDataStructures[A]= ds match {
    case Cons(x,xs) => xs
    case _ => Nil
  }


  // Exercise 3.3: Using the same idea, implement the function setHead for replacing the first element of a List with a different value.
  def setHead[A](h:A,ds:Aug31_functionalDataStructures[A]):Aug31_functionalDataStructures[A]=Cons(h,ds)
  //setHead(0,Aug31_functionalDataStructures(1,2,3,4,5)) gives Cons(0,Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Nil))))))

  // Exercise 3.4: Generalize tail to the function drop, which removes the first n elements from a list.
  // Note that this function takes time proportional only to the number of elements being dropped—we don’t need to make a copy of the entire List.
  def drop[A](ds:Aug31_functionalDataStructures[A], n:Int):Aug31_functionalDataStructures[A] ={
    @annotation.tailrec
    def loop(n:Int, ds:Aug31_functionalDataStructures[A]):Aug31_functionalDataStructures[A]=n match {
      case 0 => ds
      case _ => loop(n-1,tail(ds):Aug31_functionalDataStructures[A])
    }
    loop(n,ds)
  }

  //------------------------- Part-II  (1st Sept.) -------------------------

  //def head
@annotation.tailrec
  def head[A](l:Aug31_functionalDataStructures[A]):A = l match {
    case Cons(x,_)=>x
    case _ => head(l) //remember this applies for Nil as well
  }


  //Exercise 3.5: Implement dropWhile, which removes elements from the List prefix as long as they match a predicate.
  def dropWhile[A](l: Aug31_functionalDataStructures[A], f: A => Boolean): Aug31_functionalDataStructures[A]={
    @annotation.tailrec
    def loop(l:Aug31_functionalDataStructures[A],f:A=>Boolean,n:Int):Int = if (l == Nil || !f(head(l))) n
    else loop(tail(l),f,n+1)
    drop(l,loop(l,f,0))
  }

  /*
  Exercise 3.6: Not everything works out so nicely. Implement a function, init, that returns a List consisting of all but the last element of a List.
  So, given List(1,2,3,4), init will return List(1,2,3).
  Why can’t this function be implemented in constant time like tail?
  Ans: It is like a singly linked list, we will have to traverse it until the last element, hence it is not O(1).
   */
  def init[A](l: Aug31_functionalDataStructures[A]): Aug31_functionalDataStructures[A]={
//    @annotation.tailrec
    def loop(l: Aug31_functionalDataStructures[A]):Aug31_functionalDataStructures[A]=l match {
      case Cons(x,Nil) => Nil
      case Cons(x,xs) => Cons(x,loop(xs))
      case _ => Nil
    }
    loop(l)
  }

}



