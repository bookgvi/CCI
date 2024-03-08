package leetcode

import java.util.*

class CountElementsWithMaximumFrequency {

    companion object {
        const val MAX_COUNT = 100
    }

    fun maxFrequencyElements(nums: IntArray): Int {
        var countedArr = max(countElts(nums))
        var res = countedArr.last()
        if (countedArr.size > 1) {
            res = Arrays.stream(countedArr).sum()
        }
        return res;
    }

    private fun radixSort(nums : IntArray) : IntArray {
        val size = nums.size
        val tmpArr = IntArray(size)
        val count = IntArray(MAX_COUNT)
        for (num in nums) {
            count[num] += 1
        }
        for (i in 1..< MAX_COUNT) {
            count[i] += count[i - 1]
        }
        for (i in nums.lastIndex downTo 0) {
            tmpArr[--count[nums[i]]] = nums[i]
        }
        return tmpArr
    }

    private fun countElts(nums : IntArray) : IntArray {
        val count = IntArray(MAX_COUNT)
        for (num in nums) {
            count[num] += 1
        }
        return Arrays.stream(count).filter{ elt -> elt != 0 }.toArray()
    }

    private fun max(nums : IntArray) : IntArray {
        val maxArr = radixSort(nums)
        val res = IntArray(nums.size)
        var index = 0
        val last = maxArr.last()
        for (i in maxArr.lastIndex - 1 downTo 0) {
            if (last == maxArr[i]) {
                res[index++] = last
            } else {
                break
            }
        }
        res[index++] = last
        return Arrays.stream(res).filter{ elt -> elt != 0}.toArray()
    }
 }