

//给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。 
//
// 请你返回 任意 一个长度为 k 的整数子序列。 
//
// 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,1,3,3], k = 2
//输出：[3,3]
//解释：
//子序列有最大和：3 + 3 = 6 。 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,3,4], k = 3
//输出：[-1,3,4]
//解释：
//子序列有最大和：-1 + 3 + 4 = 6 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,4,3,3], k = 2
//输出：[3,4]
//解释：
//子序列有最大和：3 + 4 = 7 。
//另一个可行的子序列为 [4, 3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= nums.length 
// 
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 8 👎 0


package cn.db117.leetcode.solution20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2099.找到和最大的长度为 K 的子序列.find-subsequence-of-length-k-with-the-largest-sum
 *
 * @author db117
 * @since 2021-12-22 11:59:00
 **/

public class Solution_2099 {
    public static void main(String[] args) {
        Solution solution = new Solution_2099().new Solution();

        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{2,1,3,3}, 2)));
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{-1,-2,3,4}, 3)));
        System.out.println(Arrays.toString(solution.maxSubsequence(new int[]{3,4,3,3}, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            // 两次排序
            PriorityQueue<int[]> queue = new PriorityQueue<>(nums.length,(o1, o2) -> o2[0]-o1[0]);
            for (int i = 0; i < nums.length; i++) {
                queue.add(new int[]{nums[i], i});
            }

            int[][] tmp = new int[k][2];
            for (int i = 0; i < k; i++) {
                tmp[i] = queue.poll();
            }

            Arrays.sort(tmp, Comparator.comparing(ints -> ints[1]));

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = tmp[i][0];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}