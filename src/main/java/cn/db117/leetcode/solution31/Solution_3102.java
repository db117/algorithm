

//给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。 
//
// 两点之间的距离定义为它们的曼哈顿距离。 
//
// 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[3,10],[5,15],[10,2],[4,4]]
//输出：12
//解释：移除每个点后的最大距离如下所示：
//- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
//- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
//- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
//- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
//在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[1,1],[1,1]]
//输出：0
//解释：移除任一点后，任意两点之间的最大距离都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= points.length <= 10⁵ 
// points[i].length == 2 
// 1 <= points[i][0], points[i][1] <= 10⁸ 
// 
//
// Related Topics 数组 数学 👍 12 👎 0


package cn.db117.leetcode.solution31;

import java.util.TreeMap;

/**
 * 3102.最小化曼哈顿距离.minimize-manhattan-distances
 *
 * @author db117
 * @since 2024-04-06 19:40:52
 **/

public class Solution_3102 {
    public static void main(String[] args) {
        Solution solution = new Solution_3102().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDistance(int[][] points) {
            // 切比雪夫距离 (x',y')=(x+y,y−x)
            // ∣x1−x2∣ + ∣y1−y2∣=max(∣x1′−x2′∣,∣y1′−y2′∣)

            int ans = Integer.MAX_VALUE;
            TreeMap<Integer, Integer> xs = new TreeMap<>();
            TreeMap<Integer, Integer> ys = new TreeMap<>();

            // 计算所有点的x+y和y-x的个数
            for (int[] point : points) {
                int x = point[0], y = point[1];
                xs.put(x + y, xs.getOrDefault(x + y, 0) + 1);
                ys.put(y - x, ys.getOrDefault(y - x, 0) + 1);
            }

            int n = points.length;
            for (int[] point : points) {
                // 移除一个点后,计算最大距离
                int x = point[0], y = point[1];
                int xpy = x + y, ymx = y - x;
                // 移除一个点后,计算最大距离
                if (xs.get(xpy) == 1) {
                    xs.remove(xpy);
                } else {
                    xs.put(xpy, xs.get(xpy) - 1);
                }
                if (ys.get(ymx) == 1) {
                    ys.remove(ymx);
                } else {
                    ys.put(ymx, ys.get(ymx) - 1);
                }

                int max = Math.max(
                        xs.lastKey() - xs.firstKey(),
                        ys.lastKey() - ys.firstKey()
                );
                // 加入回去
                xs.put(xpy, xs.getOrDefault(xpy, 0) + 1);
                ys.put(ymx, ys.getOrDefault(ymx, 0) + 1);


                ans = Math.min(ans, max);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}