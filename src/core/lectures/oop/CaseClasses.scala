package core.lectures.oop

object CaseClasses extends App {

  /*
  equals, hashcode, toString
   */

  case class Person(name: String, age: Int)

  //1. Class parameters are fields
  val jim: Person = new Person("Jim", 32)
  println(jim.age)

  //2. sensible toString
  println(jim)

  //3. equals, hashcode implemented
  //4. CCs have handy copy method
  val jim2 = jim.copy(age = 31)
  println(jim2)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 28)

  //6. CCs are serializable
  // Akka

  //7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING


  case object UnitedKingdom

}
