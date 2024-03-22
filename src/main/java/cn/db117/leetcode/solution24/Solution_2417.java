

//给定一个 正整数 n。 
//
// 如果一个整数 k 中的 偶数 位数与 奇数 位数相等，那么我们称 k 为公平整数。 
//
// 返回 大于或等于 n 的 最小 的公平整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 10
//解释: 大于等于 2 的最小的公平整数是 10。
//10是公平整数，因为它的偶数和奇数个数相等 (一个奇数和一个偶数)。 
//
// 示例 2: 
//
// 
//输入: n = 403
//输出: 1001
//解释: 大于或等于 403 的最小的公平整数是 1001。
//1001 是公平整数，因为它有相等数量的偶数和奇数 (两个奇数和两个偶数)。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数学 枚举 👍 1 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2417.最近的公平整数.closest-fair-integer
 *
 * @author db117
 * @since 2024-03-21 21:51:39
 **/

public class Solution_2417 {
    public static void main(String[] args) {
        Solution solution = new Solution_2417().new Solution();
        // 2
//        System.out.println(solution.closestFair(2));
        // 99
        System.out.println(solution.closestFair(99));
        System.out.println(solution.closestFair(99999999));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closestFair(int n) {
            String s = Integer.toString(n);
            int len = s.length();
            int ans = 0;
            if ((len & 1) == 1) {
                // 位数肯定比当前树大 1
                ans = (int) Math.pow(10, len);
                // 需要添加的 1 的个数
                int one = (len + 1) / 2 - 1;
                for (int i = 0; i < one; i++) {
                    ans += (int) Math.pow(10, i);
                }
                return ans;
            }

            // 一个个找
            for (int i = n; i < Integer.MAX_VALUE; i++) {
                if ((Integer.toString(i).length()&1)==1) {
                    // 跳过无效的
                    i *= 10;
                }
                if (check(i)) {
                    return i;
                }
            }

            return 0;
        }

        private boolean check(int n) {
            int odd = 0, even = 0;
            while (n > 0) {
                int i = n % 10;
                if ((i & 1) == 1) {
                    odd++;
                } else {
                    even++;
                }
                n /= 10;
            }
            return odd == even;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}