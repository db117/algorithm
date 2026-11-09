

//给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [1, n] 内整数的一个 排列。 
//
// 同时给你一个长度为 n 的 二进制 数组 locked 和一个整数 k。 
//
// 
// locked[i] = 1 表示下标 i 已锁定。 
// locked[i] = 0 表示下标 i 已解锁。 
// 
//
// 你可以按 任意顺序 执行以下操作： 
//
// 
// 交换：选择一个下标 i，需满足下标 i 和 i + 1 当前都处于解锁状态，然后交换 nums[i] 和 nums[i + 1]。 
// 解锁：选择一个下标 i，满足 locked[i] = 1，并通过将 locked[i] = 0 来 永久 解锁它。 
// 
//
// 你可以执行任意次数的交换操作，但 最多 只能执行 k 次解锁操作。 
//
// 返回将 nums 排序为 严格递增 顺序所需的 最小总操作次数 。如果不可能，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [2,1,3,4], locked = [0,1,0,1], k = 1 
// 
//
// 输出： 2 
//
// 解释： 
//
// 
// 解锁下标 1。数组 locked 变为 [0,0,0,1]。 
// 交换 nums[0] 和 nums[1]。数组 nums 变为 [1,2,3,4]。 
// 
//
// 总操作次数为 1 + 1 = 2。 
//
//
// 示例 2： 
//
// 
// 输入： nums = [3,1,2], locked = [1,0,1], k = 2 
// 
//
// 输出： 4 
//
// 解释： 
//
// 
// 解锁下标 0 和 2。此时所有下标都已解锁。 
// 交换下标 0 和 1。数组 nums 变为 [1,3,2]。 
// 交换下标 1 和 2。数组 nums 变为 [1,2,3]。 
// 
//
// 总操作次数为 2 + 2 = 4。 
//
//
// 示例 3： 
//
// 
// 输入： nums = [2,3,1], locked = [1,0,0], k = 0 
// 
//
// 输出： -1 
//
// 解释： 
//
// 下标 0 被锁定，因此它的值无法被移动。由于 k = 0，无法解锁任何下标。因此，无法对数组进行排序。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length == locked.length <= 2000 
// 1 <= nums[i] <= n 
// 0 <= locked[i] <= 1 
// nums 是范围 [1, n] 内整数的一个排列。 
// 0 <= k <= n 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution40;

/**
 * 4099.将锁定数组排序的最少操作次数.minimum-operations-to-sort-with-locked-indices
 *
 * @author db117
 * @since 2026-11-09 22:30:38
 **/

public class Solution_4099 {
    public static void main(String[] args) {
        Solution solution = new Solution_4099().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int[] locked, int k) {
            int n = nums.length;
            int ans = 0;

            int unLocked = 0;
            for (int i = 0; i < n; i++) {
                if (locked[i] == 1) {
                    if (i + 1 != nums[i]) {// 需要解锁排序
                        unLocked++;
                    }
                }
            }
            if (unLocked > k) {
                // 解锁的不够
                return -1;
            }

            for (int ok = 1; ok <= n; ok++) {
                if (nums[ok - 1] == ok) {
                    // 有序
                    continue;
                }
                int index = -1;
                for (int i = 0; i < n; i++) {
                    if (nums[i] == ok) {
                        // 找到目标数字位置
                        index = i;
                        break;
                    }
                }

                for (int i = index - 1; i >= ok - 1; i--) {
                    // 向后移动
                    nums[i + 1] = nums[i];
                    ans++;
                    // 解锁
                    if (locked[i] == 1) {
                        ans++;
                        locked[i] = 0;
                        k--;
                    }
                    // 解锁
                    if (locked[i + 1] == 1) {
                        locked[i + 1] = 0;
                        k--;
                        ans++;
                    }
                    // 解锁不够
                    if (k < 0) {
                        return -1;
                    }
                }
                nums[ok - 1] = ok;

            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}