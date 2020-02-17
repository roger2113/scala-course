package core.lectures.oop

object Exceptions extends App {

  val x: String = null
  //  println(x.length)

  //  val aWeirdValue: String = throw new NullPointerException
  //Exception and Error are the main throwable classes

  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you!")
    else 42
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    println("finally")
  }

  println(potentialFail)

  class MyException extends Exception
  val exception = new MyException
//  throw  exception

}
