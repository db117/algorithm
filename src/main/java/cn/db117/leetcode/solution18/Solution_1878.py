# 1878.矩阵中最大的三个菱形和
# 给你一个 m x n 的整数矩阵 grid 。 
# 
#  菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。下图是四个可行的菱形，每个菱形和
# 应该包含的格子都用了相应颜色标注在图中。 
#  
#  
# 
#  注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。 
# 
#  请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
# 输出：[228,216,211]
# 解释：最大的三个菱形和如上图所示。
# - 蓝色：20 + 3 + 200 + 5 = 228
# - 红色：200 + 2 + 10 + 4 = 216
# - 绿色：5 + 200 + 4 + 2 = 211
#  
# 
#  示例 2： 
#  
#  
# 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
# 输出：[20,9,8]
# 解释：最大的三个菱形和如上图所示。
# - 蓝色：4 + 2 + 6 + 8 = 20
# - 红色：9 （右下角红色的面积为 0 的菱形）
# - 绿色：8 （下方中央面积为 0 的菱形）
#  
# 
#  示例 3： 
# 
#  
# 输入：grid = [[7,7,7]]
# 输出：[7]
# 解释：所有三个可能的菱形和都相同，所以返回 [7] 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  m == grid.length 
#  n == grid[i].length 
#  1 <= m, n <= 100 
#  1 <= grid[i][j] <= 10⁵ 
#  
# 
#  Related Topics 数组 数学 矩阵 前缀和 排序 堆（优先队列） 👍 48 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        diag_sum = [[0] * (n + 1) for _ in range(m + 1)]  # ↘ 前缀和
        anti_sum = [[0] * (n + 1) for _ in range(m + 1)]  # ↙ 前缀和
        for i, row in enumerate(grid):
            for j, num in enumerate(row):
                diag_sum[i + 1][j + 1] = diag_sum[i][j] + num
                anti_sum[i + 1][j] = anti_sum[i][j + 1] + num

        # 从 (x,y) 开始，向 ↘，连续 k 个数的和
        def query_diagonal(x, y, k):
            return diag_sum[x + k][y + k] - diag_sum[x][y]

        # 从 (x,y) 开始，向 ↙，连续 k 个数的和
        def query_anti_diagonal(x, y, k):
            return anti_sum[x + k][y + 1 - k] - anti_sum[x][y + 1]

        x = y = z = 0  # 最大，次大，第三大

        def update(v: int) -> None:
            nonlocal x, y, z
            if v > x:
                x, y, z = v, x, y
            elif x > v > y:
                y, z = v, y
            elif y > v > z:
                z = v

        # 枚举菱形正中心 (i,j)
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                update(v)
                # 顶点不能出界
                mx = min(i, m - 1 - i, j, n - 1 - j)
                for k in range(1, mx + 1):
                    a = query_diagonal(i - k, j, k)  # 菱形右上的边
                    b = query_diagonal(i, j - k, k)  # 菱形左下的边
                    c = query_anti_diagonal(i - k + 1, j - 1, k - 1)  # 菱形左上的边
                    d = query_anti_diagonal(i, j + k, k + 1)  # 菱形右下的边
                    update(a + b + c + d)

        ans = [x, y, z]
        while ans[-1] == 0:
            ans.pop()

        return ans

# leetcode submit region end(Prohibit modification and deletion)
