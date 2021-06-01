// 给定一个正整数 n ，你可以做如下操作：
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 位运算 数学 
// 👍 94 👎 0


package cn.db117.leetcode.solution3;

/**
 * 397.整数替换.integer-replacement
 *
 * @author db117
 * @since 2021-06-01 10:33:09
 **/

public class Solution_397 {
    public static void main(String[] args) {
        Solution solution = new Solution_397().new Solution();
        // 65535 17
        System.out.println(solution.integerReplacement(Integer.MAX_VALUE));

//        System.out.println(solution.integerReplacement(8));
//        System.out.println(solution.integerReplacement(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int integerReplacement(int n) {
            return (int) helper(n);
        }

        public long helper(long n) {
            // long 防止越界
            long ans = 0;
            while (n > 1) {
                if ((n & 1) == 1) {
                    // 比较 +1 -1 取最小的
                    return ans + 1 + Math.min(helper(n + 1), helper(n - 1));
                } else {
                    n >>= 1;
                }
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}