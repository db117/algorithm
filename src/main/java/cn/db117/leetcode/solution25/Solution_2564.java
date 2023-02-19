

//给你一个 二进制字符串 s 和一个整数数组 queries ，其中 queries[i] = [firsti, secondi] 。 
//
// 对于第 i 个查询，找到 s 的 最短子字符串 ，它对应的 十进制值 val 与 firsti 按位异或 得到 secondi ，换言之，val ^ 
//firsti == secondi 。 
//
// 第 i 个查询的答案是子字符串 [lefti, righti] 的两个端点（下标从 0 开始），如果不存在这样的子字符串，则答案为 [-1, -1] 。如
//果有多个答案，请你选择 lefti 最小的一个。 
//
// 请你返回一个数组 ans ，其中 ans[i] = [lefti, righti] 是第 i 个查询的答案。 
//
// 子字符串 是一个字符串中一段连续非空的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "101101", queries = [[0,5],[1,2]]
//输出：[[0,2],[2,3]]
//解释：第一个查询，端点为 [0,2] 的子字符串为 "101" ，对应十进制数字 5 ，且 5 ^ 0 = 5 ，所以第一个查询的答案为 [0,2]。第二个
//查询中，端点为 [2,3] 的子字符串为 "11" ，对应十进制数字 3 ，且 3 ^ 1 = 2 。所以第二个查询的答案为 [2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：s = "0101", queries = [[12,8]]
//输出：[[-1,-1]]
//解释：这个例子中，没有符合查询的答案，所以返回 [-1,-1] 。
// 
//
// 示例 3： 
//
// 
//输入：s = "1", queries = [[4,5]]
//输出：[[0,0]]
//解释：这个例子中，端点为 [0,0] 的子字符串对应的十进制值为 1 ，且 1 ^ 4 = 5 。所以答案为 [0,0] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] 要么是 '0' ，要么是 '1' 。 
// 1 <= queries.length <= 10⁵ 
// 0 <= firsti, secondi <= 10⁹ 
// 
//
// 
//
// 👍 11 👎 0


package cn.db117.leetcode.solution25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2564.子字符串异或查询.substring-xor-queries
 *
 * @author db117
 * @since 2023-02-13 11:29:18
 **/

public class Solution_2564 {
    public static void main(String[] args) {
        Solution solution = new Solution_2564().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int[][] ans = new int[queries.length][];
            // 预处理答案
            Map<Integer, int[]> map = helper(s);
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0] ^ queries[i][1];
                int[] arr = map.get(a);
                if (arr == null) {
                    // 没有找到
                    ans[i] = new int[]{-1, -1};
                    continue;
                }
                ans[i] = arr;
            }

            return ans;
        }

        private Map<Integer, int[]> helper(String s) {
            int n = s.length();
            Map<Integer, int[]> ans = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    ans.putIfAbsent(0, new int[]{i, i});
                    continue;
                }
                int value = 0;
                // 最多 32 次循环
                for (int j = i; j < n; j++) {
                    value <<= 1;
                    value += s.charAt(j) == '1' ? 1 : 0;
                    if (value < 0) {
                        // 越界了
                        break;
                    }
                    ans.putIfAbsent(value, new int[]{i, j});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}