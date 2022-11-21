@file:JvmName("Filter&Map")

package FilteringAndSortingData

fun main(args:Array<String>){
    val Integers = listOf(1, 2, 3, 4, 5, 6)

    val smallInts  = Integers.filter { it < 5 }
    //for(i: Int in smallInts) println(i)

    val squaredInt = Integers.map { it * it }
    //for(i: Int in squaredInt ) println(i)

    //==================================lambdas in collections=========================================
    val filteredAndMappedInt = Integers
        .filter { it < 5 }
        .map { it * it }

    //for(i:Int in filteredAndMappedInt) println(i)

    val meetingSchedules = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Staff Meeting"))

    val filterMeeting = meetingSchedules
        .filter { m -> m.meetingName.startsWith("S") }
        .map { m-> m.meetingName }

    for (meeting in filterMeeting) println(meeting)

    //==================================================using predicates as variables==================================

    val myPredicate = {m:Int -> m >10}

    val numberList = listOf(3, 5, 7, 9, 11, 13, 17, 19)
    //all
    val bigNum = numberList.all(myPredicate)
    println(bigNum)
    //any
    val bigNumber = numberList.any(myPredicate)
    println(bigNumber)
    //count

    val checkNum = numberList.count(myPredicate)
    println(checkNum)

    //find
    //===================using a nullable=====================================
    val checkNumber:Int? = numberList.find { it > 19 }
    println(checkNumber)

}


data class Meeting(val Id:Int, val meetingName:String)




