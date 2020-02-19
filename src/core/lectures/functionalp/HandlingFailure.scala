package core.lectures.functionalp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("FAILURE"))

  def unsafeMethod(): String = throw new RuntimeException("FFFUUU")

  //Try objects via apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  //utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  //IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  //map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  //for-comprehensions
  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html> ... </html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def get(host: String, port: String): Connection = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }
  }

  Try(HttpService.get(host, port)).flatMap(connection => Try(connection.get("some_url"))).foreach(renderHTML)


}
