

//给你一个字符串数组 words 和一个字符串 target。 
//
// 如果字符串 x 是 words 中 任意 字符串的 前缀，则认为 x 是一个 有效 字符串。 
//
// 现计划通过 连接 有效字符串形成 target ，请你计算并返回需要连接的 最少 字符串数量。如果无法通过这种方式形成 target，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 
// 输入： words = ["abc","aaaaa","bcdef"], target = "aabcdabc" 
// 
//
// 输出： 3 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[1] 的长度为 2 的前缀，即 "aa"。 
// words[2] 的长度为 3 的前缀，即 "bcd"。 
// words[0] 的长度为 3 的前缀，即 "abc"。 
// 
//
// 示例 2： 
//
// 
// 输入： words = ["abababab","ab"], target = "ababaababa" 
// 
//
// 输出： 2 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// 
//
// 示例 3： 
//
// 
// 输入： words = ["abcdef"], target = "xyz" 
// 
//
// 输出： -1 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 5 * 10⁴ 
// 输入确保 sum(words[i].length) <= 10⁵. 
// words[i] 只包含小写英文字母。 
// 1 <= target.length <= 5 * 10⁴ 
// target 只包含小写英文字母。 
// 
//
// Related Topics 线段树 数组 字符串 二分查找 动态规划 字符串匹配 哈希函数 滚动哈希 👍 32 👎 0


package cn.db117.leetcode.solution32;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * 3292.形成目标字符串需要的最少字符串数 II.minimum-number-of-valid-strings-to-form-target-ii
 *
 * @author db117
 * @since 2024-12-18 18:29:30
 **/

public class Solution_3292 {
    public static void main(String[] args) {
        Solution solution = new Solution_3292().new Solution();
        // ["bbbabcbcbacbcbcabcacacbacabcbcacabcbcbaacaacaabbaabacaabccacbaaacbbcbbcccccaacacacbacbcbccaabaacacacacaaabbbabccbbccbccaacbbcccbbcaaacbacaacaaaabbbabcbaccbbbbbbbbcbccc","aaaabbca","a"]
        //			"aaaccbabac"
        System.out.println(solution.minValidStrings(new String[]{"bbbabcbcbacbcbcabcacacbacabcbcacabcbcbaacaacaabbaabacaabccacbaaacbbcbbcccccaacacacbacbcbccaabaacacacacaaabbbabccbbccbccaacbbcccbbcaaacbacaacaaaabbbabcbaccbbbbbbbbcbccc"}, "aaaabbca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1_070_777_777;

        public int minValidStrings(String[] words, String target) {
            char[] t = target.toCharArray();
            int maxLength = 0;
            int n = t.length;

            // 多项式字符串哈希（方便计算子串哈希值）
            // 哈希函数 hash(s) = s[0] * base^(n-1) + s[1] * base^(n-2) + ... + s[n-2] * base + s[n-1]
            final int BASE = (int) 8e8 + new Random().nextInt((int) 1e8); // 随机 base，防止 hack
            int[] powBase = new int[n + 1]; // powBase[i] = base^i
            int[] preHash = new int[n + 1]; // 前缀哈希值 preHash[i] = hash(target[0] 到 target[i-1])
            powBase[0] = 1;
            for (int i = 0; i < n; i++) {
                powBase[i + 1] = (int) ((long) powBase[i] * BASE % MOD);
                preHash[i + 1] = (int) (((long) preHash[i] * BASE + t[i]) % MOD); // 秦九韶算法计算多项式哈希
            }

            for (String word : words) {
                maxLength = Math.max(maxLength, word.length());
            }

            // 每个字符串的前缀哈希值
            HashSet<Integer>[] preHashSet = new HashSet[maxLength + 1];// 最长 100
            Arrays.setAll(preHashSet, i -> new HashSet<>());
            for (String word : words) {
                int m = word.length();
                long h = 0;
                for (int i = 0; i < m; i++) {
                    h = (h * BASE + word.charAt(i)) % MOD;
                    preHashSet[i].add((int) h);
                }
            }

            int curr = 0;// 当前桥的右端点
            int nextR = 0;// 下一个桥的右端点
            int ans = 0;
            for (int i = 0; i < n; i++) {
                // 下一个桥的最大右端点
                while (nextR < n && nextR - i < maxLength && preHashSet[nextR - i].contains(subHash(i, nextR + 1, powBase, preHash))) {
                    nextR++;
                }
                if (i == curr) {// 到达当前桥的右端点，说明当前桥已经用完，需要新建桥
                    if (i == nextR) {// 无法到达 i+1，无法形成 target
                        return -1;
                    }

                    curr = nextR;
                    ans++;
                }
            }

            return ans;
        }

        // 区间 hash 值
        private int subHash(int l, int r, int[] powBase, int[] preHash) {
            return (int) ((((long) preHash[r] - (long) preHash[l] * powBase[r - l]) % MOD + MOD) % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}