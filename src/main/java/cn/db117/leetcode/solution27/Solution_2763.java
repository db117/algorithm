

//一个长度为 n 下标从 0 开始的整数数组 arr 的 不平衡数字 定义为，在 sarr = sorted(arr) 数组中，满足以下条件的下标数目： 
//
// 
// 0 <= i < n - 1 ，和 
// sarr[i+1] - sarr[i] > 1 
// 
//
// 这里，sorted(arr) 表示将数组 arr 排序后得到的数组。 
//
// 给你一个下标从 0 开始的整数数组 nums ，请你返回它所有 子数组 的 不平衡数字 之和。 
//
// 子数组指的是一个数组中连续一段 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,1,4]
//输出：3
//解释：总共有 3 个子数组有非 0 不平衡数字：
//- 子数组 [3, 1] ，不平衡数字为 1 。
//- 子数组 [3, 1, 4] ，不平衡数字为 1 。
//- 子数组 [1, 4] ，不平衡数字为 1 。
//其他所有子数组的不平衡数字都是 0 ，所以所有子数组的不平衡数字之和为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,3,3,3,5]
//输出：8
//解释：总共有 7 个子数组有非 0 不平衡数字：
//- 子数组 [1, 3] ，不平衡数字为 1 。
//- 子数组 [1, 3, 3] ，不平衡数字为 1 。
//- 子数组 [1, 3, 3, 3] ，不平衡数字为 1 。
//- 子数组 [1, 3, 3, 3, 5] ，不平衡数字为 2 。
//- 子数组 [3, 3, 3, 5] ，不平衡数字为 1 。
//- 子数组 [3, 3, 5] ，不平衡数字为 1 。
//- 子数组 [3, 5] ，不平衡数字为 1 。
//其他所有子数组的不平衡数字都是 0 ，所以所有子数组的不平衡数字之和为 8 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= nums.length 
// 
//
// 👍 7 👎 0


package cn.db117.leetcode.solution27;

import java.util.HashSet;
import java.util.Set;

/**
 * 2763.所有子数组中不平衡数字之和.sum-of-imbalance-numbers-of-all-subarrays
 *
 * @author db117
 * @since 2023-07-04 16:06:29
 **/

public class Solution_2763 {
    public static void main(String[] args) {
        Solution solution = new Solution_2763().new Solution();
        // 2,3,1,4
        System.out.println(solution.sumImbalanceNumbers(new int[]{
                2, 3, 1, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumImbalanceNumbers(int[] nums) {
            int ans = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int cur = 0;
                Set<Integer> set = new HashSet<>();
                set.add(nums[i]);
                for (int j = i + 1; j < n; j++) {
                    int num = nums[j];
                    if (set.contains(num)) {
                        // 重复的数字不会影响当前起点开始的结果,直接加前面的结果
                        ans += cur;
                        continue;
                    }
                    boolean pre = set.contains(num - 1);
                    boolean post = set.contains(num + 1);
                    // 一边有,则当前数字会和之前的数字在一起。不需要处理
                    if (post && pre) {
                        // 两边都有,则有一个数字从不平衡变成平衡
                        cur--;
                    } else if (!pre && !post) {
                        // 两边都没有,则多了一个不平衡数字
                        cur++;
                    }
                    ans += cur;
                    set.add(num);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}