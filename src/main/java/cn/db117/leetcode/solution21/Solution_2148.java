

//给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [11,7,2,15]
//输出：2
//解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
//元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
//总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
// 
//
// 示例 2： 
//
// 输入：nums = [-3,3,3,90]
//输出：2
//解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
//由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// 👍 5 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2148.元素计数.count-elements-with-strictly-smaller-and-greater-elements
 *
 * @author db117
 * @since 2022-01-25 18:30:48
 **/

public class Solution_2148 {
    public static void main(String[] args) {
        Solution solution = new Solution_2148().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countElements(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            if (nums[0] == nums[nums.length - 1]) {
                return 0;
            }

            return nums.length - map.get(nums[0]) - map.get(nums[nums.length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}