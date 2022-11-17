package HIgherOrderFunctions

import java.util.Date

class Meeting{
    var location:String = ""
    var time: Date = Date()
    var attendee = mutableListOf<String>()

    fun showEvent(){
        println("$location, $time, $attendee")
    }
}



fun main(args: Array<String>){
    var meetingToday = Meeting()
     // first method

    meetingToday.attendee.add("Janet")
    meetingToday.time = Date(2022, 12, 1)
    meetingToday.location = "Kabarak"

    meetingToday.showEvent()

    //second method using with

    with(meetingToday){
        attendee.add("Jamie")
        time = Date(2022, 12, 1)
        location = "Kabarak"
    }
    meetingToday.showEvent()

    //third method using apply =========used when there is complex initialization ===== this is beautiful lol!!!!

    meetingToday.apply {
        attendee.add("Loise")
        location = "USIU"
        time = Date(2022, 16, 4)
    }.showEvent()
}