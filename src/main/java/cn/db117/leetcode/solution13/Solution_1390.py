# 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [21,4,7]
# 输出：32
# 解释：
# 21 有 4 个因数：1, 3, 7, 21
# 4 有 3 个因数：1, 2, 4
# 7 有 2 个因数：1, 7
# 答案仅为 21 的所有因数的和。
#  
# 
#  示例 2: 
# 
#  
# 输入: nums = [21,21]
# 输出: 64
#  
# 
#  示例 3: 
# 
#  
# 输入: nums = [1,2,3,4,5]
# 输出: 0 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 10⁴ 
#  1 <= nums[i] <= 10⁵ 
#  
# 
#  Related Topics 数组 数学 👍 59 👎 0
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)

MAX = 100_001
count = [0] * MAX  # 统计因数个数
sumArr = [0] * MAX  # 统计因数和
for i in range(1, MAX):
    for j in range(i, MAX, i):
        count[j] += 1
        sumArr[j] += i


class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        ans = 0
        for x in nums:
            if count[x] == 4:  # 4个因数
                ans += sumArr[x]

        return ans
# leetcode submit region end(Prohibit modification and deletion)
