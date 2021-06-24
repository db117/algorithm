


//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 滑动窗口 
// 👍 224 👎 0


package cn.db117.leetcode.office;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48.最长不含重复字符的子字符串.zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 *
 * @author db117
 * @since 2021-06-24 15:50:07
 **/

public class Offer_48 {
    public static void main(String[] args) {
        Solution solution = new Offer_48().new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            // 双指针
            int left = 0, right = 0, max = 0;
            Set<Character> set = new HashSet<>();

            while (right < chars.length) {
                // 右指针右移
                if (!set.contains(chars[right])) {
                    set.add(chars[right]);
                    right++;
                    continue;
                }
                max = Math.max(max, right - left);

                // 移动左指针
                while (set.contains(chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
            }

            // 最长字符串包含最后一个的情况
            max = Math.max(max, right - left);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}