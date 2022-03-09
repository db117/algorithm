

//给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最
//小 。 
//
// 返回追加到 nums 中的 k 个整数之和。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,25,10,25], k = 2
//输出：5
//解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
//nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
//所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。 
//
// 示例 2： 
//
// 输入：nums = [5,6], k = 6
//输出：25
//解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
//nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
//所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁹ 
// 
// Related Topics 贪心 数组 数学 排序 👍 24 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;

/**
 * 2195.向数组中追加 K 个整数.append-k-integers-with-minimal-sum
 *
 * @author db117
 * @since 2022-03-09 17:05:41
 **/

public class Solution_2195 {
    public static void main(String[] args) {
        Solution solution = new Solution_2195().new Solution();

        System.out.println(solution.minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
        System.out.println(solution.minimalKSum(new int[]{5, 6}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimalKSum(int[] nums, int k) {
            long ans = 0;
            Arrays.sort(nums);
            int n = 1;
            for (int num : nums) {
                if (k <= 0) {
                    break;
                }
                if (n < num) {
                    // 有空位可以添加,从 n 到 nums[i] - 1
                    int count = Math.min(k, num - n);

                    ans += ((long) n + count - 1 + n) * count / 2;

                    k -= count;

                }
                // 下一个数字
                n = num + 1;
            }

            if (k > 0) {
                // 数组跑完了,还有空位
                ans += ((long) n + k - 1 + n) * k / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}