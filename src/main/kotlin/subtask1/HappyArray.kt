package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        val res = mutableListOf<Int>()
        var wasFoundBad = false

        sadArray.forEachIndexed { index, el ->
            val isHappy = index == 0 || index == sadArray.size - 1 || sadArray[index - 1] + sadArray[index + 1] >= el
            if (isHappy) {
                res.add(el)
            } else {
                wasFoundBad = true
            }
        }

        return if (wasFoundBad) convertToHappy(res.toIntArray()) else res.toIntArray()
    }
}
