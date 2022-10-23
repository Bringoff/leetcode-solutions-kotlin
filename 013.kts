class Solution {
    fun romanToInt(s: String): Int {
        var result = 0
        for (i in s.indices) {
            val currentRoman = s[i]
            val next = if (i < s.length - 1) s[i + 1] else null
            val currentLatin = latinToRomanMapping[currentRoman]!!
            if (next == null || latinToRomanMapping[next]!! <= currentLatin) {
                result += currentLatin
            } else {
                result -= currentLatin
            }
        }
        return result
    }

    companion object {
        private val latinToRomanMapping = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
    }
}