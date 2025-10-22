

//给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。 
//
// 倍数 指能被 k 整除的任意正整数。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [8,2,3,4,6], k = 2 
// 
//
// 输出： 10 
//
// 解释： 
//
// 当 k = 2 时，其倍数为 2、4、6、8、10、12……，其中在 nums 中缺失的最小倍数是 10。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,4,7,10,15], k = 5 
// 
//
// 输出： 5 
//
// 解释： 
//
// 当 k = 5 时，其倍数为 5、10、15、20……，其中在 nums 中缺失的最小倍数是 5。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 1 <= k <= 100 
// 
//
// Related Topics 数组 哈希表 👍 2 👎 0


package cn.db117.leetcode.solution37;

import java.util.HashSet;
import java.util.Set;

/**
 * 3718.缺失的最小倍数.smallest-missing-multiple-of-k
 *
 * @author db117
 * @since 2025-10-22 17:40:08
 **/

public class Solution_3718 {
    public static void main(String[] args) {
        Solution solution = new Solution_3718().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingMultiple(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 1; ; i++) {
                if (!set.contains(i * k)) {

                    return i * k;

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}