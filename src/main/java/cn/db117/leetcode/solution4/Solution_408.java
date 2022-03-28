

//字符串可以用 缩写 进行表示，缩写 的方法是将任意数量的 不相邻 的子字符串替换为相应子串的长度。例如，字符串 "substitution" 可以缩写为（不
//止这几种方法）： 
//
// 
// "s10n" ("s ubstitutio n") 
// "sub4u4" ("sub stit u tion") 
// "12" ("substitution") 
// "su3i1u2on" ("su bst i t u ti on") 
// "substitution" (没有替换子字符串) 
// 
//
// 下列是不合法的缩写： 
//
// 
// "s55n" ("s ubsti tutio n"，两处缩写相邻) 
// "s010n" (缩写存在前导零) 
// "s0ubstitution" (缩写是一个空字符串) 
// 
//
// 给你一个字符串单词 word 和一个缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。 
//
// 子字符串是字符串中连续的非空字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "internationalization", abbr = "i12iz4n"
//输出：true
//解释：单词 "internationalization" 可以缩写为 "i12iz4n" ("i nternational iz atio n") 。
// 
//
// 示例 2： 
//
// 
//输入：word = "apple", abbr = "a2e"
//输出：false
//解释：单词 "apple" 无法缩写为 "a2e" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 20 
// word 仅由小写英文字母组成 
// 1 <= abbr.length <= 10 
// abbr 由小写英文字母和数字组成 
// abbr 中的所有数字均符合 32-bit 整数范围 
// 
// Related Topics 双指针 字符串 👍 39 👎 0


package cn.db117.leetcode.solution4;

/**
 * 408.有效单词缩写.valid-word-abbreviation
 *
 * @author db117
 * @since 2022-03-28 11:01:08
 **/

public class Solution_408 {
    public static void main(String[] args) {
        Solution solution = new Solution_408().new Solution();
        System.out.println(solution.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(solution.validWordAbbreviation("apple", "a2e"));
        System.out.println(solution.validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println(solution.validWordAbbreviation("hi", "2i"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            char[] chars1 = word.toCharArray();
            char[] chars2 = abbr.toCharArray();
            if (chars1.length < chars2.length) {
                return false;
            }

            int i1 = 0, i2 = 0;
            while (i1 < chars1.length && i2 < chars2.length) {
                char c1 = chars1[i1];
                char c2 = chars2[i2];
                if (c1 == c2) {
                    i1++;
                    i2++;
                    continue;
                }
                if (c2 == '0') {
                    // 不能有 0 开头
                    return false;
                }
                if (!Character.isDigit(c2)) {
                    // 只能是数字
                    return false;
                }

                // 缩写长度
                int n = 0;
                while (i2 < chars2.length && Character.isDigit(chars2[i2])) {
                    n *= 10;
                    n += chars2[i2] - '0';
                    i2++;
                }

                if (i1 + n > chars1.length) {
                    // 超长
                    return false;
                }

                i1 += n;
            }


            return i1 == chars1.length && i2 == chars2.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}