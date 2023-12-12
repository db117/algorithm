

//给你一个字符串 word 和一个整数 k 。 
//
// 如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串： 
//
// 
// s 中每个字符 恰好 出现 k 次。 
// 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。 
// 
//
// 请你返回 word 中 完全 子字符串的数目。 
//
// 子字符串 指的是一个字符串中一段连续 非空 的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "igigee", k = 2
//输出：3
//解释：完全子字符串需要满足每个字符恰好出现 2 次，且相邻字符相差至多为 2 ：igigee, igigee, igigee 。
// 
//
// 示例 2： 
//
// 
//输入：word = "aaabbbccc", k = 3
//输出：6
//解释：完全子字符串需要满足每个字符恰好出现 3 次，且相邻字符相差至多为 2 ：aaabbbccc, aaabbbccc, aaabbbccc, 
//aaabbbccc, aaabbbccc, aaabbbccc 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 只包含小写英文字母。 
// 1 <= k <= word.length 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 26 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2953.统计完全子字符串.count-complete-substrings
 *
 * @author db117
 * @since 2023-12-12 10:56:20
 **/

public class Solution_2953 {
    public static void main(String[] args) {
        Solution solution = new Solution_2953().new Solution();
        // "igigee"
        //			2
//        System.out.println(solution.countCompleteSubstrings("igigee", 2));

        // "gvgvvgv"
        //			2
        System.out.println(solution.countCompleteSubstrings("gvgvvgv", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int countCompleteSubstrings(String word, int k) {
            char[] chars = word.toCharArray();
            int n = chars.length;
            // 分组循环
            int start = 0;
            for (int i = 0; i < n; ) {
                i++;
                while (i < n && Math.abs(chars[i] - chars[i - 1]) <= 2) {
                    i++;
                }
                // 这个组内的进行判断
                group(Arrays.copyOfRange(chars, start, i), k);
                // 下一个组
                start = i;
            }
            return ans;
        }

        private void group(char[] chars, int k) {
            int n = chars.length;
            // 数组长度肯定是 k 的倍数,直接枚举滑动窗口大小
            for (int m = 1; m * k <= n && m <= 26; m++) {// 窗口大小 窗口最大 26*k
                int[] count = new int[26];
                for (int right = 0; right < n; right++) {
                    count[chars[right] - 'a']++;// 右边界右移
                    if (right + 1 < k * m) {
                        // 不够窗口大小
                        continue;
                    }
                    // 判断是否满足条件
                    boolean flag = true;
                    for (int i = 0; i < 26; i++) {
                        if (count[i] > 0 && count[i] != k) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        // 满足条件
                        ans++;
                    }
                    // 左边界右移
                    count[chars[right + 1 - k * m] - 'a']--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}