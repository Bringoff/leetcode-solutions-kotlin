import java.lang.Character.isMirrored
import java.util.*

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
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return isMirrored(root.left, root.right)
    }

    private fun isMirrored(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null && second == null) return true

        if (first == null || second == null) return false

        if (first.`val` != second.`val`) return false

        return isMirrored(first.left, second.right) && isMirrored(first.right, second.left)
    }
}

class NonRecursiveSolution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        val stack = Stack<TreeNode?>()

        stack.push(root.left)
        stack.push(root.right)

        while (!stack.isEmpty()) {
            val first = stack.pop()
            val second = stack.pop()

            if (first == null && second == null) continue
            if (first == null || second == null) return false
            if (first.`val` != second.`val`) return false
            stack.push(first.left)
            stack.push(second.right)
            stack.push(first.right)
            stack.push(second.left)
        }

        return true
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}