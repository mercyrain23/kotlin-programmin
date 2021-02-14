package boostcourse

import kotlin.random.Random

fun main() {
//    if (someObject != null && someObject.status) {
//        doThis()
//    }
//    someObject?.takeif { it.status }?.apply { doThis() }

    val input = "Kotlin"
    val keyword = "in"

    // 입력 문자열에 키워드가 있으면 인덱스를 반환하는 함수를 takeIf 를 사용
    input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")
    input.indexOf(keyword).takeUnless { it < 0 } ?: error("keyword not found")

//     시간 측정
     val executionTime = measureTimeMillis {
        // 측정할 작업 코드
    }
    println("Execution Time = $executionTime ms")

    // 난수 생성하기
    val number = Random.nextInt(21)  // 숫자는 난수 발생 범위
    println(number)
}

// 코틀린 system 패키지의 Timing.kt 파일
public inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

public inline fun measureNanoTime(block: () -> Unit): Long {
    val start = System.nanoTime()
    block()
    return System.nanoTime() - start
}