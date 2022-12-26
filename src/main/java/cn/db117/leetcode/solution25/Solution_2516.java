

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
// 👍 10 👎 0


package cn.db117.leetcode.solution25;

import java.util.ArrayList;
import java.util.List;

/**
 * 2516.每种字符至少取 K 个.take-k-of-each-character-from-left-and-right
 *
 * @author db117
 * @since 2022-12-26 09:56:45
 **/

public class Solution_2516 {
    public static void main(String[] args) {
        Solution solution = new Solution_2516().new Solution();
        System.out.println(solution.takeCharacters("aabaaaacaabc", 2));
        System.out.println(solution.takeCharacters("a", 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int n = chars.length;
            // 记录出现位置
            List<Integer> ai = new ArrayList<>();
            List<Integer> bi = new ArrayList<>();
            List<Integer> ci = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char c = chars[i];
                if (c == 'a') {
                    ai.add(i);
                } else if (c == 'b') {
                    bi.add(i);
                } else {
                    ci.add(i);
                }
            }
            if (ai.size() < k || bi.size() < k || ci.size() < k) {
                return -1;
            }
            int ans = Integer.MAX_VALUE;
            // 全从后面取
            ans = n - Math.min(ai.get(ai.size() - k), Math.min(bi.get(bi.size() - k), ci.get(ci.size() - k)));

            // 枚举左边选取的数量
            int[] count = new int[3];
            for (int left = 1; left <= n; left++) {
                if (left > ans) {
                    // 后面不可能比这个短了
                    break;
                }
                count[chars[left - 1] - 'a']++;
                if (count[0] >= k && count[1] >= k && count[2] >= k) {
                    // 后面不可能比这个短了
                    ans = Math.min(ans, left);
                    return ans;
                }

                // 找到右边需要的位置
                int right = 0;
                if (count[0] < k) {
                    right = Math.max(right, n - ai.get(ai.size() - (k - count[0])));
                }
                if (count[1] < k) {
                    right = Math.max(right, n - bi.get(bi.size() - (k - count[1])));
                }
                if (count[2] < k) {
                    right = Math.max(right, n - ci.get(ci.size() - (k - count[2])));
                }
                ans = Math.min(ans, left + right);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}