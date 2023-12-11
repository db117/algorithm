

//给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。 
//
// 在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 
//nums[j] 。 
//
// 返回执行任意次操作后能得到的 字典序最小的数组 。 
//
// 如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应元素比数组 b 中的对应元素的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如
//，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,3,9,8], limit = 2
//输出：[1,3,5,8,9]
//解释：执行 2 次操作：
//- 交换 nums[1] 和 nums[2] 。数组变为 [1,3,5,9,8] 。
//- 交换 nums[3] 和 nums[4] 。数组变为 [1,3,5,8,9] 。
//即便执行更多次操作，也无法得到字典序更小的数组。
//注意，执行不同的操作也可能会得到相同的结果。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,7,6,18,2,1], limit = 3
//输出：[1,6,7,18,1,2]
//解释：执行 3 次操作：
//- 交换 nums[1] 和 nums[2] 。数组变为 [1,6,7,18,2,1] 。
//- 交换 nums[0] 和 nums[4] 。数组变为 [2,6,7,18,1,1] 。
//- 交换 nums[0] 和 nums[5] 。数组变为 [1,6,7,18,1,2] 。
//即便执行更多次操作，也无法得到字典序更小的数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,7,28,19,10], limit = 3
//输出：[1,7,28,19,10]
//解释：[1,7,28,19,10] 是字典序最小的数组，因为不管怎么选择下标都无法执行操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= limit <= 10⁹ 
// 
//
// Related Topics 并查集 数组 排序 👍 24 👎 0


package cn.db117.leetcode.solution29;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2948.交换得到字典序最小的数组.make-lexicographically-smallest-array-by-swapping-elements
 *
 * @author db117
 * @since 2023-12-11 14:24:55
 **/

public class Solution_2948 {
    public static void main(String[] args) {
        Solution solution = new Solution_2948().new Solution();
        // [1,5,3,9,8]
        //			2
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(new int[]{
                1, 5, 3, 9, 8
        }, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
            // 分组排序 把相差小于 limit 的放到一组
            Integer[] ids = new Integer[n];
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
            // 按照值排序
            Arrays.sort(ids, Comparator.comparingInt(a -> nums[a]));

            // 分组排序
            for (int i = 0; i < n; ) {
                int start = i;// 当前组的开始
                i++;
                while (i < n && nums[ids[i]] - nums[ids[i - 1]] <= limit) {
                    i++;
                }
                // 当前组的结束 i-1
                // [start,i) 排序
                Integer[] temp = Arrays.copyOfRange(ids, start, i);
                Arrays.sort(temp);
                // 把排序后的放到结果中
                for (int j = 0; j < temp.length; j++) {
                    ans[temp[j]] = nums[ids[start + j]];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}