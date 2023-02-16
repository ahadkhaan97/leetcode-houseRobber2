fun main() {
    print(rob(intArrayOf(1, 2, 3, 4)))
}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty())
        return 0
    if (nums.size == 1)
        return nums[0]

    var prev1 = nums[0]
    var prev2 = maxOf(nums[0], nums[1])

    for (i in 2 until nums.size - 1) {
        val current = maxOf(nums[i] + prev1, prev2)
        prev1 = prev2
        prev2 = current
    }

    var prev3 = nums[nums.size - 1]
    var prev4 = maxOf(nums[nums.size - 1], nums[nums.size - 2])

    for (i in nums.size - 3 downTo 1) {
        val current = maxOf(nums[i] + prev3, prev4)
        prev3 = prev4
        prev4 = current
    }


    return maxOf(prev3, prev4)
}