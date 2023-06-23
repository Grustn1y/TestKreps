fun main(args: Array<String>) {
    var valueFirstCube: Int
    var valueSecondCube: Int
    var lastCubesValue: Int = 0

    var minimalBet:Int=50
    var playerBet: Int = 0
    val playerBank: Int = 500

    var gameOver: Boolean = true
    var victoryInFirstRound: Boolean = false

    println("Первый этап игры: Come Out Roll ")
    println("Ваш банк составляет $playerBank монет ")
    println("Нажмите Enter чтобы начать игру ")
    readLine()

    while (gameOver) {
        println("Введите сумму вашей ставки")
        playerBet = readln()!!.toInt()

        while (true)
        {
            if (playerBet<minimalBet)
            {
                println("Ваша ставка меньше допустимой, установите сумму больше")
                playerBet = readln()!!.toInt()
            }
            else if (playerBet>=minimalBet)
            {
                break
            }
            else if (playerBet>playerBank)
            {
                println("Ваша ставка превышает банк,введите сумму меньше")
                playerBet = readln()!!.toInt()
            }
        }

        valueFirstCube = (1..6).random()
        valueSecondCube = (1..6).random()

        println("На первой кости выпало $valueFirstCube")
        println("На второй кости выпало $valueSecondCube")

        lastCubesValue = valueFirstCube + valueSecondCube

        if (valueFirstCube + valueSecondCube == 2 || valueFirstCube + valueSecondCube == 3 || valueFirstCube + valueSecondCube == 12) {
            println("Вы проигали, игра окончена, ваш банк составляет ${playerBank - playerBet}")
            gameOver = false
            victoryInFirstRound=false
        }
        if (valueFirstCube + valueSecondCube == 7 || valueFirstCube + valueSecondCube == 11) {
            println("Поздравляем, вы выиграли, ваш банк составляет ${playerBank + playerBet}")
            gameOver = false
            victoryInFirstRound=false
        }
        else {
            println("Поздравляем вы перешли на следующий этап")
            println()
            victoryInFirstRound = true
            gameOver=false
        }
    }
    if (victoryInFirstRound)
    {
        gameOver=true
        println("Второй этап игры: Point Roll")
        println("Необходимо  выбить то же число что и на предыдущем раунде, но до первого выпадения 7")
        println("Нажмите Enter чтобы начать игру ")
        readLine()

        while (gameOver)
        {
            println("Введите сумму вашей ставки")
            playerBet= readln()!!.toInt()

            valueFirstCube= (1..6).random()
            valueSecondCube= (1..6).random()

            println( "На первой кости выпало $valueFirstCube")
            println( "На второй кости выпало $valueSecondCube")

            if (valueFirstCube+valueSecondCube==7)
            {
                gameOver=false
                println("Вы проиграли: сумма вашего банка ${playerBank-playerBet}")

            }
            if (valueFirstCube+valueSecondCube==lastCubesValue)

            {
                println("Вы выиграли: сумма вашего банка составляет  ${playerBank+playerBet}")
                gameOver=false
            }
            else
            {
                println("У вас нет выигрышной или проигрышной комбинации, вы можете перебросить кости еще раз")
                println()
                continue
            }
        }
    }
}
