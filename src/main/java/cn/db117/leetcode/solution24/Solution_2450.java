

//给定一个 二进制 字符串 s 和一个正整数 k。 
//
// 你可以对字符串应用以下操作 任意 次数: 
//
// 
// 从 s 中选择任何大小为 k 的子字符串，将其所有字符 翻转，即将所有 1 都变成 0，所有 0 都变成 1。 
// 
//
// 返回您可以获得的 不同 字符串的数量。因为答案可能太大，所以对 10⁹ + 7 取模 后返回。 
//
// 注意: 
//
// 
// 二进制字符串是 仅由 字符 0 和 1 组成的字符串。 
// 子字符串是字符串的连续部分。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "1001", k = 3
//输出: 4
//解释: 我们可以获得以下字符串:
//- 对字符串不应用任何操作将得到 s = "1001"。
//- 对从下标 0 开始的子字符串应用一个操作，得到 s = "0111"。
//- 对从下标 1 开始的子字符串应用一个操作，得到 s = "1110"。
//- 对从下标 0 和 1 开始的两个子字符串都应用一个操作，得到 s = "0000"。
//可以证明，我们不能获得任何其他字符串，所以答案是 4。 
//
// 示例 2: 
//
// 
//输入: s = "10110", k = 5
//输出: 2
//解释: 我们可以获得以下字符串:
//- 对字符串不执行任何操作，将得到 s = "10110"。
//- 对整个字符串应用一个操作将得到 s = "01001"。
//可以证明，我们不能获得任何其他字符串，所以答案是 2。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= s.length <= 10⁵ 
// s[i] 是 0 或 1。 
// 
//
// Related Topics 数学 字符串 👍 1 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2450.应用操作后不同二进制字符串的数量.number-of-distinct-binary-strings-after-applying-operations
 *
 * @author db117
 * @since 2023-03-03 11:05:43
 **/

public class Solution_2450 {
    public static void main(String[] args) {
        Solution solution = new Solution_2450().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int countDistinctStrings(String s, int k) {
            // 脑筋急转弯
            // 以每一个字符结尾转换都会是*2
            int count = s.length() - k + 1;
            long ans = 1;
            for (int i = 0; i < count; i++) {
                ans <<= 1;
                ans %= mod;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}