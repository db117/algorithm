

//给你一个字符串 s ，它只包含三种字符 a, b 和 c 。 
//
// 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcabc"
//输出：10
//解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", 
//"bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
// 
//
// 示例 2： 
//
// 输入：s = "aaacb"
//输出：3
//解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
// 
//
// 示例 3： 
//
// 输入：s = "abc"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 x 10^4 
// s 只包含字符 a，b 和 c 。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 182 👎 0


package cn.db117.leetcode.solution13;

/**
 * 1358.包含所有三种字符的子字符串数目.number-of-substrings-containing-all-three-characters
 *
 * @author db117
 * @since 2026-06-30 17:10:56
 **/

public class Solution_1358 {
    public static void main(String[] args) {
        Solution solution = new Solution_1358().new Solution();
        // abcabc
        System.out.println(solution.numberOfSubstrings("abcabc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubstrings(String s) {
            // 滑动窗口
            int n = s.length();
            int a = 0, b = 0, c = 0;
            int ans = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                char cur = s.charAt(right);
                if (cur == 'a') {
                    a++;
                } else if (cur == 'b') {
                    b++;
                } else {
                    c++;
                }
                while (a > 0 && b > 0 && c > 0) {
                    ans += n - right;// 以当前left为起点的子串数量

                    // 左边界向右移动
                    char pre = s.charAt(left);
                    if (pre == 'a') {
                        a--;
                    } else if (pre == 'b') {
                        b--;
                    } else {
                        c--;
                    }


                    left++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}