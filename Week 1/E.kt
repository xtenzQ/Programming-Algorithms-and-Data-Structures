package week1

import java.io.*

fun <T : Closeable, R> T.useWith(block: T.() -> R): R = use { with(it, block) }

fun main(args: Array<String>) {
    File("input.txt").bufferedReader().useWith {
        File("output.txt").printWriter().useWith {
            val n = readLine()!!.toInt()
            val arr: ArrayList<Long> = readLine()!!.split(' ').map(String::toLong).toCollection(ArrayList())

            // One by one move boundary of unsorted subarray
            for (i in 0 until n - 1) {
                // Find the minimum element in unsorted array
                var min_idx = i
                for (j in i + 1 until n)
                    if (arr[j] < arr[min_idx])
                        min_idx = j

                // Swap the found minimum element with the first
                // element
                val temp = arr[min_idx]
                arr[min_idx] = arr[i]
                arr[i] = temp
                if (min_idx != i) {
                    println("Swap elements at indices ${i + 1} and ${min_idx + 1}.")
                }

            }

            print("No more swaps needed.\n")
            for (element in arr) print("$element ")
        }
    }
}