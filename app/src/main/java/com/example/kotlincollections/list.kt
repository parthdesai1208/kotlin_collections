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

    //region associate
    //Returns a Map containing key-value pair
    val names = listOf("Grace Hopper", "Jacob Bernoulli", "Johann Bernoulli")
    val byLastName = names.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
    // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
    println(byLastName) // {Hopper=Grace, Bernoulli=Johann}

    val names1 = listOf("Grace Hopper", "Jacob Bernoulli1", "Johann Bernoulli2")
    val byLastName1 = names1.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
    //now we have all of the list, because we have "Bernoulli1" & "Bernoulli2" are different words
     println(byLastName1) //{Hopper=Grace, Bernoulli1=Jacob, Bernoulli2=Johann}
    //endregion

    //region associateTo
    //Returns a Map containing key-value pair
    //same as associate, but apply operation(inside lamda) to "passed map"
    data class DataClassForAssociateTo(val firstName: String, val lastName: String)
    val listForAssociateTo = listOf(DataClassForAssociateTo("Grace", "Hopper"), DataClassForAssociateTo("Jacob", "Bernoulli"), DataClassForAssociateTo("Johann", "Bernoulli"))
    val mapToApplyAssociateToOperation = mutableMapOf<String, String>()
    listForAssociateTo.associateTo(mapToApplyAssociateToOperation) { it.lastName to it.firstName }
    println(mapToApplyAssociateToOperation)
    //endregion

    //region associateBy
    //Returns a Map containing key-value pair
    //same as associate, but used it when you want to pass function in key or value param
    data class DataClassForAssociateBy(val firstName: String, val lastName: String)
    val listAssociateBy = listOf(
        DataClassForAssociateBy("John", "Ali"),
        DataClassForAssociateBy("Naidu", "Tan"),
        DataClassForAssociateBy("Evgenii", "Dmitry"))

    fun getKey(data: DataClassForAssociateBy): String { return data.firstName.dropLast(2).uppercase() }
    fun getValue(data: DataClassForAssociateBy): String { return data.lastName.dropLast(2).lowercase() }

    val finalAssociateByList = listAssociateBy.associateBy(::getKey,::getValue)
    println("Original List")
    println(listAssociateBy.associate { Pair(it.firstName,it.lastName) })
    println("After operation List")
    println("drop last two character & convert to upper,lower")
    println(finalAssociateByList)
//    Original List
//    {John=Ali, Naidu=Tan, Evgenii=Dmitry}
//    After operation List
//    drop last two character & convert to upper,lower
//    {JO=a, NAI=t, EVGEN=dmit}

    val listAssociateBy1 = listOf("John", "Ali", "Naidu", "Tan","Evgenii", "Dmitry")
    fun getKey1(data: String): String { return data.dropLast(2).uppercase() }
    val finalAssociateByList1 = listAssociateBy1.associateBy{ getKey1(it) }
    println("Original List")
    println(listAssociateBy1.associateWith { it })
    println("After operation List")
    println("drop last two character & convert to upper")
    println(finalAssociateByList1)
//    Original List
//    {John=John, Ali=Ali, Naidu=Naidu, Tan=Tan, Evgenii=Evgenii, Dmitry=Dmitry}
//    After operation List
//    drop last two character & convert to upper
//    {JO=John, A=Ali, NAI=Naidu, T=Tan, EVGEN=Evgenii, DMIT=Dmitry}
    //endregion

    //region associateByTo
    //Returns a Map containing key-value pair
    //same as associate, but apply operation
    data class DataClassForAssociateByTo(val firstName: String, val lastName: String)

    val listAssociateByTo = listOf(
        DataClassForAssociateByTo("John", "Ali"),
        DataClassForAssociateByTo("Naidu", "Tan"),
        DataClassForAssociateByTo("Evgenii", "Dmitry")
    )

    fun getKey(data: DataClassForAssociateByTo): String {
        return data.firstName.dropLast(2).uppercase()
    }

    fun getValue(data: DataClassForAssociateByTo): String {
        return data.lastName.dropLast(2).lowercase()
    }

    val finalAssociateByTo = mutableMapOf<String, String>()
    listAssociateByTo.associateByTo(destination = finalAssociateByTo, keySelector =  { getKey(it) }, valueTransform =  {getValue(it)})
    println("Original List")
    println(listAssociateByTo.associate { Pair(it.firstName, it.lastName) })
    println("After operation List")
    println("drop last two character & convert to upper,lower")
    println(finalAssociateByTo)
//    Original List
//    {John=Ali, Naidu=Tan, Evgenii=Dmitry}
//    After operation List
//    drop last two character & convert to upper,lower
//    {JO=a, NAI=t, EVGEN=dmit}
    //endregion

    //region associateWith
    //Returns a Map containing key-value pair
    //where key is same as list element & value is produced by value selector(pass inside lambda)
    val listAssociateWith = listOf("a", "abc", "ab", "def", "abcd")
    val mapAssociateWith = listAssociateWith.associateWith { it.length }
    println(mapAssociateWith.keys) // [a, abc, ab, def, abcd]
    println(mapAssociateWith.values) // [1, 3, 2, 3, 4]
    //endregion

    //region associateWithTo
    //Returns a passed Map containing key-value pair
    //where key is same as list element & value is produced by value selector(pass inside lambda)
    data class DataClassForAssociateWithTo(val firstName: String, val lastName: String) {
        override fun toString(): String = "$firstName $lastName" //for simplicity of output
    }

    val listAssociateWithTo = listOf(
        DataClassForAssociateWithTo("Grace", "Hopper"),
        DataClassForAssociateWithTo("Jacob", "Bernoulli"),
        DataClassForAssociateWithTo("Jacob", "Bernoulli")
    )
    val mapAssociateWithTo = mutableMapOf<DataClassForAssociateWithTo, Int>()
    listAssociateWithTo.associateWithTo(mapAssociateWithTo) { it.firstName.length + it.lastName.length }
    println(mapAssociateWithTo) //{Grace Hopper=11, Jacob Bernoulli=14}
    //endregion

}