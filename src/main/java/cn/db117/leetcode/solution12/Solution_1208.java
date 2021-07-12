// 给你两个长度相同的字符串，s 和 t。
//
// 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的
//绝对值。 
//
// 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。 
//
// 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。 
//
// 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "bcdf", maxCost = 3
//输出：3
//解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", t = "cdef", maxCost = 3
//输出：1
//解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcd", t = "acde", maxCost = 0
//输出：1
//解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10^5 
// 0 <= maxCost <= 10^6 
// s 和 t 都只含小写英文字母。 
// 
// Related Topics 字符串 二分查找 前缀和 滑动窗口 
// 👍 133 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1208.尽可能使字符串相等.get-equal-substrings-within-budget
 *
 * @author db117
 * @since 2021-07-12 18:15:05
 **/

public class Solution_1208 {
    public static void main(String[] args) {
        Solution solution = new Solution_1208().new Solution();
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            char[] sc = s.toCharArray();
            char[] tc = t.toCharArray();
            int left = 0, right = 0;
            int useCost = 0;

            while (right < sc.length) {
                useCost += Math.abs(sc[right] - tc[right]);
                // 窗口不会收缩，一直都是最大的
                right++;

                // 当前窗口大小下，前面肯定有满足的，当前窗口满足与否不重要，左边界和右边界一块移动就可以了
                if (useCost > maxCost) {
                    useCost -= Math.abs(sc[left] - tc[left]);
                    left++;
                }
            }
            return right - left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}