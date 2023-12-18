

//给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。 
//
// 将这个数组划分为一个或多个长度为 3 的子数组，并满足以下条件： 
//
// 
// nums 中的 每个 元素都必须 恰好 存在于某个子数组中。 
// 子数组中 任意 两个元素的差必须小于或等于 k 。 
// 
//
// 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,8,7,9,3,5,1], k = 2
//输出：[[1,1,3],[3,4,5],[7,8,9]]
//解释：可以将数组划分为以下子数组：[1,1,3]，[3,4,5] 和 [7,8,9] 。
//每个子数组中任意两个元素的差都小于或等于 2 。
//注意，元素的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,3,2,7,3], k = 3
//输出：[]
//解释：无法划分数组满足所有条件。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// n 是 3 的倍数 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁵ 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;

/**
 * 2966.划分数组并满足最大差限制.divide-array-into-arrays-with-max-difference
 *
 * @author db117
 * @since 2023-12-18 11:11:54
 **/

public class Solution_2966 {
    public static void main(String[] args) {
        Solution solution = new Solution_2966().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            Arrays.sort(nums);

            int n = nums.length;
            int[][] ans = new int[n / 3][3];
            int index = 0;
            for (int i = 0; i < n / 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ans[i][j] = nums[index++];
                }
            }
            for (int[] an : ans) {
                if (an[2] - an[0] > k) {// 子数组中 任意 两个元素的差必须小于或等于 k 。
                    return new int[0][0];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}