package fps

import java.util.function.Predicate

import scala.annotation.tailrec

package object excercisesChapter3 {

  def tail[A](xs: List[A]): List[A] = {
    drop(xs, 1)
  }

  def setHead[A](xs : List[A], a: A): List[A] = {
    xs match {
      case Nil => scala.sys.error("trying to set head element on Nil")
      case h :: t =>
        a :: t
    }
  }

  @tailrec
  def drop[A](xs: List[A], i: Int) : List[A] = {
    xs match {
      case Nil => Nil
      case h :: t if i > 0=>
        drop(t, i - 1)
      case _ =>
        xs
    }
  }

  @tailrec
  def dropWhile[A](xs: List[A], p: A => Boolean) : List[A] = {
    xs match {
      case Nil => Nil
      case h :: t if p(h) =>
        dropWhile(t, p)
      case _ =>
        xs
    }
  }

  def init[A](xs: List[A]): List[A] = {
    @tailrec
    def _init(it: List[A], acc: List[A] = Nil): List[A] = {
      it match {
        case h :: Nil =>
          acc
        case Nil =>
          acc
        case h :: t =>
          _init(t, h :: acc)
      }
    }
    reverse(_init(xs))
  }

  def reverse[A](xs: List[A]): List[A] = {
    @tailrec
    def _reverse[A](_xs: List[A], acc: List[A] = Nil): List[A] = {
      _xs match {
        case Nil => acc
        case h :: t =>
          _reverse(t, h :: acc)
      }
    }
    _reverse(xs)
  }
}
