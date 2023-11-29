

//给你三个整数 a ，b 和 n ，请你返回 (a XOR x) * (b XOR x) 的 最大值 且 x 需要满足 0 <= x < 2ⁿ。 
//
// 由于答案可能会很大，返回它对 109 + 7 取余 后的结果。 
//
// 注意，XOR 是按位异或操作。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 12, b = 5, n = 4
//输出：98
//解释：当 x = 2 时，(a XOR x) = 14 且 (b XOR x) = 7 。所以，(a XOR x) * (b XOR x) = 98 。
//98 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 示例 2： 
//
// 
//输入：a = 6, b = 7 , n = 5
//输出：930
//解释：当 x = 25 时，(a XOR x) = 31 且 (b XOR x) = 30 。所以，(a XOR x) * (b XOR x) = 930 
//。
//930 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 6, n = 3
//输出：12
//解释： 当 x = 5 时，(a XOR x) = 4 且 (b XOR x) = 3 。所以，(a XOR x) * (b XOR x) = 12 。
//12 是所有满足 0 <= x < 2n 中 (a XOR x) * (b XOR x) 的最大值。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b < 2⁵⁰ 
// 0 <= n <= 50 
// 
//
// Related Topics 贪心 位运算 数学 👍 10 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2939.最大异或乘积.maximum-xor-product
 *
 * @author db117
 * @since 2023-11-27 17:59:53
 **/

public class Solution_2939 {
    public static void main(String[] args) {
        Solution solution = new Solution_2939().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int mod = 1000000007;

        public int maximumXorProduct(long a, long b, int n) {

            long ans = 0;
            long x = 0;
            for (int i = n - 1; i >= 0; i--) {
                long cur = 1L << i;
                if ((a & cur) == 0 && (b & cur) == 0) {
                    // 都为0
                    x |= cur;
                    continue;
                }
                if ((a & cur) != 0 && (b & cur) != 0) {
                    // 都为1
                    continue;
                }
                // 一个为0 一个为1
                long next = x | cur;
                String m1 = multiply(String.valueOf(a ^ next), String.valueOf(b ^ next));
                String m2 = multiply(String.valueOf(a ^ x), String.valueOf(b ^ x));
                if (m1.length() < m2.length()) {
                    continue;
                }
                if (m1.length() > m2.length()) {
                    x = next;
                    continue;
                }
                if (m1.compareTo(m2) > 0) {
                    x = next;
                }

            }
            return (int) (((a ^ x) % mod) * ((b ^ x) % mod) % mod);
        }

        public static String multiply(String num1, String num2) {
            int m = num1.length();
            int n = num2.length();
            int[] products = new int[m + n];

            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    products[i + j + 1] += x * y;
                }
            }

            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = m + n - 1; i >= 0; i--) {
                int sum = products[i] + carry;
                carry = sum / 10;
                sb.insert(0, sum % 10);
            }

            while (!sb.isEmpty() && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            return sb.isEmpty() ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}