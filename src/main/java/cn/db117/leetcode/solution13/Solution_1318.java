

// 给你三个正整数 a、b 和 c。
//
// 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算 a OR b == c 成立的最小翻转次数。 
//
// 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：a = 2, b = 6, c = 5
//输出：3
//解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c 
//
// 示例 2： 
//
// 输入：a = 4, b = 2, c = 7
//输出：1
// 
//
// 示例 3： 
//
// 输入：a = 1, b = 2, c = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 10^9 
// 1 <= b <= 10^9 
// 1 <= c <= 10^9 
// 
// Related Topics 位运算 
// 👍 28 👎 0


package cn.db117.leetcode.solution13;

/**
 * 1318.或运算的最小翻转次数.minimum-flips-to-make-a-or-b-equal-to-c
 *
 * @author db117
 * @since 2021-06-03 16:28:18
 **/

public class Solution_1318 {
    public static void main(String[] args) {
        Solution solution = new Solution_1318().new Solution();
        System.out.println(solution.minFlips(2, 4, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int a, int b, int c) {
            int ans = 0;
            for (int i = 0; i < 31; i++) {
                int tmp = 1 << i;
                if ((c & tmp) > 0) {
                    // c 在当前位为1
                    if ((b & tmp) == 0 && (a & tmp) == 0) {
                        // a b 在当前位都为0是需要操作一下
                        ans++;
                    }
                } else {
                    // c 在当前位为0 , 为 1 的都得操作一下
                    if ((b & tmp) > 0) {
                        ans++;
                    }
                    if ((a & tmp) > 0) {
                        ans++;
                    }

                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}