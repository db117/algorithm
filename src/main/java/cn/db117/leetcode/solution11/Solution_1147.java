

//你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足: 
//
// 
// subtexti 是 非空 字符串 
// 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text ) 
// 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立 
// 
//
// 返回k可能最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "ghiabcdefhelloadamhelloabcdefghi"
//输出：7
//解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
// 
//
// 示例 2： 
//
// 
//输入：text = "merchant"
//输出：1
//解释：我们可以把字符串拆分成 "(merchant)"。
// 
//
// 示例 3： 
//
// 
//输入：text = "antaprezatepzapreanta"
//输出：11
//解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 仅由小写英文字符组成 
// 
//
// Related Topics 贪心 双指针 字符串 动态规划 哈希函数 滚动哈希 👍 82 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1147.段式回文.longest-chunked-palindrome-decomposition
 *
 * @author db117
 * @since 2023-04-12 09:49:16
 **/

public class Solution_1147 {
    public static void main(String[] args) {
        Solution solution = new Solution_1147().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestDecomposition(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            // 贪心
            // 前后比较，找到了就算
            int n = s.length();
            for (int i = 1; i <= n / 2; i++) {
                // 前后比一下
                if (s.substring(0, i).equals(s.substring(n - i))) {
                    return longestDecomposition(s.substring(i, n - i)) + 2;
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}