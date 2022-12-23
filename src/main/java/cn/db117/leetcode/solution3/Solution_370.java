

//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。 
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... 
//endIndex]（包括 startIndex 和 endIndex）增加 inc。 
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
//
// Related Topics 数组 前缀和 👍 148 👎 0


package cn.db117.leetcode.solution3;

/**
 * 370.区间加法.range-addition
 *
 * @author db117
 * @since 2022-12-23 10:21:14
 **/

public class Solution_370 {
    public static void main(String[] args) {
        Solution solution = new Solution_370().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            // 差分数组
            int[] diff = new int[length + 7];
            for (int[] update : updates) {
                diff[update[0]] += update[2];
                diff[update[1] + 1] -= update[2];
            }
            int[] ans = new int[length];
            ans[0] = diff[0];

            for (int i = 1; i < length; i++) {
                ans[i] = diff[i] + ans[i - 1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}