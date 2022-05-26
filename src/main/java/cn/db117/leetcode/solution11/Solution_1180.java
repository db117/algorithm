

//给你一个字符串 s，返回 只含 单一字母 的子串个数 。 
//
// 示例 1： 
//
// 
//输入： s = "aaaba"
//输出： 8
//解释： 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
//"aaa" 出现 1 次。
//"aa" 出现 2 次。
//"a" 出现 4 次。
//"b" 出现 1 次。
//所以答案是 1 + 2 + 4 + 1 = 8。
// 
//
// 示例 2: 
//
// 
//输入： s = "aaaaaaaaaa"
//输出： 55
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 仅由小写英文字母组成 
// 
// Related Topics 数学 字符串 👍 32 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1180.统计只含单一字母的子串.count-substrings-with-only-one-distinct-letter
 *
 * @author db117
 * @since 2022-05-26 16:34:52
 **/

public class Solution_1180 {
    public static void main(String[] args) {
        Solution solution = new Solution_1180().new Solution();

        System.out.println(solution.countLetters("aaaba"));
        System.out.println(solution.countLetters("aaaaaaaaaa"));
        System.out.println(solution.countLetters(":"));
        System.out.println(solution.countLetters(":"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countLetters(String s) {
            char[] chars = s.toCharArray();
            char pre = chars[0];// 前一个字符
            int count = 1;// 一样字符的数量
            int i = 1;
            int ans = 0;
            while (i <= chars.length) {
                // 找一样的字符
                while (i < chars.length && chars[i] == pre) {
                    i++;
                    count++;
                }

                // 简单累加
                for (int j = 1; j <= count; j++) {
                    ans += j;
                }

                if (i == chars.length) {
                    break;
                }
                // 下一个
                count = 1;
                pre = chars[i];
                i++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}