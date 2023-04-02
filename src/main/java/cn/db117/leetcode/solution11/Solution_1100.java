

//给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。 
//
// 
//
// 示例 1： 
//
// 输入：S = "havefunonleetcode", K = 5
//输出：6
//解释：
//这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
// 
//
// 示例 2： 
//
// 输入：S = "home", K = 5
//输出：0
//解释：
//注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 10^4 
// S 中的所有字符均为小写英文字母 
// 1 <= K <= 10^4 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 46 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1100.长度为 K 的无重复字符子串.find-k-length-substrings-with-no-repeated-characters
 *
 * @author db117
 * @since 2023-03-29 14:14:41
 **/

public class Solution_1100 {
    public static void main(String[] args) {
        Solution solution = new Solution_1100().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numKLenSubstrNoRepeats(String s, int k) {
            int n = s.length();
            if (k > n) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int[] count = new int[26];
            int num = 0;

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int index = chars[i] - 'a';
                if (count[index] == 0) {
                    num++;
                }
                count[index]++;
                if (i >= k) {
                    count[chars[i - k] - 'a']--;
                    if (count[chars[i - k] - 'a'] == 0) {
                        num--;
                    }
                }
                if (num == k) {
                    ans++;
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}