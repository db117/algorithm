

//给你一个正整数 n 。 
//
// 请你将 n 的值替换为 n 的 质因数 之和，重复这一过程。 
//
// 
// 注意，如果 n 能够被某个质因数多次整除，则在求和时，应当包含这个质因数同样次数。 
// 
//
// 返回 n 可以取到的最小值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 15
//输出：5
//解释：最开始，n = 15 。
//15 = 3 * 5 ，所以 n 替换为 3 + 5 = 8 。
//8 = 2 * 2 * 2 ，所以 n 替换为 2 + 2 + 2 = 6 。
//6 = 2 * 3 ，所以 n 替换为 2 + 3 = 5 。
//5 是 n 可以取到的最小值。
// 
//
// 示例 2： 
//
// 输入：n = 3
//输出：3
//解释：最开始，n = 3 。
//3 是 n 可以取到的最小值。 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 
//
// 👍 5 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2507.使用质因数之和替换后可以取到的最小值.smallest-value-after-replacing-with-sum-of-prime-factors
 *
 * @author db117
 * @since 2022-12-19 10:51:16
 **/

public class Solution_2507 {
    public static void main(String[] args) {
        Solution solution = new Solution_2507().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestValue(int n) {
            while (true) {
                int sum = 0, cur = n, i = 2;
                while (i * i <= cur) {
                    // 能被除尽,则一直除
                    while (cur % i == 0) {
                        sum += i;
                        cur /= i;
                    }
                    i++;
                }
                if (cur > 1) {
                    // 加上最后一个数字
                    sum += cur;
                }
                if (sum == n) {
                    // 不能变小了
                    return sum;
                }
                n = sum;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}