

//给你一个整数数组 nums 。 
//
// 如果数组 nums 的一个分割满足以下条件，我们称它是一个 美丽 分割： 
//
// 
// 数组 nums 分为三段 非空子数组：nums1 ，nums2 和 nums3 ，三个数组 nums1 ，nums2 和 nums3 按顺序连接可以得到 
//nums 。 
// 子数组 nums1 是子数组 nums2 的 前缀 或者 nums2 是 nums3 的 前缀。 
// 
//
// 请你返回满足以上条件的分割 数目 。 
//
// 子数组 指的是一个数组里一段连续 非空 的元素。 
//
// 前缀 指的是一个数组从头开始到中间某个元素结束的子数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,1,2,1] 
// 
//
// 输出：2 
//
// 解释： 
//
// 美丽分割如下： 
//
// 
// nums1 = [1] ，nums2 = [1,2] ，nums3 = [1] 。 
// nums1 = [1] ，nums2 = [1] ，nums3 = [2,1] 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4] 
// 
//
// 输出：0 
//
// 解释： 
//
// 没有美丽分割。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 50 
// 
//
// Related Topics 数组 动态规划 👍 9 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3388.统计数组中的美丽分割.count-beautiful-splits-in-an-array
 *
 * @author db117
 * @since 2024-12-20 10:58:55
 **/

public class Solution_3388 {
    public static void main(String[] args) {
        Solution solution = new Solution_3388().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautifulSplits(int[] nums) {
            int n = nums.length;
            // 预处理最长公共前缀
            int[][] lcp = new int[n + 1][n + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (nums[i] == nums[j]) {
                        lcp[i][j] = lcp[i + 1][j + 1] + 1;
                    }
                }
            }

            int ans = 0;
            // 枚举分割的情况
            for (int i = 1; i < n - 1; i++) {// 第二段的开始位置
                for (int j = i + 1; j < n; j++) {// 第三段的开始位置
                    if (i <= j - i && lcp[0][i] >= i) {
                        // 第一段是第二段的前缀
                        ans++;
                        continue;
                    }
                    if (lcp[i][j] >= j - i) {
                        // 第二段是第三段的前缀
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}