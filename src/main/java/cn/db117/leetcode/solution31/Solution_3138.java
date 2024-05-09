

//给你一个字符串 s ，它由某个字符串 t 和若干 t 的 同位字符串 连接而成。 
//
// 请你返回字符串 t 的 最小 可能长度。 
//
// 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "abba" 
// 
//
// 输出：2 
//
// 解释： 
//
// 一个可能的字符串 t 为 "ba" 。 
//
// 示例 2： 
//
// 
// 输入：s = "cdef" 
// 
//
// 输出：4 
//
// 解释： 
//
// 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 7 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3138.同位字符串连接的最小长度.minimum-length-of-anagram-concatenation
 *
 * @author db117
 * @since 2024-05-09 09:41:25
 **/

public class Solution_3138 {
    public static void main(String[] args) {
        Solution solution = new Solution_3138().new Solution();
        // "abba"
        System.out.println(solution.minAnagramLength("abba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;

        public int minAnagramLength(String s) {
            int n = s.length();
            chars = s.toCharArray();
            // 从 1 找到（n/2）
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0 && check(i)) {
                    return i;
                }
            }
            // 都不行就是原来的字符串
            return n;
        }

        private boolean check(int i) {
            int[] base = new int[26];
            // 第一个子串
            for (int j = 0; j < i; j++) {
                base[chars[j] - 'a']++;
            }
            int loop = chars.length / i;
            // 后面的子串都和第一个进行比较
            for (int j = 1; j < loop; j++) {
                int[] cur = new int[26];
                for (int k = 0; k < i; k++) {
                    int index = chars[j * i + k] - 'a';
                    cur[index]++;
                    if (cur[index] > base[index]) {
                        return false;
                    }
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}