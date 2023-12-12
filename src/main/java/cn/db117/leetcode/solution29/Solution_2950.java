

//每个英文字母都被映射到一个数字，如下所示。 
//
// 
//
// 如果字符串的字符的映射值的总和可以被字符串的长度整除，则该字符串是 可整除 的。 
//
// 给定一个字符串 s，请返回 s 的 可整除子串 的数量。 
//
// 子串 是字符串内的一个连续的非空字符序列。 
//
// 
//
// 示例 1： 
//
// 
// 
// 
// Substring 
// Mapped 
// Sum 
// Length 
// Divisible? 
// 
// 
// a 
// 1 
// 1 
// 1 
// Yes 
// 
// 
// s 
// 7 
// 7 
// 1 
// Yes 
// 
// 
// d 
// 2 
// 2 
// 1 
// Yes 
// 
// 
// f 
// 3 
// 3 
// 1 
// Yes 
// 
// 
// as 
// 1, 7 
// 8 
// 2 
// Yes 
// 
// 
// sd 
// 7, 2 
// 9 
// 2 
// No 
// 
// 
// df 
// 2, 3 
// 5 
// 2 
// No 
// 
// 
// asd 
// 1, 7, 2 
// 10 
// 3 
// No 
// 
// 
// sdf 
// 7, 2, 3 
// 12 
// 3 
// Yes 
// 
// 
// asdf 
// 1, 7, 2, 3 
// 13 
// 4 
// No 
// 
// 
// 
//
// 
//输入：word = "asdf"
//输出：6
//解释：上表包含了有关 word 中每个子串的详细信息，我们可以看到其中有 6 个是可整除的。
// 
//
// 示例 2: 
//
// 
//输入：word = "bdh"
//输出：4
//解释：4 个可整除的子串是："b"，"d"，"h"，"bdh"。
//可以证明 word 中没有其他可整除的子串。
// 
//
// 示例 3: 
//
// 
//输入：word = "abcd"
//输出：6
//解释：6 个可整除的子串是："a"，"b"，"c"，"d"，"ab"，"cd"。
//可以证明 word 中没有其他可整除的子串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 2000 
// word 仅包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 0 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2950.可整除子串的数量.number-of-divisible-substrings
 *
 * @author db117
 * @since 2023-12-12 10:23:50
 **/

public class Solution_2950 {
    public static void main(String[] args) {
        Solution solution = new Solution_2950().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] mapper = new int[]{
                1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9
        };

        public int countDivisibleSubstrings(String word) {
            int n = word.length();
            int[] pre = new int[n + 1];// 前缀和
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + mapper[word.charAt(i) - 'a'];
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {// [i,j]
                    if ((pre[j + 1] - pre[i]) % (j - i + 1) == 0) {
                        ans++;
                    }

                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}