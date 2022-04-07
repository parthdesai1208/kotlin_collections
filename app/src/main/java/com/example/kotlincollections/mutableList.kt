package com.example.kotlincollections

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(){

    //region basic mutableList methods
    val stringList = mutableListOf("one", "two", "three")
    stringList.remove("one")  //remove specified element from list
    stringList.removeAt(0)     //remove from 1st position
    stringList.add("four")           //add at the end of the list
    stringList.removeAll(stringList) //remove entire collections
    stringList.add("zero")          //add at the end of the list
    stringList.add(1,"add at 2nd position") //add at specified position in the list
    stringList.addAll(mutableListOf("one", "two", "three")) //add entire collections at the end of the list
    stringList.removeFirst() //Removes first element from list or throws NoSuchElementException if list is empty
    stringList.removeFirstOrNull() //Removes first element from list or returns null if list is empty
    stringList.removeLast()  //Removes last element from list or throws NoSuchElementException if list is empty
    stringList.removeLastOrNull() //Removes last element from list or returns null if list is empty
    stringList.removeIf { it == "one" }     //remove element that fulfill the given condition of body
                                            //@RequiresApi(Build.VERSION_CODES.N)
    stringList.add("done")
    stringList.forEach { println(it) }
//done
    //endregion

    //region shuffle
    val shuffleList = mutableListOf("1","2","3","4","5","6","7","8","9","10")
    shuffleList.shuffle() //make random list, here we get uniquely random list everytime
    println(shuffleList)
    //[8, 1, 2, 3, 4, 6, 9, 10, 5, 7]

    val shuffleSeedList = mutableListOf("1","2","3","4","5","6","7","8","9","10")
    val r = java.util.Random(1) //make random list but with seed so we get same list again & again
    shuffleSeedList.shuffle(r)
    println(shuffleSeedList)
    //[7, 10, 8, 9, 5, 3, 1, 4, 2, 6]

    val shuffledList = mutableListOf("1","2","3","4","5","6","7","8","9","10")
    val newList = shuffledList.shuffled() //generate new random list, here we get uniquely random list everytime
    println(shuffledList)
    //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(newList)
    //[2, 6, 3, 8, 10, 5, 9, 7, 4, 1]

    val shuffledSeedList = mutableListOf("1","2","3","4","5","6","7","8","9","10")
    val ran = java.util.Random(1) //generate new random list but with seed so we get same list again & again
    val newList1 = shuffledSeedList.shuffled(ran)
    println(shuffledSeedList)
    //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    println(newList1)
    //[7, 10, 8, 9, 5, 3, 1, 4, 2, 6]
    //endregion
}