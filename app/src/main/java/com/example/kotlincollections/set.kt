package com.example.kotlincollections

fun main() {

    //region basic set things
    val numbers = setOf(1, 2, 3, 4, 4, 3, 2, 1, 1)
    println(numbers)
    //[1, 2, 3, 4] //stores unique element

    println("size = ${numbers.size}")
    //size = 4

    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}")
    //The sets are equal: true
    //Two sets are equal if they have the same size, and for each element of a set there is an equal element in the other set

    val numbersBackwards2 = setOf(4,3,2,1,5)
    println("The sets are not equal: ${numbers == numbersBackwards2}")
    //The sets are not equal: false
    //endregion
}