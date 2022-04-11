package com.example.kotlincollections

fun main() {

    /*//region basic list things
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
    //endregion*/

    //region contains
    //Checks if the specified element is contained in this collection.
    //returns Boolean
    val containsList = listOf("hi", "i", "am", "parth")
    println(containsList.contains("hi")) //true
    println(containsList.contains("hello")) //false
    //endregion

    //region containsAll
    //Checks if all elements in the specified collection are contained in this collection
    //returns Boolean
    val containsAllList = listOf("hi", "i", "am", "parth", "i", "am", "here")
    val smallList = listOf("hi", "i", "am", "here")
    println(containsAllList.containsAll(smallList)) //true

    val smallList1 = listOf("hi", "i", "here", "am")
    println(containsAllList.containsAll(smallList1)) //true

    val smallList2 = listOf("hi", "i", "in", "paris")
    println(containsAllList.containsAll(smallList2)) //false
    //endregion

    //region isEmpty
    //if the collection is empty then true
    //otherwise false
    val isEmptyList = listOf(1, 2, 3, 4)
    println(isEmptyList.isEmpty()) //false
    val isEmptyList1 = emptyList<Byte>()
    println(isEmptyList1.isEmpty()) //true
    //endregion

    //region iterator
    val iteratorList = listOf(1, 2, 3, 4, 5, 6)
    //Returns the next element in the iteration.
    println(iteratorList.iterator().next()) //1

    //Returns true if the iteration has more elements.
    println(iteratorList.iterator().hasNext()) //true

    //Returns an iterator over the elements of this object.
    val numbersIterator = iteratorList.iterator()
    while (numbersIterator.hasNext()) {
        print(numbersIterator.next()) //123456
    }
    //endregion
}