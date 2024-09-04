from typing import List


class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        # 默认选第一个
        mx = nums[0]
        mn = nums[0]
        # 记录前面的最小值 和最大值
        for x in nums[1:]:
            # 一共有四种情况
            # 不选
            # 只选当前的
            # 和前面的最小值的乘积
            # 和前面的最大值的乘积
            tmpMx = mx
            mx = max(mx, x, mn * x, mx * x)
            mn = min(mn, x, mn * x, tmpMx * x)

        return mx
