import java.util.*

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val result = LinkedList<Int>()
        var nextAddition = 0
        for (i in digits.size - 1 downTo 0) {
            val current = digits[i]
            var next = current + nextAddition
            if (i == digits.size - 1) {
                next += 1
            }
            nextAddition = next / 10
            next %= 10
            result.add(0, next)
        }
        if (nextAddition != 0) {
            result.add(0, nextAddition)
        }
        return result.toIntArray()
    }
}