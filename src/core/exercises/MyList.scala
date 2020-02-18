package core.exercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(f: A => Unit): Unit

  //hofs
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)


  //high-order functions
  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //hofs
  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else Empty

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  //  override def sort(compare: (A, A) => Int): MyList[A] = {
  //    def insert(x: A, sortedList: MyList[A]): MyList[A] =
  //      if (sortedList.isEmpty) new Cons(x, Empty)
  //      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
  //      else Cons(sortedList, insert(x, sortedList.tail))
  //
  //    val sorted = t.sort(compare)
  //    insert(h, sorted)

  override def sort(compare: (A, A) => Int): MyList[A] = ???

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  override def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }
}

trait MyPredicate[-T] { // T => Boolean
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] { // A => B
  def transform(elem: A): B
}
