

//在某个数组 arr 中，值符合等差数列的数值规律：在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相
//等。 
//
// 我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组 arr。 
//
// 给你这个缺值的数组 arr，返回 被删除的那个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [5,7,11,13]
//输出：9
//解释：原来的数组是 [5,7,9,11,13]。
// 
//
// 示例 2： 
//
// 
//输入：arr = [15,13,12]
//输出：14
//解释：原来的数组是 [15,14,13,12]。 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 0 <= arr[i] <= 10⁵ 
// 给定的数组 保证 是一个有效的数组。 
// 
// Related Topics 数组 数学 👍 19 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1228.等差数列中缺失的数字.missing-number-in-arithmetic-progression
 *
 * @author db117
 * @since 2022-05-26 16:46:45
 **/

public class Solution_1228 {
    public static void main(String[] args) {
        Solution solution = new Solution_1228().new Solution();

        System.out.println(solution.missingNumber(new int[]{5, 7, 11, 13}));
        System.out.println(solution.missingNumber(new int[]{15, 13, 12}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] arr) {
            // 考虑等差位负数
            int diff = Math.min(Math.abs(arr[2] - arr[1]), Math.abs(arr[1] - arr[0]));
            if (arr[1] - arr[0] < 0) {
                diff = -diff;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] != diff) {
                    return arr[i] + diff;
                }
            }
            return arr[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}