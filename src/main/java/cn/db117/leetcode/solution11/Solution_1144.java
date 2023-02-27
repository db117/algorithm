

//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。 
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组： 
//
// 
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ... 
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
// 
//
// 示例 2： 
//
// 输入：nums = [9,6,1,6,2]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 👍 71 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1144.递减元素使数组呈锯齿状.decrease-elements-to-make-array-zigzag
 *
 * @author db117
 * @since 2023-02-27 09:44:44
 **/

public class Solution_1144 {
    public static void main(String[] args) {
        Solution solution = new Solution_1144().new Solution();
        System.out.println(solution.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            // 奇数大
            int odd = 0;
            int even = 0;
            for (int i = 0; i < nums.length; i++) {
                // 找两边，越界为最大值
                int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
                int right = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
                // 累加 把当前数字减小到比两边小
                if ((i & 1) == 0) {
                    even += Math.max(0, nums[i] - Math.min(left, right) + 1);
                } else {
                    odd += Math.max(0, nums[i] - Math.min(left, right) + 1);
                }
            }
            return Math.min(odd, even);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}