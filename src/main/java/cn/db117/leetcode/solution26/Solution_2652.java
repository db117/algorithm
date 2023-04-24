

//给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。 
//
// 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。 
//
// 
//
// 示例 1： 
//
// 输入：n = 7
//输出：21
//解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：40
//解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40 。
// 
//
// 示例 3： 
//
// 输入：n = 9
//输出：30
//解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10³ 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2652.倍数求和.sum-multiples
 *
 * @author db117
 * @since 2023-04-24 13:50:30
 **/

public class Solution_2652 {
    public static void main(String[] args) {
        Solution solution = new Solution_2652().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfMultiples(int n) {
            int ans = 0;
            // 所有 3 的倍数
            for (int i = 3; i <= n; i += 3) {
                ans += i;
            }
            // 5 的倍数（不包含3）
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 != 0) {
                    ans += i;
                }
            }
            // 7的倍数 （不包含3 5）
            for (int i = 7; i <= n; i += 7) {
                if (i % 5 != 0 && i % 3 != 0) {
                    ans += i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}