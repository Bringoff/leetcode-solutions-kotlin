/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildTree(nums, 0, nums.size - 1)
    }

    private fun buildTree(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val middle = (left + right) / 2

        val root = TreeNode(nums[middle])
        root.left = buildTree(nums, left, middle - 1)
        root.right = buildTree(nums, middle + 1, right)

        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
