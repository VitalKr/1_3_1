fun main(args: Array<String>) {

    var time = 0
    val minute = 60
    val hour = minute * 60
    val day = hour * 24
    val twoDays = day * 2
    val threeDays = day * 3

    do {
        println()
        println("Введите время проведенное в сети в секундах или \"end\" для выхода.")
        val timeUser = readln()
        if (timeUser != "end") {
            try {
                time = timeUser.toInt()

            } catch (e: Exception) {
                println("ВНИМАНИЕ!!! Вы ввели не число!")
            }

            println(agoToText(time, minute,  hour, day, twoDays, threeDays))
        }
    } while (timeUser != "end")
}

private fun agoToText(
    time: Int,
    minute: Int,
    hour: Int,
    day: Int,
    twoDays: Int,
    threeDays: Int
): String {

    val text = when (time) {
        in 1..minute -> "был(а) только что"
        in (minute + 1)..hour -> "был(а) ${time / 60} ${nameNumMin(time)} назад"
        in (hour + 1)..day -> "был(а) в сети ${time / 60 / 24} ${nameNumHour(time)} назад"
        in (day + 1)..twoDays -> "был(а) в сети сегодня"
        in (twoDays + 1)..threeDays -> "был(а) в сети вчера"
        in (threeDays + 1) .. Int.MAX_VALUE  -> "был(а) в сети давно"
        else -> "Ошибка ввода данных!"
    }
    return text
}

fun nameNumMin(time: Int): String {
    val timeMin100 = (time / 60) % 100
    val timeMin10 = (time / 60) % 10
    return when {
        timeMin100 in 11..19 -> "минут"
        timeMin10 == 1 -> "минуту"
        timeMin10 in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun nameNumHour(time: Int): String {
    val timeHour100 = (time / 60 / 24) % 100
    val timeHour10 = (time / 60 / 24) % 10
    return when {
        timeHour100 in 11..19 -> "часов"
        timeHour10 == 1 -> "час"
        timeHour10 in 2..4 -> "часа"
        else -> "часов"
    }
}



