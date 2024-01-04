package com.example.kotlincollections

@Suppress("unused")
fun main1() {

    //region basic list things
    val items = listOf("1st item", "2nd item", "3rd item", "4th item")
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
    //region indexOfFirst
    //Returns index of the first element matching the given predicate
    val indexOfFirstList = listOf(1, 2, 3, 3, 4, 4, 4, 5, 5)
    println(indexOfFirstList.indexOfFirst { it == 3 }) //2
    //endregion
    //region indexOfLast
    //Returns index of the last element matching the given predicate
    val indexOfLastList = listOf(1, 2, 3, 3, 4, 4, 4, 5, 5)
    println(indexOfLastList.indexOfLast { it == 4 }) //6
    //endregion
    //region intersect
    //Returns a set containing all elements that are contained by both collections
    val intersectList1 = listOf(1, 2, 3, 4, 5)
    val intersectList2 = listOf(3, 4, 5, 6, 7)
    val intersectList = intersectList1.intersect(intersectList2)
    println(intersectList) //[3, 4, 5]
    //endregion
    val lastIndexOfList = listOf("one", "two", "three", "four", "two", "five")
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

    //region isEmpty and isNotEmpty
    //isEmpty() =  if the collection is empty then true otherwise false
    //isNotEmpty() = if the collection is not empty then true otherwise false
    val isEmptyList = listOf(1, 2, 3, 4)
    println(isEmptyList.isEmpty()) //false
    println(isEmptyList.isNotEmpty()) //true
    val isEmptyList1 = emptyList<Byte>()
    println(isEmptyList1.isEmpty()) //true
    println(isEmptyList1.isNotEmpty()) //false
    //endregion

    //region isNullOrEmpty
    //Returns true if this nullable collection is either null or empty.
    var isNullOrEmptyList: List<Any>? = null
    println(isNullOrEmptyList.isNullOrEmpty()) //true
    isNullOrEmptyList = listOf(1, 2, 3, 4, 5)
    println(isNullOrEmptyList.isNullOrEmpty()) //false
    isNullOrEmptyList = emptyList()
    println(isNullOrEmptyList.isNullOrEmpty()) //true
    //endregion

    //region ifEmpty
    //Returns this array if it's not empty or the result inside lambda
    var ifEmptyCollection = listOf(1, 2, 3)
    ifEmptyCollection.ifEmpty { println("The list is empty.") }
    println(ifEmptyCollection) //[1, 2, 3]
    ifEmptyCollection = emptyList()
    ifEmptyCollection.ifEmpty { println("The list is empty now") }

    //[1, 2, 3]
    //The list is empty now
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
    val country = listOf("India", "US", "UK", "Canada", "Australia", "Russia")
    val subList = country.subList(fromIndex = 2, toIndex = 4)
    subList.forEach {
        println(it)
//        UK
//        Canada
    }
    //endregion

    //region indices
    //return index range
    val collection = listOf('a', 'b', 'c', 'd', 'e', 'f')
    println(collection.indices) // 0..5
    //endregion

    //region all
    //returns true if all elements matching the given elements or list is empty, otherwise false
    val allListFalse = listOf("1", "2", "3", "4", "5")
    println(allListFalse.all { it == "2" }) //false
    val allListTrue = listOf("2", "2", "2", "2", "2")
    println(allListTrue.all { it == "2" }) //true
    val allListEmpty = emptyList<String>()
    println(allListEmpty.all { it == "2" }) //true
    //endregion

    //region any
    //Returns true if array has at least one element, otherwise false (if list is empty then false)
    val anyListEmpty = emptyList<String>()
    println(anyListEmpty.any())  //false
    println(anyListEmpty.any { it == "2" }) //false

    val anyListFalse = listOf("1", "2", "3", "4", "5")
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
    println(listToSequence.joinToString())     //a, b, c
    //endregion

    //region associate
    //Returns a Map containing key-value pair
    val names = listOf("Grace Hopper", "Jacob Bernoulli", "Johann Bernoulli")
    val byLastName =
        names.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
    // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
    println(byLastName) // {Hopper=Grace, Bernoulli=Johann}

    val names1 = listOf("Grace Hopper", "Jacob Bernoulli1", "Johann Bernoulli2")
    val byLastName1 =
        names1.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
    //now we have all of the list, because we have "Bernoulli1" & "Bernoulli2" are different words
    println(byLastName1) //{Hopper=Grace, Bernoulli1=Jacob, Bernoulli2=Johann}
    //endregion

    //region associateTo
    //Returns a Map containing key-value pair
    //same as associate, but apply operation(inside lamda) to "passed map"
    data class DataClassForAssociateTo(val firstName: String, val lastName: String)

    val listForAssociateTo = listOf(
        DataClassForAssociateTo("Grace", "Hopper"),
        DataClassForAssociateTo("Jacob", "Bernoulli"),
        DataClassForAssociateTo("Johann", "Bernoulli")
    )
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
        DataClassForAssociateBy("Evgenii", "Dmitry")
    )

    fun getKey(data: DataClassForAssociateBy): String {
        return data.firstName.dropLast(2).uppercase()
    }

    fun getValue(data: DataClassForAssociateBy): String {
        return data.lastName.dropLast(2).lowercase()
    }

    val finalAssociateByList = listAssociateBy.associateBy(::getKey, ::getValue)
    println("Original List")
    println(listAssociateBy.associate { Pair(it.firstName, it.lastName) })
    println("After operation List")
    println("drop last two character & convert to upper,lower")
    println(finalAssociateByList)
//    Original List
//    {John=Ali, Naidu=Tan, Evgenii=Dmitry}
//    After operation List
//    drop last two character & convert to upper,lower
//    {JO=a, NAI=t, EVGEN=dmit}

    val listAssociateBy1 = listOf("John", "Ali", "Naidu", "Tan", "Evgenii", "Dmitry")
    fun getKey1(data: String): String {
        return data.dropLast(2).uppercase()
    }

    val finalAssociateByList1 = listAssociateBy1.associateBy { getKey1(it) }
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
    listAssociateByTo.associateByTo(
        destination = finalAssociateByTo,
        keySelector = { getKey(it) },
        valueTransform = { getValue(it) })
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

    //region average
    //Returns an average value of elements in the sequence.
    val listAverage = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(listAverage.average()) //5.5
    //endregion

    //region chunked
    //Splits this sequence into a sequence of lists
    val listChunked = "one two three four five six seven eight nine ten".split(' ')
    val chunked = listChunked.chunked(3)
    println(chunked)
    //[[one, two, three], [four, five, six], [seven, eight, nine], [ten]]
    val codonTable =
        mapOf("ATT" to "Isoleucine", "CAA" to "Glutamine", "CGC" to "Arginine", "GGC" to "Glycine")
    val dnaFragment = "ATTCGCGGCCGCCAA"

    val proteins = dnaFragment.chunked(3) { codon: CharSequence ->
        codonTable[codon.toString()] ?: error("Unknown codon")
    }

    println(proteins)
    //[Isoleucine, Arginine, Glycine, Arginine, Glutamine]
    //endregion

    //region count
    //Returns the number of elements in this sequence.
    val listCount = listOf(1, 2, 3, 4, 4, 5, 5, 45, 45, 54, 5, 45)
    println(listCount.count()) //12

    println(listCount.count { it == 4 }) //2
    //since we have 4, 2 times
    //endregion

    //region distinct
    //Returns a sequence containing only distinct elements from the given sequence.
    val listDistinct = listOf('a', 'A', 'b', 'B', 'A', 'a')
    println(listDistinct.distinct()) //[a, A, b, B]
    val listDistinctBy = listOf("apple", "banana", "mango", "berry")
    println(listDistinctBy.distinctBy { it[0] })
    //[apple, banana, mango]
    //Since, elements banana and berry have same first character,
    // these are considered to be same by distinctBy() function.
    //endregion

    //region drop
    val charDrop = ('a'..'z').toList()
    //drop = Returns a list containing all elements except first n elements.
    println(charDrop.drop(23))          //[x,y,z]
    //dropping first 23 element here

    //dropLast = Returns a list containing all elements except last n elements.
    println(charDrop.dropLast(23))      //[a,b,c]
    //dropping last 23 element

    //dropWhile = Returns a list containing all elements except first elements that satisfy the given condition
    println(charDrop.dropWhile { it < 'x' })    //[x,y,z]
    //dropping first element which satisfy condition

    //dropLastWhile = Returns a list containing all elements except last elements that satisfy the given condition
    println(charDrop.dropLastWhile { it > 'c' }) // [a, b, c]
    //dropping last element which satisfy condition
    //endregion

    //region elementAt
    //Returns an element at the given index or throws an IndexOutOfBoundsException
    val listElementAt = listOf(1, 2, 3)
    println(listElementAt.elementAt(0)) // 1
    //Returns an element at the given index or null if the index is out of bounds
    println(listElementAt.elementAtOrNull(3)) //null
    //Returns an element at the given index or defaultValue function if the index is out of bounds
    println(listElementAt.elementAtOrElse(index = 3, defaultValue = { 500 })) //500
    //endregion

    //region emptySequence
    //Returns an empty sequence.
    val valEmptySequence = emptySequence<String>()
    println(valEmptySequence) //kotlin.sequences.EmptySequence@2acf57e3
    //endregion

    //region filter
    //Returns a sequence containing only elements matching the given condition
    val listFilter = listOf(1, 2, 3, 4, 5, 6, 7)
    println(listFilter.filter { it % 2 == 0 }) //[2, 4, 6]
    //region filterTo
    val listFilterTo = mutableListOf<Int>()
    println(listFilter.filterTo(destination = listFilterTo) { it % 2 == 0 })
    //endregion

    //region filterNot
    //Returns a sequence containing all elements not matching the given predicate
    val filterNotList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filterNotList1 = filterNotList.filterNot { it % 2 == 0 }
    println(filterNotList1) // Output: [1, 3, 5, 7, 9]
    //endregion
    //region filterNotTo
    //Appends all elements not matching the given predicate to the given destination.
    val intNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7)
    val evenNumbers = mutableListOf<Int>()
    val notMultiplesOf3 = mutableListOf<Int>()
    intNumbers.filterTo(evenNumbers) { it % 2 == 0 }
    intNumbers.filterNotTo(notMultiplesOf3) { number -> number % 3 == 0 }
    println(evenNumbers) // [2, 4, 6]
    println(notMultiplesOf3) // [1, 2, 4, 5, 7]
    //endregion

    //region filterNotNull
    //Returns a sequence containing all elements that are not null
    val nullableList: List<Int?> = listOf(1, null, 2, null, 3, 4, null)
    val filterNotNullList: List<Int> = nullableList.filterNotNull()
    println(filterNotNullList) // Output: [1, 2, 3, 4]
    //endregion
    //region filterNotNullTo
    //Appends all elements that are not null to the given destination
    val filterNotNullToList: MutableList<Int> = mutableListOf()
    nullableList.filterNotNullTo(filterNotNullToList)
    println(filterNotNullToList) // This will print: [1, 2, 3, 4]
    //endregion

    //region filterIndexed
    //Returns a list containing only elements matching the given condition, we get index as well
    val listFilterIndexed = listOf(0, 1, 2, 3, 4, 8, 6)
    println(listFilterIndexed.filterIndexed { index, i -> index == i }) // [0, 1, 2, 3, 4, 6] (8 is not matching the index)
    //endregion
    //region filterIndexedTo
    //fill all elements to new list, matching the given condition
    val listFilterIndexedTo = listOf(0, 1, 2, 3, 4, 8, 6)
    val numbersOnSameIndexAsValue = mutableListOf<Int>()
    println(numbersOnSameIndexAsValue) // []

    listFilterIndexedTo.filterIndexedTo(numbersOnSameIndexAsValue) { index, i -> index == i }
    println(numbersOnSameIndexAsValue) // [0, 1, 2, 3, 4, 6]
    //endregion

    //region filterIsInstance
    //gives sequence containing all elements that are instances of specified type parameter
    val filterIsInstanceList: List<Any> = listOf(1, "apple", 2.5, "banana", 3, "cherry")
    val stringList: List<String> = filterIsInstanceList.filterIsInstance<String>()
    println(stringList) //[apple, banana, cherry]
    //endregion
    //region filterIsInstanceTo
    //fill to new list, matching given "klass" specified
    val mixedList: List<Any> = listOf(1, "Hello", 3.14, true, "world")
    val filterIsInstanceToList =
        mixedList.filterIsInstanceTo(destination = mutableListOf(), klass = String::class.java)
    println(filterIsInstanceToList) //[Hello, world]
    //endregion
    //endregion

    //region find
    //Returns the first element matching the given condition, or null if no such element was found.
    val listFind = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(listFind.find { it == 2 })  //2
    println(listFind.find { it == 12 }) //null

    //Returns the last element matching the given condition, or null if no such element was found.
    println(listFind.findLast { it % 2 == 0 }) //10
    //endregion

    //region first
    val listFirst = listOf(
        "first string",
        "second first string",
        "third string",
        "fourth string",
        "fifth string"
    )
    //Returns first element.
    println(listFirst.first()) //first string
    //Returns the first element matching the given condition
    println(listFirst.first { it.contains("first") }) //first string
    println(listFirst.first { it.contains("seven") }) //throws exception
    //Returns the first element, or null if the list is empty.
    println(listFirst.firstOrNull())
    //Returns the first element matching the given condition, or null if element was not found.
    println(listFirst.firstOrNull { it.contains("seven") })
    //return first non-null value produced by provided transformation function
    println(listFirst.firstNotNullOfOrNull { if (it == "first string") "first" else "not found" }) //first
    println(listFirst.firstNotNullOfOrNull { if (it == "fifth string") "first" else "not found" }) //not found
    //endregion
    //region flatMap
    //return list contains single element which produced by given transformation function
    val listFlatMap = listOf("kotlin", "collection")
    println(listFlatMap.flatMap { it.toList() })    //[k, o, t, l, i, n, c, o, l, l, e, c, t, i, o, n]
    val listFlatMap1 = listOf(1, 2, 3, 4, 5)
    println(listFlatMap1.flatMap { listOf(it, it * 2) }) //[1, 2, 2, 4, 3, 6, 4, 8, 5, 10]
    //region flatMapTo
    //write to new list, containing single element which produced by given transformation function
    val listToWriteFlatMap = mutableListOf<Char>()
    println(listToWriteFlatMap)                        //[]
    listFlatMap.flatMapTo(destination = listToWriteFlatMap) { ("it.").toList() }
    println(listToWriteFlatMap)                        //[k, o, t, l, i, n, ., c, o, l, l, e, c, t, i, o, n, .]
    //endregion
    //region flatMapIndexed
    //same as flatMap but also gives you index
    println(listFlatMap.flatMapIndexed { index: Int, s: String ->
        if (index % 2 == 0) {
            listOf("$s even index")
        } else {
            listOf("$s odd index")
        }
    }) //[kotlin even index, collection odd index]
    //endregion
    //region flatMapIndexedTo
    //write to new list & same as flatMapIndexed
    val listToWriteFlatMapIndexed = mutableListOf<String>()
    println(listToWriteFlatMapIndexed)     //[]
    listFlatMap.flatMapIndexedTo(
        destination = listToWriteFlatMapIndexed,
        transform = { index: Int, s: String ->
            if (index % 2 == 0) {
                listOf("$s even index")
            } else {
                listOf("$s odd index")
            }
        })
    println(listToWriteFlatMapIndexed)     //[kotlin even index, collection odd index]
    //endregion
    //endregion
    //region flatten
    //Returns a single list of all elements from all collections in the given collection
    val flattenArray = arrayOf(
        arrayOf(1),
        arrayOf(2, 3),
        arrayOf(4, 5, 6)
    )

    println(flattenArray.flatten()) // [1, 2, 3, 4, 5, 6]

    val flattenList = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
    println(flattenList.flatten()) // [1, 2, 3, 4, 5, 6]
    //endregion
    //region fold
    //returns Map<K,R> where K is group key which is invoked by initialValueSelector function
    //R is accumulator which is produced by operation function
    val fruits = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")

    val evenFruits = fruits.groupingBy { it.first() }       //first() return 1st character
        .fold(
            initialValueSelector = { key, _ -> key to mutableListOf<String>() },
            operation = { _, accumulator, element ->
                accumulator.also { (_, list) -> if (element.length % 2 == 0) list.add(element) }
            })

    val sorted = evenFruits.values.sortedBy { it.first }  //first - return first(A) of Pair<A,B>
    println(evenFruits.keys.sortedBy { it }) //[a,b,c]
    println(sorted) // [(a, []), (b, [banana]), (c, [cherry, citrus])]
    //endregion

    //region foldTo
    val listFoldTo = fruits.groupingBy { it.first() }       //first() return 1st character
        .foldTo(destination = mutableMapOf(),
            initialValueSelector = { key, _ -> key to mutableListOf<String>() },
            operation = { _, accumulator, element ->
                accumulator.also { (_, list) -> if (element.length % 2 == 0) list.add(element) }
            })

    val sortedFoldTo =
        listFoldTo.values.sortedBy { it.first }  //first - return first(A) of Pair<A,B>
    println(sortedFoldTo) //[(a, []), (b, [banana]), (c, [cherry, citrus])]
    //endregion

    //region foldIndexed
    //returns data type which is passed to initial
    //execute from right to left as index first
    //then default value as accumulator
    //then value from left to right
    val listFoldIndexed = listOf(1, 2, 3, 4, 5)
    println(listFoldIndexed.foldIndexed(initial = "0", operation = { index, accumulator, value ->
        "$index. $accumulator - $value"
    }))                                 //4. 3. 2. 1. 0. 0 - 1 - 2 - 3 - 4 - 5
    //endregion
    //region foldRight
    //execute from left to right as accumulator
    //then default value which passed in initial as value
    println(listFoldIndexed.foldRight(initial = "0", operation = { accumulator, value ->
        "$accumulator acc - $value val"
    }))                           //1 acc - 2 acc - 3 acc - 4 acc - 5 acc - 0 val val val val val
    //endregion
    //region foldRightIndexed
    //same as foldRight + index
    println(
        listFoldIndexed.foldRightIndexed(
            initial = "0",
            operation = { index, accumulator, value ->
                "$index. $accumulator acc - $value val"
            })
    )             //0. 1 acc - 1. 2 acc - 2. 3 acc - 3. 4 acc - 4. 5 acc - 0 val val val val val
    //endregion

    //region forEach & forEachIndexed
    val listForEach = listOf(1, 2, 3, 4, 5, 6, 7)
    listForEach.forEach {
        print(it) //1234567
    }
    listForEach.forEachIndexed { index, i ->
        print("$index : $i ")  //0 : 1 1 : 2 2 : 3 3 : 4 4 : 5 5 : 6 6 : 7
    }
    //endregion

    //region getOrElse
    //return element at index else defaultValue for List
    val listGetOrElse = listOf(1, 2, 3, 4)
    println(listGetOrElse.getOrElse(index = 1, defaultValue = { 10 }))  //2

    val emptyListGetOrElse = emptyList<String>()
    println(emptyListGetOrElse.getOrElse(index = 10, defaultValue = { 1000 })) //1000

    val mapGetOrElse = mapOf(1 to "first", 2 to "second", 3 to "third", 4 to "four")
    println(mapGetOrElse.getOrElse(key = 2, defaultValue = { "default value" })) //second

    val emptyMapGetOrElse = emptyMap<Int, String>()
    println(
        emptyMapGetOrElse.getOrElse(
            key = 10,
            defaultValue = { "default value" })
    ) //default value
    //endregion

    //region getOrNull
    //return element at index else null
    val listGetOrNull = listOf(1, 2, 3)
    println(listGetOrNull.getOrNull(index = 0)) //1
    println(listGetOrNull.getOrNull(index = 3)) //null
    //endregion

    //region groupBy
    //return map as key from keySelector operation &
    //              value from valueTransform operation
    //           if valueTransform not provided then original list is printed
    val listGroupBy = listOf("a", "ab", "abc", "abcd")
    val groupByMap = listGroupBy.groupBy(keySelector = { it.length })
    println(groupByMap) //{1=[a], 2=[ab], 3=[abc], 4=[abcd]}

    val listGroupBy1 = listOf(1 to "A", 2 to "B", 3 to "c", 4 to "A")
    val groupByMap1 =
        listGroupBy1.groupBy(keySelector = { it.second }, valueTransform = { it.first })
    println(groupByMap1) //{A=[1, 4], B=[2], c=[3]}
    //endregion

    //region groupByTo
    //same as groupBy but apply to map
    val mapFromGroupByTo = mutableMapOf<Int, MutableList<String>>()
    listGroupBy.groupByTo(destination = mapFromGroupByTo, keySelector = { it.length })
    println(mapFromGroupByTo) //{1=[a], 2=[ab], 3=[abc], 4=[abcd]}
    //endregion

    //region groupingBy
    //return map as key from keySelector operation &
    //              value from appending to keySelector operation
    val words = "one two three four five six seven eight nine ten".split(' ')
    val firstCharWithCount = words.groupingBy(keySelector = { it.first() }).eachCount()
    println(firstCharWithCount) //{o=1, t=3, f=2, s=2, e=1, n=1}
    //endregion

    //region hashMapOf
    //Returns an empty new HashMap
    val varHashMapOf: HashMap<Int, String> = hashMapOf(1 to "x", 2 to "y", 3 to "z")
    println(varHashMapOf) // {1=x, 2=y, 3=z}
    //endregion

    //region hashSetOf
    //Returns an empty new HashSet.
    val varHashSetOf = hashSetOf(1, 2, 3, 4, 5)
    varHashSetOf.add(3)
    varHashSetOf.remove(2)
    println(varHashSetOf) //[1, 3, 4, 5]
    //endregion

    //region joinTo
    //Appends the string from all the elements separated using separator and using the given prefix and postfix if supplied
    val joinToString = StringBuilder("An existing string and a list: ")
    val joinToList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(
        joinToList.joinTo(
            buffer = joinToString,
            separator = "$",
            prefix = "[",
            postfix = "]",
            limit = 5,
            truncated = "?",
            transform = { (it * 2).toString() }
        ).toString()
        //An existing string and a list: [2$4$6$8$10$?]
    )
    //endregion
    //region joinToString
    //Creates a string from all the elements separated using separator and using the given prefix and postfix if supplied.
    val joinToStringList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(
        joinToStringList.joinToString(
            separator = "$",
            prefix = "[",
            postfix = "]",
            limit = 5,
            truncated = "?",
            transform = { (it * 2).toString() }
        )) //[2$4$6$8$10$?]
    //endregion

    //region last
    //Returns the last element.
    val listLast = listOf(1,2,3,4,5,6)
    println(listLast.last()) //6
    //endregion

    //region lastIndexOf
    //Returns last index of matching element
    val listLastIndexOf = listOf(1,2,3,4,5,6,5)
    println(listLastIndexOf.lastIndexOf(5)) //6
    //endregion

    //region lastOrNull
    //Returns the last element, or null if the array is empty
    val listLastOrNull = emptyList<Int>()
    println(listLast.lastOrNull())          //6
    println(listLastOrNull.lastOrNull())    //null

    //lastOrNull { }
    //Returns the last element matching the given predicate, or null if no such element was found
    println(listLast.lastOrNull { it < 5 })  //4
    println(listLast.lastOrNull { it > 7 })  //null
    //endregion

    //region linkedMapOf
    //immutable map but maintains the order of elements based on their insertion order
    val _linkedMapOf = linkedMapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )

    for ((key, value) in _linkedMapOf) {
        println("Key: $key, Value: $value")
    }
    //Key: 1, Value: one
    //Key: 2, Value: two
    //Key: 3, Value: three
    //endregion

    //region linkedSetOf
    //set but maintains the order of elements based on their insertion order
    val _linkedHashSet: LinkedHashSet<String> = linkedSetOf("apple", "banana", "orange", "apple")
    for (fruit in _linkedHashSet) {
        println(fruit)
    }
    //apple
    //banana
    //orange
    //endregion

    //region List
    //Creates a new read-only list with the specified size
    val listForList = List(5) { (it + 1) * (it + 1) }
    println(listForList) // [1, 4, 9, 16, 25]
    //endregion

    //region listOf
    //Returns a new read-only list
    val listForlist = listOf('a', 'b', 'c')
    println(listForlist.size) //3
    println(listForlist) //[a,b,c]
    //endregion

    //region listOfNotNull
    //returns new list of non null if it has element otherwise empty list
    //will return
    val listListOfNotNull1 = listOfNotNull(1, null, 2, null, 3)
    println(listListOfNotNull1) // [1, 2, 3]

    val listListOfNotNull2 = listOfNotNull<Any>(null)
    println(listListOfNotNull2) // []
    //endregion


}

fun main() {

}