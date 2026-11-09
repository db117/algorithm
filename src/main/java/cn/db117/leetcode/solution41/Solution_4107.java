

//给你两个长度均为 n 的整数数组 nums 和 target。 
//
// 对于每个下标 i，考虑将原数组的 后缀 nums[i..n - 1] 按 非递增顺序 排序。 
//
// 返回使排序后的数组等于 target 的下标 i 的数量。 
//
// 子数组 是数组中一个连续的 非空 元素序列。 
//
// 数组的 后缀 是从任意下标开始并延伸至数组末尾的子数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], target = [3,2,1] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
// i = 0：排序后的数组为 [3, 2, 1]，等于 target。 
// i = 1：排序后的数组为 [1, 3, 2]。 
// i = 2：排序后的数组为 [1, 2, 3]。 
// 
//
// 只有 i = 0 符合要求，因此答案为 1。 
//
//
// 示例 2： 
//
// 
// 输入： nums = [1,5,6,4,6], target = [1,5,6,6,4] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 选择 i = 2 或 i = 3，排序后都会得到 [1, 5, 6, 6, 4]。其他下标均无法得到 target。因此，答案为 2。 
//
//
// 示例 3： 
//
// 
// 输入： nums = [7,6,8], target = [8,6,7] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 分别对从下标 0、1 和 2 开始的后缀排序，会依次得到 [8, 7, 6]、[7, 8, 6] 和 [7, 6, 8]。它们均不等于 target，因此
//答案为 0。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length == target.length <= 10⁵ 
// 1 <= nums[i], target[i] <= 105 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution41;

import java.util.HashMap;
import java.util.Map;

/**
 * 4107.统计有效后缀排序的数量 I.count-valid-suffix-sorts-i
 *
 * @author db117
 * @since 2026-11-09 22:19:12
 **/

public class Solution_4107 {
    public static void main(String[] args) {
        Solution solution = new Solution_4107().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSuffix(int[] nums, int[] target) {
            int n = nums.length;
            int ans = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                cnt.put(target[i], cnt.getOrDefault(target[i], 0) + 1);
                cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) - 1);
            }
            long count = cnt.values().stream().filter(value -> value != 0).count();
            if (count > 0) {
                // 如果计数排序不一致，不可能相等的
                return 0;
            }

            // 记录前面多少位是相等的
            boolean[] flag = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (nums[i] == target[i]) {
                    flag[i] = true;
                } else {
                    break;
                }
            }
            // 从后往前枚举，找到非递增的
            for (int i = n - 1; i >= 0; i--) {
                if (i < n - 1 && target[i] < target[i + 1]) {
                    return ans;
                }
                // 前面的都相等，当前也相等，那么答案加一
                if (i > 0 && flag[i - 1]) {
                    ans++;
                }
                // 前面没有了，就是全部排序了
                if (i == 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}