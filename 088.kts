class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var index1 = m - 1
        var index2 = n - 1
        var i = m + n - 1

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums1[index1]
                index1--
            } else {
                nums1[i] = nums2[index2]
                index2--
            }
            i--
        }
        while (index2 >= 0) {
            nums1[i] = nums2[index2]
            index2--
            i--
        }
    }
}