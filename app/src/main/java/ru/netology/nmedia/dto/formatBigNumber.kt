package ru.netology.nmedia.dto

fun formatBigNumber(number: Int): String {
    var firstNumber: Int
    var secondNumber: Int
    when (number) {
        in 1_000..9_999 -> {
            firstNumber = number / 1_000
            secondNumber = number % 1_000
            return if (secondNumber > 100) {
                secondNumber /= 100
                firstNumber.toString() + "." + secondNumber.toString() + "K"
            } else {
                firstNumber.toString() + "K"
            }
        }

        in 10_000..99_999 -> {
            firstNumber = number / 1_000
            return firstNumber.toString() + "K"
        }

        in 100_000..999_999 -> {
            firstNumber = number / 1_000
            return firstNumber.toString() + "K"
        }

        in 1_000_000..999_999_999 -> {
            firstNumber = number / 1_000_000
            secondNumber = number % 1_000_000
            return if (secondNumber > 100_000) {
                secondNumber /= 100_000
                firstNumber.toString() + "." + secondNumber.toString() + "M"
            } else {
                firstNumber.toString() + "M"
            }
        }
    }
    return number.toString()
}