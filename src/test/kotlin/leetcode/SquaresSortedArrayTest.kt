package leetcode

import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SquaresSortedArrayTest {

    @Test
    fun testEmptyArray() {
        val nums = intArrayOf()
        Assert.assertEquals(-1, SquaresSortedArray().binarySearchFirstNegativeValue(nums))
    }

    @Test
    fun testPositiveArray() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        Assert.assertEquals(-1, SquaresSortedArray().binarySearchFirstNegativeValue(nums))
    }

    @Test
    fun testNegativeArray() {
        val nums = intArrayOf(-5, -4, -3, -2, -1)
        Assert.assertEquals(4, SquaresSortedArray().binarySearchFirstNegativeValue(nums))
    }

    @Test
    fun testNegativeArrayWithZero() {
        val nums = intArrayOf(-5, -4, -3, -2, -1, 0)
        Assert.assertEquals(4, SquaresSortedArray().binarySearchFirstNegativeValue(nums))
    }

    @Test
    fun testMixedArray1() {
        val nums = intArrayOf(-4,-1,0,3,10)
        Assert.assertEquals(1, SquaresSortedArray().binarySearchFirstNegativeValue(nums))
    }
    
    @Test
    fun testMergeEmptyArrays() {
        val lArr = intArrayOf()
        val rArr = intArrayOf()
        val expected = intArrayOf()
        assertArrayEquals(expected, SquaresSortedArray().merge(lArr, rArr))
    }

    @Test
    fun testMergeOneEmptyArray() {
        val lArr = intArrayOf()
        val rArr = intArrayOf(1, 2, 3)
        val expected = intArrayOf(1, 2, 3)
        assertArrayEquals(expected, SquaresSortedArray().merge(lArr, rArr))
    }

    @Test
    fun testMergeEqualLengthArrays() {
        val lArr = intArrayOf(1, 3, 5)
        val rArr = intArrayOf(2, 4, 6)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6)
        assertArrayEquals(expected, SquaresSortedArray().merge(lArr, rArr))
    }

    @Test
    fun testMergeUnequalLengthArrays() {
        val lArr = intArrayOf(1, 3, 5, 7)
        val rArr = intArrayOf(2, 4, 6)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        assertArrayEquals(expected, SquaresSortedArray().merge(lArr, rArr))
    }
    @Test
    fun testAllPositiveIntegers() {
        val input = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 4, 9, 16, 25)
        assertArrayEquals(expected, SquaresSortedArray().sortedSquares(input))
    }

    @Test
    fun testAllNegativeIntegers() {
        val input = intArrayOf(-5, -4, -3, -2, -1)
        val expected = intArrayOf(1, 4, 9, 16, 25)
        assertArrayEquals(expected, SquaresSortedArray().sortedSquares(input))
    }

    @Test
    fun testMixOfPositiveAndNegativeIntegers() {
        val input = intArrayOf(-4, -1, 0, 3, 10)
        val expected = intArrayOf(0, 1, 9, 16, 100)
        assertArrayEquals(expected, SquaresSortedArray().sortedSquares(input))
    }
    @Test
    fun testMixOfPositiveAndNegativeIntegers2() {
        val input = intArrayOf(-7,-3,2,3,11)
        val expected = intArrayOf(4,9,9,49,121)
        assertArrayEquals(expected, SquaresSortedArray().sortedSquares(input))
    }
}