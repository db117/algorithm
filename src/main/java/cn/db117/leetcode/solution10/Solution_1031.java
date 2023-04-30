

//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 
//firstLen 和 secondLen 。 
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。 
//
// 子数组是数组的一个 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstLen, secondLen <= 1000 
// 2 <= firstLen + secondLen <= 1000 
// firstLen + secondLen <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 156 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1031.两个非重叠子数组的最大和.maximum-sum-of-two-non-overlapping-subarrays
 *
 * @author db117
 * @since 2023-04-25 13:42:56
 **/

public class Solution_1031 {
    public static void main(String[] args) {

        Solution solution = new Solution_1031().new Solution();
        // nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));

        // nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//        System.out.println(solution.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int max = -1;
            int n = nums.length;
            // 前缀和
            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ps[i + 1] = ps[i] + nums[i];
            }

            // 前面 firstLen 长度的最大值
            int[] preF = new int[n + 1];
            // 后面 firstLen 长度的最大值(包含)
            int[] lastF = new int[n + 1];
            // 前面 secondLen 长度的最大值
            int[] preS = new int[n + 1];
            // 后面 secondLen 长度的最大值(包含)
            int[] lastS = new int[n + 1];

            for (int i = firstLen; i < n; i++) {
                preF[i] = Math.max(preF[i - 1], ps[i] - ps[i - firstLen]);
            }
            for (int i = secondLen; i < n; i++) {
                preS[i] = Math.max(preS[i - 1], ps[i] - ps[i - secondLen]);
            }
            for (int i = n - firstLen; i >= 0; i--) {
                lastF[i] = Math.max(lastF[i + 1], ps[i + firstLen] - ps[i]);
            }
            for (int i = n - secondLen; i >= 0; i--) {
                lastS[i] = Math.max(lastS[i + 1], ps[i + secondLen] - ps[i]);
            }

            for (int i = 0; i < n; i++) {
                // 以 i 为分界线
                // 前面 firstLen 的最大值 + 后面 secondLen 的最大值
                max = Math.max(max, preF[i] + lastS[i]);
                // 反过来
                max = Math.max(max, preS[i] + lastF[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}