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
// val list2 = List(1,2,3,4,5)
val list2 = List(0,1,2,3,4,5)
// val list2 = List(0,1,2,3,4,5)
// val list2 = List()
// val list2: List[Int] = null
val startsWithOne = list2 match
  case ::(1, tail) => s"List starts with 1, and tail = $tail"
  case head :: tail => s"List starts with $head (not 1), and tail = $tail"
  case Nil => "List is empty"
  case null => "bad things, man"


// pattern matching trick #3 vararg pattern
val list3 = List(1,2,3,4)
// val list3 = List(0,1,2,3,4)
val dontCareAboutTheRest = list3 match
  case List(_, 2, _*) => "Only care about the 2nd element being 2"
  case _ => "2nd element is not = 2" 


// pattern matching trick #4 other infix pattern
val list4 = List(1,2,3,42)
// val list4 = List(1,2,3,42,5)
val mustEndWith42 = list4 match
  case List(1,_,_*) :+ 42 => "The list ends with 42"
  case _ => "The list does not end with 42"


// pattern matching trick #5 type specifier
// val gimmeAValue: Any = 45
val gimmeAValue: Any = "45"
val gimmeTheType = gimmeAValue match
  case _: Int => "I got an Int"
  case str: String => s"I got a string = '$str'"
  case _ => "Not sure what we got"


// pattern matching trick #6 name binding
case class SocSecNum(first3: String, second2: String, third4: String)
case class Person2(name: String, age: Int, ssn: SocSecNum)
val betty = Person2("betty", 27, SocSecNum("999", "88", "7777"))
def requestMoreInfo(p: Person2): String = s"The person ${p.name} is a good person."
def bettysInfo = betty match
  case p1 @ Person2(name, age, ssn2 @ ssn) => s"${p1.name}'s info: ${requestMoreInfo(p1)} - ${ssn2.first3}"
bettysInfo


// pattern matching trick #7 conditional guards
