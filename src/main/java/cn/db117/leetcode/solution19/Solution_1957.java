


//一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。 
//
// 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。 
//
// 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "leeetcode"
//输出："leetcode"
//解释：
//从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
//没有连续三个相同字符，所以返回 "leetcode" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabaaaa"
//输出："aabaa"
//解释：
//从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
//从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
//没有连续三个相同字符，所以返回 "aabaa" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "aab"
//输出："aab"
//解释：没有连续三个相同字符，所以返回 "aab" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 2 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1957.删除字符使字符串变好.delete-characters-to-make-fancy-string
 *
 * @author db117
 * @since 2021-08-09 15:33:40
 **/

public class Solution_1957 {
    public static void main(String[] args) {
        Solution solution = new Solution_1957().new Solution();

        System.out.println(solution.makeFancyString("leeetcode"));
        System.out.println(solution.makeFancyString("aaabaaaa"));
        System.out.println(solution.makeFancyString("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String makeFancyString(String s) {
            char[] chars = s.toCharArray();
            // 双指针
            int next = 0;
            char pre = '0';
            int curLong = 1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != pre) {
                    // 和上一个字符不一样
                    chars[next++] = chars[i];
                    curLong = 1;
                    pre = chars[i];
                    continue;
                }
                // 有重复字符
                curLong++;
                if (curLong < 3) {
                    chars[next++] = chars[i];
                    curLong++;
                }

            }
            return new String(chars, 0, next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}