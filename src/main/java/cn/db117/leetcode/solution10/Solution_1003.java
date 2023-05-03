

//给你一个字符串 s ，请你判断它是否 有效 。
//
// 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ： 
//
// 
// 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + 
//tright 。注意，tleft 和 tright 可能为 空 。 
// 
//
// 如果字符串 s 有效，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcbc"
//输出：true
//解释：
//"" -> "abc" -> "aabcbc"
//因此，"aabcbc" 有效。 
//
// 示例 2： 
//
// 
//输入：s = "abcabcababcc"
//输出：true
//解释：
//"" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
//因此，"abcabcababcc" 有效。 
//
// 示例 3： 
//
// 
//输入：s = "abccba"
//输出：false
//解释：执行操作无法得到 "abccba" 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁴ 
// s 由字母 'a'、'b' 和 'c' 组成 
// 
//
// Related Topics 栈 字符串 👍 119 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1003.检查替换后的词是否有效.check-if-word-is-valid-after-substitutions
 *
 * @author db117
 * @since 2023-05-03 20:34:47
 **/

public class Solution_1003 {
    public static void main(String[] args) {
        Solution solution = new Solution_1003().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 简单粗暴直接替换字符串
            while (s.length() > 0) {
                int indexOf = s.indexOf("abc");
                if (indexOf < 0) {
                    return false;
                }
                s = s.substring(0, indexOf) + s.substring(indexOf + 3);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}