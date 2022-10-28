// Source video: https://www.youtube.com/watch?v=qe85507fSc8
// Channel: https://www.youtube.com/c/RocktheJVM

val aNumber = 42
val ordinal = aNumber match
  case 1 => "first"
  case 2 => "second"
  case 3 => "third"
  case _ => s"${aNumber}th"

case class Person(name: String, age: Int)
val bob = Person("Bob", 34)
val bobGreeting = bob match
  case Person(n, a) => s"name: $n, age: $a"


// pattern matching trick #1 list extractors
val numberList = List(1,2,3,42)
val mustHaveThree = numberList match
  case List(_, _, 3, fourth) => s"List has 3rd element = 3, length = 4 and the fourth element = $fourth"
  case _ => "List length != 4 or does not have 3rd element = 3"

val numberList2 = numberList :+ 5
val mustHaveThree2 = numberList2 match
  case List(_, _, 3, fourth, _*) => s"List has 3rd element = 3 and the fourth element = $fourth"
  case _ => "List does not have 3rd element = 3"


// pattern matching trick #2 Haskell-like prepending
// val list1 = List(1,2,3,4,5)
// val list1 = List(0,1,2,3,4,5)
// val list1 = List()
val list1: List[Int] = null
val startsWithOne = list1 match
  case 1 :: tail => s"List starts with 1, and tail = $tail"
  case head :: tail => s"List starts with $head (not 1), and tail = $tail"
  case Nil => "List is empty"
  case _ => "bad things, man"


  // pattern matching trick #3 vararg pattern
  val list2 = List(1,2,3,4)
  // val list2 = List(0,1,2,3,4)
  val dontCareAboutTheRest = list2 match
    case List(_, 2, _*) => "Only care about the 2nd element being 2"
    case _ => "2nd element is not = 2" 
  