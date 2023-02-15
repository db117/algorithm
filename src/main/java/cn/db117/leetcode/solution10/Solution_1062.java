

//给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入："abcd"
//输出：0
//解释：没有重复子串。
// 
//
// 示例 2： 
//
// 输入："abbaba"
//输出：2
//解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
// 
//
// 示例 3： 
//
// 输入："aabcaabdaab"
//输出：3
//解释：最长的重复子串为 "aab"，出现 3 次。
// 
//
// 示例 4： 
//
// 输入："aaaaa"
//输出：4
//解释：最长的重复子串为 "aaaa"，出现 2 次。 
//
// 
//
// 提示： 
//
// 
// 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。 
// 1 <= S.length <= 1500 
// 
//
// Related Topics 字符串 二分查找 动态规划 后缀数组 哈希函数 滚动哈希 👍 85 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1062.最长重复子串.longest-repeating-substring
 *
 * @author db117
 * @since 2023-02-15 17:14:35
 **/

public class Solution_1062 {
    public static void main(String[] args) {
        Solution solution = new Solution_1062().new Solution();
        System.out.println(solution.longestRepeatingSubstring("aabcaabdaab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestRepeatingSubstring(String s) {
            int ans = 0;
            char[] chars = s.toCharArray();
            int n = chars.length;
            // 从每一个字符开始遍历，找最长的相同子串
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cur = 0;
                    int left = i, right = j;
                    while (right < n && chars[left] == chars[right]) {
                        left++;
                        right++;
                        cur++;
                    }
                    ans = Math.max(ans, cur);
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}