

//整数可以被看作是其因子的乘积。 
//
// 例如： 
//
// 8 = 2 x 2 x 2;
//  = 2 x 4. 
//
// 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。 
//
// 注意： 
//
// 
// 你可以假定 n 为永远为正数。 
// 因子必须大于 1 并且小于 n。 
// 
//
// 示例 1： 
//
// 输入: 1
//输出: []
// 
//
// 示例 2： 
//
// 输入: 37
//输出: [] 
//
// 示例 3： 
//
// 输入: 12
//输出:
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//] 
//
// 示例 4: 
//
// 输入: 32
//输出:
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
// 
//
// Related Topics 回溯 👍 171 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 254.因子的组合.factor-combinations
 *
 * @author db117
 * @since 2024-05-22 10:28:42
 **/

public class Solution_254 {
    public static void main(String[] args) {
        Solution solution = new Solution_254().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> getFactors(int n) {
            dfs(n, new ArrayList<>(), 2);
            return ans;
        }

        /**
         * 递归
         *
         * @param n   当前数字的组合
         * @param pre 上一个数字
         */
        private void dfs(int n, List<Integer> cur, int pre) {
            if (n == 1 && cur.size() > 1) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            // 避免重复，从小王大了选
            for (int i = pre; i  <= n; i++) {
                if (n % i == 0) {
                    cur.add(i);
                    dfs(n / i, cur, i);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}