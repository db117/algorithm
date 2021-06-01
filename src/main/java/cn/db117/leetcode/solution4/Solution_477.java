// 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
//
// 给你一个整数数组 nums，请你计算并返回 nums 中任意两个数之间汉明距离的总和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,14,2]
//输出：6
//解释：在二进制表示中，4 表示为 0100 ，14 表示为 1110 ，2表示为 0010 。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,14,4]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 
// Related Topics 位运算 
// 👍 218 👎 0


package cn.db117.leetcode.solution4;

/**
 * 477.汉明距离总和.total-hamming-distance
 *
 * @author db117
 * @since 2021-06-01 14:38:13
 **/

public class Solution_477 {
    public static void main(String[] args) {
        Solution solution = new Solution_477().new Solution();
        System.out.println(solution.totalHammingDistance(new int[]{
                4, 14, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0;
            int[] count = new int[31];
            // 统计每一个位置1的数量
            for (int i = 0; i < 32; i++) {
                int tmp = 1 << i;
                for (int num : nums) {
                    if ((num & tmp) > 0) {
                        count[i]++;
                    }
                }
            }

            for (int i : count) {
                // 1 的数量 和 0 的数量的乘机  就是需要交换的次数
                ans += (nums.length - i) * i;
            }

            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public int totalHammingDistance(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    ans += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
            return ans;
        }
    }
}