

//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组 👍 76 👎 0


package cn.db117.leetcode.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 163.缺失的区间.missing-ranges
 *
 * @author db117
 * @since 2022-03-11 11:49:32
 **/

public class Solution_163 {
    public static void main(String[] args) {
        Solution solution = new Solution_163().new Solution();

        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            // 防止越界
            long[] arr = new long[nums.length + 2];
            arr[0] = lower - 1;
            arr[arr.length - 1] = upper + 1;
            for (int i = 0; i < nums.length; i++) {
                arr[i + 1] = nums[i];
            }

            List<String> ans = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                long diff = arr[i] - arr[i - 1];
                if (diff < 2) {
                    continue;
                }
                if (diff == 2) {
                    ans.add(String.valueOf(arr[i] - 1));
                } else {
                    ans.add((arr[i - 1] + 1) + "->" + (arr[i] - 1));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}