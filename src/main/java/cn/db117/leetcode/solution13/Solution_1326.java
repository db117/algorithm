

//在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。 
//
// 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。 
//
// 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可
//以灌溉的区域为 [i - ranges[i], i + ranges[i]] 。 
//
// 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, ranges = [3,4,1,1,0,0]
//输出：1
//解释：
//点 0 处的水龙头可以灌溉区间 [-3,3]
//点 1 处的水龙头可以灌溉区间 [-3,5]
//点 2 处的水龙头可以灌溉区间 [1,3]
//点 3 处的水龙头可以灌溉区间 [2,4]
//点 4 处的水龙头可以灌溉区间 [4,4]
//点 5 处的水龙头可以灌溉区间 [5,5]
//只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, ranges = [0,0,0,0]
//输出：-1
//解释：即使打开所有水龙头，你也无法灌溉整个花园。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// ranges.length == n + 1 
// 0 <= ranges[i] <= 100 
// 
//
// Related Topics 贪心 数组 动态规划 👍 184 👎 0


package cn.db117.leetcode.solution13;

/**
 * 1326.灌溉花园的最少水龙头数目.minimum-number-of-taps-to-open-to-water-a-garden
 *
 * @author db117
 * @since 2023-02-21 14:10:42
 **/

public class Solution_1326 {
    public static void main(String[] args) {
        Solution solution = new Solution_1326().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTaps(int n, int[] ranges) {
            // 以 i 为左端点能够到达的最右边(一个水龙头)
            int[] rightMost = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int range = ranges[i];
                if (i > range) {
                    // 对于同一个最左端点来说，i 比之前的大，当前右边界则必定是最大的
                    rightMost[i - range] = i + range;
                } else {
                    // 最左边的端点可能是好多个水龙头范围的起点
                    rightMost[0] = Math.max(rightMost[0], i + range);
                }
            }

            int ans = 0;
            int curRight = 0;// 当前右边界
            int nextRight = 0;// 下一个右边界
            for (int i = 0; i < n; i++) {
                // 这个区间内的左端点，能够到达的最右边的点
                nextRight = Math.max(nextRight, rightMost[i]);
                if (i == curRight) {// 当前水龙头的右端点到了
                    if (i == nextRight) {
                        // 后面的点到不了了
                        return -1;
                    }
                    // 开启上一个区间的某一个水龙头
                    curRight = nextRight;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}