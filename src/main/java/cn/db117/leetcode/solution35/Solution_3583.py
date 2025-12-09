# 给你一个整数数组 nums。 
# 
#  特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)： 
# 
#  
#  0 <= i < j < k < n，其中 n = nums.length 
#  nums[i] == nums[j] * 2 
#  nums[k] == nums[j] * 2 
#  
# 
#  返回数组中 特殊三元组 的总数。 
# 
#  由于答案可能非常大，请返回结果对 10⁹ + 7 取余数后的值。 
# 
#  
# 
#  示例 1： 
# 
#  
#  输入： nums = [6,3,6] 
#  
# 
#  输出： 1 
# 
#  解释： 
# 
#  唯一的特殊三元组是 (i, j, k) = (0, 1, 2)，其中： 
# 
#  
#  nums[0] = 6, nums[1] = 3, nums[2] = 6 
#  nums[0] = nums[1] * 2 = 3 * 2 = 6 
#  nums[2] = nums[1] * 2 = 3 * 2 = 6 
#  
# 
#  示例 2： 
# 
#  
#  输入： nums = [0,1,0,0] 
#  
# 
#  输出： 1 
# 
#  解释： 
# 
#  唯一的特殊三元组是 (i, j, k) = (0, 2, 3)，其中： 
# 
#  
#  nums[0] = 0, nums[2] = 0, nums[3] = 0 
#  nums[0] = nums[2] * 2 = 0 * 2 = 0 
#  nums[3] = nums[2] * 2 = 0 * 2 = 0 
#  
# 
#  示例 3： 
# 
#  
#  输入： nums = [8,4,2,8,4] 
#  
# 
#  输出： 2 
# 
#  解释： 
# 
#  共有两个特殊三元组： 
# 
#  
#  (i, j, k) = (0, 1, 3) 
#  
# 
#  
#  nums[0] = 8, nums[1] = 4, nums[3] = 8 
#  nums[0] = nums[1] * 2 = 4 * 2 = 8 
#  nums[3] = nums[1] * 2 = 4 * 2 = 8 
#  
#  
#  (i, j, k) = (1, 2, 4)
#  
#  nums[1] = 4, nums[2] = 2, nums[4] = 4 
#  nums[1] = nums[2] * 2 = 2 * 2 = 4 
#  nums[4] = nums[2] * 2 = 2 * 2 = 4 
#  
#  
# 
# 
#  
# 
#  提示： 
# 
#  
#  3 <= n == nums.length <= 10⁵ 
#  0 <= nums[i] <= 10⁵ 
#  
# 
#  Related Topics 数组 哈希表 计数 👍 27 👎 0
from collections import defaultdict
from typing import List, Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        pre = defaultdict(int)  # i 前面每个数字出现的次数
        suf = Counter(nums)  # j 后面每个数字出现的次数

        ans = 0

        for num in nums:  # 枚举 j
            suf[num] -= 1  # 后面的数字数量减一

            ans += pre[num * 2] * suf[num * 2]

            pre[num] += 1  # 前面的数字数量加一

        return ans % (10 ** 9 + 7)

# leetcode submit region end(Prohibit modification and deletion)
