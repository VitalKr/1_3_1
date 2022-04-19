const val SECUNDA: Int = 60
const val MINUTE: Int = 60
const val HOUR: Int = MINUTE * SECUNDA
const val DAY: Int = HOUR * 24
const val TWO_DAYS: Int = DAY * 2
const val TREE_DAYS: Int = DAY * 3

fun main() {
    var time: Int
    do {
        println()
        println("Введите время проведенное в сети в секундах или \"end\" для выхода.")
        val inputUser = readln()
        if (isNotEnd(inputUser)) {
            try {
                time = inputUser.toInt()
            } catch (e: Exception) {
                println("ВНИМАНИЕ!!! Вы ввели не число!")
                continue
            }

            println(agoToText(time))
        }
    } while (isNotEnd(inputUser))
}

private fun isNotEnd(timeUser: String) = timeUser != "end"

private fun agoToText(time: Int): String =
    when (time) {
        in 1..MINUTE -> "был(а) только что"
        in (MINUTE + 1)..HOUR -> {
            val timeMin = time / MINUTE
            "был(а) $timeMin ${nameNumMin(timeMin)} назад"
        }
        in (HOUR + 1)..DAY -> {
            val timeHour = time / MINUTE / SECUNDA
            "был(а) в сети $timeHour ${nameNumHour(timeHour)} назад"
        }
        in (DAY + 1)..TWO_DAYS -> "был(а) в сети сегодня"
        in (TWO_DAYS + 1)..TREE_DAYS -> "был(а) в сети вчера"
        in (TREE_DAYS + 1)..Int.MAX_VALUE -> "был(а) в сети давно"
        else -> "Ошибка ввода данных!"
    }

fun nameNumMin(timeMin: Int) = nameNum(
    num = timeMin,
    one = "минуту",
    few = "минуты",
    many = "минут"
)

fun nameNumHour(timeHour: Int) = nameNum(
    num = timeHour,
    one = "час",
    few = "часа",
    many = "часов"
)

fun nameNum(num: Int, one: String, few: String, many: String): String {
    val remain10 = num % 10
    val remain100 = num % 100
    return when {
        remain100 in 11..19 -> many
        remain10 == 1 -> one
        remain10 in 2..4 -> few
        else -> many
    }
}




