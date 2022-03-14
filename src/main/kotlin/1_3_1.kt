fun main(args: Array<String>) {


    val time = 660
    val minute = 60
    val hour = minute * 60
    val day = hour * 24
    val twoDays = day * 2
    val threeDays = day * 3
    var text: String

    when (time) {
        in 1..minute -> text = "только что"
        in (minute + 1)..hour -> text = "минут назад"
        in (hour + 1)..day -> {

            text = "${time / 60} часов назад"
        }
    }


    /*




      println(
          "Если предыдущая сумма покупок от 0 до 1 000 рублей, то никаких скидок нет.\n" +
                  "Если предыдущая сумма покупок от 1 001 до 10 000 рублей, то стандартная скидка - 100 рублей.\n" +
                  "Если предыдущая сумма покупок от 10 001 рубль и выше то % составляет 5% от суммы."
      )
      println("Введите сумму первой покупки:")
      println("Введите рубли:")
      val rub1 = readln()
      println("Введите копейки:")
      val kop1 = readln()

      println("Введите сумму второй покупки:")
      println("Введите рубли:")
      val rub2 = readln()
      println("Введите копейки:")
      val kop2 = readln()
      println("Постоянный покупатель? (y/n)")
      val vip = readln()

      var amount_rub1 = 0
      var amount_kop1 = 0
      var amount1 = 0
      var amount_rub2 = 0
      var amount_kop2 = 0
      var amount2 = 0
      var sum = 0
      var skidka = 0
      try {
          amount_rub1 = rub1.toInt()
          amount_kop1 = kop1.toInt()
          amount_rub2 = rub2.toInt()
          amount_kop2 = kop2.toInt()
          amount1 = amount_rub1 * 100 + amount_kop1
          amount2 = amount_rub2 * 100 + amount_kop2

          print("Сумма первой покупки равна:")
          println("  $amount_rub1 руб. $amount_kop1 коп.")
          print("Сумма второй покупки равна:")
          println("  $amount_rub2 руб. $amount_kop2 коп.")

      } catch (e: Exception) {
          println("Вы ввели не число")
      }
      if ((0 < amount1) && (amount1 <= 1000_00)) {
          sum = amount2

          println("Скидок нет. Ваша сумма покупки составила: " + sum / 100.0 + " руб.")
      }
      if ((1000_00 < amount1) && (amount1 <= 10000_00)) {
          sum = (amount2 - 100)
          println("Ваша скидка 100 руб. Ваша сумма покупки с учетом скидки составила: " + sum / 100.0 + " руб.")
      }
      if (10000_00 < amount1) {
          sum = (amount2 - (amount2 * 5 / 100))
          println("Ваша скидка 100 руб. Ваша сумма покупки с учетом скидки составила: " + sum / 100.0)
      }

      if (vip == "y") {
          skidka = (sum / 100)
          sum = (sum - skidka)
          println(
              "Ваша дополнительная скидка как постоянному клиенту " + skidka / 100.0 + " руб. \n" +
                      "Ваша сумма покупки с учетом скидки составила: " + sum / 100.0 + " руб."
          )

      } else println("Дополнительных скидок нет")

  */
}