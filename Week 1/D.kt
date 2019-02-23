package week1

import java.io.*

fun <T : Closeable, R> T.useWith(block: T.() -> R): R = use { with(it, block) }

fun main(args: Array<String>) {
    File("input.txt").bufferedReader().useWith {
        File("output.txt").printWriter().useWith {
            val n = readLine()!!.toInt()
            val arr: ArrayList<Float> = readLine()!!.split(' ').map(String::toFloat).toCollection(ArrayList())
            val iArr: ArrayList<Int> = (1..n).toCollection(ArrayList())
            for (j in 1 until n) {
                val key = arr[j]
                val iKey = iArr[j]
                var i = j - 1
                while ((i >= 0) && (arr[i] > key)) {
                    arr[i + 1] = arr[i]
                    iArr[i + 1] = iArr[i]
                    i--
                }
                arr[i + 1] = key
                iArr[i + 1] = iKey
            }
            print("${iArr[0]} ${iArr[(n - 1) / 2]} ${iArr[n - 1]}")
        }
    }
}
