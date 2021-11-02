

//给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。 
//
// 整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算： 
//
// 如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值： 
//
// 
// x + nums[i] 
// x - nums[i] 
// x ^ nums[i]（按位异或 XOR） 
// 
//
// 注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他
//运算。 
//
// 返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3], start = 6, goal = 4
//输出：2
//解释：
//可以按 6 → 7 → 4 的转化路径进行，只需执行下述 2 次运算：
//- 6 ^ 1 = 7
//- 7 ^ 3 = 4
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,12], start = 2, goal = 12
//输出：2
//解释：
//可以按 2 → 14 → 12 的转化路径进行，只需执行下述 2 次运算：
//- 2 + 12 = 14
//- 14 - 2 = 12
// 
//
// 示例 3： 
//
// 输入：nums = [3,5,7], start = 0, goal = -4
//输出：2
//解释：
//可以按 0 → 3 → -4 的转化路径进行，只需执行下述 2 次运算：
//- 0 + 3 = 3
//- 3 - 7 = -4
//注意，最后一步运算使 x 超过范围 0 <= x <= 1000 ，但该运算仍然可以生效。
// 
//
// 示例 4： 
//
// 输入：nums = [2,8,16], start = 0, goal = 1
//输出：-1
//解释：
//无法将 0 转化为 1 
//
// 示例 5： 
//
// 输入：nums = [1], start = 0, goal = 3
//输出：3
//解释：
//可以按 0 → 1 → 2 → 3 的转化路径进行，只需执行下述 3 次运算：
//- 0 + 1 = 1 
//- 1 + 1 = 2
//- 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i], goal <= 10⁹ 
// 0 <= start <= 1000 
// start != goal 
// nums 中的所有整数互不相同 
// 
// 👍 13 👎 0


package cn.db117.leetcode.solution20;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 2059.转化数字的最小运算数.minimum-operations-to-convert-number
 *
 * @author db117
 * @since 2021-11-02 16:12:45
 **/

public class Solution_2059 {
    public static void main(String[] args) {
        Solution solution = new Solution_2059().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums, int start, int goal) {
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            // 简单粗暴bfs
            while (!queue.isEmpty()) {
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    for (int num : nums) {
                        int cur = poll + num;
                        if (set.add(cur) && cur >= 0 && cur <= 1000) {
                            queue.add(cur);
                        }
                        cur = poll - num;
                        if (set.add(cur) && cur >= 0 && cur <= 1000) {
                            queue.add(cur);
                        }
                        cur = poll ^ num;
                        if (set.add(cur) && cur >= 0 && cur <= 1000) {
                            queue.add(cur);
                        }
                    }
                    if (set.contains(goal)) {
                        return ans;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}