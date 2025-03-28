

//给你一个整数数组 nums 。 
//
// 开始时，选择一个满足 nums[curr] == 0 的起始位置 curr ，并选择一个移动 方向 ：向左或者向右。 
//
// 此后，你需要重复下面的过程： 
//
// 
// 如果 curr 超过范围 [0, n - 1] ，过程结束。 
// 如果 nums[curr] == 0 ，沿当前方向继续移动：如果向右移，则 递增 curr ；如果向左移，则 递减 curr 。 
// 如果 nums[curr] > 0: 
// 
// 将 nums[curr] 减 1 。 
// 反转 移动方向（向左变向右，反之亦然）。 
// 沿新方向移动一步。 
// 
// 
//
// 如果在结束整个过程后，nums 中的所有元素都变为 0 ，则认为选出的初始位置和移动方向 有效 。 
//
// 返回可能的有效选择方案数目。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,0,2,0,3] 
// 
//
// 输出：2 
//
// 解释： 
//
// 可能的有效选择方案如下： 
//
// 
// 选择 curr = 3 并向左移动。 
// 
//
// 
// [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1
//,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,
//0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] 
//-> [0,0,0,0,0]. 
// 
// 
// 选择 curr = 3 并向右移动。
// 
// [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1
//,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,
//0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0]. 
// 
// 
//
//
// 示例 2： 
//
// 
// 输入：nums = [2,3,4,0,4,1,0] 
// 
//
// 输出：0 
//
// 解释： 
//
// 不存在有效的选择方案。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 至少存在一个元素 i 满足 nums[i] == 0 。 
// 
//
// Related Topics 数组 前缀和 模拟 👍 1 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3354.使数组元素等于零.make-array-elements-equal-to-zero
 *
 * @author db117
 * @since 2024-11-20 16:06:34
 **/

public class Solution_3354 {
    public static void main(String[] args) {
        Solution solution = new Solution_3354().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countValidSelections(int[] nums) {
            int ans = 0;
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int left = 0;
            for (int num : nums) {
                if (num == 0) {
                    // 右边的和
                    int right = sum - left;
                    if (left == right) {
                        // 两边相等，往哪个反向走都可以
                        ans += 2;
                    }
                    if (left + 1 == right) {
                        // 往左边走，可以
                        ans++;
                    }
                    if (left - 1 == right) {
                        ans++;
                    }
                }
                left += num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}