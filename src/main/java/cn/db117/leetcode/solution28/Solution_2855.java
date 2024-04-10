

//给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得
//到递增数组，返回 -1 。 
//
// 一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：2
//解释：
//第一次右移后，nums = [2,3,4,5,1] 。
//第二次右移后，nums = [1,2,3,4,5] 。
//现在 nums 是递增数组了，所以答案为 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,5]
//输出：0
//解释：nums 已经是递增数组了，所以答案为 0 。 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,4]
//输出：-1
//解释：无法将数组变为递增数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// nums 中的整数互不相同。 
// 
//
// Related Topics 数组 👍 8 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2855.使数组成为递增数组的最少右移次数.minimum-right-shifts-to-sort-the-array
 *
 * @author db117
 * @since 2024-04-10 17:09:12
 **/

public class Solution_2855 {
    public static void main(String[] args) {
        Solution solution = new Solution_2855().new Solution();
        // [3,4,5,1,2]
        System.out.println(solution.minimumRightShifts(List.of(3, 4, 5, 1, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRightShifts(List<Integer> nums) {
            // 找到最大值的位置
            int max = 0;
            int index = 0;
            int n = nums.size();
            for (int i = 0; i < n; i++) {
                Integer num = nums.get(i);
                if (num > max) {
                    max = num;
                    index = i;
                }
            }

            // 判断是否是递增数组
            for (int i = 1; i < index; i++) {
                if (nums.get(i) < nums.get(i - 1)) {
                    return -1;
                }
            }
            if (index == n - 1) {
                return 0;
            }
            // 分两段进行判断
            if (nums.get(n - 1) > nums.get(0)) {
                return -1;
            }
            for (int i = index + 2; i < n; i++) {
                if (nums.get(i) < nums.get(i - 1)) {
                    return -1;
                }
            }
            return n - index - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}