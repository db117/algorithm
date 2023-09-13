

//实数集合可以表示为若干不相交区间的并集，其中每个区间的形式为 [a, b)（左闭右开），表示满足 a <= x < b 的所有实数 x 的集合。如果某个区间
// [a, b) 中包含实数 x ，则称实数 x 在集合中。 
//
// 给你一个 有序的 不相交区间列表 intervals 。intervals 表示一个实数集合，其中每一项 intervals[i] = [ai, bi] 
//都表示一个区间 [ai, bi) 。再给你一个要删除的区间 toBeRemoved 。 
//
// 返回 一组实数，该实数表示intervals 中 删除 了 toBeRemoved 的部分 。换句话说，返回实数集合，并满足集合中的每个实数 x 都在 
//intervals 中，但不在 toBeRemoved 中。你的答案应该是一个如上所述的 有序的 不相连的间隔列表 。 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
//输出：[[0,1],[6,7]]
// 
//
// 示例 2： 
// 
// 
//输入：intervals = [[0,5]], toBeRemoved = [2,3]
//输出：[[0,2],[3,5]]
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
//输出：[[-5,-4],[-3,-2],[4,5],[8,9]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// -10⁹ <= ai < bi <= 10⁹ 
// 
//
// Related Topics 数组 👍 40 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1272.删除区间.remove-interval
 *
 * @author db117
 * @since 2023-09-13 10:32:29
 **/

public class Solution_1272 {
    public static void main(String[] args) {
        Solution solution = new Solution_1272().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> ans = new ArrayList<>();

            for (int[] interval : intervals) {
                if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
                    // 没有交集
                    ans.add(List.of(interval[0], interval[1]));
                    continue;
                }
                if (interval[0] >= toBeRemoved[0] && interval[1] <= toBeRemoved[1]) {
                    // 被完全覆盖
                    continue;
                }

                if (interval[0] < toBeRemoved[0]) {
                    // 左边有多余的
                    ans.add(List.of(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    // 右边有多余的
                    ans.add(List.of(toBeRemoved[1], interval[1]));
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}