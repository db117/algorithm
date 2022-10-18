

//给你一个由 正 整数组成的数组 nums 。 
//
// 你必须取出数组中的每个整数，反转其中每个数位，并将反转后得到的数字添加到数组的末尾。这一操作只针对 nums 中原有的整数执行。 
//
// 返回结果数组中 不同 整数的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,13,10,12,31]
//输出：6
//解释：反转每个数字后，结果数组是 [1,13,10,12,31,1,31,1,21,13] 。
//反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
//数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2]
//输出：1
//解释：反转每个数字后，结果数组是 [2,2,2,2,2,2] 。
//数组中不同整数的数目为 1（数字 2）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 哈希表 数学 👍 4 👎 0


package cn.db117.leetcode.solution24;

import java.util.HashSet;

/**
 * 2442.反转之后不同整数的数目.count-number-of-distinct-integers-after-reverse-operations
 *
 * @author db117
 * @since 2022-10-18 16:05:25
 **/

public class Solution_2442 {
    public static void main(String[] args) {
        Solution solution = new Solution_2442().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDistinctIntegers(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);

                String s = new StringBuilder(Integer.toString(num)).reverse().toString();
                set.add(Integer.parseInt(s));
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}