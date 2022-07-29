

//给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。 
//
// 子数组 是一个数组中一段连续非空元素组成的序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,0,0,2,0,0,4]
//输出：6
//解释：
//子数组 [0] 出现了 4 次。
//子数组 [0,0] 出现了 2 次。
//不存在长度大于 2 的全 0 子数组，所以我们返回 6 。 
//
// 示例 2： 
//
// 输入：nums = [0,0,0,2,0,0]
//输出：9
//解释：
//子数组 [0] 出现了 5 次。
//子数组 [0,0] 出现了 3 次。
//子数组 [0,0,0] 出现了 1 次。
//不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [2,10,2019]
//输出：0
//解释：没有全 0 子数组，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 数学 👍 3 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2348.全 0 子数组的数目.number-of-zero-filled-subarrays
 *
 * @author db117
 * @since 2022-07-29 17:04:37
 **/

public class Solution_2348 {
    public static void main(String[] args) {
        Solution solution = new Solution_2348().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long ans = 0;
            int i = 0;
            // 连续的 0
            while (i < nums.length) {
                if (nums[i] != 0) {
                    i++;
                    continue;
                }
                int c = 0;
                while (i < nums.length && nums[i] == 0) {
                    c++;
                    i++;
                }
                ans += helper(c);

            }
            return ans;
        }

        // 累加到 1
        private long helper(long n) {
            if (n == 1) {
                return 1;
            }
            return n + helper(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}