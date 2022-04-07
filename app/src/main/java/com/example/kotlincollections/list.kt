package com.example.kotlincollections

fun main() {

    //region basic list things
    val items = listOf("1st item","2nd item","3rd item","4th item")
    println(items)
    //[1st item, 2nd item, 3rd item, 4th item]


    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}") //size of the list
    println("Third element: ${numbers.get(2)}")  //get element at given position
    println("Fourth element: ${numbers[3]}")    //get element at given position but with less code
    println("Index of element \"two\" ${numbers.indexOf("two")}") //get index of the given element
//    Number of elements: 4
//    Third element: three
//    Fourth element: four
//    Index of element "two" 1

    val lastIndexList = listOf("one","two","three","four","two","five")
    println(lastIndexList.lastIndexOf("two")) //find the last matching element & give index of it
    //4
    //endregion

}