package boostcourse

fun main() {

    // 인라인 함수 shortFunc의 내용이 복사되어 들어감
    shortFunc(3) { println("First call: $it") }
    shortFunc(5) { println("Second call: $it") }

    sub( { println("inline") }, { println("noinline ") })

    shortFunc(3) {
        println("First call: $it")
        return // ①
    }

    shortFunc2(3) {
        println("First call: $it")
//        return // ①
    }

    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))

    // 중위 표현법
    val multi = 3 multiply 10
    println(multi)

    val num = 3
    val str = num strPlus "Kotlin"
    println(str)

    val number = 5
    println("Factorial: $number -> ${factorial(number)}")
}

//fun(x: Int, y: Int): Int = x + y // 함수 이름이 생략된 익명 함수

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}

inline fun sub(out1: () -> Unit, noinline out2: () -> Unit) {
}

inline fun shortFunc2(a: Int, crossinline out: (Int) -> Unit) {
    println("Before calling out()")
//    nestedFunc { out(a) }
    println("After calling out()")
}

fun String.getLongString(target: String): String =
    if (this.length > target.length) this  else target


// Int를 확장해서 multiply() 함수가 하나 더 추가되었음
infix fun Int.multiply(x: Int): Int {  // infix로 선언되므로 중위 함수
    return this * x
}

infix fun Int.strPlus(x: String): String {
    return "$x version $this"
}

tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial(n-1, run*n)
}
