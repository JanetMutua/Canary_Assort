@file:JvmName("Employees")

package Companion.Objects

fun main(args: Array<String>){
    var Jordan = Employee(234, "Jordan", 23)
    Jordan.displayDetails()

    Jordan.addJobDesription("Accountant")

    Employee.addPostGrad("Jordan")
    Employee.addUndergrad("Linus")

    println(Employee.addUndergrad("Agnes"))

}

class Implementer{

    //create static functions that are callable from Java
    //implement / call factory methods
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            var Jordan = Employee(234, "Jordan", 23)
            Jordan.displayDetails()

            Jordan.addJobDesription("Accountant")

            Employee.addPostGrad("Jordan")
            Employee.addUndergrad("Linus")

            println(Employee.addUndergrad("Agnes"))

        }
    }
}


open class Employee(var id:Int = 0, var name:String, var age:Int = 23){

    fun displayDetails(){
        println("Employee records: $name , $id , $age ")
    }
    //calls the singleton of EmployeeJob
    fun addJobDesription(jobType:String){
        val Job = EmployeeJob.allJobDescriptions
            .filter { it.jobName == jobType }
            .firstOrNull()

        println(Job)

    }
    // defining factory methods using the companion object
    companion object : XmlSerializer<Employee>{
        override fun toXml(item: Employee){

        }
        //factory methods
        fun addUndergrad(name: String): Undergrad{
            return Undergrad(name)
        }

        fun addPostGrad(name: String): Postgraduate{
            return Postgraduate(name)
        }
    }


}
// classes to be used for factory methods with a companion object
class Undergrad(degreeName: String): Employee(name = ""){}
class Postgraduate(postDegreeName: String) : Employee(name = ""){}

// interface to be implemented by the companion object

interface XmlSerializer<T>{
    fun toXml(item:T)
}