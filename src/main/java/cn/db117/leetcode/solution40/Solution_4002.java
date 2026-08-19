package cn.db117.leetcode.solution40;

/**
 * 4002. 统计有效序列数目
 */
public class Solution_4002 {

    public static void main(String[] args) {
        // 12
        //3©leetcode   55©leetcode
        Solution solution = new Solution();
        System.out.println(solution.countValidSequences(12, 3));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static
    class Solution {
        private static final int MOD = 1_000_000_007;

        static {
            //全局缓存
            initCombinations(500000);
        }

        public int countValidSequences(int n, int k) {
            // 全部数字的组合数
            long all = combination(n - 1, k - 1);

            long allOdd = 0;
            if ((n - k) % 2 == 0) {// 全是奇数
                int upper = (n + k - 2) / 2;
                allOdd = combination(upper, k - 1);
            }
            return Math.toIntExact((all - allOdd + MOD) % MOD);
        }

        private static long[] factorial;
        private static long[] inverseFactorial;

        private static void initCombinations(int n) {
            factorial = new long[n + 1];
            inverseFactorial = new long[n + 1];

            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i % MOD;
            }

            inverseFactorial[n] = fastPow(factorial[n], MOD - 2);

            for (int i = n; i >= 1; i--) {
                inverseFactorial[i - 1] = inverseFactorial[i] * i % MOD;
            }
        }

        // 组合数
        private static long combination(int n, int k) {
            if (k < 0 || k > n) {
                return 0;
            }

            return factorial[n]
                    * inverseFactorial[k] % MOD
                    * inverseFactorial[n - k] % MOD;
        }

        // 快速幂
        private static long fastPow(long base, long exponent) {
            long result = 1;

            while (exponent > 0) {
                if ((exponent & 1) == 1) {
                    result = result * base % MOD;
                }

                base = base * base % MOD;
                exponent >>= 1;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
