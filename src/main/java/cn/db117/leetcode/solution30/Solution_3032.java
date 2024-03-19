

//给你两个 正整数 a 和 b ，返回 闭区间 [a, b] 内各位数字都不同的数字个数。
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 20
//输出：19
//解释：除 11 以外，区间 [1, 20] 内的所有数字的各位数字都不同。因此，答案为 19 。
// 
//
// 示例 2： 
//
// 
//输入：a = 9, b = 19
//输出：10
//解释：除 11 以外，区间 [1, 20] 内的所有数字的各位数字都不同。因此，答案为 10 。
// 
//
// 示例 3： 
//
// 
//输入：a = 80, b = 120
//输出：27
//解释：区间 [80, 120] 内共有 41 个整数，其中 27 个数字的各位数字都不同。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= b <= 1000 
// 
//
// Related Topics 哈希表 数学 动态规划 👍 0 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3032.统计各位数字都不同的数字个数 II.count-numbers-with-unique-digits-ii
 *
 * @author db117
 * @since 2024-03-19 16:02:28
 **/

public class Solution_3032 {
    public static void main(String[] args) {
        Solution solution = new Solution_3032().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberCount(int a, int b) {
            int ans = 0;
            for (int i = a; i <= b; i++) {
                String s = Integer.toString(i);
                if (s.chars().distinct().count() == s.length()) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}