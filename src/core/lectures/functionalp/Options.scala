package core.lectures.functionalp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  //unsafe APIs
  def unsafeMethod(): String = null

  //  val result = Some(unsafeMethod()) //WrONg
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  //chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  //functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UNSAFE

  //map , flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //for-comprehensions
  val config: Map[String, String] = Map(
    //fetched from elsewhere
    "host" -> "176.34.11.75",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  //try establish a connection, if so - print the connect method
  val coonectionn = config.get("host").flatMap(host => config.get("port").flatMap(port => Connection.apply(host, port)))

  val connection = Connection apply(config("host"), config("port"))
  private val connectionStatus: Option[String] = connection.map(c => c.connect)
  connectionStatus.foreach(println)

  //chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection.apply(host, port))
      .map(connection => connection.connect))
    .foreach(println)


  //for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
