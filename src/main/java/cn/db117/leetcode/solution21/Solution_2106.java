

//在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, 
//amounti] 表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不
//相同 。 
//
// 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就
//记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。 
//
// 返回你可以摘到水果的 最大总数 。 
//
// 
//
// 示例 1： 
// 输入：fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
//输出：9
//解释：
//最佳路线为：
//- 向右移动到位置 6 ，摘到 3 个水果
//- 向右移动到位置 8 ，摘到 6 个水果
//移动 3 步，共摘到 3 + 6 = 9 个水果
// 
//
// 示例 2： 
// 输入：fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
//输出：14
//解释：
//可以移动最多 k = 4 步，所以无法到达位置 0 和位置 10 。
//最佳路线为：
//- 在初始位置 5 ，摘到 7 个水果
//- 向左移动到位置 4 ，摘到 1 个水果
//- 向右移动到位置 6 ，摘到 2 个水果
//- 向右移动到位置 7 ，摘到 4 个水果
//移动 1 + 3 = 4 步，共摘到 7 + 1 + 2 + 4 = 14 个水果
// 
//
// 示例 3： 
// 输入：fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
//输出：0
//解释：
//最多可以移动 k = 2 步，无法到达任一有水果的地方
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// fruits[i].length == 2 
// 0 <= startPos, positioni <= 2 * 10⁵ 
// 对于任意 i > 0 ，positioni-1 < positioni 均成立（下标从 0 开始计数） 
// 1 <= amounti <= 10⁴ 
// 0 <= k <= 2 * 10⁵ 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 72 👎 0


package cn.db117.leetcode.solution21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2106.摘水果.maximum-fruits-harvested-after-at-most-k-steps
 *
 * @author db117
 * @since 2023-05-04 10:18:05
 **/

public class Solution_2106 {
    public static void main(String[] args) {
        Solution solution = new Solution_2106().new Solution();
        // fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
        System.out.println(solution.maxTotalFruits(new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4));
        System.out.println(solution.maxTotalFruits(new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}}, 5, 4));
        // fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
        System.out.println(solution.maxTotalFruits(new int[][]{{0, 3}, {6, 4}, {8, 5}}, 3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int n = fruits.length;
            int ans = 0;
            // 只有 2 种走法 一直往左右走  先向一个方向走在转向
            // 枚举左端点找区间和

            // 滑动窗口，用队列存一下
            Deque<int[]> queue = new LinkedList<>();
            int leftIndex = bs(fruits, startPos - k); // 最左能走到的位置
            if (leftIndex == -1 || leftIndex > startPos + k) {
                // 找不到一个可以采摘的水果
                return 0;
            }
            int right = leftIndex;// 初始右边界
            int sum = 0;

            // 滑动窗口
            while (right < n) {

                if (fruits[right][0] > startPos + k) {
                    // 后面的都采摘不到了
                    break;
                }

                queue.offerLast(fruits[right]);
                sum += fruits[right][1];

                int rightIndex = fruits[right][0];

                if (rightIndex > startPos) {// 还没有到开始位置，不需要移动左边界
                    while (!queue.isEmpty()) {
                        int i = queue.peekFirst()[0];
                        if (rightIndex - i + Math.min(rightIndex - startPos, startPos - i) > k) {
                            // 从起点到两个点的距离大于 k
                            sum -= queue.pollFirst()[1];
                        } else {
                            break;
                        }
                    }
                }

                ans = Math.max(ans, sum);
                right++;
            }


            return ans;
        }

        // 找大于等于目标的最小值
        public int bs(int[][] fruits, int target) {
            int left = 0, right = fruits.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (fruits[mid][0] >= target) {
                    right = mid;// 可能是答案
                } else {
                    left = mid + 1;
                }
            }
            return fruits[right][0] >= target ? right : -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}