// 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
// 
//
// 示例 2： 
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
// 
//
// 示例 3： 
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// Related Topics 数组 二分查找 
// 👍 181 👎 0


package cn.db117.leetcode.solution8;

/**
 * 875.爱吃香蕉的珂珂.koko-eating-bananas
 *
 * @author db117
 * @since 2021-07-08 16:33:51
 **/

public class Solution_875 {
    public static void main(String[] args) {
        Solution solution = new Solution_875().new Solution();

        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {

            int left = 1, right = 0;
            for (int pile : piles) {
                right = Math.max(right, pile);
            }

            // 即找吃完时间大于等于 h 的最小值
            while (left < right) {
                int mid = left + (right - left) / 2;
                int time = helper(piles, mid);

                if (time > h) {
                    // 吃不玩，缩小左边界
                    left = mid + 1;
                } else {
                    // time >= h
                    // 还可以减少
                    // 若当前 mid 就是目标值，会使 left 一直加到当前值并退出循环
                    right = mid;
                }
            }
            return right;
        }

        // 吃完需要多少时间
        private int helper(int[] piles, int min) {
            int ans = 0;
            for (int pile : piles) {
                // 向上取整
                ans += (pile + min - 1) / min;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}