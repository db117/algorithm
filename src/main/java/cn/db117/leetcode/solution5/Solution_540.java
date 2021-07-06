//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
//
// 示例 1: 
//
// 
//输入: [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。 
// Related Topics 数组 二分查找 
// 👍 246 👎 0


package cn.db117.leetcode.solution5;

/**
 * 540.有序数组中的单一元素.single-element-in-a-sorted-array
 *
 * @author db117
 * @since 2021-07-06 10:16:31
 **/

public class Solution_540 {
    public static void main(String[] args) {
        Solution solution = new Solution_540().new Solution();

        System.out.println(solution.singleNonDuplicate(new int[]{
                1, 1, 2, 3, 3, 4, 4, 8, 8
        }));

        System.out.println(solution.singleNonDuplicate(new int[]{
                1, 3, 3,
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 如果 mid 为奇数，与前面相等则目标值在左边，与后面相等则目标值在右边
                // 否则相反
                if ((mid & 1) == 1) {
                    // mid 为奇数则不可能是第一个或最后一个，数组总数为奇数
                    if (nums[mid - 1] == nums[mid]) {
                        // 目标在右边
                        left = mid + 1;
                    } else if (nums[mid] == nums[mid + 1]) {
                        // 目标值在左边
                        right = mid - 1;
                    } else {
                        // 前后都没有相同的数字
                        return nums[mid];
                    }
                } else {
                    // mid 为偶数

                    // 极值处理
                    if (mid == nums.length - 1) {
                        if (nums[mid - 1] != nums[mid]) {
                            return nums[mid];
                        } else {
                            right = mid - 2;
                            continue;
                        }
                    }
                    if (mid == 0) {
                        if (nums[mid] != nums[mid + 1]) {
                            return nums[mid];
                        } else {
                            left = mid + 2;
                        }
                        continue;
                    }

                    // 跟奇数相反
                    if (nums[mid - 1] == nums[mid]) {
                        // 目标值在左边
                        right = mid - 2;
                    } else if (nums[mid] == nums[mid + 1]) {
                        // 目标在右边
                        left = mid + 2;
                    } else {
                        // 前后都没有相同的数字
                        return nums[mid];
                    }
                }


            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}