

//给你两个字符串 s 和 t 。 
//
// 你可以从字符串 t 中删除任意数目的字符。 
//
// 如果没有从字符串 t 中删除字符，那么得分为 0 ，否则： 
//
// 
// 令 left 为删除字符中的最小下标。 
// 令 right 为删除字符中的最大下标。 
// 
//
// 字符串的得分为 right - left + 1 。 
//
// 请你返回使 t 成为 s 子序列的最小得分。 
//
// 一个字符串的 子序列 是从原字符串中删除一些字符后（也可以一个也不删除），剩余字符不改变顺序得到的字符串。（比方说 "ace" 是 "abcde" 的子序
//列，但是 "aec" 不是）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abacaba", t = "bzaa"
//输出：1
//解释：这个例子中，我们删除下标 1 处的字符 "z" （下标从 0 开始）。
//字符串 t 变为 "baa" ，它是字符串 "abacaba" 的子序列，得分为 1 - 1 + 1 = 1 。
//1 是能得到的最小得分。
// 
//
// 示例 2： 
//
// 
//输入：s = "cde", t = "xyz"
//输出：3
//解释：这个例子中，我们将下标为 0， 1 和 2 处的字符 "x" ，"y" 和 "z" 删除（下标从 0 开始）。
//字符串变成 "" ，它是字符串 "cde" 的子序列，得分为 2 - 0 + 1 = 3 。
//3 是能得到的最小得分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 都只包含小写英文字母。 
// 
//
// 
//
// 👍 10 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2565.最少得分子序列.subsequence-with-the-minimum-score
 *
 * @author db117
 * @since 2023-02-13 11:33:01
 **/

public class Solution_2565 {
    public static void main(String[] args) {
        Solution solution = new Solution_2565().new Solution();
        // s = "abacaba", t = "bzaa"
//        System.out.println(solution.minimumScore("abacaba", "bzaa"));

        // s = "cde", t = "xyz"
//        System.out.println(solution.minimumScore("cde", "xyz"));

        // s =
        //"cbaa"
        //t =
        //"a"
//        System.out.println(solution.minimumScore("cbaa", "a"));

        // s =
        //"gbjbacdiiiecgceeafdcdhjhhcjfchjbejibhejgjhhhjhifahfbbcfcajehjgcjgffjdejbhjahgffgdaifhhgaadjiabfdf"
        //t =
        //"hidefgbgjghceagdaaib"
        // 5
        System.out.println(solution.minimumScore("gbjbacdiiiecgceeafdcdhjhhcjfchjbejibhejgjhhhjhifahfbbcfcajehjgcjgffjdejbhjahgffgdaifhhgaadjiabfdf", "hidefgbgjghceagdaaib"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumScore(String s, String t) {
            char[] charsS = s.toCharArray();
            char[] charsT = t.toCharArray();
            int m = charsS.length;
            int n = charsT.length;
            // s[..i] 对应 t 中最长后缀子串的开始位置
            int[] suf = new int[m + 1];
            // s[..i] 对应 t 中最长前缀子串的开始位置
            int[] pre = new int[m + 1];

            suf[m] = n;
            for (int i = m - 1, j = n - 1; i >= 0; i--) {
                if (j >= 0 && charsS[i] == charsT[j]) {
                    j--;
                }
                suf[i] = j + 1;
            }
            if (suf[0] == 0) {
                // 说明 t 是 s 的子序列
                return 0;
            }

            for (int i = 0, j = 0; i < m; i++) {
                if (charsS[i] == charsT[j]) {
                    if (j < n - 1) {
                        j++;
                    }
                }
                pre[i] = j;
            }

            int ans = suf[0];// 直接删除 t[0,suf[0]]
            for (int i = 0; i < m; i++) {
                // 把 s 分两半,找前缀子序列和后缀子序列
                if (suf[i + 1] >= pre[i]) {
                    ans = Math.min(ans, suf[i + 1] - pre[i]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}