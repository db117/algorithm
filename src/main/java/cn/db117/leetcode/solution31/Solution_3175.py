from typing import List


class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        mx = 0
        cnt = 0

        for i in range(1,len(skills)):
            if skills[mx] < skills[i]:
                # 换了个最大值
                mx = i
                cnt = 0
            # 上一个最大值还是最大值 ，次数加一
            cnt += 1

            # 赢了 k 次
            if cnt == k:
                return mx

        # 一轮没有找到赢的，那么这个最大值后面全是赢
        return mx
