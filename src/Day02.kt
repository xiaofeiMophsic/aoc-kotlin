// A 石头(1) B 布(2) C 剪刀(3)
// X 石头 Y 布 Z 剪刀
// 0(L), 3(D), 6(W)
val part1ScoreList = mapOf(
    "A X" to 4,
    "A Y" to 8,
    "A Z" to 3,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 7,
    "C Y" to 2,
    "C Z" to 6
)

val part2ScoreList = mapOf(
    "A X" to 3,
    "A Y" to 4,
    "A Z" to 8,
    "B X" to 1,
    "B Y" to 5,
    "B Z" to 9,
    "C X" to 2,
    "C Y" to 6,
    "C Z" to 7
)

fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf {
            part1ScoreList[it] ?: 0
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            part2ScoreList[it] ?: 0
        }
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}