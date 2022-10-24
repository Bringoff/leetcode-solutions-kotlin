class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        for (i in 0 until strs[0].length) {
            val currentChar = strs[0][i]
            for (j in 1 until strs.size) {
                if (i >= strs[j].length || strs[j][i] != currentChar) {
                    return strs[0].substring(0, i)
                }
            }
        }

        return strs[0]
    }
}