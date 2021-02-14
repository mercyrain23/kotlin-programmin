package boostcourse

// let(), also()
fun main() {
    val score: Int? = 32

    // let을 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") } // score 이 null 아 아니면 실행. score 값을 it 에 복사한다
       val str = score.let { it.toString() } // ②
        println(str)
    }

    checkScoreLet()

    // let 함수의 체이닝
    var a = 1
    var b = 2

    a = a.let { it + 2 }.let {
        val i = it + b
        i  // 마지막 식 반환
    }
    println(a) //5


    // let 의 중첩 사용
    var x = "Kotlin!"
    x.let { outer ->
        outer.let { inner ->
            print("Inner is $inner and outer is $outer") // 이때는 it을 사용하지 않고 명시적 이름을 사용
        }
    }

    // 반환값을 바깥쪽의 람다식에만 적용
   var y = "Kotlin!"
    y = y.let { outer ->
        outer.let { inner ->
            print("Inner is $inner and outer is $outer")
            "Inner String" // 이것은 반환되지 않음
        }
        "Outer STring" // 이 문자열이 반환되어 y에 할당
    }

    // null 체크
    val firstName: String? = "hi"
    val lastName: String = "hello"

    if (null != firstName) {
        print("$firstName $lastName")
    } else {
        print("$lastName")
    }
    firstName?.let { print("$it $lastName") } ?: print("$lastName")

}
