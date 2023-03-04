

//给你一个整数数组 nums ，返回其中 按位与三元组 的数目。 
//
// 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件： 
//
// 
// 0 <= i < nums.length 
// 0 <= j < nums.length 
// 0 <= k < nums.length 
// nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3]
//输出：12
//解释：可以选出如下 i, j, k 三元组：
//(i=0, j=0, k=1) : 2 & 2 & 1
//(i=0, j=1, k=0) : 2 & 1 & 2
//(i=0, j=1, k=1) : 2 & 1 & 1
//(i=0, j=1, k=2) : 2 & 1 & 3
//(i=0, j=2, k=1) : 2 & 3 & 1
//(i=1, j=0, k=0) : 1 & 2 & 2
//(i=1, j=0, k=1) : 1 & 2 & 1
//(i=1, j=0, k=2) : 1 & 2 & 3
//(i=1, j=1, k=0) : 1 & 1 & 2
//(i=1, j=2, k=0) : 1 & 3 & 2
//(i=2, j=0, k=1) : 3 & 2 & 1
//(i=2, j=1, k=0) : 3 & 1 & 2
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0]
//输出：27
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] < 2¹⁶ 
// 
//
// Related Topics 位运算 数组 哈希表 👍 134 👎 0


package cn.db117.leetcode.solution9;

/**
 * 982.按位与为零的三元组.triples-with-bitwise-and-equal-to-zero
 *
 * @author db117
 * @since 2023-03-04 21:44:04
 **/

public class Solution_982 {
    public static void main(String[] args) {
        Solution solution = new Solution_982().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] nums) {
            // 统计出 2 个数字出现的可能性
            int[] arr = new int[1 << 16];
            for (int i : nums) {
                for (int j : nums) {
                    arr[i & j]++;
                }
            }
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                // 遍历所有数字和 其他两个数字出现的可能性进行匹配
                for (int num : nums) {
                    if ((num & i) == 0) {
                        ans += arr[i];
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}