from typing import List


class Solution:
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        map = {}
        ans = 0
        for num in nums:
            if num in map:
                ans ^= num
            map[num] = True
        return ans
