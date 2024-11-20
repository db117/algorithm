

//给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。 
//
// 对于每个查询 queries[i]： 
//
// 
// 在 nums 的下标范围 [li, ri] 内选择一个下标子集。 
// 将选中的每个下标对应的元素值减 1。 
// 
//
// 零数组 是指所有元素都等于 0 的数组。 
//
// 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。 
//
// 数组的 子集 是对数组元素的选择（可能为空）。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,0,1], queries = [[0,2]] 
// 
//
// 输出： true 
//
// 解释： 
//
// 
// 对于 i = 0： 
// 
//
// 
// 选择下标子集 [0, 2] 并将这些下标处的值减 1。 
// 数组将变为 [0, 0, 0]，这是一个零数组。 
// 
// 
//
//
// 示例 2： 
//
// 
// 输入： nums = [4,3,2,1], queries = [[1,3],[0,2]] 
// 
//
// 输出： false 
//
// 解释： 
//
// 
// 对于 i = 0： 
// 
//
// 
// 选择下标子集 [1, 2, 3] 并将这些下标处的值减 1。 
// 数组将变为 [4, 2, 1, 0]。 
// 
// 
// 对于 i = 1：
// 
// 选择下标子集 [0, 1, 2] 并将这些下标处的值减 1。 
// 数组将变为 [3, 1, 0, 0]，这不是一个零数组。 
// 
// 
//
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= li <= ri < nums.length 
// 
//
// Related Topics 数组 前缀和 👍 1 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3355.零数组变换 I.zero-array-transformation-i
 *
 * @author db117
 * @since 2024-11-20 16:08:51
 **/

public class Solution_3355 {
    public static void main(String[] args) {
        Solution solution = new Solution_3355().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            // 差分数组
            int[] arr = new int[n + 2];
            for (int[] query : queries) {
                int l = query[0];
                int r = query[1] + 1;
                arr[l]++;
                arr[r]--;
            }
            int cur = 0;// 当前位置可以操作的次数
            for (int i = 0; i < n; i++) {
                cur += arr[i];
                if (nums[i] > cur) {
                    // 当前位置不可能变成 0
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}