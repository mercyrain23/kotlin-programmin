package boost

fun main() {
    retFunc()
    retFunc2()
    labelBreak()
    labelBreak2()
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("start of retFunc")

//    inlineLambda(12, 3) { a, b ->
//        val result = a + b
//        if (result > 10) return // 아래 실행하지 않고 함수 빠져나감
//    }

    inlineLambda(13, 3) lit@{ a, b ->  // ① 람다식 블록의 시작 부분에 라벨을 지정함
        val result = a + b
        if(result > 10) return@lit // ② 라벨을 사용한 블록의 끝부분으로 반환 , return@a 1 <- 특정 값 반환시
        println("result: $result")
    } // ③ 이 부분으로 빠져나간다
    println("end of retFunc") //  ④ 이 부분이 실행됨
}

// 암묵적 라벨
fun retFunc2() {
    println("start of retFunc")
    inlineLambda(13, 3) { a, b ->
        val result = a + b
        if(result > 10) return@inlineLambda
        println("result: $result")
    }
    println("end of retFunc")
}

fun labelBreak() {
    println("labelBreak")
    for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) break
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

fun labelBreak2() {
    println("labelBreak")
    first@ for(i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) break@first
            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}