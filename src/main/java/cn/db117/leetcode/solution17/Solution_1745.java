

//给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。 
//
// 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcbdd"
//输出：true
//解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
// 
//
// 示例 2： 
//
// 
//输入：s = "bcbddxy"
//输出：false
//解释：s 没办法被分割成 3 个回文子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 2000 
// s 只包含小写英文字母。 
// 
//
// Related Topics 字符串 动态规划 👍 71 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1745.分割回文串 IV.palindrome-partitioning-iv
 *
 * @author db117
 * @since 2025-03-04 19:47:03
 **/

public class Solution_1745 {
    public static void main(String[] args) {
        Solution solution = new Solution_1745().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;
        Boolean[][] helperMemo;
        Boolean[][] memo;

        public boolean checkPartitioning(String s) {
            chars = s.toCharArray();
            helperMemo = new Boolean[chars.length][chars.length];
            memo = new Boolean[chars.length][3];
            return dfs(s.length() - 1, 2);
        }

        private boolean dfs(int i, int j) {
            if (j == 0) {
                return helper(0, i);
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            for (int left = j/*最小也要从 j 开始*/; left <= i; left++) {
                if (helper(left, i) && dfs(left - 1, j - 1)) {
                    return memo[i][j] = true;
                }
            }

            return memo[i][j] = false;
        }


        // 判断[left,right]区间修改为回文串需要多少次修改次数
        boolean helper(int left, int right) {
            if (left >= right) {
                return true;
            }
            if (helperMemo[left][right] != null) {
                return helperMemo[left][right];
            }


            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }

            return helperMemo[left][right] = true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}