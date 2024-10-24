

//给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。 
//
// 数组的 x-sum 计算按照以下步骤进行： 
//
// 
// 统计数组中所有元素的出现次数。 
// 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。 
// 计算结果数组的和。 
// 
//
// 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。 
//
// 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
// 
//
// 子数组 是数组内的一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2 
// 
//
// 输出：[6,10,12] 
//
// 解释： 
//
// 
// 对于子数组 [1, 1, 2, 2, 3, 4]，只保留元素 1 和 2。因此，answer[0] = 1 + 1 + 2 + 2。 
// 对于子数组 [1, 2, 2, 3, 4, 2]，只保留元素 2 和 4。因此，answer[1] = 2 + 2 + 2 + 4。注意 4 被保留是因为
//其数值大于出现其他出现次数相同的元素（3 和 1）。 
// 对于子数组 [2, 2, 3, 4, 2, 3]，只保留元素 2 和 3。因此，answer[2] = 2 + 2 + 2 + 3 + 3。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [3,8,7,8,7,5], k = 2, x = 2 
// 
//
// 输出：[11,15,15,15,12] 
//
// 解释： 
//
// 由于 k == x，answer[i] 等于子数组 nums[i..i + k - 1] 的总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 50 
// 1 <= nums[i] <= 50 
// 1 <= x <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 0 👎 0


package cn.db117.leetcode.solution33;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 3318.计算子数组的 x-sum I.find-x-sum-of-all-k-long-subarrays-i
 *
 * @author db117
 * @since 2024-10-15 10:18:12
 **/

public class Solution_3318 {
    public static void main(String[] args) {
        Solution solution = new Solution_3318().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int k, x;

        public int[] findXSum(int[] nums, int k, int x) {
            int[] ans = new int[nums.length - k + 1];
            // 对顶堆

            for (int r = 0; r < nums.length; r++) {
                // 进入窗口
                int in = nums[r];
                remove(in);
                count.merge(in, 1, Integer::sum);
                insert(in);

                int l = r - k + 1;
                if (l < 0) {
                    continue;
                }
                // 窗口大小够了

                // 保证 left 中是 k 个最大次数的
                while (!right.isEmpty() && left.size() < x) {
                    right2left();
                }
                while (!left.isEmpty() && left.size() > x) {
                    left2right();
                }
                ans[l] = (int) sumLeft;

                // 移除窗口
                int out = nums[l];
                remove(out);
                count.merge(out, -1, Integer::sum);
                insert(out);


            }
            return ans;
        }

        // 出现次数 - 数字
        TreeSet<int[]> left = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        TreeSet<int[]> right = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Map<Integer, Integer> count = new HashMap<>();
        long sumLeft = 0;

        private void insert(int num) {
            Integer curCount = count.getOrDefault(num, 0);
            if (curCount == 0) {
                return;
            }
            int[] next = {curCount, num};
            if (!left.isEmpty() && left.comparator().compare(next, left.first()) > 0) {// 当前数字出现的次数在 left 中
                sumLeft += (long) curCount * num;
                left.add(next);
            } else {
                right.add(next);
            }
        }

        private void remove(int num) {
            int curCount = count.getOrDefault(num, 0);
            if (curCount == 0) {
                return;
            }
            int[] next = {curCount, num};
            if (left.contains(next)) {// 当前数字出现的次数在 left 中
                sumLeft -= (long) curCount * num;
                left.remove(next);
            } else {
                right.remove(next);
            }
        }

        private void left2right() {
            int[] ints = left.pollFirst();
            right.add(ints);
            sumLeft -= (long) ints[0] * ints[1];
        }

        private void right2left() {
            int[] ints = right.pollLast();
            left.add(ints);
            sumLeft += (long) ints[0] * ints[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}