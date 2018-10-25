import java.util.*

fun main(args: Array<String>) {
    println("Choose a function to integrate:")
    for (i in 1..Functions.values().size) {
        println("$i. ${Functions.values()[i - 1].func}")
    }
    println("Input the number of function:")
    val input = Scanner(System.`in`)
    val choose = input.nextInt() - 1
    if (choose < 0 || choose > Functions.values().size - 1) {
        println("\u001B[31mThe number is incorrect")
        System.exit(1)
    }
    println("Now enter the lower bound, then higher and precision")
    val lowerBound = input.nextDouble()
    val higherBound = input.nextDouble()
    val precision = input.nextDouble()
    val method = Method(lowerBound, higherBound, precision, Functions.values()[choose])
    method.compute()
    println("The integration result is: ${method.result}\n" +
            "Number of pieces: ${method.number}\n" +
            "Resulting Runge precision: ${method.RungePrecision}")
}