//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 179 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 611.有效三角形的个数.valid-triangle-number
 *
 * @author db117
 * @since 2021-07-06 11:21:04
 **/

public class Solution_611 {
    public static void main(String[] args) {
        Solution solution = new Solution_611().new Solution();
        int[] ints = {
                24, 3, 82, 22, 35, 84, 19
        };
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        // 10
        System.out.println(solution.triangleNumber(new int[]{
                3, 19, 22, 24, 35, 82, 84
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                // 固定一个点，移动两个点
                // 数组递增，则第三个数字不需要从头开始遍历
                int right = i + 2;
                for (int left = i + 1; left < nums.length - 1; left++) {
                    while (right < nums.length && nums[right] < nums[i] + nums[left]) {
                        right++;
                    }

                    // 区间内所有数字都可以组成三角形
                    ans += right - left - 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}