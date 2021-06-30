// 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
//
// 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 
//
// 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 
//
// 示例： 
//
// 输入: "aba", "cdc", "eae"
//输出: 3
// 
//
// 
//
// 提示： 
//
// 
// 所有给定的字符串长度不会超过 10 。 
// 给定字符串列表的长度将在 [2, 50 ] 之间。 
// 
//
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 
// 👍 62 👎 0


package cn.db117.leetcode.solution5;

import java.util.Arrays;

/**
 * 522.最长特殊序列 II.longest-uncommon-subsequence-ii
 *
 * @author db117
 * @since 2021-06-30 17:42:15
 **/

public class Solution_522 {
    public static void main(String[] args) {
        Solution solution = new Solution_522().new Solution();

        // "aabbcc", "aabbcc","bc","bcc","aabbccc"
        // 7
        System.out.println(solution.findLUSlength(new String[]{
                "aabbcc", "aabbcc", "bc", "bcc", "aabbccc"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());

            for (String str : strs) {

                // 前面开始一个个比较
                int count = 0; // 是子序列的数量
                for (String s : strs) {
                    if (str.length() > s.length()) {
                        // 后面的没有必要比了
                        break;
                    }


                    if (helper(s, str)) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count == 1) {
                    return str.length();
                }
            }
            return -1;
        }

        // 判断 s2 是不是 s1 的子序列
        private boolean helper(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }

            int index2 = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (index2 == s2.length()) {
                    return true;
                }
                if (s1.charAt(i) == s2.charAt(index2)) {
                    index2++;
                }
            }
            return index2 == s2.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}