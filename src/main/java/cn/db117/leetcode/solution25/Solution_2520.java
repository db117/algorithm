

//给你一个整数 num ，返回 num 中能整除 num 的数位的数目。 
//
// 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。 
//
// 
//
// 示例 1： 
//
// 输入：num = 7
//输出：1
//解释：7 被自己整除，因此答案是 1 。
// 
//
// 示例 2： 
//
// 输入：num = 121
//输出：2
//解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
// 
//
// 示例 3： 
//
// 输入：num = 1248
//输出：4
//解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁹ 
// num 的数位中不含 0 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2520.统计能整除数字的位数.count-the-digits-that-divide-a-number
 *
 * @author db117
 * @since 2023-01-03 13:56:39
 **/

public class Solution_2520 {
    public static void main(String[] args) {
        Solution solution = new Solution_2520().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigits(int num) {
            char[] chars =
                    Integer.toString(num).toCharArray();

            int ans = 0;
            for (char c : chars) {
                if (num % (c - '0') == 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}