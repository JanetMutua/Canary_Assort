package HIgherOrderFunctions

fun main(args: Array<String>){
    var sequence = Program()

    var total = 0
     //==============================normal function method========================
    //sequence.fibonacci(10)
     //===============================OO method====================================
    //sequence.fibonacci(8, object:implementationFibonacci{
    //    override fun execute(value: Int){
    //        println(value)
    //    }
    //})

    //===============================functional notation============================

    //sequence.fibonacci(8, {n -> println(n)})

    //=======OR==============

    //sequence.fibonacci(8){n -> println(n)}

    //=======OR==============

    //sequence.fibonacci(6, ::println)

    //=======OR==============

    //sequence.fibonacci(6, { println(it)})

    //=======OR==============

    //sequence.fibonacci(8){ println(it)}
    //==============================================================================================================
    //closure - mutation on lambda functions

    sequence.fibonacci(8) {it -> total += it}
    println(total)


}

interface implementationFibonacci{
    fun execute(value: Int)
}


class Program{
    //=====================================using high level functions to implement====================================

    fun fibonacci(limit:Int, func: (Int) -> Unit){
        var prev = 0
        var prevprev = 0
        var current = 1

        for(i: Int in 1..limit){
            func(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    //==========================================Object oriented way===================================================
    fun fibonacci(limit:Int, value:implementationFibonacci){
        var prev = 0
        var prevprev = 0
        var current = 1

        for(i: Int in 1..limit){
            value.execute(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }
    //=====================================using functional notation=================================================






    //============================================normal function way=================================================
    fun fibonacci(limit:Int){
        var prev = 0
        var prevprev = 0
        var current = 1

        for(i: Int in 1..limit){
            println(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }
}
