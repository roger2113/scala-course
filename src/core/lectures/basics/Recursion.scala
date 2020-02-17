package core.lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def anotherFactorial(n: BigInt): BigInt = {
    @tailrec
    def factHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION, helps with stack overflow = use recursive call as the LAST expresion

    factHelper(n, 1)
  }

}
