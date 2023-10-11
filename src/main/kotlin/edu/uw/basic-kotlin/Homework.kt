package edu.uw.basickotlin

import kotlin.reflect.typeOf

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): Any {
    when(arg) {
        "Hello" -> return "world"
        is String -> return "Say what?"
        0 -> return "zero"
        1 -> return "one"
        in 2..10 -> return "low number"
        is Int -> return "a number"
        else -> return "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(num1: Int, num2: Int): Int {
    return num1 - num2
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(num1: Int, num2: Int, fun1: (input1: Int, input2: Int) -> Int): Int {
     return fun1(num1, num2)
}
// write a class "Person" with first name, last name and age
class Person constructor(var firstName: String, val lastName: String, var age: Int) {
    val debugString = "[Person firstName:${firstName} lastName:${lastName} age:${age}]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money (var amount: Int, var currency: String) {
    init {
        if (amount < 0) {
            println(amount)
        throw IllegalArgumentException("Must be greater than 0")
        }

        val possibleAnswers = listOf("USD","EUR","CAN","GBP")
        if (possibleAnswers.none { it == currency}) {
            throw IllegalArgumentException("Needs to be a valid currency")
        }
    }

    public fun convert(currType: String): Money {
        var initialAmount: Int = when (currency) {
            "GBP" -> amount * 2
            "EUR" -> (amount * 2) / 3
            "CAN" -> (amount * 4) / 5
            else -> amount
        }
        var finalAmount: Int = when (currType) {
            "GBP" -> initialAmount / 2
            "EUR" -> (initialAmount * 3) / 2
            "CAN" -> (initialAmount * 5) / 4
            else -> initialAmount
        }
        return Money(finalAmount, currType)
    }
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.convert(this.currency).amount, this.currency)
    }
}
