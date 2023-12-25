

//有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组
// hFences 和 vFences 给出。 
//
// 水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, 
//vFences[i]) 。 
//
// 返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。 
//
// 由于答案可能很大，所以请返回结果对 10⁹ + 7 取余 后的值。 
//
// 注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (
//m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：m = 4, n = 3, hFences = [2,3], vFences = [2]
//输出：4
//解释：移除位于 2 的水平栅栏和位于 2 的垂直栅栏将得到一个面积为 4 的正方形田地。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：m = 6, n = 7, hFences = [2], vFences = [4]
//输出：-1
//解释：可以证明无法通过移除栅栏形成正方形田地。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m, n <= 10⁹ 
// 1 <= hFences.length, vFences.length <= 600 
// 1 < hFences[i] < m 
// 1 < vFences[i] < n 
// hFences 和 vFences 中的元素是唯一的。 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2975.移除栅栏得到的正方形田地的最大面积.maximum-square-area-by-removing-fences-from-a-field
 *
 * @author db117
 * @since 2023-12-25 10:49:09
 **/

public class Solution_2975 {
    public static void main(String[] args) {
        Solution solution = new Solution_2975().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            // 算出所有可能的边长
            Set<Integer> set = new HashSet<>();
            Arrays.sort(hFences);
            Arrays.sort(vFences);
            int h = hFences.length;
            set.add(m - 1);
            for (int i = 0; i < h; i++) {
                set.add(hFences[i] - 1);
                set.add(m - hFences[i]);
                for (int j = i + 1; j < h; j++) {
                    set.add(hFences[j] - hFences[i]);
                }
            }
            int max = 0;
            int v = vFences.length;
            for (int i = 0; i < v; i++) {
                if (set.contains(vFences[i] - 1)) {
                    max = Math.max(max, vFences[i] - 1);
                }
                if (set.contains(n - vFences[i])) {
                    max = Math.max(max, n - vFences[i]);
                }
                for (int j = i + 1; j < v; j++) {
                    // 如果两个垂直栅栏之间的距离在set中,则可以组成正方形
                    if (set.contains(vFences[j] - vFences[i])) {
                        max = Math.max(max, vFences[j] - vFences[i]);
                    }
                }
            }
            if (set.contains(n - 1)) {
                max = Math.max(max, n - 1);
            }

            return max == 0 ? -1 : (int) (((long) max % 1_000_000_007 * max % 1_000_000_007) % 1_000_000_007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}