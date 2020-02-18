package core.lectures.functionalp

object TuplesAndMaps extends App {

  //tuples = finite ordered "lists"
  val aTuple0 = new Tuple2(2, "hello, tuple") //Tuple2[Int, String] = (Int, String)
  val aTuple1 = Tuple2(2, "hello, tuple") //Tuple2[Int, String] = (Int, String)
  val aTuple2 = (2, "hello, tuple") //Tuple2[Int, String] = (Int, String)

  println(aTuple0._1) // -> 2
  println(aTuple0.copy(_2 = "goodbye, Java"))
  println(aTuple0.swap)

  //Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook)

  //map operations
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))

  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functional on maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  //filterKeys
  println(phoneBook.view.filterKeys(x => x.startsWith("J")))
  //mapValues
  println(phoneBook.view.mapValues(number => number * 10))

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  def socialConnection(network: Map[String, Set[String]], person1: String, person2: String): Boolean = {

    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(person2, Set(), network(person1) + person1)
  }

}
