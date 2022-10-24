class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x

        val longX = x.toLong()

        var left = 0L
        var right = x / 2L

        while (left <= right) {
            val mid = (left + right) / 2
            val sqr = mid * mid
            if (sqr == longX) return mid.toInt()
            else if (sqr < x) left = mid + 1
            else right = mid - 1
        }
        return left.toInt() - 1
    }
}
