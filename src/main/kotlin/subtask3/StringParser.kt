package subtask3

import java.util.*

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val squareStack = Stack<Int>()
        val angleStack = Stack<Int>()
        val roundStack = Stack<Int>()
        val result = mutableListOf<Pair<Int, Int>>()

        inputString.forEachIndexed { index, char ->
            when (char) {
                '[' -> squareStack.add(index)
                '<' -> angleStack.add(index)
                '(' -> roundStack.add(index)
                ']' -> if (squareStack.size > 0) {
                    val startIndex = squareStack.pop()
                    result.add(Pair(startIndex + 1, index))
                }
                '>' -> if (angleStack.size > 0) {
                    val startIndex = angleStack.pop()
                    result.add(Pair(startIndex + 1, index))
                }
                ')' -> if (roundStack.size > 0) {
                    val startIndex = roundStack.pop()
                    result.add(Pair(startIndex + 1, index))
                }
            }
        }

        result.sortBy { it.first }
        return result.map { inputString.substring(it.first, it.second) }.toTypedArray()
    }
}
