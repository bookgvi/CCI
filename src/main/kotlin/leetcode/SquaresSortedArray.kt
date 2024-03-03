package leetcode

import java.util.*

class SquaresSortedArray {

    fun sortedSquares(nums: IntArray): IntArray {
        val l = binarySearchFirstNegativeValue(nums)
        val size = nums.size;
        val squaredNums: IntArray
        if (l < 0) {
            squaredNums = squaredNums(nums)
        } else {
            val leftSquaredArr = squaredNums(Arrays.copyOf(nums, l + 1))
            val rSize = size - l - 1
            if (rSize > 0) {
                val righAtrr = IntArray(rSize)
                System.arraycopy(nums, l + 1, righAtrr, 0, rSize)
                val rightSquaredArr = squaredNums(righAtrr)
                squaredNums = merge(leftSquaredArr, rightSquaredArr)
            } else {
                squaredNums = leftSquaredArr
            }
        }
        return squaredNums
    }

    fun merge(lArr: IntArray, rArr: IntArray): IntArray {
        val size = lArr.size + rArr.size
        var l = 0
        var r = 0
        var index = 0
        var squaredNums = IntArray(size)
        while (l < lArr.size && r < rArr.size) {
            if (lArr[l] <= rArr[r]) {
                squaredNums[index++] = lArr[l++]
            } else {
                squaredNums[index++] = rArr[r++]
            }
        }
        while (l < lArr.size) {
            squaredNums[index++] = lArr[l++]
        }
        while (r < rArr.size) {
            squaredNums[index++] = rArr[r++]
        }
        return Arrays.copyOf(squaredNums, size)
    }

    fun squaredNums(nums : IntArray) : IntArray {
        val size = nums.size;
        val squaredNums = IntArray(size)
        if (nums[0] < 0) {
            for (i in 0 .. nums.lastIndex) {
                squaredNums[size - i - 1] = nums[i] * nums[i]
            }
        } else {
            for (i in 0.. nums.lastIndex) {
                squaredNums[i] = nums[i] * nums[i]
            }
        }
        return squaredNums
    }

    fun binarySearchFirstNegativeValue(nums: IntArray) : Int {
        var l = 0
        var r = nums.lastIndex
        while (r - l >= 0) {
            val mid = (r + l) shr 1
            if (nums[mid] >= 0) {
                r = mid - 1
            } else if (nums[mid] < 0) {
                l = mid;
            }
            if (r - l == 1) {
                if (nums[l] < 0 && nums[r] < 0) {
                    return r
                }
                if (nums[l] < 0 && nums[r] >= 0) {
                    return l
                }
            }
        }
        return -(l + 1)
    }
}