

//给你一个字符串 s ，请你删去其中的所有元音字母 'a'，'e'，'i'，'o'，'u'，并返回这个新字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "leetcodeisacommunityforcoders"
//输出："ltcdscmmntyfrcdrs"
// 
//
// 示例 2： 
//
// 
//输入：s = "aeiou"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 15 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1119.删去字符串中的元音.remove-vowels-from-a-string
 *
 * @author db117
 * @since 2022-03-23 17:07:55
 **/

public class Solution_1119 {
    public static void main(String[] args) {
        Solution solution = new Solution_1119().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeVowels(String s) {
            // 'a'，'e'，'i'，'o'，'u'
            StringBuilder ans = new StringBuilder(s.length());
            for (char c : s.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    continue;
                }
                ans.append(c);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}