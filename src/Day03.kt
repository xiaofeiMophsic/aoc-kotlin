
fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val half = it.length / 2
            val firstComp = it.substring(0, half)
            val secondComp = it.substring(half)

            val result: Int = firstComp.find { c -> secondComp.contains(c, false) }?.let { common ->
                if (common.isUpperCase()) {
                    common.code - 'A'.code + 27
                } else {
                    common.code - 'a'.code + 1
                }
            } ?: 0

            result
        }
    }

    fun part2(input: List<String>): Int {
        val rucksacks = input.foldIndexed(mutableListOf<MutableList<String>>()) {index, lists, current ->
            if (index % 3 == 0) {
                lists.add(mutableListOf())
            }

            lists.lastOrNull()?.add(current) ?: run {
                lists.add(mutableListOf<String>().apply {
                    this + current
                })
            }
            lists
        }

        return rucksacks.sumOf { rucksack ->
            rucksack.fold(mutableSetOf<Char>()) { acc, current->
                if (acc.isEmpty()) {
                    acc += current.toSet()
                    acc
                } else {
                    acc.intersect(current.toSet()).toMutableSet()
                }
            }.map { common->
                if (common.isUpperCase()) {
                    common.code - 'A'.code + 27
                } else {
                    common.code - 'a'.code + 1
                }
            }.singleOrNull() ?: 0
        }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}