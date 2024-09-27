

//给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。 
//
// 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabaaaacaabc", k = 2
//输出：8
//解释：
//从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
//从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
//共需要 3 + 5 = 8 分钟。
//可以证明需要的最少分钟数是 8 。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", k = 1
//输出：-1
//解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由字母 'a'、'b'、'c' 组成 
// 0 <= k <= s.length 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 66 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2516.每种字符至少取 K 个.take-k-of-each-character-from-left-and-right
 *
 * @author db117
 * @since 2024-09-27 10:31:28
 **/

public class Solution_2516_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_2516_1().new Solution();
        // s = "aabaaaacaabc", k = 2
//        System.out.println(solution.takeCharacters("aabaaaacaabc", 2));

        // s =
        //"cbaabccac" , k = 3
        System.out.println(solution.takeCharacters("cbaabccac", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeCharacters(String s, int k) {
            int n = s.length();
            // 滑动窗口
            int[] all = new int[3];
            for (char c : s.toCharArray()) {
                all[c - 'a']++;
            }
            if (all[0] < k || all[1] < k || all[2] < k) {
                return -1;
            }
            int ans = Integer.MIN_VALUE;
            int left = 0;
            for (int right = 0; right < n; right++) {
                all[s.charAt(right) - 'a']--;
                while (left <= right && (all[0] < k || all[1] < k || all[2] < k)) {
                    // 需要移动左边界，缩小滑动窗口
                    all[s.charAt(left) - 'a']++;
                    left++;
                }
                if (all[0] >= k && all[1] >= k && all[2] >= k) {
                    // 窗口外的满足条件
                    ans = Math.max(ans, right - left + 1);
                }
            }
            if (ans == Integer.MIN_VALUE) {
                return -1;
            }
            return n - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}