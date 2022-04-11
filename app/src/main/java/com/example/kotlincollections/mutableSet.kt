package com.example.kotlincollections

fun main(){

    //region basic mutableSet thing
    val flexibleSet = mutableSetOf(4,3,1,2,2,2,2)
    println(flexibleSet)
    //[4, 3, 1, 2]

    println("size = ${flexibleSet.size}")
    //size = 4

    println("first element is ${flexibleSet.first()}")
    //first element is 4

    println("last element is ${flexibleSet.last()}")
    //last element is 2
    //endregion
}