package week1

import java.io.*

fun <T : Closeable, R> T.useWith(block: T.() -> R): R = use { with(it, block) }

fun main(args: Array<String>) {
    File("input.txt").bufferedReader().useWith {
        File("output.txt").printWriter().useWith {
            val (a, b) = readLine()!!.split(' ').map(String::toLong)
            println(a + b)
        }
    }
}
