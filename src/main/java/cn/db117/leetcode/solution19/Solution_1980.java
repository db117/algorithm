


//给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 
//nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = ["01","10"]
//输出："11"
//解释："11" 没有出现在 nums 中。"00" 也是正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = ["00","01"]
//输出："11"
//解释："11" 没有出现在 nums 中。"10" 也是正确答案。
// 
//
// 示例 3： 
//
// 
//输入：nums = ["111","011","001"]
//输出："101"
//解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 16 
// nums[i].length == n 
// nums[i] 为 '0' 或 '1' 
// 
// Related Topics 数组 字符串 回溯 👍 4 👎 0


package cn.db117.leetcode.solution19;

import java.util.Arrays;

/**
 * 1980.找出不同的二进制字符串.find-unique-binary-string
 *
 * @author db117
 * @since 2021-08-26 11:44:59
 **/

public class Solution_1980 {
    public static void main(String[] args) {
        Solution solution = new Solution_1980().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            int ans = -1;
            int off = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i].equals(nums[i - 1])) {
                    off++;
                }
                if (Integer.valueOf(nums[i], 2) != i - off) {
                    ans = i;
                    break;
                }
            }


            if (ans == -1) {
                // 肯定没有 全是1 的数字
                StringBuilder b = new StringBuilder(len);
                while (b.length() < len) {
                    b.insert(0, '1');
                }
                return b.toString();
            }

            StringBuilder b = new StringBuilder(Integer.toString(ans, 2));
            while (b.length() < len) {
                b.insert(0, '0');
            }

            return b.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}