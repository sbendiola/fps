package fps

import scala.annotation.tailrec

package object excercisesChapter2 {
  //2.1
  /*
  first 2 fibonaci numbers are 0 and 1, the nrh is the sum of the previous 2
  */
  def fib(n: Int): Int = {
    @tailrec
    def _fib(i: Int, prev: Int, next: Int): Int = {
      val x = prev + next
      if (i == 0) prev
      else if (i == 1) next
      else _fib(i - 1, next,  prev + next)
    }
    _fib(n, 0, 1)
  }

  //2.2
  @tailrec
  def isSorted[A](as: List[A], ordered: (A, A) => Boolean): Boolean = as match {
    case h :: t:: rest =>
      if (ordered(h, t)) isSorted(t :: rest, ordered)
      else false
    case _ => true
  }
  //2.3
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => b: B => f(a, b)
  }

  //2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  //2.5
  def compose[A, B, C](d: B => C, f: A => B): A => C = {
    a: A => d(f(a))
  }
}
