


//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 450 👎 0


package cn.db117.leetcode.solution4;

/**
 * 424.替换后的最长重复字符.longest-repeating-character-replacement
 *
 * @author db117
 * @since 2021-06-07 15:03:55
 **/

public class Solution_424 {
    public static void main(String[] args) {
        Solution solution = new Solution_424().new Solution();

        System.out.println(solution.characterReplacement("ABAB", 2));
        System.out.println(solution.characterReplacement("AABABBA", 1));
        System.out.println(solution.characterReplacement("ABBB", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] chars = s.toCharArray();
            // 统计字符出现的次数
            int[] map = new int[26];
            int max = 0, left = 0, right = 0;
            int curMax = 0;
            while (right < chars.length) {
                char cur = chars[right];
                map[cur - 'A']++;

                // 当前窗口数量最多的字符
                curMax = Math.max(curMax, map[cur - 'A']);

                if (right - left + 1 - curMax > k) {
                    // 不是最多的字符的数量大于 k 则不符合题意
                    // 当前窗口左边界右移
                    map[chars[left] - 'A']--;
                    left++;
                }

                right++;
                max = Math.max(right - left, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}