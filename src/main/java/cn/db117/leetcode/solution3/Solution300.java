package cn.db117.leetcode.solution3;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/9/8/008 16:33
 */
public class Solution300 {
    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{
                1, 3, 6, 7, 9, 4, 10, 5, 6
        }));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // 最小值都为1
        Arrays.fill(dp, 1);

        int max = 0;
        // 遍历前面的所以数字
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 当小于当前值时,取最大的数量
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    class Solution {
        // 二分 贪心 O(n*logn)
        public int lengthOfLIS(int[] nums) {
            int ans = 0;
            // 最长上升子序列（Longest  Increasing Subsequence）
            int[] lis = new int[nums.length];
            int index = 0;
            for (int num : nums) {
                if (index == 0) {
                    // 初始化子序列
                    lis[index++] = num;
                    continue;
                }

                if (num > lis[index - 1]) {
                    // 大于直接添加到尾部
                    lis[index++] = num;
                    continue;
                }


                // 二分找第一个大于当前值的索引
                int left = 0, right = index - 1;
                while (left < right) {
                    // 找左边中位数
                    int mid = (left + right) / 2;
                    if (lis[mid] < num) {
                        // 继续找右边的
                        left = mid + 1;
                    } else {
                        // 可能是目标
                        right = mid;
                    }
                }

                // 替换掉
                lis[right] = num;
            }

            return index;
        }
    }
}
