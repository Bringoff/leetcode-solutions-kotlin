class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (currentElement in s) {
            if (OPENING.contains(currentElement)) {
                stack.addLast(currentElement)
            } else {
                // removeLastOrNull() function is missing in Kotlin 1.3 used on Leetcode atm.
                // Can be replaced with `if (stack.isEmpty()) null else stack.removeLast()`
                val lastOpeningBracket = stack.removeLastOrNull()
                val correctOpeningBracket = CLOSED_OPEN_MAPPING[currentElement]
                if (lastOpeningBracket == null || lastOpeningBracket != correctOpeningBracket) return false
            }
        }
        return stack.isEmpty()
    }

    companion object {
        private val OPENING = hashSetOf('(', '[', '{')
        private val CLOSED_OPEN_MAPPING = hashMapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{'
        )
    }
}