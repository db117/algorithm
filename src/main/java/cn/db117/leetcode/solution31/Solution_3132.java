

//给你两个整数数组 nums1 和 nums2。 
//
// 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。 
//
// 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。 
//
// 返回能够实现数组相等的 最小 整数 x 。 
//
// 
//
// 示例 1: 
//
// 
// 输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10] 
// 
//
// 输出：-2 
//
// 解释： 
//
// 移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。 
//
// 示例 2: 
//
// 
// 输入：nums1 = [3,5,5,3], nums2 = [7,7] 
// 
//
// 输出：2 
//
// 解释： 
//
// 移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums1.length <= 200 
// nums2.length == nums1.length - 2 
// 0 <= nums1[i], nums2[i] <= 1000 
// 测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;

/**
 * 3132.找出与数组相加的整数 II.find-the-integer-added-to-array-ii
 *
 * @author db117
 * @since 2024-04-30 11:15:34
 **/

public class Solution_3132 {
    public static void main(String[] args) {
        Solution solution = new Solution_3132().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            // 最多有 3 种可能的情况
            // nums2[0] 对应到 nums1[0] 或者 nums1[1] 或者 nums1[2]
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            for (int i = 2; i >= 0; i--) {
                // 从大到小开始校验
                if (check(nums1, nums2, nums2[0] - nums1[i])) {
                    return nums2[0] - nums1[i];
                }
            }
            return -1;
        }

        // 校验 nums1 是否可以通过 diff 与 nums2 相等
        private boolean check(int[] nums1, int[] nums2, int diff) {
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] + diff == nums2[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            return j == nums2.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}