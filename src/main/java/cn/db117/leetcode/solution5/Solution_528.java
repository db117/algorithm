


//给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 
//i 的概率与 w[i] 成正比。 
//
// 
// 
//
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
//
// 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。 
//
// 
//
// 示例 1： 
//
// 输入：
//["Solution","pickIndex"]
//[[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 输入：
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 10000 
// 1 <= w[i] <= 10^5 
// pickIndex 将被调用不超过 10000 次 
// 
// Related Topics 数学 二分查找 前缀和 随机化 
// 👍 101 👎 0


package cn.db117.leetcode.solution5;

import java.util.Random;

/**
 * 528.按权重随机选择.random-pick-with-weight
 *
 * @author db117
 * @since 2021-07-08 17:37:53
 **/

public class Solution_528 {
    public static void main(String[] args) {
        Solution solution = new Solution_528().new Solution(new int[]{1});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 前缀和
        int[] sums;
        Random random = new Random();

        public Solution(int[] w) {
            sums = new int[w.length];
            sums[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sums[i] = sums[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            // 随机一个数字，二分查找索引
            int target = random.nextInt(sums[sums.length - 1]);
            return bs(target);
        }

        public int bs(int target) {
            int left = 0, right = sums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                // 找不目标大的最小值
                // 找什么值不重要，随机的
                if (sums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}