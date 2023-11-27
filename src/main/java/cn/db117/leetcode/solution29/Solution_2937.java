

//给你三个字符串 s1、s2 和 s3。 你可以根据需要对这三个字符串执行以下操作 任意次数 
// 。 
//
// 在每次操作中，你可以选择其中一个长度至少为 2 的字符串 
// 并删除其 最右位置上 的字符。 
//
// 如果存在某种方法能够使这三个字符串相等，请返回使它们相等所需的 最小 操作次数；否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "abc"，s2 = "abb"，s3 = "ab"
//输出：2
//解释：对 s1 和 s2 进行一次操作后，可以得到三个相等的字符串。
//可以证明，不可能用少于两次操作使它们相等。 
//
// 示例 2： 
//
// 
//输入：s1 = "dac"，s2 = "bac"，s3 = "cac"
//输出：-1
//解释：因为 s1 和 s2 的最左位置上的字母
// 不相等，所以无论进行多少次操作，它们都不可能相等。因此答案是 -1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length, s3.length <= 100 
// s1、s2 和 s3 仅由小写英文字母组成。 
// 
//
// Related Topics 字符串 👍 7 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2937.使三个字符串相等.make-three-strings-equal
 *
 * @author db117
 * @since 2023-11-27 17:57:22
 **/

public class Solution_2937 {
    public static void main(String[] args) {
        Solution solution = new Solution_2937().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinimumOperations(String s1, String s2, String s3) {
            int len1 = s1.length();
            int len2 = s2.length();
            int len3 = s3.length();
            int len = Math.min(len1, len2);
            len = Math.min(len, len3);

            int count = 0;
            for (int i = 0; i < len; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                char c3 = s3.charAt(i);
                if (c1 == c2 && c2 == c3) {
                    // 前面相同的数量
                    count++;
                } else {
                    break;
                }
            }
            if (count == 0) {
                return -1;
            }
            return len1 + len2 + len3 - 3 * count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}