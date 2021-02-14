package boostcourse

fun main() {
    var skills = "Kotlin"

    val a = 10
    skills = run {
        val level = "Kotlin Level:" + a
        level // 마지막 표현식이 반환됨
    }
    println(skills) // Kotlin Level: 10

    // apply , run 비
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    val retrunObj = person.apply {
        this.name = "Sean"
        this.skills = "Java"
        "success" // 사용되지 않음
    }
    println(person) // Person(name=Sean, skills=Java)
    println(retrunObj)  // Person(name=Sean, skills=Java)

    val retrunObj2 = person.run {
        this.name = "Dooly"
        this.skills = "C#"
        "success" // 반환
    }
    println(person) // Person(name=Dooly, skills=C#)
    println(retrunObj2)  // success

}