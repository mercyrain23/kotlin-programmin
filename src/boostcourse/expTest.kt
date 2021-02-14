package boostcourse

fun main() {
    for (x in 1..5) { // 코틀린의 in과 범위 지정을 활용한 루프
        println(x) // 본문
    }

    for (i in 5 downTo 1) print(i)

    for (i in 1..5 step 2) print(i)
}