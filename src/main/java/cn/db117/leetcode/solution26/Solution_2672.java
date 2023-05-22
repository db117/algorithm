

//给你一个下标从 0 开始、长度为 n 的数组 nums 。一开始，所有元素都是 未染色 （值为 0 ）的。 
//
// 给你一个二维整数数组 queries ，其中 queries[i] = [indexi, colori] 。 
//
// 对于每个操作，你需要将数组 nums 中下标为 indexi 的格子染色为 colori 。 
//
// 请你返回一个长度与 queries 相等的数组 answer ，其中 answer[i]是前 i 个操作 之后 ，相邻元素颜色相同的数目。 
//
// 更正式的，answer[i] 是执行完前 i 个操作后，0 <= j < n - 1 的下标 j 中，满足 nums[j] == nums[j + 1] 
//且 nums[j] != 0 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]
//输出：[0,1,1,0,2]
//解释：一开始数组 nums = [0,0,0,0] ，0 表示数组中还没染色的元素。
//- 第 1 个操作后，nums = [2,0,0,0] 。相邻元素颜色相同的数目为 0 。
//- 第 2 个操作后，nums = [2,2,0,0] 。相邻元素颜色相同的数目为 1 。
//- 第 3 个操作后，nums = [2,2,0,1] 。相邻元素颜色相同的数目为 1 。
//- 第 4 个操作后，nums = [2,1,0,1] 。相邻元素颜色相同的数目为 0 。
//- 第 5 个操作后，nums = [2,1,1,1] 。相邻元素颜色相同的数目为 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, queries = [[0,100000]]
//输出：[0]
//解释：一开始数组 nums = [0] ，0 表示数组中还没染色的元素。
//- 第 1 个操作后，nums = [100000] 。相邻元素颜色相同的数目为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= indexi <= n - 1 
// 1 <= colori <= 10⁵ 
// 
//
// Related Topics 数组 👍 5 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2672.有相同颜色的相邻元素数目.number-of-adjacent-elements-with-the-same-color
 *
 * @author db117
 * @since 2023-05-22 10:31:11
 **/

public class Solution_2672 {
    public static void main(String[] args) {
        Solution solution = new Solution_2672().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] colorTheArray(int n, int[][] queries) {
            // 模拟
            int[] ans = new int[queries.length];
            int[] colors = new int[n];
            int cur = 0;
            for (int i = 0; i < queries.length; i++) {
                int k = queries[i][0];
                int color = queries[i][1];
                int pre = colors[k];
                if (color == pre) {
                    ans[i] = cur;
                    continue;
                }

                // 前后两个颜色
                if (k - 1 >= 0) {
                    if (pre != 0 && colors[k - 1] == pre) {
                        cur--;
                    }
                    if (color == colors[k - 1]) {
                        cur++;
                    }
                }
                if (k + 1 < n) {
                    if (pre != 0 && colors[k + 1] == pre) {
                        cur--;
                    }
                    if (color == colors[k + 1]) {
                        cur++;
                    }
                }
                ans[i] = cur;
                colors[k] = color;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}