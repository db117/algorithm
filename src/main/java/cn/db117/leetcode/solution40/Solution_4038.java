

//给你一个整数数组 nums。 
//
// 如果整数 x 在 nums 中的所有出现位置都位于同一个 连续 区间内，则称 x 为 特殊整数。 
//
// 返回 nums 中 不同 特殊整数的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,2,1] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
// 1 出现在下标 0 和 3，形成了两个分离的区间，因此它不是特殊整数。 
// 2 在下标 [1, 2] 处形成一个连续区间，因此它是特殊整数。 
// 
//
// 因此，共有一个特殊整数。 
//
//
// 示例 2： 
//
// 
// 输入： nums = [3,3,1,2,2,1] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 
// 3 在下标 [0, 1] 处形成一个连续区间，因此它是特殊整数。 
// 1 出现在下标 2 和 5，形成了两个分离的区间，因此它不是特殊整数。 
// 2 在下标 [3, 4] 处形成一个连续区间，因此它是特殊整数。 
// 
//
// 因此，共有两个特殊整数。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution40;

import java.util.ArrayList;
import java.util.List;

/**
 * 4038.计算单个区间中出现的整数数量.count-integers-appearing-in-a-single-block
 *
 * @author db117
 * @since 2026-09-05 17:41:05
 **/

public class Solution_4038 {
    public static void main(String[] args) {
        Solution solution = new Solution_4038().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSpecialIntegers(int[] nums) {
            // 模拟
            int ans = 0;
            int n = nums.length;


            for (int i = 0; i <= 100; i++) {
                List<Integer> index = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (nums[j] == i) {
                        index.add(j);
                    }
                }
                if (!index.isEmpty()) {
                    int size = index.size();
                    boolean flag = true;
                    for (int j = 1; j < size; j++) {
                        if (index.get(j) - index.get(j - 1) != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans++;
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}