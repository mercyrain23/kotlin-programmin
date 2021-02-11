package boost

fun main() {

    val result: Int

//    val multi = { a: Int, b: Int -> a * b }
//    val multi: (a: Int, b: Int) -> Int = { a, b -> a * b }
    val multi: (a: Int, b: Int) -> Int = { a, b ->
        println("$a, $b")
        a * b
    }

    result = multi(10, 20)
    println(result)

    val greet: () -> Unit = { println("Hello World!") }
    val squre = { x: Int -> x * x } // 선언 부분 생략하려면 x 자료형 명시
    val nestedLambda: () -> () -> Unit = { { println("Nested Lambda") }}


    val result1 = callByValue(lambda()) // 람다식 함수를 호출
    println(result1)

    val result2 = callByName(otherLambda) // 람다식 이름으로 호출
    println(result2)

    // 1. 인자와 반환값이 있는 함수
    val res1 = funcParam(3, 2, ::sum)
    println(res1)

    // 2. 인자가 없는 함수
    hello(::text) // 반환값이 없음

    // 3. 일반 변수에 값처럼 할당
    val likeLambda = ::sum
    println(likeLambda(6,6))

    // 매개변수 없는 람다식 함수
    noParam({ "Hello World!" })
    noParam { "Hello World!" } // 위와 동일 결과, 소괄호 생략 가능

    // 매개변수가 하나 있는 람다식 함수
    oneParam({ a -> "Hello World! $a" })
    oneParam { a -> "Hello World! $a" } // 위와 동일 결과, 소괄호 생략 가능
    oneParam { "Hello World! $it" }  // 위와 동일 결과, it으로 대체 가능

    // 매개변수가 두 개 있는 람다식 함수
    moreParam { a, b -> "Hello World! $a $b" } // 매개변수명 생략 불가
}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {  // 람다 표현식이 두 줄이다
    println("lambda function")
    true 		    // 마지막 표현식 문장의 결과가 반환
}

fun callByName(b: () -> Boolean): Boolean { // 람다식 함수 자료형으로 선언된 매개변수
    println("callByName function")
    return b()
}

val otherLambda: () -> Boolean = {
    println("otherLambda function")
    true
}

fun sum(a: Int, b: Int) = a + b

fun text(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}

// 매개변수가 없는 람다식 함수가 noParam 함수의 매개변수 out으로 지정됨
fun noParam(out: () -> String) = println(out())

// 매개변수가 하나 있는 람다식 함수가 oneParam함수의 매개변수 out으로 지정됨
fun oneParam(out: (String) -> String) {
    println(out("OneParam"))
}

// 매개변수가 두 개 있는 람다식 함수가 moreParam 함수의 매개변수로 지정됨
fun moreParam(out: (String, String) -> String) {
    println(out("OneParam", "TwoParam"))
}