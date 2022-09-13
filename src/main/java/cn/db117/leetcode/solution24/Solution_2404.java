

//给你一个整数数组 nums ，返回出现最频繁的偶数元素。 
//
// 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,2,4,4,1]
//输出：2
//解释：
//数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
//返回最小的那个，即返回 2 。 
//
// 示例 2： 
//
// 输入：nums = [4,4,4,9,2,4]
//输出：4
//解释：4 是出现最频繁的偶数元素。
// 
//
// 示例 3： 
//
// 输入：nums = [29,47,21,41,13,37,25,7]
//输出：-1
//解释：不存在偶数元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution24;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2404.出现最频繁的偶数元素.most-frequent-even-element
 *
 * @author db117
 * @since 2022-09-13 17:26:43
 **/

public class Solution_2404 {
    public static void main(String[] args) {
        Solution solution = new Solution_2404().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> countMap = new TreeMap<>();
            for (int num : nums) {
                if ((num & 1) != 1) {
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                }
            }

            int ans = -1;
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                Integer num = entry.getKey();
                Integer count = entry.getValue();
                if (count > max) {
                    ans = num;
                    max = count;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}