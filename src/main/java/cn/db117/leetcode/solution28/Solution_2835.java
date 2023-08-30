

//给你一个下标从 0 开始的数组 nums ，它包含 非负 整数，且全部为 2 的幂，同时给你一个整数 target 。 
//
// 一次操作中，你必须对数组做以下修改： 
//
// 
// 选择数组中一个元素 nums[i] ，满足 nums[i] > 1 。 
// 将 nums[i] 从数组中删除。 
// 在 nums 的 末尾 添加 两个 数，值都为 nums[i] / 2 。 
// 
//
// 你的目标是让 nums 的一个 子序列 的元素和等于 target ，请你返回达成这一目标的 最少操作次数 。如果无法得到这样的子序列，请你返回 -1 。
// 
//
// 数组中一个 子序列 是通过删除原数组中一些元素，并且不改变剩余元素顺序得到的剩余数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,8], target = 7
//输出：1
//解释：第一次操作中，我们选择元素 nums[2] 。数组变为 nums = [1,2,4,4] 。
//这时候，nums 包含子序列 [1,2,4] ，和为 7 。
//无法通过更少的操作得到和为 7 的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,32,1,2], target = 12
//输出：2
//解释：第一次操作中，我们选择元素 nums[1] 。数组变为 nums = [1,1,2,16,16] 。
//第二次操作中，我们选择元素 nums[3] 。数组变为 nums = [1,1,2,16,8,8] 。
//这时候，nums 包含子序列 [1,1,2,8] ，和为 12 。
//无法通过更少的操作得到和为 12 的子序列。 
//
// 示例 3： 
//
// 
//输入：nums = [1,32,1], target = 35
//输出：-1
//解释：无法得到和为 35 的子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2³⁰ 
// nums 只包含非负整数，且均为 2 的幂。 
// 1 <= target < 2³¹ 
// 
//
// 👍 30 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;
import java.util.TreeMap;

/**
 * 2835.使子序列的和等于目标的最少操作次数.minimum-operations-to-form-subsequence-with-target-sum
 *
 * @author db117
 * @since 2023-08-30 10:29:17
 **/

public class Solution_2835 {
    public static void main(String[] args) {
        Solution solution = new Solution_2835().new Solution();
        //nums =
        //[1,32,1,2]
        //target =
        //12]
//        System.out.println(solution.minOperations(List.of(1, 32, 1, 2), 12));

        // nums =
        //[16,64,4,128]
        //target =
        //6
        System.out.println(solution.minOperations(List.of(16, 64, 4, 128), 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(List<Integer> nums, int target) {
            // 2的幂 -> 数量
            TreeMap<Integer, Integer> map = new TreeMap<>();
            long s = 0;
            for (Integer num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                s += num;
            }
            if (s < target) {
                // 总和小于目标
                // 当小于等于时一定可以,全部变成1
                return -1;
            }

            long sum = 0;// 记录没有使用的数字的和
            int ans = 0;
            for (int i = 0; i < 31; i++) {
                int pow = 1 << i;
                if (target < pow) {
                    break;
                }
                sum += (long) map.getOrDefault(pow, 0) * pow;
                if ((target & pow) == 0) {
                    // 当前bit位为0
                    continue;
                }
                if (sum >= pow) {
                    // 比当前bit位小的数字的和大于target
                    target -= pow;
                    sum -= pow;
                    continue;
                }
                // 需要从高的地方开始拆
                Integer key = map.higherKey(pow);
                if (key == null) {
                    // 没有比当前bit位大的数字
                    return -1;// 无法达到
                }
                while (pow < key) {
                    // 拆到当前bit位
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                    map.put(key / 2, map.getOrDefault(key / 2, 0) + 2);// 拆成两个
                    key /= 2;
                    ans++;
                }
                sum += key * 2;// 肯定是两个
                if (sum >= pow) {
                    // 拆到当前bit位
                    target -= pow;
                    sum -= pow;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}