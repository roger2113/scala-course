package core.lectures.basics

object Expressions extends App {

  val x = 1 + 3
  println(x)
  println(1 + 3 * 4)
  println(1 == x)
  println(!(1 == x))

  var aVariable1 = 2
  aVariable1 +=4
  println(aVariable1)

  //INSTRUCTIONS (DO) vs EXPRESSIONS (VALUE)

  //IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // - IF expression, returns value, not tells to set value
  println(aConditionValue)

  //EVERYTHING IN SCALA IS AN EXPRESSION

  var aVariable = 2
  val aWeirdValue = (aVariable = 3) //Unit type ==== void
  println(aWeirdValue) //()

  //side effects: println(), whiles, reassigning

  // Code blocks

  //code block is an expression
  //code block value is value of the last expression
  val aCodeBlock = {
    val y = 2
    val z = 7

    if(z > y) "hello" else "good bye "
  }

  println(aCodeBlock) //'hello'

}
