

//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// Related Topics 数组 哈希表 数学 👍 271 👎 0


package cn.db117.leetcode.solution4;

import java.util.HashMap;
import java.util.Map;

/**
 * 447.回旋镖的数量.number-of-boomerangs
 *
 * @author db117
 * @since 2024-01-08 10:03:53
 **/

public class Solution_447 {
    public static void main(String[] args) {
        Solution solution = new Solution_447().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                map.clear();
                for (int[] ints : points) {
                    int dis = (point[0] - ints[0]) * (point[0] - ints[0]) + (point[1] - ints[1]) * (point[1] - ints[1]);// 算距离
                    Integer pre = map.getOrDefault(dis, 0);
                    ans += pre * 2;// 前面所有相等距离的节点都可以组成回旋镖
                    map.put(dis, pre + 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}