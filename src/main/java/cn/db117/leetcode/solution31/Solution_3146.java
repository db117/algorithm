

//给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。 
//
// 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。 
//
// 返回 s 和 t 之间的 排列差 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "abc", t = "bac" 
// 
//
// 输出：2 
//
// 解释： 
//
// 对于 s = "abc" 和 t = "bac"，排列差是： 
//
// 
// "a" 在 s 中的位置与在 t 中的位置之差的绝对值。 
// "b" 在 s 中的位置与在 t 中的位置之差的绝对值。 
// "c" 在 s 中的位置与在 t 中的位置之差的绝对值。 
// 
//
// 即，s 和 t 的排列差等于 |0 - 1| + |2 - 2| + |1 - 0| = 2。 
//
// 示例 2： 
//
// 
// 输入：s = "abcde", t = "edbac" 
// 
//
// 输出：12 
//
// 解释： s 和 t 的排列差等于 |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 26 
// 每个字符在 s 中最多出现一次。 
// t 是 s 的一个排列。 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 2 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3146.两个字符串的排列差.permutation-difference-between-two-strings
 *
 * @author db117
 * @since 2024-05-16 17:21:31
 **/

public class Solution_3146 {
    public static void main(String[] args) {
        Solution solution = new Solution_3146().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPermutationDifference(String s, String t) {
            // 计数
            int[] index1 = new int[26];
            int[] index2 = new int[26];
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                index1[chars1[i] - 'a'] = i;
                index2[chars2[i] - 'a'] = i;
            }

            int ans = 0;
            for (int i = 0; i < 26; i++) {
                ans += Math.abs(index1[i] - index2[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}