package org.example

class GameInput(input: String) {
    private val input = input.split(",")
    var validated = validateInput()
    fun interpret(): Command {
        return if (input[0] == "W"){
            Command(
                wall = input[0] == "W",
                rows = IntRange(input[2].toInt(), input[4].toInt()),
                cols = IntRange(Letters.indexOf(input[1]), Letters.indexOf(input[3]))
            )
        } else {
            Command(
                wall = false,
                rows = IntRange(input[2].toInt(), input[2].toInt()),
                cols = IntRange(Letters.indexOf(input[1]), Letters.indexOf(input[1])),
                player = input[0].toByte()
            )
        }
    }

    fun validateInput(): Boolean {
        if (input.first().toString() !in listOf("W", "0", "1")) {
            return false
        }

        if (input.first() == "W") {
            if (input.size != 5) return false
            if (!trailingPatternValidation(input.subList(1, input.size))) {
                return false
            }
        } else {
            if (input.size != 3) return false
            if (!trailingPatternValidation(input.subList(1, input.size))) {
                return false
            }
        }
        return true
    }

    private fun trailingPatternValidation(trailingInput: List<String>): Boolean {
        for (i in trailingInput.indices) {
            if (i % 2 != 0 && !trailingInput[i].containsOnlyLetters()) {
                continue
            } else if (trailingInput[i].containsOnlyLetters()) {
                continue
            } else {
                return false
            }
        }
        return true
    }
    private fun String.containsOnlyLetters(): Boolean = this.all { it.isLetter() }
}