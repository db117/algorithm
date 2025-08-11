

//给你一个由大写英文字母组成的字符串 s。 
//
// 你可以在字符串的 任意 位置（包括字符串的开头或结尾）最多插入一个 大写英文字母。 
//
// 返回在 最多插入一个字母 后，字符串中可以形成的 "LCT" 子序列的 最大 数量。 
//
// 子序列 是从另一个字符串中删除某些字符（可以不删除）且不改变剩余字符顺序后得到的一个 非空 字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "LMCT" 
// 
//
// 输出： 2 
//
// 解释： 
//
// 可以在字符串 s 的开头插入一个 "L"，变为 "LLMCT"，其中包含 2 个子序列，分别位于下标 [0, 3, 4] 和 [1, 3, 4]。 
//
// 示例 2： 
//
// 
// 输入： s = "LCCT" 
// 
//
// 输出： 4 
//
// 解释： 
//
// 可以在字符串 s 的开头插入一个 "L"，变为 "LLCCT"，其中包含 4 个子序列，分别位于下标 [0, 2, 4]、[0, 3, 4]、[1, 2,
// 4] 和 [1, 3, 4]。 
//
// 示例 3： 
//
// 
// 输入： s = "L" 
// 
//
// 输出： 0 
//
// 解释： 
//
// 插入一个字母无法获得子序列 "LCT"，结果为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由大写英文字母组成。 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution36;

/**
 * 3628.插入一个字母的最大子序列数.maximum-number-of-subsequences-after-one-inserting
 *
 * @author db117
 * @since 2025-08-11 17:47:35
 **/

public class Solution_3628 {
    public static void main(String[] args) {
        Solution solution = new Solution_3628().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numOfSubsequences(String s) {
            char[] chars = s.toCharArray();


            int n = s.length();
            int[] preL = new int[n + 1];
            int[] preC = new int[n + 1];
            int[] preT = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preL[i + 1] = preL[i] + (chars[i] == 'L' ? 1 : 0);
                preC[i + 1] = preC[i] + (chars[i] == 'C' ? 1 : 0);
                preT[i + 1] = preT[i] + (chars[i] == 'T' ? 1 : 0);
            }

            // 加 c
            long max = 0;
            long ansC = 0;
            for (int i = 0; i < n; i++) {
                int l = preL[i];
                int t = preT[n] - preT[i];
                if (chars[i] == 'C') {
                    ansC += (long) l * t;
                }
                max = Math.max(max, (long) l * t);
            }
            ansC += max;


            // 加 l
            long ansL = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'C') {
                    int l = preL[i] + 1;
                    int t = preT[n] - preT[i];
                    ansL += (long) l * t;
                }

            }

            // 加 t
            long ansT = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'C') {
                    int l = preL[i];
                    int t = preT[n] - preT[i] + 1;
                    ansT += (long) l * t;
                }

            }
            return Math.max(ansL, Math.max(ansT, ansC));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}