

//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 
//d 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 数组 哈希表 👍 53 👎 0


package cn.db117.leetcode.solution17;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726.同积元组.tuple-with-same-product
 *
 * @author db117
 * @since 2023-10-19 10:09:23
 **/

public class Solution_1726 {
    public static void main(String[] args) {
        Solution solution = new Solution_1726().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tupleSameProduct(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            // 两两组合,找到所有可能的乘机
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int key = nums[i] * nums[j];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            for (Integer value : map.values()) {
                if (value < 2) {
                    continue;
                }
                // 一旦乘机相同,则可以组成4个元素的元组
                // 每个元组有8种排列
                ans += (value * (value - 1) / 2) * 8;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}