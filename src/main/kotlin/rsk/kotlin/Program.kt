package rsk.kotlin

import rsk.java.Created
import rsk.java.User
//passing Kotlin functions into Java methods
//turning Kotlin lambda into a Java anonymous object (  SAML interface )

fun main(args:Array<String>){
    var user = User("Alois")
    var count = 0
    //adding a variable to my lambda function
    var eventListener = {u:User -> println("user $u ${++count} has been created")}
    //using the SAM constructor: (not typically used but use it when there is a type mismatch when using Kotlin lambdas with java objects
    var eventListenerTwo = Created({println("user $it ${++count} has been created")})

    user.create(eventListenerTwo)
    user.create(eventListener)
    user.create { println("user $it ${++count} has been created") }
}