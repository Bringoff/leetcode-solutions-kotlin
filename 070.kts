class Solution {
    private val cache = HashMap<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        val first = cache[n - 1] ?: climbStairs(n - 1)
        cache[n - 1] = first
        val second = cache[n - 2] ?: climbStairs(n - 2)
        cache[n - 2] = second
        return first + second
    }
}

class NonRecursiveSolution {
    fun climbStairs(n: Int): Int {
        val storage = IntArray(46).also {
            it[0] = 0
            it[1] = 1
            it[2] = 2
        }
        for (i in 3..n) {
            storage[i] = storage[i - 1] + storage[i - 2]
        }
        return storage[n]
    }
}
