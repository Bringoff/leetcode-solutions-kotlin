class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val scanned = HashMap<Int, Int>()

        for (i in nums.indices) {
            val current = nums[i]
            if (scanned.containsKey(target - current)) return intArrayOf(i, scanned[target - current]!!)
            scanned[current] = i
        }
        return intArrayOf()
    }
}