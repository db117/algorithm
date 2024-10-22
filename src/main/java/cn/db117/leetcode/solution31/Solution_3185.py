from typing import List


class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        map = {}
        ans = 0
        for hour in hours:
            ans += map.get((24 - (hour % 24)) % 24, 0)
            map[hour % 24] = map.get(hour % 24, 0) + 1
        return ans
