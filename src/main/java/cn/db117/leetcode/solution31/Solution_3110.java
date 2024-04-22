

//给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和。 
//
// 请你返回 s 的 分数 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "hello" 
// 
//
// 输出：13 
//
// 解释： 
//
// s 中字符的 ASCII 码分别为：'h' = 104 ，'e' = 101 ，'l' = 108 ，'o' = 111 。所以 s 的分数为 |104 
//- 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13 。 
//
// 示例 2： 
//
// 
// 输入：s = "zaz" 
// 
//
// 输出：50 
//
// 解释： 
//
// s 中字符的 ASCII 码分别为：'z' = 122 ，'a' = 97 。所以 s 的分数为 |122 - 97| + |97 - 122| = 25
// + 25 = 50 。 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 100 
// s 只包含小写英文字母。 
// 
//
// Related Topics 字符串 👍 0 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3110.字符串的分数.score-of-a-string
 *
 * @author db117
 * @since 2024-04-22 15:07:45
 **/

public class Solution_3110 {
    public static void main(String[] args) {
        Solution solution = new Solution_3110().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfString(String s) {
            int ans = 0;
            char[] chars = s.toCharArray();
            int n = chars.length;
            for (int i = 1; i < n; i++) {
                ans += Math.abs(chars[i] - chars[i - 1]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}