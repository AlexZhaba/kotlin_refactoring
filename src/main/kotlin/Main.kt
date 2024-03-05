import java.time.LocalDate
import java.time.LocalDateTime

// 1. BEFORE REFACTORING
fun calculateFactorialOld(n: Int): Int {
    if (n == 0) {
        return 1
    } else {
        var result = 1
        for (i in 1..n) {
            result *= i
        }
        return result
    }
}

// 1. AFTER REFACTORING
fun calculateFactorial(n: Int): Int {
    return if (n == 0) 1 else (1..n).fold(1) { acc, i -> acc * i }
}

// 2. BEFORE REFACTORING

fun removeDuplicatesOld(numbers: List<Int>): List<Int> {
    val uniqueNumbers = mutableListOf<Int>()
    for (num in numbers) {
        if (!uniqueNumbers.contains(num)) {
            uniqueNumbers.add(num)
        }
    }
    return uniqueNumbers
}

// 2. AFTER REFACTORING

fun removeDuplicates(numbers: List<Int>): List<Int> {
    return numbers.toSet().toList()
}

// 3. BEFORE REFACTORING
fun sumOfSquaresOld(numbers: List<Int>): Int {
    var sum = 0
    for (num in numbers) {
        sum += num * num
    }
    return sum
}

// 3. AFTER REFACTORING

fun sumOfSquares(numbers: List<Int>): Int {
    return numbers.sumOf { it * it }
}

// 4. BEFORE REFACTORING

class GigasecondOld {
    val gigaSeconds = 1e9.toLong()

    val date: LocalDateTime
    constructor(initialDate: LocalDateTime) {
        date = initialDate.plusSeconds(gigaSeconds)
    }

    constructor(initialDate: LocalDate) : this(initialDate.atStartOfDay())
}

// 4. AFTER REFACTORING

class Gigasecond(initialDate: LocalDateTime) {
    val gigaSeconds = 1e9.toLong()

    val date = initialDate.plusSeconds(gigaSeconds)

    constructor(initialDate: LocalDate) : this(initialDate.atStartOfDay())
}

// 5. BEFORE REFACTORING
fun checkPrimeNumberOld(num: Int): Boolean {
    if (num < 2) {
        return false
    }
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

// 5. AFTER REFACTORING
fun checkPrimeNumber(num: Int): Boolean {
    return num > 1 && (2 until num).none { num % it == 0 }
}

fun main(args: Array<String>) {

}