

// 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
//
// 返回使 A 中的每个值都是唯一的最少操作次数。 
//
// 示例 1: 
//
// 输入：[1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 
//
// 示例 2: 
//
// 输入：[3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 40000 
// 0 <= A[i] < 40000 
// 
// Related Topics 贪心 数组 计数 排序 👍 186 👎 0


package cn.db117.leetcode.solution9;

/**
 * 945.使数组唯一的最小增量.minimum-increment-to-make-array-unique
 *
 * @author db117
 * @since 2021-10-08 17:39:18
 **/

public class Solution_945 {
    public static void main(String[] args) {
        Solution solution = new Solution_945().new Solution();
        System.out.println(solution.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minIncrementForUnique(int[] nums) {
            // 计数排序
            // 可优化，没有必要都弄怎么大的数字，可以先找最大值
            int[] count = new int[100001];

            for (int num : nums) {
                count[num]++;
            }

            int move = 0;
            for (int i = 0; i < count.length - 1; i++) {
                if (count[i] > 1) {
                    // 需要往后移动的数量
                    int cur = count[i] - 1;
                    // 往后移动
                    count[i + 1] += cur;

                    move += cur;
                }
            }

            // 处理溢出的，即移动完后大于 40000 的
            int other = count[100000] - 1;// 移动到当前位置已经算过了，只需要算往后移动的
            // 1,2,3....,other 累加
            move += (other + 1) * other / 2;

            return move;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}