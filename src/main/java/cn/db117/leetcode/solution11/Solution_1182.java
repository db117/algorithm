

//给你一个数组 colors，里面有 1、2、 3 三种颜色。 
//
// 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。 
//
// 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。 
//
// 如果不存在解决方案，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//输出：[3,0,3]
//解释： 
//距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
// 
//
// 示例 2： 
//
// 输入：colors = [1,2], queries = [[0,3]]
//输出：[-1]
//解释：colors 中没有颜色 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 38 👎 0


package cn.db117.leetcode.solution11;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 1182.与目标颜色间的最短距离.shortest-distance-to-target-color
 *
 * @author db117
 * @since 2023-10-30 11:13:41
 **/

public class Solution_1182 {
    public static void main(String[] args) {
        Solution solution = new Solution_1182().new Solution();
        // [1,1,2,1,3,2,2,3,3]
        //			[[1,3],[2,2],[6,1]]
        System.out.println(solution.shortestDistanceColor(new int[]{
                1, 1, 2, 1, 3, 2, 2, 3, 3
        }, new int[][]{
                {1, 3}, {2, 2}, {6, 1}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
            // 二分查找，使用 treeSet 方便点
            TreeSet<Integer> set1 = new TreeSet<>();
            TreeSet<Integer> set2 = new TreeSet<>();
            TreeSet<Integer> set3 = new TreeSet<>();
            for (int i = 0; i < colors.length; i++) {
                int color = colors[i];
                if (color == 1) {
                    set1.add(i);
                } else if (color == 2) {
                    set2.add(i);
                } else {
                    set3.add(i);
                }
            }

            List<Integer> ans = new ArrayList<>(queries.length);
            for (int[] query : queries) {
                int index = query[0];
                int color = query[1];

                if (color == 1) {
                    ans.add(getMin(set1, index));
                } else if (color == 2) {
                    ans.add(getMin(set2, index));
                } else {
                    ans.add(getMin(set3, index));
                }
            }
            return ans;
        }

        private int getMin(TreeSet<Integer> set, int index) {
            Integer floor = set.floor(index);// 小于等于的最大值
            Integer ceiling = set.ceiling(index);// 大于等于的最小值

            // 判空
            if (floor == null && ceiling == null) {
                return -1;
            }
            if (floor == null) {
                return ceiling - index;
            }
            if (ceiling == null) {
                return index - floor;
            }
            return Math.min(ceiling - index, index - floor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}