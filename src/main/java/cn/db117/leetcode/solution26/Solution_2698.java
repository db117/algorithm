

//给你一个正整数 n ，请你返回 n 的 惩罚数 。 
//
// n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和： 
//
// 
// 1 <= i <= n 
// i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：182
//解释：总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
// 
//
// 示例 2： 
//
// 
//输入：n = 37
//输出：1478
//解释：总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// 👍 7 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2698.求一个整数的惩罚数.find-the-punishment-number-of-an-integer
 *
 * @author db117
 * @since 2023-05-22 11:24:24
 **/

public class Solution_2698 {
    public static void main(String[] args) {
        Solution solution = new Solution_2698().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 预处理
        static boolean[] arr = new boolean[1002];

        static {
            for (int i = 1; i < 1002; i++) {
                if (helper(i)) {
                    arr[i] = true;
                }
            }
        }

        public int punishmentNumber(int n) {
            int ans = 0;
            for (int i = 0; i <= n; i++) {
                if (arr[i]) {
                    ans += i * i;
                }
            }
            return ans;
        }

        public static boolean helper(int i) {
            return dfs(String.valueOf(i * i), i, 0, 0);
        }

        // 回溯
        public static boolean dfs(String s, int n, int cur, int index) {
            if (index == s.length()) {
                return cur == n;
            }

            for (int j = index + 1; j <= s.length(); j++) {
                // 当前字符串的数值
                int valueOf = Integer.parseInt(s.substring(index, j));
                // 处理剩余字符串
                if (dfs(s, n, valueOf + cur, j)) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}