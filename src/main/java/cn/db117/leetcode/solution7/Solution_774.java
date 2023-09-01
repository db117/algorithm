

//整数数组 stations 表示 水平数轴 上各个加油站的位置。给你一个整数 k 。 
//
// 请你在数轴上增设 k 个加油站，新增加油站可以位于 水平数轴 上的任意位置，而不必放在整数位置上。 
//
// 设 penalty() 是：增设 k 个新加油站后，相邻 两个加油站间的最大距离。 请你返回 
//penalty()
// 可能的最小值。与实际答案误差在 
//10⁻⁶ 范围内的答案将被视作正确答案。
//
// 
//
// 示例 1： 
//
// 
//输入：stations = [1,2,3,4,5,6,7,8,9,10], k = 9
//输出：0.50000
// 
//
// 示例 2： 
//
// 
//输入：stations = [23,24,36,39,46,56,57,65,84,98], k = 1
//输出：14.00000
// 
//
// 
//
// 提示： 
//
// 
// 10 <= stations.length <= 2000 
// 0 <= stations[i] <= 10⁸ 
// stations 按 严格递增 顺序排列 
// 1 <= k <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 👍 63 👎 0


package cn.db117.leetcode.solution7;

/**
 * 774.最小化去加油站的最大距离.minimize-max-distance-to-gas-station
 *
 * @author db117
 * @since 2023-09-01 11:36:25
 **/

public class Solution_774 {
    public static void main(String[] args) {
        Solution solution = new Solution_774().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double minmaxGasDist(int[] stations, int k) {
            double left = 0, right = 1e8;
            while (left < right - 1e-6) {// 误差范围
                double mid = left + (right - left) / 2;
                if (check(stations, k, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(int[] stations, int k, double diff) {
            for (int i = 1; i < stations.length; i++) {
                if (stations[i] - stations[i - 1] > diff) {
                    // 间距大于diff,则需要增加加油站
                    k -= (int) ((stations[i] - stations[i - 1]) / diff);
                    if (k < 0) {
                        // 加油站不够
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}