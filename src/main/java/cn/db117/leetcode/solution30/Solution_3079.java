

//给你一个整数数组 nums ，数组中的元素都是 正 整数。定义一个加密函数 encrypt ，encrypt(x) 将一个整数 x 中 每一个 数位都用 
//x 中的 最大 数位替换。比方说 encrypt(523) = 555 且 encrypt(213) = 333 。 
//
// 请你返回数组中所有元素加密后的 和 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3] 
// 
//
// 输出：6 
//
// 解释：加密后的元素位 [1,2,3] 。加密元素的和为 1 + 2 + 3 == 6 。 
//
// 示例 2： 
//
// 
// 输入：nums = [10,21,31] 
// 
//
// 输出：66 
//
// 解释：加密后的元素为 [11,22,33] 。加密元素的和为 11 + 22 + 33 == 66 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 👍 3 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3079.求出加密整数的和.find-the-sum-of-encrypted-integers
 *
 * @author db117
 * @since 2024-04-20 16:27:26
 **/

public class Solution_3079 {
    public static void main(String[] args) {
        Solution solution = new Solution_3079().new Solution();
        // [10,21,31]
        System.out.println(solution.sumOfEncryptedInt(new int[]{
                10, 21, 31
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfEncryptedInt(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                String s = Integer.toString(num);
                char[] chars = s.toCharArray();
                char max = chars[0];
                for (int i = 1; i < chars.length; i++) {
                    max = (char) Math.max(max, chars[i]);
                }

                int cur = 0;
                for (int i = 0; i < chars.length; i++) {
                    cur = cur * 10 + (max - '0');
                }
                sum += cur;
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}