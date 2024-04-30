

//给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空子数组中不同元素的个数。 
//
// 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。 
//
// 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。 
//
// 返回 nums 唯一性数组 的 中位数 。 
//
// 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3] 
// 
//
// 输出：1 
//
// 解释： 
//
// nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]
//), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1,
// 2, 2, 3] 。唯一性数组的中位数为 1 ，因此答案是 1 。 
//
// 示例 2： 
//
// 
// 输入：nums = [3,4,3,4,5] 
// 
//
// 输出：2 
//
// 解释： 
//
// nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答
//案是 2 。 
//
// 示例 3： 
//
// 
// 输入：nums = [4,3,5,4] 
// 
//
// 输出：2 
//
// 解释： 
//
// nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 👍 5 👎 0


package cn.db117.leetcode.solution31;

import java.util.HashMap;
import java.util.Map;

/**
 * 3134.找出唯一性数组的中位数.find-the-median-of-the-uniqueness-array
 *
 * @author db117
 * @since 2024-04-30 10:31:59
 **/

public class Solution_3134 {
    public static void main(String[] args) {
        Solution solution = new Solution_3134().new Solution();
        // [1,2,3]
//        System.out.println(solution.medianOfUniquenessArray(new int[]{
//                1, 2, 3
//        }));
        // [1]
        System.out.println(solution.medianOfUniquenessArray(new int[]{
                1
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int medianOfUniquenessArray(int[] nums) {
            // 所有子数组的数量为 n*（n+1）/2
            // 中位数就是代表第 n*（n+1）/2+1/2 个数
            int n = nums.length;
            long all = (long) n * (n + 1) / 2;
            long k = (all + 1) / 2;
            int left = 0, right = n;

            while (left < right) {
                int mid = (right + left) / 2;
                if (check(nums, k, mid)) {
                    right = mid;
                } else {
                    // 不超过 mid 的子数组数量小于 k
                    left = mid + 1;
                }
            }
            return right;
        }

        // 判断不超过 distinct 的子数组数量是否大于等于 k
        private boolean check(int[] nums, long k, int distinct) {
            // 判断不超过 distinct 的子数组数量是否小于 k
            // 滑动窗口
            int left = 0;
            long count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 向右扩展
                map.merge(nums[i], 1, Integer::sum);
                while (map.size() > distinct) {
                    // 左边界收缩
                    map.merge(nums[left], -1, Integer::sum);
                    if (map.get(nums[left]) <= 0) {
                        // 移除
                        map.remove(nums[left]);
                    }
                    left++;
                }
                // 统计子数组数量
                count += i - left + 1;
                if (count >= k) {
                    return true;
                }
            }
            return count >= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}