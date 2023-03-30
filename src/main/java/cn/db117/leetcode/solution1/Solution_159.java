

//给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eceba"
//输出：3
//解释：满足题目要求的子串是 "ece" ，长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：s = "ccaabbb"
//输出：5
//解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 195 👎 0


package cn.db117.leetcode.solution1;

/**
 * 159.至多包含两个不同字符的最长子串.longest-substring-with-at-most-two-distinct-characters
 *
 * @author db117
 * @since 2023-03-30 10:03:37
 **/

public class Solution_159 {
    public static void main(String[] args) {
        Solution solution = new Solution_159().new Solution();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int[] hash = new int[128];
            int count = 0;
            int left = 0, right = 0;
            int ans = 0;
            while (right < n) {
                // 移动右指针
                while (right < n && (count < 2 || hash[chars[right]] > 0)) {
                    hash[chars[right]]++;
                    if (hash[chars[right]] == 1) {
                        count++;
                    }
                    right++;
                }
                ans = Math.max(ans, right - left);
                // 收缩左
                while (count == 2) {
                    hash[chars[left]]--;
                    if (hash[chars[left]] == 0) {
                        count--;
                    }
                    left++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}