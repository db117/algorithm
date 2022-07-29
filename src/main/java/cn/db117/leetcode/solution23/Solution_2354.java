

//给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。 
//
// 如果满足下述条件，则数对 (num1, num2) 是 优质数对 ： 
//
// 
// num1 和 num2 都 在数组 nums 中存在。 
// num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按
//位 与 操作。 
// 
//
// 返回 不同 优质数对的数目。 
//
// 如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。 
//
// 注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：5
//解释：有如下几个优质数对：
//- (3, 3)：(3 AND 3) 和 (3 OR 3) 的二进制表示都等于 (11) 。值为 1 的位数和等于 2 + 2 = 4 ，大于等于 k = 
//3 。
//- (2, 3) 和 (3, 2)： (2 AND 3) 的二进制表示等于 (10) ，(2 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等
//于 1 + 2 = 3 。
//- (1, 3) 和 (3, 1)： (1 AND 3) 的二进制表示等于 (01) ，(1 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等
//于 1 + 2 = 3 。
//所以优质数对的数目是 5 。 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1], k = 10
//输出：0
//解释：该数组中不存在优质数对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 60 
// 
//
// Related Topics 位运算 数组 哈希表 二分查找 👍 22 👎 0


package cn.db117.leetcode.solution23;

import java.util.HashSet;
import java.util.Set;

/**
 * 2354.优质数对的数目.number-of-excellent-pairs
 *
 * @author db117
 * @since 2022-07-29 18:18:30
 **/

public class Solution_2354 {
    public static void main(String[] args) {
        Solution solution = new Solution_2354().new Solution();
        // [1,2,3,1]
        //3
        System.out.println(solution.countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countExcellentPairs(int[] nums, int k) {
            // 脑筋急转弯
            // 去重
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            // 统计
            int[] count = new int[32];
            for (Integer num : set) {
                count[Integer.bitCount(num)]++;
            }

            long ans = 0;
            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count.length; j++) {
                    if (i + j >= k) {
                        // 两个数字的 1 的数量 大于等于 k 即可
                        ans += (long) count[i] * count[j];
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}