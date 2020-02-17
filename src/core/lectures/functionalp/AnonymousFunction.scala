package core.lectures.functionalp

object AnonymousFunction extends App {

  //  val doubler = new Function[Int, Int] {
  //    override def apply(v1: Int): Int = v1 * 2;
  //  } OR

  //anonymous function = LAMBDA
  val doubler0 = (x: Int) => x * 2
  val doubler1: Int => Int = (x: Int) => x * 2
  val doubler2: Int => Int = x => x * 2

  //multiply parameters
  val adder0 = (a: Int, b: Int) => a + b
  val adder1: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no parameters
  val doSome0 = () => 3
  val doSome1: () => Int = () => 3

  //care
  println(doSome0) //function itself
  println(doSome0()) //call

  //curly bracers to lambds
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b
}
