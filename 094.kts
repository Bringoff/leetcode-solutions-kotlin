import java.util.Stack

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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        inorder(root, result)
        return result
    }

    private fun inorder(root: TreeNode?, result: MutableList<Int>) {
        if (root == null) return

        inorder(root.left, result)
        result.add(root.`val`)
        inorder(root.right, result)
    }
}

class NonRecursiveSolution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        val stack = Stack<TreeNode>()
        var currentNode = root

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode)
                currentNode = currentNode.left
            }
            currentNode = stack.pop()
            result.add(currentNode.`val`)
            currentNode = currentNode.right
        }

        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}