# 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ： 
# 
#  
#  选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。 
#  
# 
#  如果两个元素有 公共边 ，那么它们就是 相邻 的。 
# 
#  你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。 
# 
#  
# 
#  示例 1： 
#  输入：matrix = [[1,-1],[-1,1]]
# 输出：4
# 解释：我们可以执行以下操作使和等于 4 ：
# - 将第一行的 2 个元素乘以 -1 。
# - 将第一列的 2 个元素乘以 -1 。
#  
# 
#  示例 2： 
#  输入：matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
# 输出：16
# 解释：我们可以执行以下操作使和等于 16 ：
# - 将第二行的最后 2 个元素乘以 -1 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  n == matrix.length == matrix[i].length 
#  2 <= n <= 250 
#  -10⁵ <= matrix[i][j] <= 10⁵ 
#  
# 
#  Related Topics 贪心 数组 矩阵 👍 49 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        # 2个负数可以通过多次的转换都变成正值，如果负数的个数是偶数个就都可以变成正数
        # 最多只有一个负数
        total = 0  # 矩阵的绝对值的和
        min_num = 1000000000  # 矩阵中的最小值
        count = 0  # 矩阵中负数的个数
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                total += abs(matrix[i][j])
                min_num = min(min_num, abs(matrix[i][j]))
                if matrix[i][j] < 0:
                    count += 1
        if count % 2 > 0:
            total -= 2 * min_num  # 减去最小值
        return total

# leetcode submit region end(Prohibit modification and deletion)
