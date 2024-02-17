package org.example

class GameInput(private val input: String) {
    var validated = validateInput()
    fun interpret(): Command {
        if (input[0] == 'W'){
            return Command(
                wall = input[0] == 'W',
                rows = IntRange(input[2].toString().toInt(), input[4].toString().toInt()),
                cols = IntRange(Letters.indexOf(input[1]), Letters.indexOf(input[3]))
            )
        } else {
            return Command(
                wall = false,
                rows = IntRange(input[2].toString().toInt(), input[2].toString().toInt()),
                cols = IntRange(Letters.indexOf(input[1].toString()), Letters.indexOf(input[1].toString())),
            )
        }
    }

    fun validateInput(): Boolean {
        if (input.first().toString() !in listOf("W", "0", "1")) {
            return false
        }

        if (input.first() == 'W') {
            if (input.length != 5) return false
            if (!trailingPatternValidation(input.substring(1, input.length))) {
                return false
            }
        } else {
            if (input.length != 3) return false
            if (!trailingPatternValidation(input.substring(1, input.length))) {
                return false
            }
        }
        return true
    }

    private fun trailingPatternValidation(trailingInput: String): Boolean {
        for (i in trailingInput.indices) { //Need to ensure this function is actually correct, in which casee why are we returning false up there
            if (i % 2 != 0 && !trailingInput[i].isLetter()) {
                continue
            } else if (trailingInput[i].isLetter()) {
                continue
            } else {
                return false
            }
        }
        return true
    }
}