package boostcourse

import java.io.File

fun main() {
    data class Person(var name: String, var skills: String)
    var person = Person("Kildong", "Kotlin")

    val a = person.let {
        it.skills = "Android"
        "success" // 마지막 문장을 결과로 반환
    }

    println(person) // Person(name=Kildong, skills=Android)
    println("a: $a") // a: success

    val b = person.also {
        it.skills = "Java"
        "seccess" // 마지막 문장 사용되지 않음
    }

    println(person) // Person(name=Kildong, skills=Java)
    println("b: $b") // b: Person(name=Kildong, skills=Java)

    // 디렉터리 생성 함수
//    fun makeDir(path: String): File {
//        val result = File(path)
//        result.mkdirs()
//        return result
//    }
    fun makeDir(path: String) = path.let{ File(it) }.also{ it.mkdirs() }
}