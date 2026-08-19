

//
//
// 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。 
//
// 给定一个二维数组 reservedSeats ，其中 reservedSeats[i] = [rowi, seati] 表示第 rowi 行的座位 
//seati 已经被预定。 
//
// 四人小组必须被安排在同一排的四个座位上。该小组可以坐在以下座位块之一： 
//
// 
// 座位 2, 3, 4, 5 
// 座位 4, 5, 6, 7 
// 座位 6, 7, 8, 9 
// 
//
// 只有当该块中的所有座位都 没有 被预订时，才能使用该块。每个座位 最多 只能分配给一个小组。 
//
// 返回一个整数，表示可以分配的 最大 四人小组数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
//输出：4
//解释：上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= reservedSeats.length <= min(10 * n, 10⁴) 
// reservedSeats[i] == [rowi, seati] 
// 1 <= rowi <= n 
// 1 <= seati <= 10 
// 所有 reservedSeats[i] 都是互不相同的。 
// 
//
// Related Topics 贪心 位运算 数组 哈希表 👍 90 👎 0


package cn.db117.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 1386.安排电影院座位.cinema-seat-allocation
 *
 * @author db117
 * @since 2026-08-19 19:04:44
 **/

public class Solution_1386 {
    public static void main(String[] args) {
        Solution solution = new Solution_1386().new Solution();
        // 2
        //[[1,5],[2,8],[2,10],[2,2],[1,6],[1,10],[1,1],[2,5],[1,2]]
        // 0
/*        System.out.println(solution.maxNumberOfFamilies(2, new int[][]{
                {1, 5}, {2, 8}, {2, 10}, {2, 2}, {1, 6}, {1, 10}, {1, 1}, {2, 5}, {1, 2}
        }));*/

        // 3
        //[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
        System.out.println(solution.maxNumberOfFamilies(3, new int[][]{
                {1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            int m = reservedSeats.length;
            Map<Integer, Integer> seat = new HashMap<>();
            int ans = 0;

            // 用二进制表示座位，1表示该座位被占用，0表示该座位未被占用
            for (int[] reservedSeat : reservedSeats) {
                int row = reservedSeat[0];
                int col = reservedSeat[1];
                if (col == 1 || col == 10) {
                    // 1和10列的座位不考虑
                    continue;
                }
                seat.put(row, seat.getOrDefault(row, 0) | (1 << col - 1));
            }

            int empty = n - seat.size();
            ans += empty * 2;// 空行可以安排两个四人小组
            for (int value : seat.values()) {
                // 检查该行是否可以安排一个四人小组
                if ((value & 0b11110) == 0 || (value & 0b1111000) == 0 || (value & 0b111100000) == 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}