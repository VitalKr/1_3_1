const val minute = 60
const val hour = minute * 60
const val day = hour * 24
const val twoDays = day * 2
const val threeDays = day * 3

fun main() {
    var time: Int
    do {
        println()
        println("Введите время проведенное в сети в секундах или \"end\" для выхода.")
        val timeUser = readln()
        if (timeUser != "end") {
            try {
                time = timeUser.toInt()
            } catch (e: Exception) {
                println("ВНИМАНИЕ!!! Вы ввели не число!")
                continue
            }
            val timeMin = time / 60
            val timeHour = time / 60 / 24

            println(agoToText(time, timeMin, timeHour))
        }
    } while (timeUser != "end")
}

private fun agoToText(time: Int, timeMin: Int, timeHour: Int): String =
    when (time) {
        in 1..minute -> "был(а) только что"
        in (minute + 1)..hour -> "был(а) $timeMin ${nameNumMin(timeMin)} назад"
        in (hour + 1)..day -> "был(а) в сети $timeHour ${nameNumHour(timeHour)} назад"
        in (day + 1)..twoDays -> "был(а) в сети сегодня"
        in (twoDays + 1)..threeDays -> "был(а) в сети вчера"
        in (threeDays + 1)..Int.MAX_VALUE -> "был(а) в сети давно"
        else -> "Ошибка ввода данных!"
    }

fun nameNumMin(timeMin: Int): String {
    val (timeMin100, timeMin10) = timeCount(timeMin)
    return when {
        timeMin100 in 11..19 -> "минут"
        timeMin10 == 1 -> "минуту"
        timeMin10 in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun nameNumHour(timeHour: Int): String {
    val (timeHour100, timeHour10) = timeCount(timeHour)
    return when {
        timeHour100 in 11..19 -> "часов"
        timeHour10 == 1 -> "час"
        timeHour10 in 2..4 -> "часа"
        else -> "часов"
    }
}

private fun timeCount(timeMin: Int): Pair<Int, Int> {
    val timeMin100 = (timeMin) % 100
    val timeMin10 = (timeMin) % 10
    return Pair(timeMin100, timeMin10)
}




