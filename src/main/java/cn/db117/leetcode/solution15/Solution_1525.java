//给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数
//目相同。 
//
// 请你返回 s 中好分割的数目。 
//
// 
//
// 示例 1： 
//
// 输入：s = "aacaba"
//输出：2
//解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
//("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
// 
//
// 示例 2： 
//
// 输入：s = "abcd"
//输出：1
//解释：好分割为将字符串分割成 ("ab", "cd") 。
// 
//
// 示例 3： 
//
// 输入：s = "aaaaa"
//输出：4
//解释：所有分割都是好分割。 
//
// 示例 4： 
//
// 输入：s = "acbadbaada"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// s 只包含小写英文字母。 
// 1 <= s.length <= 10^5 
// 
// Related Topics 位运算 字符串 
// 👍 17 👎 0


package cn.db117.leetcode.solution15;

/**
 * 1525.字符串的好分割数目.number-of-good-ways-to-split-a-string
 *
 * @author db117
 * @since 2021-06-04 16:09:07
 **/

public class Solution_1525 {
    public static void main(String[] args) {
        Solution solution = new Solution_1525().new Solution();
        System.out.println(solution.numSplits("aacaba"));
        System.out.println(solution.numSplits("abcd"));
        System.out.println(solution.numSplits("aaaaa"));
        System.out.println(solution.numSplits("acbadbaada"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSplits(String s) {
            char[] chars = s.toCharArray();
            int ans = 0;
            // 使用 bit 来保存字符是否出现
            // 分别从左后两边开始算 | 的值
            int[] leftArr = new int[chars.length];
            int[] rightArr = new int[chars.length];

            int left = 0, right = 0;
            for (int i = 0; i < chars.length; i++) {
                // 统计从左边当当前位置出现的字符个数
                left |= 1 << (chars[i] - 'a');
                leftArr[i] = Integer.bitCount(left);

                right |= 1 << (chars[chars.length - 1 - i] - 'a');
                rightArr[chars.length - 1 - i] = Integer.bitCount(right);
            }

            // 对比,次数一样就 +1
            for (int i = 0; i < chars.length - 1; i++) {
                if (leftArr[i] == rightArr[i + 1]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}