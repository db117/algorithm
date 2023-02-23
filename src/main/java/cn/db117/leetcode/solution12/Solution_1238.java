

//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足： 
//
// 
// p[0] = start 
// p[i] 和 p[i+1] 的二进制表示形式只有一位不同 
// p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同 
// 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, start = 3
//输出：[3,2,0,1]
//解释：这个排列的二进制表示是 (11,10,00,01)
//     所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]
// 
//
// 示例 2： 
//
// 输出：n = 3, start = 2
//输出：[2,6,7,5,4,0,1,3]
//解释：这个排列的二进制表示是 (010,110,111,101,100,000,001,011)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2^n 
// 
//
// Related Topics 位运算 数学 回溯 👍 77 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1238.循环码排列.circular-permutation-in-binary-representation
 *
 * @author db117
 * @since 2023-02-23 11:04:25
 **/

public class Solution_1238 {
    public static void main(String[] args) {
        Solution solution = new Solution_1238().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            int len = 1 << n;
            List<Integer> ans = new ArrayList<>(len);
            boolean[] flag = new boolean[len];
            flag[start] = true;
            ans.add(start);
            helper(ans, flag, n, start);
            return ans;
        }

        private boolean helper(List<Integer> ans, boolean[] flag, int n, int pre) {
            if (ans.size() == 1 << n) {
                // 只有一位不一样
                return Integer.bitCount(ans.get(0) ^ ans.get(ans.size() - 1)) == 1;
            }
            for (int i = 0; i < n; i++) {
                // 遍历每一位，一个个试
                int cur = pre ^ (1 << i);
                if (flag[cur]) {
                    continue;
                }
                flag[cur] = true;
                ans.add(cur);

                if (helper(ans, flag, n, cur)) {
                    return true;
                }

                ans.remove(ans.size() - 1);
                flag[cur] = false;

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}