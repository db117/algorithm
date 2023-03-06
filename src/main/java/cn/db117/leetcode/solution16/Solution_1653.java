

//给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。 
//
// 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' 
//，此时认为 s 是 平衡 的。 
//
// 请你返回使 s 平衡 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
// 
//
// 示例 2： 
//
// 
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 要么是 'a' 要么是 'b' 。 
// 
//
// Related Topics 栈 字符串 动态规划 👍 74 👎 0


package cn.db117.leetcode.solution16;

/**
 * 1653.使字符串平衡的最少删除次数.minimum-deletions-to-make-string-balanced
 *
 * @author db117
 * @since 2023-03-06 10:03:07
 **/

public class Solution_1653 {
    public static void main(String[] args) {
        Solution solution = new Solution_1653().new Solution();
//        System.out.println(solution.minimumDeletions("aababbab"));
//        System.out.println(solution.minimumDeletions("b"));
//        System.out.println(solution.minimumDeletions("ab"));
//        System.out.println(solution.minimumDeletions("bbbbbbbb"));
        System.out.println(solution.minimumDeletions("aaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeletions(String s) {
            int n = s.length();

            int ans = Integer.MAX_VALUE;
            int[] rightA = new int[n + 1];// 右边的 a
            for (int i = n - 1; i >= 0; i--) {
                rightA[i] = rightA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
            }
            int b = 0;// 左边的 b
            for (int i = 0; i <= n; i++) {
                // 去掉左边的 b ，右边的 a
                ans = Math.min(b + rightA[i], ans);

                if (i < n && s.charAt(i) == 'b') {
                    b++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}