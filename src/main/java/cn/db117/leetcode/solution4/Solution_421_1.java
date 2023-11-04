

//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 位运算 字典树 数组 哈希表 👍 643 👎 0


package cn.db117.leetcode.solution4;

import java.util.HashSet;
import java.util.Set;

/**
 * 421.数组中两个数的最大异或值.maximum-xor-of-two-numbers-in-an-array
 *
 * @author db117
 * @since 2023-11-04 23:31:25
 **/

public class Solution_421_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_421_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            int h = 31 - Integer.numberOfLeadingZeros(max);// 最高位的 1
            int mask = 0;// 方便去掉 i 后面的 1
            int ans = 0;
            Set<Integer> set = new HashSet<>();// 使用 set 去重,对前面的数据进行异或比较
            for (int i = h; i >= 0; i--) {
                set.clear();
                mask |= (1 << i);
                int newAns = ans | (1 << i);
                for (Integer num : nums) {
                    num &= mask;// 去掉 i 后面的 1
                    if (set.contains(newAns ^ num)) {// 如果存在 a ^ b = newAns 则说明当前位可以为 1
                        ans = newAns;
                        break;
                    }
                    set.add(num);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}