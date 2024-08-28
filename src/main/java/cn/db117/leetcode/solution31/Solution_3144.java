

//给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。比方说，s == "ababcc" 那么 ("abab", "c", "c") ，(
//"ab", "abc", "c") 和 ("ababcc") 都是合法分割，但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和
// ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。 
//
// 请你返回 s 最少 能分割成多少个平衡子字符串。 
//
// 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "fabccddg" 
// 
//
// 输出：3 
//
// 解释： 
//
// 我们可以将 s 分割成 3 个子字符串：("fab, "ccdd", "g") 或者 ("fabc", "cd", "dg") 。 
//
// 示例 2： 
//
// 
// 输入：s = "abababaccddb" 
// 
//
// 输出：2 
//
// 解释： 
//
// 我们可以将 s 分割成 2 个子字符串：("abab", "abaccddb") 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 动态规划 计数 👍 36 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3144.分割字符频率相等的最少子字符串.minimum-substring-partition-of-equal-character-frequency
 *
 * @author db117
 * @since 2024-08-28 22:40:52
 **/

public class Solution_3144 {
    public static void main(String[] args) {
        Solution solution = new Solution_3144().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] chars;
        private int[] memo;

        public int minimumSubstringsInPartition(String s) {
            this.chars = s.toCharArray();
            memo = new int[chars.length];
            return dfs(memo.length - 1);
        }

        private int dfs(int i) {
            if (i < 0) {
                return 0;
            }

            if (memo[i] > 0) {
                return memo[i];
            }
            int[] count = new int[26];
            int k = 0;// 不同字符数量
            int ans = Integer.MAX_VALUE;
            int maxCount = 0;// 最大字符数量
            for (int j = i; j >= 0; j--) {
                if (count[chars[j] - 'a'] == 0) {
                    k++;
                }
                count[chars[j] - 'a']++;
                maxCount = Math.max(maxCount, count[chars[j] - 'a']);

                if (i - j + 1 == k * maxCount) {
                    // 符合条件
                    ans = Math.min(ans, dfs(j - 1) + 1);
                }
            }

            return memo[i] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}