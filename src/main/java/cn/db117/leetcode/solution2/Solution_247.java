

//给定一个整数 n ，返回所有长度为 n 的 中心对称数 。你可以以 任何顺序 返回答案。 
//
// 中心对称数 是一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 2
//输出：["11","69","88","96"]
// 
//
// 示例 2: 
//
// 
//输入：n = 1
//输出：["0","1","8"] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 14 
// 
//
// Related Topics 递归 数组 字符串 👍 103 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 247.中心对称数 II.strobogrammatic-number-ii
 *
 * @author db117
 * @since 2024-04-26 14:38:32
 **/

public class Solution_247 {
    public static void main(String[] args) {
        Solution solution = new Solution_247().new Solution();
        // 2
        System.out.println(solution.findStrobogrammatic(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        int n;
        char[] mid = new char[]{'0', '1', '8'};
        // 成对出现的数字
        char[] all = new char[]{'0', '1', '8', '6', '9'};
        char[] allD = new char[]{'0', '1', '8', '9', '6'};

        public List<String> findStrobogrammatic(int n) {
            this.n = n;
            dfs(0, new char[n]);
            return ans;
        }

        private void dfs(int index, char[] temp) {
            if ((n & 1) == 1 && index == n / 2) {
                // 奇数 中间只能是 0 1 8
                for (char c : mid) {
                    temp[index] = c;
                    ans.add(new String(temp));
                }
                return;
            }
            if ((n & 1) == 0 && n / 2 == index) {
                // 偶数 都分配完了
                ans.add(new String(temp));
                return;
            }


            for (int i = 0; i < all.length; i++) {
                char c = all[i];
                if (index == 0 && c == '0') {
                    // 第一个不能是0
                    continue;
                }
                temp[index] = c;
                temp[n - index - 1] = allD[i];
                dfs(index + 1, temp);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}