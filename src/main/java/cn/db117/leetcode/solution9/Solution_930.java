// 给你一个二元数组 nums ，和一个整数 goal ，请你统计并有多少个和为 goal 的 非空 子数组。
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 哈希表 双指针 
// 👍 101 👎 0


package cn.db117.leetcode.solution9;

import java.util.HashMap;
import java.util.Map;

/**
 * 930.和相同的二元子数组.binary-subarrays-with-sum
 *
 * @author db117
 * @since 2021-06-16 15:14:54
 **/

public class Solution_930 {
    public static void main(String[] args) {
        Solution solution = new Solution_930().new Solution();
        System.out.println(solution.numSubarraysWithSum(new int[]{
                1, 0, 1, 0, 1
        }, 2));

        System.out.println(solution.numSubarraysWithSum(new int[]{
                0, 0, 0, 0, 0
        }, 0));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int ans = 0;
            // 前缀和 hash

            // sum -> 数量
            // 前缀和出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 避免漏掉 区间包含第一个数字的情况,即 sum==goal时
            map.put(0, 1);
            int sum = 0;

            for (int num : nums) {
                sum += num;
                // 前面 sum-goal 出现的次数
                // 即有多少个区间满足和等于 goal
                if (map.containsKey(sum - goal)) {
                    ans += map.get(sum - goal);
                }

                // 保存当前前缀和出现的次数
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int ans = 0;
            // 记录累计和
            // 添加一个虚拟的位置,方便计算
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            // 对应 nums 索引
            for (int left = 0; left < nums.length; left++) {
                // 对应 sum 索引
                for (int right = left + 1; right < sum.length; right++) {
                    int tmp = sum[right] - sum[left];
                    if (tmp == goal) {
                        // 符合题意
                        ans++;
                    } else if (tmp > goal) {
                        // 后面都不符合
                        break;
                    }
                }
            }

            return ans;
        }
    }
}