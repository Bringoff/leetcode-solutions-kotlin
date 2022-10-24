class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var rightIndex = 0
        for (leftIndex in nums.indices) {
            if (nums[leftIndex] != nums[rightIndex]) {
                nums[++rightIndex] = nums[leftIndex]
            }
        }
        return rightIndex + 1
    }
}