

//给定 X-Y 平面上的一组点 points ，其中 points[i] = [xi, yi] 。这些点按顺序连成一个多边形。 
//
// 如果该多边形为 凸 多边形（凸多边形的定义）则返回 true ，否则返回 false 。 
//
// 你可以假设由给定点构成的多边形总是一个 简单的多边形（简单多边形的定义）。换句话说，我们要保证每个顶点处恰好是两条边的汇合点，并且这些边 互不相交 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: points = [[0,0],[0,5],[5,5],[5,0]]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: points = [[0,0],[0,10],[10,10],[10,0],[5,5]]
//输出: false 
//
// 
//
// 提示: 
//
// 
// 3 <= points.length <= 10⁴ 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 不同 
// 
//
// 
//
// Related Topics 几何 数学 👍 36 👎 0


package cn.db117.leetcode.solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 469.凸多边形.convex-polygon
 *
 * @author db117
 * @since 2022-12-23 11:20:04
 **/

public class Solution_469 {
    public static void main(String[] args) {
        Solution solution = new Solution_469().new Solution();
        int[][] ints = {{0, 1907}, {6, 952}, {12, 29}, {376, 23}, {1217, 10}, {2622, 2}, {9260, 5}, {9729, 33},
                {9977, 111}, {9995, 3692}, {9984, 8244}, {9963, 9092}, {9941, 9740}, {9915, 9966},
                {9754, 9992}, {9665, 9999}, {808, 9997}, {201, 9966}, {93, 9928}, {4, 9247}, {2, 7152}, {0, 4926}};
        List<List<Integer>> points = new ArrayList<>();
        for (int[] anInt : ints) {
            points.add(Arrays.stream(anInt).boxed().collect(Collectors.toList()));
        }
        System.out.println(solution.isConvex(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isConvex(List<List<Integer>> points) {
            int n = points.size();
            // 凸多边形 向量点积同号
            // 每个点的前后两个点的差 相乘同号
            long pre = 0;
            long cur;

            for (int i = 0; i < n; i++) {
                List<Integer> p1 = points.get(i);
                List<Integer> p2 = points.get((i + 1 + n) % n);
                List<Integer> p3 = points.get((i + 2 + n) % n);
                long a = p2.get(0) - p1.get(0);
                long b = p2.get(1) - p1.get(1);
                long c = p3.get(0) - p1.get(0);
                long d = p3.get(1) - p1.get(1);
                cur = a * d - c * b;
                if (cur != 0) {
                    if (pre * cur < 0) {
                        // 当前的差乘和上一个不同号
                        return false;
                    }
                    pre = cur;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}