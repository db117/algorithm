//特殊序列 是由 正整数 个 0 ，紧接着 正整数 个 1 ，最后 正整数 个 2 组成的序列。
//
// 
// 比方说，[0,1,2] 和 [0,0,1,1,1,2] 是特殊序列。 
// 相反，[2,1,0] ，[1] 和 [0,1,2,0] 就不是特殊序列。 
// 
//
// 给你一个数组 nums （仅 包含整数 0，1 和 2），请你返回 不同特殊子序列的数目 。由于答案可能很大，请你将它对 109 + 7 取余 后返回。 
//
//
// 一个数组的 子序列 是从原数组中删除零个或者若干个元素后，剩下元素不改变顺序得到的序列。如果两个子序列的 下标集合 不同，那么这两个子序列是 不同的 。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,2]
//输出：3
//解释：特殊子序列为 [0,1,2,2]，[0,1,2,2] 和 [0,1,2,2] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,0,0]
//输出：0
//解释：数组 [2,2,0,0] 中没有特殊子序列。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1,2,0,1,2]
//输出：7
//解释：特殊子序列包括：
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
//- [0,1,2,0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 2 
// 
// 👍 7 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1955.统计特殊子序列的数目.count-number-of-special-subsequences
 *
 * @author db117
 * @since 2021-08-02 11:17:27
 **/

public class Solution_1955 {
    public static void main(String[] args) {
        Solution solution = new Solution_1955().new Solution();
        System.out.println(solution.countSpecialSubsequences(new int[]{
                0, 1, 2, 0, 1, 2
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSpecialSubsequences(int[] nums) {
            int mod = 1_000_000_007;
            // 已经当前 0 结尾的所有序列数
            long a = 0;
            // 以当前 1 结尾的所有序列数
            long b = 0;
            // 以当前 2 结尾的所有序列数
            long c = 0;

            for (int num : nums) {
                if (num == 0) {
                    // 0 可以放在前面每一个已经产生的序列后面，也可以单独是一个序列
                    a = a * 2 + 1;
                    a %= mod;
                } else if (num == 1) {
                    // 1 可以放在前面每一个以 1 结尾的序列后面
                    // 也可以放在每一个以 0 结尾的序列后面
                    b = b * 2 + a;
                    b %= mod;
                } else {
                    // 与 1 同理
                    c = c * 2 + b;
                    c %= mod;
                }
            }
            return (int) c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}