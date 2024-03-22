

//给定一个二维整数数组 items ，其中 items[i] = [pricei, weighti] 表示第 i 个物品的价格和重量。 
//
// 还给定一个 正 整数容量 capacity 。 
//
// 每个物品可以分成两个部分，比率为 part1 和 part2 ，其中 part1 + part2 == 1 。 
//
// 
// 第一个物品的重量是 weighti * part1 ，价格是 pricei * part1 。 
// 同样，第二个物品的重量是 weighti * part2 ，价格是 pricei * part2 。 
// 
//
// 使用给定的物品，返回填满容量为 capacity 的背包所需的 最大总价格 。如果无法填满背包，则返回 -1 。与实际答案的差距在 10⁻⁵ 以内的 实际
//答案 将被视为接受。 
//
// 
//
// 示例 1 ： 
//
// 
//输入：items = [[50,1],[10,8]], capacity = 5
//输出：55.00000
//解释：
//我们将第二个物品分成两个部分，part1 = 0.5，part2 = 0.5。 
//第一个物品的价格和重量分别为 5 和 4 。同样地，第二个物品的价格和重量也是 5 和 4 。 
//经过操作后，数组 items 变为 [[50,1],[5,4],[5,4]] 。 
//为了填满容量为 5 的背包，我们取价格为 50 的第一个元素和价格为 5 的第二个元素。 
//可以证明，55.0 是我们可以达到的最大总价值。
// 
//
// 示例 2 ： 
//
// 
//输入：items = [[100,30]], capacity = 50
//输出：-1.00000
//解释：无法用给定的物品装满背包。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= items.length <= 10⁵ 
// items[i].length == 2 
// 1 <= pricei, weighti <= 10⁴ 
// 1 <= capacity <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 👍 1 👎 0


package cn.db117.leetcode.solution25;

import java.util.PriorityQueue;

/**
 * 2548.填满背包的最大价格.maximum-price-to-fill-a-bag
 *
 * @author db117
 * @since 2024-03-22 16:33:16
 **/

public class Solution_2548 {
    public static void main(String[] args) {
        Solution solution = new Solution_2548().new Solution();
        // [[50,1],[10,8]]
        // 5
//        System.out.println(solution.maxPrice(new int[][]{
//                {50, 1},
//                {10, 8}
//        }, 5));

        // [[1,1]]
        //			1
        System.out.println(solution.maxPrice(new int[][]{
                {1, 1}
        }, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxPrice(int[][] items, int capacity) {
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
            for (int[] item : items) {
                pq.offer(new double[]{(double) item[0] / item[1], item[0], item[1]});
            }
            double res = 0;
            while (capacity > 0 && !pq.isEmpty()) {
                double[] cur = pq.poll();
                // 能放下
                if (capacity >= cur[2]) {
                    res += cur[1];
                    capacity -= cur[2];
                    continue;
                }
                // 不能放下,只能放一部分
                res += capacity / cur[2] * cur[1];
                return res;
            }
            if (capacity > 0) {
                return -1;
            }
            return res == 0 ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}