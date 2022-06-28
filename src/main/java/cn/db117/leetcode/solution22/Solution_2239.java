

//给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [-4,-2,1,4,8]
//输出：1
//解释：
//-4 到 0 的距离为 |-4| = 4 。
//-2 到 0 的距离为 |-2| = 2 。
//1 到 0 的距离为 |1| = 1 。
//4 到 0 的距离为 |4| = 4 。
//8 到 0 的距离为 |8| = 8 。
//所以，数组中距离 0 最近的数字为 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,-1,1]
//输出：1
//解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 👍 5 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2239.找到最接近 0 的数字.find-closest-number-to-zero
 *
 * @author db117
 * @since 2022-06-28 11:06:46
 **/

public class Solution_2239 {
    public static void main(String[] args) {
        Solution solution = new Solution_2239().new Solution();
        // [-4,-2,1,4,8]
        System.out.println(solution.findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosestNumber(int[] nums) {
            int min = Integer.MAX_VALUE;
            int ans = -1;

            for (int num : nums) {
                int abs = Math.abs(num);
                if (abs > min) {
                    continue;
                }
                if (abs == min) {
                    ans = Math.max(ans, num);
                } else {
                    ans = num;
                    min = abs;
                }

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}