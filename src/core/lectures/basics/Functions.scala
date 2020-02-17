package core.lectures.basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("letter", 4))

  def aParameterLessFunction(): Int = 3

  println(aParameterLessFunction())
  println(aParameterLessFunction)

  //WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Hello with side effect")

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  println(aBigFunction(5))

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(48))

}
