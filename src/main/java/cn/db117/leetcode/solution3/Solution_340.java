

//给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eceba", k = 2
//输出：3
//解释：满足题目要求的子串是 "ece" ，长度为 3 。 
//
// 示例 2： 
//
// 
//输入：s = "aa", k = 1
//输出：2
//解释：满足题目要求的子串是 "aa" ，长度为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 224 👎 0


package cn.db117.leetcode.solution3;

/**
 * 340.至多包含 K 个不同字符的最长子串.longest-substring-with-at-most-k-distinct-characters
 *
 * @author db117
 * @since 2023-03-27 15:28:29
 **/

public class Solution_340 {
    public static void main(String[] args) {
        Solution solution = new Solution_340().new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("abaccc", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0) {
                return 0;
            }
            int ans = 0;
            char[] chars = s.toCharArray();
            char[] hash = new char[128];// 记录字符出现的次数
            int n = chars.length;
            int left = 0, right = 0;
            int count = 0;
            while (right < n) {
                // 找到 k 个不同的字符
                while (count < k && right < n) {
                    hash[chars[right]]++;
                    if (hash[chars[right]] == 1) {
                        count++;
                    }
                    right++;
                }
                // 继续找存在的
                while (right < n && hash[chars[right]] > 0) {
                    hash[chars[right]]++;
                    right++;
                }
                ans = Math.max(ans, right - left);

                // 去掉一个字符
                while (left < right && count >= k) {
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