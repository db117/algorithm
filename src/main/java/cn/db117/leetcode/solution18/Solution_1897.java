//给你一个字符串数组 words（下标 从 0 开始 计数）。
//
// 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words
//[j] 中的 任一 位置上。 
//
// 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["abc","aabc","bc"]
//输出：true
//解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
//使 words[1] = "abc" 且 words[2] = "abc" 。
//所有字符串都等于 "abc" ，所以返回 true 。
// 
//
// 示例 2： 
//
// 输入：words = ["ab","a"]
//输出：false
//解释：执行操作无法使所有字符串都相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 2 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1897.重新分配字符使所有字符串都相等.redistribute-characters-to-make-all-strings-equal
 *
 * @author db117
 * @since 2021-06-24 18:22:58
 **/

public class Solution_1897 {
    public static void main(String[] args) {
        Solution solution = new Solution_1897().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean makeEqual(String[] words) {
            // 统计所有字符出现的次数

            int[] count = new int[26];
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    count[c - 'a']++;
                }
            }

            // 若都可以被整除则符合题意
            int len = words.length;
            for (int i : count) {
                if (i % len != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}