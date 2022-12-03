

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。 
//
// 子数组 是数组中一个连续非空的元素序列。 
//
// 数组的最小公倍数 是可被所有数组元素整除的最小正整数。 
//
// 
//
// 示例 1 ： 
//
// 输入：nums = [3,6,2,7,1], k = 6
//输出：4
//解释：以 6 为最小公倍数的子数组是：
//- [3,6,2,7,1]
//- [3,6,2,7,1]
//- [3,6,2,7,1]
//- [3,6,2,7,1]
// 
//
// 示例 2 ： 
//
// 输入：nums = [3], k = 2
//输出：0
//解释：不存在以 2 为最小公倍数的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i], k <= 1000 
// 
//
// Related Topics 数组 数学 数论 👍 20 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2470.最小公倍数为 K 的子数组数目.number-of-subarrays-with-lcm-equal-to-k
 *
 * @author db117
 * @since 2022-12-03 10:51:37
 **/

public class Solution_2470 {
    public static void main(String[] args) {
        Solution solution = new Solution_2470().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static int gcd(int a, int b) {
            int t;
            while (b != 0) {
                t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

        public int subarrayLCM(int[] nums, int k) {
            int ans = 0;
            // 模拟

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > k || k % nums[i] != 0) {
                    continue;
                }
                int cur = nums[i];
                for (int j = i; j < nums.length; j++) {
                    cur = (cur * nums[j]) / gcd(cur, nums[j]);
                    if (cur == k) {
                        ans++;
                    } else if (cur > k) {
                        break;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}