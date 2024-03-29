

//如果元素 x 在长度为 m 的整数数组 arr 中满足 freq(x) * 2 > m ，那么我们称 x 是 支配元素 。其中 freq(x) 是 x 在数
//组 arr 中出现的次数。注意，根据这个定义，数组 arr 最多 只会有 一个 支配元素。 
//
// 给你一个下标从 0 开始长度为 n 的整数数组 nums ，数据保证它含有一个支配元素。 
//
// 你需要在下标 i 处将 nums 分割成两个数组 nums[0, ..., i] 和 nums[i + 1, ..., n - 1] ，如果一个分割满足以
//下条件，我们称它是 合法 的： 
//
// 
// 0 <= i < n - 1 
// nums[0, ..., i] 和 nums[i + 1, ..., n - 1] 的支配元素相同。 
// 
//
// 这里， nums[i, ..., j] 表示 nums 的一个子数组，它开始于下标 i ，结束于下标 j ，两个端点都包含在子数组内。特别地，如果 j <
// i ，那么 nums[i, ..., j] 表示一个空数组。 
//
// 请你返回一个 合法分割 的 最小 下标。如果合法分割不存在，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,2,2]
//输出：2
//解释：我们将数组在下标 2 处分割，得到 [1,2,2] 和 [2] 。
//数组 [1,2,2] 中，元素 2 是支配元素，因为它在数组中出现了 2 次，且 2 * 2 > 3 。
//数组 [2] 中，元素 2 是支配元素，因为它在数组中出现了 1 次，且 1 * 2 > 1 。
//两个数组 [1,2,2] 和 [2] 都有与 nums 一样的支配元素，所以这是一个合法分割。
//下标 2 是合法分割中的最小下标。 
//
// 示例 2： 
//
// 输入：nums = [2,1,3,1,1,1,7,1,2,1]
//输出：4
//解释：我们将数组在下标 4 处分割，得到 [2,1,3,1,1] 和 [1,7,1,2,1] 。
//数组 [2,1,3,1,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
//数组 [1,7,1,2,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
//两个数组 [2,1,3,1,1] 和 [1,7,1,2,1] 都有与 nums 一样的支配元素，所以这是一个合法分割。
//下标 4 是所有合法分割中的最小下标。 
//
// 示例 3： 
//
// 输入：nums = [3,3,3,3,7,2,2]
//输出：-1
//解释：没有合法分割。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// nums 有且只有一个支配元素。 
// 
//
// Related Topics 数组 哈希表 排序 👍 8 👎 0


package cn.db117.leetcode.solution27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2780.合法分割的最小下标.minimum-index-of-a-valid-split
 *
 * @author db117
 * @since 2023-07-18 17:42:22
 **/

public class Solution_2780 {
    public static void main(String[] args) {
        Solution solution = new Solution_2780().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumIndex(List<Integer> nums) {
            int most = 0;// 出现次数最多的数字
            int total = 0;// 总数
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                if (v * 2 > nums.size()) {
                    most = k;
                    total = v;
                }
            }

            // 找到最小的下标
            int cur = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == most) {
                    cur++;
                }
                // 一个个试就行
                if ((cur) * 2 > (i + 1) && (total - cur) * 2 > (nums.size() - i - 1)) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}