package boostcourse

fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // 여기서 this는 person 객체를 가리킴
    person.apply { this.skills = "Swift" } // it 이 아니라 this 사용. (생략가능)
    println(person) // Person(name=Kildong, skills=Swift)

    val retrunObj = person.apply {
        name = "Sean" // ① this는 생략할 수 있음
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
    }
    println(person) // Person(name=Sean, skills=Java)
    println(retrunObj)  // Person(name=Sean, skills=Java)

    // 디렉터리 생성
//    File(path).apply { mkdirs() }
}