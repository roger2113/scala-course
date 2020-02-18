package core.lectures.functionalp

object HOFsCurries extends App {

  //  val superFunction: (Int, (String, Int => Boolean) => Int) => (Int => Int) = ???
  //high order function(HOF)

  //function that applies a function n times over value x
  // nTimes(f, n, x)

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x)) // -->

  //CURRIED FUNCTIONS
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y = y + 3
  println(add3(10))
  println(superAdder(3)(10))

  //functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  // toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
  // from Curry(f: (Int => Int => Int)) => (Int, Int) => Int
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def supperAdderI: (Int => Int => Int) = toCurry(_ + _)
  def add4 = supperAdderI(4)
  println(add4(17))

  def simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 17))



  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

}
