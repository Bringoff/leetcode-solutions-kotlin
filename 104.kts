import java.util.*
import kotlin.math.max

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
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)

        return max(leftDepth + 1, rightDepth + 1)
    }
}

class NonRecursiveSolution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        var depth = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (!queue.isEmpty()) {
            for (i in 0 until queue.size) {
                val node = queue.poll()
                if (node.left != null) queue.offer(node.left)
                if (node.right != null) queue.offer(node.right)
            }
            depth++
        }
        return depth
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}