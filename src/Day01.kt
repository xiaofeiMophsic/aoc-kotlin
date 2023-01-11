import java.util.Spliterator

fun main() {
    fun part1(input: List<String>): Int {
        val elves = input.split { it.isBlank() }
        return elves.maxOf {
            it.sumOf { value -> value.toInt() }
        }
    }

    fun part2(input: List<String>): Int {
        val elves = input.split { it.isBlank() }

        return elves.sortedByDescending { it.sumOf { value -> value.toInt() } }
            .take(3)
            .sumOf {
                it.sumOf { value -> value.toInt() }
            }
    }

    // test if implementation meets criteria from the description, like:
    val input = readInput("Day01")
    println(part1(input))

    println(part2(input))
}

public inline fun <T> Iterable<T>.split(predicate: (T) -> Boolean): List<List<T>> {
    return fold(mutableListOf<MutableList<T>>()) { lists, current ->
        if (predicate(current)) {
            lists.add(mutableListOf())
        } else {
            lists.lastOrNull()?.add(current) ?: run {
                lists.add(mutableListOf<T>().apply {
                    this + current
                })
            }
        }
        lists
    }
}