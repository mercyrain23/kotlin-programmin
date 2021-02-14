package boostcourse

import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.FileReader
import java.io.PrintWriter

fun main() {

    PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
        it.println("hello")
    }
}

private fun readFirstLine():String {
    BufferedReader(FileReader("test.file")).use { return it.readLine() }
}