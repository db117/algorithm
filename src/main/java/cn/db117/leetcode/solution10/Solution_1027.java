// 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
//
// 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A
//.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。 
//
// 
//
// 示例 1： 
//
// 输入：[3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 输入：[9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 输入：[20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 2000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 138 👎 0


package cn.db117.leetcode.solution10;

import java.util.HashMap;
import java.util.Map;

/**
 * 1027.最长等差数列.longest-arithmetic-subsequence
 *
 * @author db117
 * @since 2021-07-09 16:12:22
 **/

public class Solution_1027 {
    public static void main(String[] args) {
        Solution solution = new Solution_1027().new Solution();

        System.out.println(solution.longestArithSeqLength(new int[]{
                3, 6, 9, 12
        }));
        System.out.println(solution.longestArithSeqLength(new int[]{
                9, 4, 7, 2, 10
        }));
        System.out.println(solution.longestArithSeqLength(new int[]{
                20, 1, 15, 3, 10, 5, 8
        }));
        System.out.println(solution.longestArithSeqLength(new int[]{// 2
                24, 13, 1, 100, 0, 94, 3, 0, 3
        }));
        System.out.println(solution.longestArithSeqLength(new int[]{// 2
                0, 8, 45, 88, 48, 68, 28, 55, 17, 24
        }));
        System.out.println(solution.longestArithSeqLength(new int[]{// 6
                44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63, 23, 43, 3, 12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23, 70, 51, 61, 21, 52, 25, 28
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            // 动态规划
            // 以当前数字为结尾，差为 key 的数量
            Map<Integer, Integer>[] arr = new HashMap[nums.length];

            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                arr[i] = new HashMap<>();
                for (int j = 0; j < i; j++) {
                    int diff = nums[i] - nums[j];
                    // 当前值与前面每一个值的差，找到连续的长度
                    // 前面存在当前差的情况，则在前面的基础基础上 加一
                    // 不存在就只有两个数字
                    int tmp = arr[j].containsKey(diff) ? arr[j].get(diff) + 1 : 2;
                    arr[i].put(diff, tmp);
                    max = Math.max(max, tmp);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}