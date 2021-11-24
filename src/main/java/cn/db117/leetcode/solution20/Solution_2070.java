

//给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。 
//
// 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大
//的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。 
//
// 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
//输出：[2,4,5,5,6,6]
//解释：
//- queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
//- queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
//  它们中的最大美丽值为 4 。
//- queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
//  它们中的最大美丽值为 5 。
//- queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
//  所以，答案为所有物品中的最大美丽值，为 6 。
// 
//
// 示例 2： 
//
// 输入：items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
//输出：[4]
//解释：
//每个物品的价格均为 1 ，所以我们选择最大美丽值 4 。
//注意，多个物品可能有相同的价格和美丽值。
// 
//
// 示例 3： 
//
// 输入：items = [[10,1000]], queries = [5]
//输出：[0]
//解释：
//没有物品的价格小于等于 5 ，所以没有物品可以选择。
//因此，查询的结果为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= items.length, queries.length <= 10⁵ 
// items[i].length == 2 
// 1 <= pricei, beautyi, queries[j] <= 10⁹ 
// 
// Related Topics 数组 二分查找 排序 👍 8 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2070.每一个查询的最大美丽值.most-beautiful-item-for-each-query
 *
 * @author db117
 * @since 2021-11-24 17:01:13
 **/

public class Solution_2070 {
    public static void main(String[] args) {
        Solution solution = new Solution_2070().new Solution();

        System.out.println(Arrays.toString(solution.maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(solution.maximumBeauty(new int[][]{{1, 2}, {1, 2}, {1, 3}, {1, 4}}, new int[]{1})));
        System.out.println(Arrays.toString(solution.maximumBeauty(new int[][]{{10, 1000}}, new int[]{5})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            int[] ans = new int[queries.length];
            // 按价格排序
            Arrays.sort(items, Comparator.comparing(ints -> ints[0]));
            // 记录所有价格能达到的最大魅力值
            for (int i = 1; i < items.length; i++) {
                items[i][1] = Math.max(items[i][1], items[i - 1][1]);
            }

            // 二分查找价格
            for (int i = 0; i < queries.length; i++) {
                int bs = bs(items, queries[i]);
                if (bs == -1) {
                    ans[i] = 0;
                } else {
                    ans[i] = items[bs][1];
                }
            }
            return ans;
        }

        // 找小于等于 target 的物品
        private int bs(int[][] items, int target) {
            int left = 0, right = items.length - 1;
            while (left < right) {
                // 选择 left 则平均值选择靠 right 的
                int mid = (left + right + 1) / 2;
                if (items[mid][0] > target) {
                    // 不可能是要找的位置
                    right = mid - 1;
                } else {
                    // 可能是要找的位置
                    left = mid;
                }
            }
            return items[left][0] <= target ? left : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}