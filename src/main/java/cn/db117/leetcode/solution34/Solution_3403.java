

//给你一个字符串 word 和一个整数 numFriends。 
//
// Alice 正在为她的 numFriends 位朋友组织一个游戏。游戏分为多个回合，在每一回合中： 
//
// 
// word 被分割成 numFriends 个 非空 字符串，且该分割方式与之前的任意回合所采用的都 不完全相同 。 
// 所有分割出的字符串都会被放入一个盒子中。 
// 
//
// 在所有回合结束后，找出盒子中 字典序最大的 字符串。 
//
// 字符串 a 的字典序 小于 字符串 b 的前提是：在两个字符串上第一处不同的位置上，a 的字母在字母表中的顺序早于 b 中对应的字母。 如果前 min(
//a.length, b.length) 个字符都相同，那么较短的字符串字典序更小。 
//
// 
//
// 示例 1： 
//
// 
// 输入: word = "dbca", numFriends = 2 
// 
//
// 输出: "dbc" 
//
// 解释: 
//
// 所有可能的分割方式为： 
//
// 
// "d" 和 "bca"。 
// "db" 和 "ca"。 
// "dbc" 和 "a"。 
// 
//
// 示例 2： 
//
// 
// 输入: word = "gggg", numFriends = 4 
// 
//
// 输出: "g" 
//
// 解释: 
//
// 唯一可能的分割方式为："g", "g", "g", 和 "g"。 
//
// 
//
// 提示: 
//
// 
// 1 <= word.length <= 5 * 10³ 
// word 仅由小写英文字母组成。 
// 1 <= numFriends <= word.length 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3403.从盒子中找出字典序最大的字符串 I.find-the-lexicographically-largest-string-from-the-box-i
 *
 * @author db117
 * @since 2025-01-02 11:14:21
 **/

public class Solution_3403 {
    public static void main(String[] args) {
        Solution solution = new Solution_3403().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String answerString(String word, int numFriends) {
            int n = word.length();
            if (numFriends == 1) {
                return word;
            }
            // 最长的字符串长度
            int t = n + 1 - numFriends;
            String ans = word.substring(0, t);// 给个默认值
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < t; j++) {
                    if (i + j == n) {
                        // 超过字符串长度
                        break;
                    }
                    char w = word.charAt(i + j);
                    char a = ans.charAt(j);
                    if (a < w) {
                        // 更新答案
                        ans = word.substring(i, Math.min(n, i + t));
                        break;
                    }
                    if (a > w) {
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}