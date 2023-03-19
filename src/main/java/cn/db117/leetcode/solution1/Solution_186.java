

//给你一个字符数组 s ，反转其中 单词 的顺序。 
//
// 单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。 
//
// 
// 
// 必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出：["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["a"]
//输出：["a"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 可以是一个英文字母（大写或小写）、数字、或是空格 ' ' 。 
// s 中至少存在一个单词 
// s 不含前导或尾随空格 
// 题目数据保证：s 中的每个单词都由单个空格分隔 
// 
//
// Related Topics 双指针 字符串 👍 93 👎 0


package cn.db117.leetcode.solution1;

/**
 * 186.反转字符串中的单词 II.reverse-words-in-a-string-ii
 *
 * @author db117
 * @since 2023-03-14 15:42:18
 **/

public class Solution_186 {
    public static void main(String[] args) {
        Solution solution = new Solution_186().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseWords(char[] s) {
            // 先翻转每一个单词，在翻转整个数组
            int left = 0, right = 0;
            while (right < s.length) {
                while (right < s.length && s[right] != ' ') {
                    right++;
                }
                rev(s, left, right - 1);
                right++;
                left = right;
            }

            rev(s, 0, s.length - 1);
        }

        public void rev(char[] s, int left, int right) {
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                right--;
                left++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}