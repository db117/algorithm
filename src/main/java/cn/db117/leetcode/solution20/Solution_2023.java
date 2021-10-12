

//给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 
//target 的下标 (i, j) （需满足 i != j）的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = ["777","7","77","77"], target = "7777"
//输出：4
//解释：符合要求的下标对包括：
//- (0, 1)："777" + "7"
//- (1, 0)："7" + "777"
//- (2, 3)："77" + "77"
//- (3, 2)："77" + "77"
// 
//
// 示例 2： 
//
// 输入：nums = ["123","4","12","34"], target = "1234"
//输出：2
//解释：符合要求的下标对包括
//- (0, 1)："123" + "4"
//- (2, 3)："12" + "34"
// 
//
// 示例 3： 
//
// 输入：nums = ["1","1","1"], target = "11"
//输出：6
//解释：符合要求的下标对包括
//- (0, 1)："1" + "1"
//- (1, 0)："1" + "1"
//- (0, 2)："1" + "1"
//- (2, 0)："1" + "1"
//- (1, 2)："1" + "1"
//- (2, 1)："1" + "1"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i].length <= 100 
// 2 <= target.length <= 100 
// nums[i] 和 target 只包含数字。 
// nums[i] 和 target 不含有任何前导 0 。 
// 
// Related Topics 数组 字符串 👍 2 👎 0


package cn.db117.leetcode.solution20;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023.连接后等于目标字符串的字符串对.number-of-pairs-of-strings-with-concatenation-equal-to-target
 *
 * @author db117
 * @since 2021-10-12 16:01:07
 **/

public class Solution_2023 {
    public static void main(String[] args) {
        Solution solution = new Solution_2023().new Solution();
        System.out.println(solution.numOfPairs(new String[]{"777", "7", "77", "77"}, "7777"));
        System.out.println(solution.numOfPairs(new String[]{"123", "4", "12", "34"}, "1234"));
        System.out.println(solution.numOfPairs(new String[]{"1", "1", "1"}, "11"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numOfPairs(String[] nums, String target) {
            // 每个字符出现的次数
            Map<String, Integer> map = new HashMap<>();
            for (String num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int ans = 0;
            for (String num : nums) {
                if (target.length() <= num.length()) {
                    continue;
                }
                if (target.startsWith(num)) {
                    // 剩下的字符
                    String next = target.substring(num.length());
                    Integer count = map.get(next);
                    if (count == null) {
                        continue;
                    }

                    if (next.equals(num)) {
                        // 去掉自己
                        count--;
                    }

                    ans += count;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}