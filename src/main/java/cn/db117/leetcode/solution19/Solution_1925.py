# 一个 平方和三元组 (a,b,c) 指的是满足 a² + b² = c² 的 整数 三元组 a，b 和 c 。 
# 
#  给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。 
# 
#  
# 
#  示例 1： 
# 
#  输入：n = 5
# 输出：2
# 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
#  
# 
#  示例 2： 
# 
#  输入：n = 10
# 输出：4
# 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= n <= 250 
#  
# 
#  Related Topics 数学 枚举 👍 38 👎 0
import math


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countTriples(self, n: int) -> int:
        ans = 0

        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                k = i * i + j * j
                if k > n * n:  # 超过了就不用继续了
                    break
                if math.isqrt(k) ** 2 == k:  # 判断是否是平方数
                    ans += 2

        return ans


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    n = 10
    print(Solution().countTriples(n))
