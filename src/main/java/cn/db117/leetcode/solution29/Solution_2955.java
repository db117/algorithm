

//给定一个 下标从0开始 的字符串 s，以及一个二维整数数组 queries，其中 queries[i] = [li, ri] 表示 s 中从索引 li 开始
//到索引 ri 结束的子串（包括两端），即 s[li..ri]。 
//
// 返回一个数组 ans，其中 ans[i] 是 queries[i] 的 同端 子串的数量。 
//
// 如果一个 下标从0开始 且长度为 n 的字符串 t 两端的字符相同，即 t[0] == t[n - 1]，则该字符串被称为 同端。 
//
// 子串 是一个字符串中连续的非空字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcaab", queries = [[0,0],[1,4],[2,5],[0,5]]
//输出：[1,5,5,10]
//解释：每个查询的同端子串如下：
//第一个查询：s[0..0] 是 "a"，有 1 个同端子串："a"。
//第二个查询：s[1..4] 是 "bcaa"，有 5 个同端子串："bcaa", "bcaa", "bcaa", "bcaa", "bcaa"。
//第三个查询：s[2..5] 是 "caab"，有 5 个同端子串："caab", "caab", "caab", "caab", "caab"。
//第四个查询：s[0..5] 是 "abcaab"，有 10 个同端子串："abcaab", "abcaab", "abcaab", "abcaab", 
//"abcaab", "abcaab", "abcaab", "abcaab", "abcaab", "abcaab"。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", queries = [[0,3]]
//输出：[4]
//解释：唯一的查询是 s[0..3]，它有 4 个同端子串："abcd", "abcd", "abcd", "abcd"。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 仅包含小写英文字母。 
// 1 <= queries.length <= 3 * 10⁴ 
// queries[i] = [li, ri] 
// 0 <= li <= ri < s.length 
// 
//
// Related Topics 数组 哈希表 字符串 计数 前缀和 👍 0 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2955.同端子串的数量.number-of-same-end-substrings
 *
 * @author db117
 * @since 2024-05-24 17:37:26
 **/

public class Solution_2955 {
    public static void main(String[] args) {
        Solution solution = new Solution_2955().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sameEndSubstringCount(String s, int[][] queries) {
            int[] ans = new int[queries.length];
            int n = s.length();
            // 计算出每个字符的前缀和
            int[][] pre = new int[n + 1][26];
            for (int i = 0; i < n; i++) {
                System.arraycopy(pre[i], 0, pre[i + 1], 0, 26);
                pre[i + 1][s.charAt(i) - 'a']++;
            }

            // 对于每个查询可以通过前缀和计算出
            // 两端相同的字符数量 = 每个字符串出现的次数的组合数
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int l = query[0], r = query[1];
                for (int j = 0; j < 26; j++) {
                    int cnt = pre[r + 1][j] - pre[l][j];
                    // n + n-1 + n-2 +...+ 1
                    ans[i] += cnt * (cnt + 1) / 2;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}