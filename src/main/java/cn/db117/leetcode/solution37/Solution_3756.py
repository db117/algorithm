from typing import List

# 三个前缀和，计算区间数值的大小


MOD = 1_000_000_007
MAX_N = 100_001

# 预处理 10 的幂
pow10 = [1] * MAX_N

for i in range(1, MAX_N):
    pow10[i] = (pow10[i - 1] * 10) % MOD


class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        sum_d = [0] * (n + 1)  # 前面的数字和
        pre_num = [0] * (n + 1)  # 数字乘以所对应的位数后的前缀和
        sum_non_num = [0] * (n + 1)  # 前面所有非零的数字和
        for i, d in enumerate(map(int, s)):
            if d > 0:
                sum_d[i + 1] = sum_d[i] + d
                pre_num[i + 1] = (pre_num[i] * 10 + d) % MOD
                sum_non_num[i + 1] = sum_non_num[i] + 1
            else:
                sum_d[i + 1] = sum_d[i]
                pre_num[i + 1] = pre_num[i]
                sum_non_num[i + 1] = sum_non_num[i]

        ans = []
        for l, r in queries:
            rr = r + 1
            length = sum_non_num[rr] - sum_non_num[l]  # 数字的长度
            x = pre_num[rr] - pre_num[l] * pow10[length]  # 去掉前面的数值
            ans.append((x * (sum_d[rr] - sum_d[l])) % MOD)
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.sumAndMultiply("", []))
