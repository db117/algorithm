

//给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。 
//
// 你可以执行无限次下述运算： 
//
// 
// 选择一个之前未选过的下标 i ，并选择一个 严格小于 nums[i] 的质数 p ，从 nums[i] 中减去 p 。 
// 
//
// 如果你能通过上述运算使得 nums 成为严格递增数组，则返回 true ；否则返回 false 。 
//
// 严格递增数组 中的每个元素都严格大于其前面的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,9,6,10]
//输出：true
//解释：
//在第一次运算中：选择 i = 0 和 p = 3 ，然后从 nums[0] 减去 3 ，nums 变为 [1,9,6,10] 。
//在第二次运算中：选择 i = 1 和 p = 7 ，然后从 nums[1] 减去 7 ，nums 变为 [1,2,6,10] 。
//第二次运算后，nums 按严格递增顺序排序，因此答案为 true 。 
//
// 示例 2： 
//
// 
//输入：nums = [6,8,11,12]
//输出：true
//解释：nums 从一开始就按严格递增顺序排序，因此不需要执行任何运算。 
//
// 示例 3： 
//
// 
//输入：nums = [5,8,3]
//输出：false
//解释：可以证明，执行运算无法使 nums 按严格递增顺序排序，因此答案是 false 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// nums.length == n 
// 
//
// 👍 10 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2601.质数减法运算.prime-subtraction-operation
 *
 * @author db117
 * @since 2023-03-27 11:05:22
 **/

public class Solution_2601 {
    public static void main(String[] args) {
        Solution solution = new Solution_2601().new Solution();
        System.out.println(solution.primeSubOperation(new int[]{4, 9, 6, 10}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final static int MX = 1000;
        private final static int[] primes = new int[169];

        static {
            boolean[] flag = new boolean[MX + 1];
            primes[0] = 0;// 给个默认值
            int i = 1;
            for (int j = 2; j <= MX; j++) {
                if (!flag[j]) {
                    primes[i++] = j;
                    int k = j;
                    while (k <= MX) {
                        flag[k] = true;
                        k += j;
                    }
                }
            }
        }

        public boolean primeSubOperation(int[] nums) {
            int pre = 0;
            for (int num : nums) {
                if (num <= pre) {// 已经不合适了
                    return false;
                }
                // 贪心 从前到后把所欲值都减的最小
                // 找到可以减的最大值
                int pi = lowerBound(primes, num - pre);
                pre = num - primes[pi];
            }
            return true;
        }

        // 小于目标值的最大值
        public int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}