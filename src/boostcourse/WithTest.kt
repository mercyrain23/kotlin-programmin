package boostcourse

fun main() {
    data class User(val names: String, var skills: String, var email: String? = null)

    val user = User("Kildong", "default")

    val result = with(user) { // receiver의 this로 받음
        skills = "Kotlin"
        email = "Kildong@example.com"
        // 반환이 없으면 Unit 이 반환
    }
    println(user) // User(names=Kildong, skills=Kotlin, email=Kildong@example.com)
    println("result: $result") // result: kotlin.Unit
}