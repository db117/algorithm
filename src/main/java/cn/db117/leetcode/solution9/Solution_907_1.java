

//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 713 👎 0


package cn.db117.leetcode.solution9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907.子数组的最小值之和.sum-of-subarray-minimums
 *
 * @author db117
 * @since 2023-11-27 11:32:07
 **/

public class Solution_907_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_907_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int sumSubarrayMins(int[] arr) {
            //  单调栈

            int n = arr.length;
            int[] left = new int[n];
            int[] right = new int[n];

            // 找到左边第一个比当前小的
            Deque<Integer> queue = new ArrayDeque<>();
            queue.push(-1);
            for (int i = 0; i < n; i++) {
                // 左边只到不当前元素大的
                while (queue.size() > 1 && arr[queue.peek()] >= arr[i]) {
                    queue.pop();
                }
                left[i] = queue.peek();
                queue.push(i);
            }

            queue.clear();
            // 找到右边第一个比当前小的
            queue.push(n);
            for (int i = n - 1; i >= 0; i--) {
                while (queue.size() > 1 && arr[queue.peek()] > arr[i]) {
                    queue.pop();
                }
                right[i] = queue.peek();
                queue.push(i);
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                // 左边的乘以右边的
                ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
            }

            return (int) (ans % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}