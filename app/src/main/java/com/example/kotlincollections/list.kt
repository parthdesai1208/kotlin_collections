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

    val lastIndexOfList = listOf("one","two","three","four","two","five")
    println(lastIndexOfList.lastIndexOf("two")) //find the last matching element & give index of it
    //4

    //lastIndex = Returns the index of the last item in the list or -1 if the list is empty.
    val lastIndexList = listOf("a", "x", "y")
    println(lastIndexList.lastIndex) // 2
    println(lastIndexList[lastIndexList.lastIndex]) // y
    //endregion

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

    //Returns an iterator over the elements of this object in forward direction only.
    val numbersIterator = iteratorList.iterator()
    while (numbersIterator.hasNext()) {
        print(numbersIterator.next()) //123456
    }
    //endregion

    //region listIterator
    //used basically for go through each element
    //iterating through lists in both forward and backward directions
    val list: List<String> = listOf("One", "Two", "Three")

    val iterator = list.listIterator()
    while (iterator.hasNext()) {
        println("next ${iterator.next()}")
    }
    //endregion

    //region subList
    //return the list between specified from-index & (to-index - 1)
    val country = listOf("India","US","UK","Canada","Australia","Russia")
    val subList = country.subList(fromIndex =  2, toIndex = 4)
    subList.forEach {
        println(it)
//        UK
//        Canada
    }
    //endregion

    //region indices
    //return index range
    val collection = listOf('a', 'b', 'c','d','e','f')
    println(collection.indices) // 0..5
    //endregion

    //region all
    //returns true if all elements matching the given elements or list is empty, otherwise false
    val allListFalse = listOf("1","2","3","4","5")
    println(allListFalse.all { it == "2" }) //false
    val allListTrue = listOf("2","2","2","2","2")
    println(allListTrue.all { it == "2" }) //true
    val allListEmpty = emptyList<String>()
    println(allListEmpty.all { it == "2" }) //true
    //endregion

    //region any
    //Returns true if array has at least one element, otherwise false (if list is empty then false)
    val anyListEmpty = emptyList<String>()
    println(anyListEmpty.any())  //false
    println(anyListEmpty.any { it == "2" }) //false

    val anyListFalse = listOf("1","2","3","4","5")
    println(anyListFalse.any())  //true
    println(anyListFalse.any { it == "2" }) //true
    //endregion

    //region asIterable
    //return collection as iterable
    val asIterableList = listOf("1", "2", "3", "4", "5", "6", "7")
    println(asIterableList.asIterable().toString())  //[1, 2, 3, 4, 5, 6, 7]
    asIterableList.asIterable().forEach { print(it) }  //1234567
    //endregion

    //region asReversed
    //Returns new reversed read-only collections of the original List
    val originalAsReversedList = listOf('a', 'b', 'c', 'd', 'e')
    var copyOriginalAsReversedList = originalAsReversedList.asReversed()
    println(originalAsReversedList)       //[a, b, c, d, e]
    println(copyOriginalAsReversedList)   //[e, d, c, b, a]

    val originalAsReversedMutableList = originalAsReversedList.toMutableList()
    originalAsReversedMutableList.add('f')
    copyOriginalAsReversedList = originalAsReversedMutableList.asReversed()
    println(originalAsReversedMutableList)   //[a, b, c, d, e, f]
    println(copyOriginalAsReversedList)      //[f, e, d, c, b, a]
    //endregion

    //region asSequence
    //convert array/list to sequence
    val arrayToSequence = arrayOf('a', 'b', 'c')
    println(arrayToSequence.joinToString())                 //a, b, c
    println(arrayToSequence.asSequence().joinToString())    //a, b, c

    val listToSequence = listOf('a', 'b', 'c')
    println(listToSequence.asSequence().joinToString())     //a, b, c
    //endregion

    //associate
}