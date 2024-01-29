

//给你一个 正整数 数组 nums 。 
//
// 你需要从数组中选出一个满足下述条件的子集： 
//
// 
// 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x², x⁴, ..., xᵏ/², xᵏ, xᵏ/², ..., x⁴
//, x², x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 
//8, 4, 2] 则不符合。 
// 
//
// 返回满足这些条件的子集中，元素数量的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,4,1,2,2]
//输出：3
//解释：选择子集 {4,2,2} ，将其放在数组 [2,4,2] 中，它遵循该模式，且 2² == 4 。因此答案是 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,4]
//输出：1
//解释：选择子集 {1}，将其放在数组 [1] 中，它遵循该模式。因此答案是 1 。注意我们也可以选择子集 {2} 、{4} 或 {3} ，可能存在多个子集都
//能得到相同的答案。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 4 👎 0


package cn.db117.leetcode.solution30;

import java.util.HashMap;
import java.util.Map;

/**
 * 3020.子集中元素的最大数量.find-the-maximum-number-of-elements-in-subset
 *
 * @author db117
 * @since 2024-01-29 14:45:32
 **/

public class Solution_3020 {
    public static void main(String[] args) {
        Solution solution = new Solution_3020().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums) {
            int ans = 1;
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            for (Integer key : count.keySet()) {
                if (key == 1) {
                    // 1 需要特殊处理
                    Integer one = count.get(key);
                    if (one % 2 == 0) {
                        ans = Math.max(ans, one - 1);
                    } else {
                        ans = Math.max(ans, one);
                    }
                    continue;
                }
                int cur = 1;
                int start = count.get(key);
                if (start < 2) {
                    continue;
                }


                int m = 2;
                while (count.containsKey((int) Math.pow(key, m))) {
                    cur++;
                    if (count.get((int) Math.pow(key, m)) < 2) {
                        break;
                    }
                    m *= 2;// 下一个数的指数
                }

                ans = Math.max(ans, (cur - 1) * 2 + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}