

//给你两个下标从 0 开始的字符串 word1 和 word2 。 
//
// 一次 移动 由以下两个步骤组成： 
//
// 
// 选中两个下标 i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ， 
// 交换 word1[i] 和 word2[j] 。 
// 
//
// 如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "ac", word2 = "b"
//输出：false
//解释：交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
// 
//
// 示例 2： 
//
// 输入：word1 = "abcc", word2 = "aab"
//输出：true
//解释：交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符
//。
// 
//
// 示例 3： 
//
// 输入：word1 = "abcde", word2 = "fghij"
//输出：true
//解释：无论交换哪一组下标，两个字符串中都会有 5 个不同字符。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 和 word2 仅由小写英文字母组成。 
// 
//
// 👍 13 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2531.使字符串总不同字符的数目相等.make-number-of-distinct-characters-equal
 *
 * @author db117
 * @since 2023-01-09 17:29:40
 **/

public class Solution_2531 {
    public static void main(String[] args) {
        Solution solution = new Solution_2531().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isItPossible(String word1, String word2) {
            // 统计各个字符出现的次数
            int[] count1 = new int[26];
            int[] count2 = new int[26];

            for (int i = 0; i < word1.length(); i++) {
                count1[word1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < word2.length(); i++) {
                count2[word2.charAt(i) - 'a']++;
            }

            // 出现的字符数量
            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < 26; i++) {
                if (count1[i] != 0) {
                    sum1++;
                }
                if (count2[i] != 0) {
                    sum2++;
                }
            }

            for (int i = 0; i < 26; i++) {
                if (count1[i] == 0) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    if (count2[j] == 0) {
                        continue;
                    }
                    // 交换的字符相同
                    if (i == j) {
                        if (sum1 == sum2) {
                            return true;
                        } else {
                            continue;
                        }
                    }
                    int curSum1 = sum1;
                    int curSum2 = sum2;

                    // 判断各种情况堆出现的字符数量进行调整
                    if (count1[i] == 1) {
                        curSum1--;
                    }
                    if (count1[j] == 0) {
                        curSum1++;
                    }
                    if (count2[j] == 1) {
                        curSum2--;
                    }
                    if (count2[i] == 0) {
                        curSum2++;
                    }
                    if (curSum1 == curSum2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}