

//给定一个由 正整数 组成的数组 nums。 
//
// 可以对阵列执行如下操作，次数不限: 
//
// 
// 选择任意两个 相邻 的元素并用它们的 和 替换 它们。 
// 
//
// 
// 例如，如果 nums = [1,2,3,1]，则可以应用一个操作使其变为 [1,5,1]。 
// 
// 
//
//
// 返回将数组转换为 回文序列 所需的 最小 操作数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [4,3,2,1,2,3,1]
//输出: 2
//解释: 我们可以通过以下 2 个操作将数组转换为回文:
//- 在数组的第 4 和第 5 个元素上应用该操作，nums 将等于 [4,3,2,3,3,1].
//- 在数组的第 5 和第 6 个元素上应用该操作，nums 将等于 [4,3,2,3,4].
//数组 [4,3,2,3,4] 是一个回文序列。
//可以证明，2 是所需的最小操作数。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4]
//输出: 3
//解释: 我们在任意位置进行 3 次运算，最后得到数组 [10]，它是一个回文序列。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 双指针 👍 6 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2422.使用合并操作将数组转换为回文序列.merge-operations-to-turn-array-into-a-palindrome
 *
 * @author db117
 * @since 2024-03-20 20:59:15
 **/

public class Solution_2422 {
    public static void main(String[] args) {
        Solution solution = new Solution_2422().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(int[] nums) {
            // 左右指针
            int left = 0, right = nums.length - 1;
            int ans = 0;
            while (left < right) {
                if (nums[left] == nums[right]) {
                    left++;
                    right--;
                } else if (nums[left] < nums[right]) {
                    // 左边小,把左边的加到右边
                    nums[left + 1] += nums[left];
                    left++;
                    ans++;
                } else {
                    // 右边小
                    nums[right - 1] += nums[right];
                    right--;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}