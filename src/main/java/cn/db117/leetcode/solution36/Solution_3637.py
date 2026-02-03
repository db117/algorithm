# 3637.三段式数组 I
# 给你一个长度为 n 的整数数组 nums。 
# 
#  如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）： 
# 
#  
#  nums[0...p] 严格 递增， 
#  nums[p...q] 严格 递减， 
#  nums[q...n − 1] 严格 递增。 
#  
# 
#  如果 nums 是三段式数组，返回 true；否则，返回 false。 
# 
#  
# 
#  示例 1: 
# 
#  
#  输入: nums = [1,3,5,4,2,6] 
#  
# 
#  输出: true 
# 
#  解释: 
# 
#  选择 p = 2, q = 4： 
# 
#  
#  nums[0...2] = [1, 3, 5] 严格递增 (1 < 3 < 5)。 
#  nums[2...4] = [5, 4, 2] 严格递减 (5 > 4 > 2)。 
#  nums[4...5] = [2, 6] 严格递增 (2 < 6)。 
#  
# 
#  示例 2: 
# 
#  
#  输入: nums = [2,1,3] 
#  
# 
#  输出: false 
# 
#  解释: 
# 
#  无法选出能使数组满足三段式要求的 p 和 q 。 
# 
#  
# 
#  提示: 
# 
#  
#  3 <= n <= 100 
#  -1000 <= nums[i] <= 1000 
#  
# 
#  Related Topics 数组 👍 13 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        n = len(nums)
        p = 0
        q = 0
        # 第一段
        for i in range(1, n - 1):
            if nums[i - 1] >= nums[i]:
                p = i - 1
                break
        if p == 0:
            return False

        # 第二段
        for i in range(p, n - 1):
            if nums[i] <= nums[i + 1]:
                q = i
                break
        if q == n - 1:
            return False

        # 第三段
        for i in range(q + 1, n):
            if nums[i - 1] >= nums[i]:
                return False
        return True


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    # print(Solution().isTrionic([1,3,5,4,2,6]))
    # print(Solution().isTrionic([2, 1, 3]))
    # print(Solution().isTrionic([1, 1, 1, 9]))
    print(Solution().isTrionic([1, 6, 6, 3, 7]))
