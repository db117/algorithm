# 给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 
# [x, y] 的一个 唯一 建筑。 
# 
#  如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。 
# 
#  返回 被覆盖 的建筑数量。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
#  输入: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]] 
#  
# 
#  输出: 1 
# 
#  解释: 
# 
#  
#  只有建筑 [2,2] 被覆盖，因为它在每个方向上都至少存在一个建筑： 
#  
# 
#  
#  上方 ([1,2]) 
#  下方 ([3,2]) 
#  左方 ([2,1]) 
#  右方 ([2,3]) 
#  
#  
#  因此，被覆盖的建筑数量是 1。 
# 
# 
#  示例 2： 
# 
#  
# 
#  
#  输入: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]] 
#  
# 
#  输出: 0 
# 
#  解释: 
# 
#  
#  没有任何一个建筑在每个方向上都有至少一个建筑。 
#  
# 
#  示例 3： 
# 
#  
# 
#  
#  输入: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]] 
#  
# 
#  输出: 1 
# 
#  解释: 
# 
#  
#  只有建筑 [3,3] 被覆盖，因为它在每个方向上至少存在一个建筑： 
#  
# 
#  
#  上方 ([1,3]) 
#  下方 ([5,3]) 
#  左方 ([3,2]) 
#  右方 ([3,5]) 
#  
#  
#  因此，被覆盖的建筑数量是 1。 
# 
# 
#  
# 
#  提示： 
# 
#  
#  2 <= n <= 10⁵ 
#  1 <= buildings.length <= 10⁵ 
#  buildings[i] = [x, y] 
#  1 <= x, y <= n 
#  buildings 中所有坐标均 唯一 。 
#  
# 
#  Related Topics 数组 哈希表 排序 👍 27 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        ans = 0
        # 记录每行和每列的最小值和最大值
        row_min = [n + 1] * (n + 1)
        row_max = [0] * (n + 1)
        col_min = [n + 1] * (n + 1)
        col_max = [0] * (n + 1)

        for x, y in buildings:
            row_min[x] = min(row_min[x], y)
            row_max[x] = max(row_max[x], y)
            col_min[y] = min(col_min[y], x)
            col_max[y] = max(col_max[y], x)

        for x, y in buildings:
            if col_min[y] < x < col_max[y] and row_min[x] < y < row_max[x]:
                # 在中间就被覆盖
                ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
