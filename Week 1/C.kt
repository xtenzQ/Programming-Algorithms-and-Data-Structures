package week1

import java.io.*

fun <T : Closeable, R> T.useWith(block: T.() -> R): R = use { with(it, block) }

fun main(args: Array<String>) {
    File("input.txt").bufferedReader().useWith {
        File("output.txt").printWriter().useWith {
            val n = readLine()!!.toInt()
            val arr: ArrayList<Long> = readLine()!!.split(' ').map(String::toLong).toCollection(ArrayList())
            print("1 ")
            for (j in 1 until n){
                // берем значение текущего элемента массива
                val key = arr[j]
                // берем индекс предыдущего элемента массива
                var i = j - 1
                // если индекс предыдущего элемента больше нуля и предыдущий элемент больше текущего
                while ((i >= 0) && (arr[i] > key)) {
                    // то текущий элемент заменяем на предыдущий
                    arr[i + 1] = arr[i]
                    // и уменьшаем счетчик
                    i--
                }
                // выводим индекс элемента
                if (j != i + 1) print("${i + 2} ") else print("${j + 1} ")
                arr[i + 1] = key
            }
            println()
            for (element in arr) print("$element ")
        }
    }
}
