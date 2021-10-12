

//给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两
//侧相邻元素的 平均值 。 
//
// 更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + 
//nums[i+1]) / 2 不等于 nums[i] 均成立 。 
//
// 返回满足题意的任一重排结果。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,4,5]
//输出：[1,2,4,5,3]
//解释：
//i=1, nums[i] = 2, 两相邻元素平均值为 (1+4) / 2 = 2.5
//i=2, nums[i] = 4, 两相邻元素平均值为 (2+5) / 2 = 3.5
//i=3, nums[i] = 5, 两相邻元素平均值为 (4+3) / 2 = 3.5
// 
//
// 示例 2： 
//
// 输入：nums = [6,2,0,9,7]
//输出：[9,7,6,2,0]
//解释：
//i=1, nums[i] = 7, 两相邻元素平均值为 (9+6) / 2 = 7.5
//i=2, nums[i] = 6, 两相邻元素平均值为 (7+2) / 2 = 4.5
//i=3, nums[i] = 2, 两相邻元素平均值为 (6+0) / 2 = 3
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 排序 👍 10 👎 0


package cn.db117.leetcode.solution19;

import java.util.Arrays;

/**
 * 1968.构造元素不等于两相邻元素平均值的数组.array-with-elements-not-equal-to-average-of-neighbors
 *
 * @author db117
 * @since 2021-10-12 17:47:58
 **/

public class Solution_1968 {
    public static void main(String[] args) {
        Solution solution = new Solution_1968().new Solution();
        System.out.println(Arrays.toString(solution.rearrangeArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution.rearrangeArray(new int[]{6, 2, 0, 9, 7})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeArray(int[] nums) {
            int[] ans = new int[nums.length];
            Arrays.sort(nums);

            // 偶数位放大的，奇数位放小的
            int odd = 0, even = nums.length - 1;
            for (int i = 0; i < ans.length; i++) {
                if ((i & 1) == 0) {
                    ans[i] = nums[even--];
                } else {
                    ans[i] = nums[odd++];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}