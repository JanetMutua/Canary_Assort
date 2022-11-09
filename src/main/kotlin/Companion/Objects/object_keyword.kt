package Companion.Objects

open class JobDescription(var jobName:String){

}

// creates a singleton
object EmployeeJob{
    var allJobDescriptions = arrayListOf<JobDescription>()

    fun initialize(){
        allJobDescriptions.add(JobDescription("Accountant"))
    }
}