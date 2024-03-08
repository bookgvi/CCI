package leetcode

import org.junit.Test

import org.junit.Assert.*

class CountElementsWithMaximumFrequencyTest {

    @Test
    fun maxFrequencyElements() {
        val nums = intArrayOf(1,2,2,3,1,4)
        val res = CountElementsWithMaximumFrequency().maxFrequencyElements(nums)
        assertEquals(4, res)
    }

    @Test
    fun maxFrequencyElements1() {
        val nums = intArrayOf(1)
        val res = CountElementsWithMaximumFrequency().maxFrequencyElements(nums)
        assertEquals(1, res)
    }

    @Test
    fun maxFrequencyElements2() {
        val nums = intArrayOf(1,2,3,4,5,6)
        val res = CountElementsWithMaximumFrequency().maxFrequencyElements(nums)
        assertEquals(6, res)
    }

    @Test
    fun maxFrequencyElements3() {
        val nums = intArrayOf(10,12,11,9,6,19,11)
        val res = CountElementsWithMaximumFrequency().maxFrequencyElements(nums)
        assertEquals(2, res)
    }
}