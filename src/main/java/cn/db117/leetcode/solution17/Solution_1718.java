// 给你一个整数 n ，请你找到满足下面条件的一个序列：
//
// 
// 整数 1 在序列中只出现一次。 
// 2 到 n 之间每个整数都恰好出现两次。 
// 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。 
// 
//
// 序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。 
//
// 请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。 
//
// 一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0
//,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：[3,1,2,3,2]
//解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出：[5,3,1,4,3,5,2,4,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 递归 回溯算法 
// 👍 20 👎 0


package cn.db117.leetcode.solution17;

import java.util.Arrays;

/**
 * 1718.构建字典序最大的可行序列.construct-the-lexicographically-largest-valid-sequence
 *
 * @author db117
 * @since 2021-05-24 16:26:26
 **/

public class Solution_1718 {
    public static void main(String[] args) {
        Solution solution = new Solution_1718().new Solution();

        //20 [20,18,19,15,13,17,10,16,7,5,3,14,12,3,5,7,10,13,15,18,20,19,17,16,12,14,11,9,4,6,8,2,4,2,1,6,9,11,8]
        System.out.println(Arrays.toString(solution.constructDistancedSequence(20)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructDistancedSequence(int n) {
            int[] ans = new int[n * 2 - 1];

            dfs(ans, new boolean[n + 1], 0);
            return ans;
        }


        private boolean dfs(int[] ans, boolean[] flag, int index) {
            int n = flag.length - 1;
            if (index >= ans.length) {
                return true;
            }
            if (ans[index] != 0) {
                // 当前位置有数字了,往后面找
                return dfs(ans, flag, index + 1);
            }

            for (int i = n; i > 0; i--) {
                if (flag[i]) {
                    continue;
                }

                if (i == 1) {
                    ans[index] = 1;
                    flag[1] = true;

                    if (dfs(ans, flag, index + 1)) {
                        return true;
                    }
                    // 回溯
                    ans[index] = 0;
                    flag[1] = false;
                    break;
                }

                int next = index + i;
                if (next >= ans.length || ans[next] != 0) {
                    // 放不下了
                    continue;
                }

                ans[index] = i;
                ans[next] = i;
                flag[i] = true;

                if (dfs(ans, flag, index + 1)) {
                    return true;
                }

                // 回溯
                ans[index] = 0;
                ans[next] = 0;
                flag[i] = false;
            }

            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}