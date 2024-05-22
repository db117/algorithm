

//给定一个有 n 个整数的数组 nums ，如果能找到满足以下条件的三元组 (i, j, k) 则返回 true ： 
//
// 
// 0 < i, i + 1 < j, j + 1 < k < n - 1 
// 子数组 (0, i - 1) ， (i + 1, j - 1) ， (j + 1, k - 1) ， (k + 1, n - 1) 的和应该相等。 
// 
//
// 这里我们定义子数组 (l, r) 表示原数组从索引为 l 的元素开始至索引为 r 的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1,2,1,2,1]
//输出: True
//解释:
//i = 1, j = 3, k = 5. 
//sum(0, i - 1) = sum(0, 0) = 1
//sum(i + 1, j - 1) = sum(2, 2) = 1
//sum(j + 1, k - 1) = sum(4, 4) = 1
//sum(k + 1, n - 1) = sum(6, 6) = 1
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,1,2,1,2,1,2]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// n == nums.length 
// 1 <= n <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 67 👎 0


package cn.db117.leetcode.solution5;

import java.util.HashSet;
import java.util.Set;

/**
 * 548.将数组分割成和相等的子数组.split-array-with-equal-sum
 *
 * @author db117
 * @since 2024-05-22 14:50:43
 **/

public class Solution_548 {
    public static void main(String[] args) {
        Solution solution = new Solution_548().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArray(int[] nums) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }

            // 先枚举中间的 j
            for (int j = 3; j < n - 1; j++) {
                // 记录前面可以存在的和
                Set<Integer> set = new HashSet<>();
                // 枚举 i
                for (int i = 1; i < j - 1; i++) {
                    // 前面两段和相等
                   if (pre[i] == pre[j] - pre[i + 1]) {
                       set.add(pre[i]);
                   }
                }

                // 枚举 k
                for (int k = j + 2; k < n - 1; k++) {
                    // 后面的两段和相等 而且前面的和存在
                    if (pre[k] - pre[j + 1] == pre[n] - pre[k + 1] && set.contains(pre[k] - pre[j + 1])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}