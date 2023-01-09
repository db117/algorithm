

//给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。 
//
// 一步操作中，你将创建一个新数组 arr ，对于每个 i ： 
//
// 
// 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2] 
// 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2] 
// 
//
// 然后将 arr 赋值给 perm 。 
//
// 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：最初，perm = [0,1]
//第 1 步操作后，perm = [0,1]
//所以，仅需执行 1 步操作 
//
// 示例 2： 
//
// 
//输入：n = 4
//输出：2
//解释：最初，perm = [0,1,2,3]
//第 1 步操作后，perm = [0,2,1,3]
//第 2 步操作后，perm = [0,1,2,3]
//所以，仅需执行 2 步操作 
//
// 示例 3： 
//
// 
//输入：n = 6
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// n 是一个偶数 
// 
//
// Related Topics 数组 数学 模拟 👍 45 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1806.还原排列的最少操作步数.minimum-number-of-operations-to-reinitialize-a-permutation
 *
 * @author db117
 * @since 2023-01-09 10:00:24
 **/

public class Solution_1806 {
    public static void main(String[] args) {
        Solution solution = new Solution_1806().new Solution();
        System.out.println(solution.reinitializePermutation(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reinitializePermutation(int n) {
            // 记录是否被访问
            boolean[] flag = new boolean[n];
            int max = 0;

            // 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
            //如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
            for (int i = 1; i < n; i++) {
                if (!flag[i]) {
                    int step = 0;
                    int cur = i;
                    while (!flag[i]) {
                        // 当前字符没有被访问,就一直找 肯定会回来的
                        if ((cur & 1) == 1) {
                            cur = n / 2 + (cur - 1) / 2;
                        } else {
                            cur = cur / 2;
                        }
                        flag[cur] = true;
                        step++;
                    }
                    max = Math.max(max, step);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}