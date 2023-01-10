

//有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。 
//
// 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。 
//
// 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符. 
//
// 请返回一个能打开保险箱的最短字符串。 
//
// 
//
// 示例1: 
//
// 输入: n = 1, k = 2
//输出: "01"
//说明: "10"也可以打开保险箱。
// 
//
// 
//
// 示例2: 
//
// 输入: n = 2, k = 2
//输出: "00110"
//说明: "01100", "10011", "11001" 也能打开保险箱。
// 
//
// 
//
// 提示： 
//
// 
// n 的范围是 [1, 4]。 
// k 的范围是 [1, 10]。 
// k^n 最大可能为 4096。 
// 
//
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 177 👎 0


package cn.db117.leetcode.solution7;

import cn.db117.leetcode.base.Optimized;

import java.util.HashSet;
import java.util.Set;

/**
 * 753.破解保险箱.cracking-the-safe
 * 欧拉回路
 *
 * @author db117
 * @since 2023-01-10 14:09:45
 **/
@Optimized
public class Solution_753 {
    public static void main(String[] args) {
        Solution solution = new Solution_753().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 欧拉回路
        private Set<Integer> vis = new HashSet<>();
        private StringBuilder ans = new StringBuilder();
        private int mod;

        public String crackSafe(int n, int k) {
            mod = (int) Math.pow(10, n - 1);
            dfs(0, k);
            ans.append("0".repeat(n - 1));
            return ans.toString();
        }

        private void dfs(int u, int k) {
            for (int x = 0; x < k; ++x) {
                int e = u * 10 + x;
                if (vis.add(e)) {
                    int v = e % mod;
                    dfs(v, k);
                    ans.append(x);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}