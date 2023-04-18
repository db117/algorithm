

//给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。请你从 nums 中找到 p 个下标对，每个下标对对应数值取差值，你需要使得这 p 个差值的
// 最大值 最小。同时，你需要确保每个下标在这 p 个下标对中最多出现一次。 
//
// 对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。 
//
// 请你返回 p 个下标对对应数值 最大差值 的 最小值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,1,2,7,1,3], p = 2
//输出：1
//解释：第一个下标对选择 1 和 4 ，第二个下标对选择 2 和 5 。
//最大差值为 max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1 。所以我们返回 1 
//。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,2,1,2], p = 1
//输出：0
//解释：选择下标 1 和 3 构成下标对。差值为 |2 - 2| = 0 ，这是最大差值的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= p <= (nums.length)/2 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution26;

import java.util.Arrays;

/**
 * 2616.最小化数对的最大差值.minimize-the-maximum-difference-of-pairs
 *
 * @author db117
 * @since 2023-04-11 10:26:44
 **/

public class Solution_2616 {
    public static void main(String[] args) {
        Solution solution = new Solution_2616().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int p;

        public int minimizeMax(int[] nums, int p) {
            this.nums = nums;
            this.p = p;
            int n = nums.length;
            Arrays.sort(nums);
            // 二分猜答案，比赛的时候傻了没想起来
            int left = 0, right = nums[n - 1] - nums[0];
            while (left < right) {
                int mid = (int) (((long) right + left) / 2);
                if (check(mid)) {
                    right = mid;// 可能是答案
                } else {
                    left = mid + 1;// 肯定不能是答案
                }
            }

            return right;
        }

        private boolean check(int max) {
            int cur = 0;
            // 贪心计算当前 max 下能不能凑够 p 对
            // 对于选择当前数字，则需要从 [i+2,n] 选择 p-1 个数对
            // 对于不选择当前数字，则需要从 [i+1,n] 选择 p 个数对
            // [i+2,n]+1 >= [i+1,n] 所以当前数对满足，则可以直接选
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] <= max) {
                    cur++;
                    i++;// 当前数对选择了，后面就不能选了
                }
                if (cur >= p) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}