class Solution {
    fun findAnagrams(text: String, pattern: String): List<Int> {
        if (pattern.length > text.length) return emptyList()

        // first, we want to store how many times every letter occurs in the pattern we have
        // and the current substring we check
        val allowedLettersCount = 26
        val patternFrequency = IntArray(allowedLettersCount)
        val textFrequency = IntArray(allowedLettersCount)

        val results = mutableListOf<Int>()

        // we count letter occurrences for the pattern and first N letters in the string -
        // that is our substring on the first step
        for (i in pattern.indices) {
            val textChar = text[i]
            val patternChar = pattern[i]

            textFrequency[letterIndex(textChar)]++
            patternFrequency[letterIndex(patternChar)]++
        }

        // if after the first loop frequency tables are equal, the text starts with pattern permutation
        if (textFrequency.contentEquals(patternFrequency)) {
            results.add(0)
        }

        // then we shift our substring with the step equal one until we verify all the substrings
        for (i in 1 until text.length - pattern.length + 1) {
            val previousChar = text[i - 1]
            val lastSubstringChar = text[i + pattern.length - 1]
            // when we shift our substring by one, no need to recalculate all the letter occurrences
            // we just clear the first letter of previous substring and include the last letter of the new substring
            textFrequency[letterIndex(previousChar)]--
            textFrequency[letterIndex(lastSubstringChar)]++

            // on every step we need to compare letter occurrences for the pattern and the current substring
            // if they are equal, that means that the current substring is one of the results
            if (textFrequency.contentEquals(patternFrequency)) {
                results.add(i)
            }
        }

        return results
    }

    private fun letterIndex(letter: Char): Int = letter - 'a'
}
