//一个 「开心字符串」定义为：
//
// 
// 仅包含小写字母 ['a', 'b', 'c']. 
// 对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。 
// 
//
// 比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字
//符串。 
//
// 给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。 
//
// 请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1, k = 3
//输出："c"
//解释：列表 ["a", "b", "c"] 包含了所有长度为 1 的开心字符串。按照字典序排序后第三个字符串为 "c" 。
// 
//
// 示例 2： 
//
// 输入：n = 1, k = 4
//输出：""
//解释：长度为 1 的开心字符串只有 3 个。
// 
//
// 示例 3： 
//
// 输入：n = 3, k = 9
//输出："cab"
//解释：长度为 3 的开心字符串总共有 12 个 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb
//", "cab", "cac", "cba", "cbc"] 。第 9 个字符串为 "cab"
// 
//
// 示例 4： 
//
// 输入：n = 2, k = 7
//输出：""
// 
//
// 示例 5： 
//
// 输入：n = 10, k = 100
//输出："abacbabacb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10 
// 1 <= k <= 100 
// 
//
// 
// Related Topics 回溯算法 
// 👍 22 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1415.长度为 n 的开心字符串中字典序第 k 小的字符串.the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 *
 * @author db117
 * @since 2021-05-21 17:49:23
 **/

public class Solution_1415 {
    public static void main(String[] args) {
        Solution solution = new Solution_1415().new Solution();
        System.out.println(solution.getHappyString(1, 3));
        System.out.println(solution.getHappyString(1, 4));
        System.out.println(solution.getHappyString(3, 9));
        System.out.println(solution.getHappyString(2, 7));
        System.out.println(solution.getHappyString(10, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHappyString(int n, int k) {
            if (k > Math.pow(2, n - 1) * 3) {
                return "";
            }
            // 看成三进制,从ababababab开始累加k次
            char[] chars = new char[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    chars[i] = 'a';
                } else {
                    chars[i] = 'b';
                }
            }

            for (int i = 0; i < k - 1; i++) {
                add(chars);
            }


            return new String(chars);
        }

        // 加到一个合法的
        private void add(char[] chars) {
            // 是否合法

            chars[chars.length - 1]++;
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] == 'd') {
                    chars[i] = 'a';
                    chars[i - 1]++;
                } else {
                    break;
                }
            }

            // 不合法继续加
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] == chars[i - 1]) {
                    add(chars);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}