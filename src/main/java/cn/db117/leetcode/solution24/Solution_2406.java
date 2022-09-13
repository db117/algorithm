

//给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, 
//righti] 。 
//
// 你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。 
//
// 请你返回 最少 需要划分成多少个组。 
//
// 如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
//输出：3
//解释：我们可以将区间划分为如下的区间组：
//- 第 1 组：[1, 5] ，[6, 8] 。
//- 第 2 组：[2, 3] ，[5, 10] 。
//- 第 3 组：[1, 10] 。
//可以证明无法将区间划分为少于 3 个组。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,3],[5,6],[8,10],[11,13]]
//输出：1
//解释：所有区间互不相交，所以我们可以把它们全部放在一个组内。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// 1 <= lefti <= righti <= 10⁶ 
// 
//
// 👍 23 👎 0


package cn.db117.leetcode.solution24;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2406.将区间分为最少组数.divide-intervals-into-minimum-number-of-groups
 *
 * @author db117
 * @since 2022-09-13 17:41:54
 **/

public class Solution_2406 {
    public static void main(String[] args) {
        Solution solution = new Solution_2406().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minGroups(int[][] intervals) {
            // 差分数组
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int[] interval : intervals) {
                treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
                treeMap.put(interval[1] + 1, treeMap.getOrDefault(interval[1] + 1, 0) - 1);
            }

            int max = 0;
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                Integer count = entry.getValue();
                sum += count;
                max = Math.max(max, sum);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}