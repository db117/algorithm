

//给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 
//dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。 
//
// 请你采取最优策略分割 s ，使剩下的字符 最少 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
//输出：1
//解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以
//我们返回 1 。
// 
//
// 示例 2： 
//
// 输入：s = "sayhelloworld", dictionary = ["hello","world"]
//输出：3
//解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使
//用，所以我们返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// 1 <= dictionary.length <= 50 
// 1 <= dictionary[i].length <= 50 
// dictionary[i] 和 s 只包含小写英文字母。 
// dictionary 中的单词互不相同。 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 动态规划 👍 59 👎 0


package cn.db117.leetcode.solution27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2707.字符串中的额外字符.extra-characters-in-a-string
 *
 * @author db117
 * @since 2024-01-09 11:00:41
 **/

public class Solution_2707 {
    public static void main(String[] args) {
        Solution solution = new Solution_2707().new Solution();
        // "leetscode"
        //			["leet","code","leetcode"]
        System.out.println(solution.minExtraChar("leetscode", new String[]{
                "leet", "code", "leetcode"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String s;
        Set<String> set = new HashSet<>();
        int n;
        int[] memo;

        public int minExtraChar(String s, String[] dictionary) {
            this.s = s;
            n = s.length();
            memo = new int[n];
            Arrays.fill(memo, -1);
            set.addAll(Arrays.asList(dictionary));

            return dfs(0);
        }

        private int dfs(int index) {
            if (index == n) {
                return 0;
            }

            if (memo[index] != -1) {
                return memo[index];
            }

            int ans = n;

            for (int i = index; i < n; i++) {
                if (set.contains(s.substring(index, i + 1))) {
                    // 找到了
                    ans = Math.min(ans, dfs(i + 1));
                } else {
                    // 没有找到算上数字
                    ans = Math.min(ans, dfs(i + 1) + i - index + 1);
                }
            }


            return memo[index] = ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}