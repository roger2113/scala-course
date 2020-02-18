package core.lectures.functionalp

object Sequences extends App {

  //Seq
  val aSequence = Seq(1, 2, 4, 3)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 until 10).foreach(x => println("Hello " + x))

  //lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(apples5.mkString("-|-"))

  //arrays - equivalent java array
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  //arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  //vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  //vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1_000_000

  //  def getWriteTime(collection: Seq[Int]): Double = {
  //    val r = new Random
  //    val times = for {
  //      it <- to maxRuns
  //    } yield {
  //      val currentTime = System.nanoTime()
  //      collection.updated(r.nextInt(maxCapacity), 0)
  //      System.nanoTime() - currentTime
  //    }
  //
  //    times.sum * 1.0 / maxRuns
  //  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector


}
