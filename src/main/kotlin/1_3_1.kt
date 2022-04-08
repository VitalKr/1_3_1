const val minute: Int = 60
const val hour: Int = minute * minute
const val day: Int = hour * 24
const val twoDays: Int = day * 2
const val threeDays: Int = day * 3

fun main() {
    var time: Int
    do {
        println()
        println("Введите время проведенное в сети в секундах или \"end\" для выхода.")
        val timeUser = readln()
        if (isNotEnd(timeUser)) {
            try {
                time = timeUser.toInt()
            } catch (e: Exception) {
                println("ВНИМАНИЕ!!! Вы ввели не число!")
                continue
            }

            println(agoToText(time, time / minute, time / minute / minute))
        }
    } while (isNotEnd(timeUser))
}

private fun isNotEnd(timeUser: String) = timeUser != "end"

private fun agoToText(time: Int, timeMin: Int, timeHour: Int): String =
    when (time) {
        in 1..minute -> "был(а) только что"
        in (minute + 1)..hour -> "был(а) $timeMin ${nameNumMin(time / minute)} назад"
        in (hour + 1)..day -> "был(а) в сети $timeHour ${nameNumHour(time / minute / minute)} назад"
        in (day + 1)..twoDays -> "был(а) в сети сегодня"
        in (twoDays + 1)..threeDays -> "был(а) в сети вчера"
        in (threeDays + 1)..Int.MAX_VALUE -> "был(а) в сети давно"
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




