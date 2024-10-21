

//给你一个下标从 0 开始长度为 n 的整数数组 nums 和两个 正 整数 k 和 dist 。 
//
// 一个数组的 代价 是数组中的 第一个 元素。比方说，[1,2,3] 的代价为 1 ，[3,4,1] 的代价为 3 。 
//
// 你需要将 nums 分割成 k 个 连续且互不相交 的子数组，满足 第二 个子数组与第 k 个子数组中第一个元素的下标距离 不超过 dist 。换句话说，
//如果你将 nums 分割成子数组 nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)]
// ，那么它需要满足 ik-1 - i1 <= dist 。 
//
// 请你返回这些子数组的 最小 总代价。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,6,4,2], k = 3, dist = 3
//输出：5
//解释：将数组分割成 3 个子数组的最优方案是：[1,3] ，[2,6,4] 和 [2] 。这是一个合法分割，因为 ik-1 - i1 等于 5 - 2 = 
//3 ，等于 dist 。总代价为 nums[0] + nums[2] + nums[5] ，也就是 1 + 2 + 2 = 5 。
//5 是分割成 3 个子数组的最小总代价。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,1,2,2,2,1], k = 4, dist = 3
//输出：15
//解释：将数组分割成 4 个子数组的最优方案是：[10] ，[1] ，[2] 和 [2,2,1] 。这是一个合法分割，因为 ik-1 - i1 等于 3 - 
//1 = 2 ，小于 dist 。总代价为 nums[0] + nums[1] + nums[2] + nums[3] ，也就是 10 + 1 + 2 + 2 =
// 15 。
//分割 [10] ，[1] ，[2,2,2] 和 [1] 不是一个合法分割，因为 ik-1 和 i1 的差为 5 - 1 = 4 ，大于 dist 。
//15 是分割成 4 个子数组的最小总代价。
// 
//
// 示例 3： 
//
// 
//输入：nums = [10,8,18,9], k = 3, dist = 1
//输出：36
//解释：将数组分割成 4 个子数组的最优方案是：[10] ，[8] 和 [18,9] 。这是一个合法分割，因为 ik-1 - i1 等于 2 - 1 = 1 
//，等于 dist 。总代价为 nums[0] + nums[1] + nums[2] ，也就是 10 + 8 + 18 = 36 。
//分割 [10] ，[8,18] 和 [9] 不是一个合法分割，因为 ik-1 和 i1 的差为 3 - 1 = 2 ，大于 dist 。
//36 是分割成 3 个子数组的最小总代价。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 3 <= k <= n 
// k - 2 <= dist <= n - 2 
// 
//
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 15 👎 0


package cn.db117.leetcode.solution30;

import java.util.Map;
import java.util.TreeMap;

/**
 * 3013.将数组分成最小总代价的子数组 II.divide-an-array-into-subarrays-with-minimum-cost-ii
 *
 * @author db117
 * @since 2024-10-21 16:27:51
 **/

public class Solution_3013 {
    public static void main(String[] args) {
        Solution solution = new Solution_3013().new Solution();
        // [1,3,2,6,4,2]
        //			3
        //			3

        System.out.println(solution.minimumCost(new int[]{1, 3, 2, 6, 4, 2}, 3, 3));
        //			[10,1,2,2,2,1]
        //			4
        //			3
        solution = new Solution_3013().new Solution();
        System.out.println(solution.minimumCost(new int[]{10, 1, 2, 2, 2, 1}, 4, 3));
        //			[10,8,18,9]
        //			3
        //			1
        solution = new Solution_3013().new Solution();
        System.out.println(solution.minimumCost(new int[]{10, 8, 18, 9}, 3, 1));

        // [1,5,3,6]
        //			3
        //			2
        System.out.println(new Solution_3013().new Solution().minimumCost(new int[]{1, 5, 3, 6}, 3, 2));// 9

        // [1,5,3,7]
        //			3
        //			1
        System.out.println(new Solution_3013().new Solution().minimumCost(new int[]{1, 5, 3, 7}, 3, 1));// 9
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long minimumCost(int[] nums, int k, int dist) {
            // 对顶堆
            // 如果知道了第二段的第一个数的位置（记作 p），第三段的第一个数的位置，……，第 k 段的第一个数的位置（记作 q），那么这个划分方案也就确定了。
            //考虑到 q−p≤dist，本题相当于在一个大小固定为 dist+1 的滑动窗口内，求前 k−1 小的元素和。
            int n = nums.length;
            sum = nums[0];// 小顶堆的和

            for (int i = 1; i < dist + 2; i++) {
                sum += nums[i];
                add(nums[i], bigTop);
                bigTopSize++;
            }
            while (bigTopSize > k - 1) {
                big2Small();
            }
            long ans = sum;
            for (int i = dist + 2; i < n; i++) {
                // 滑动窗口开始移动
                int out = nums[i - dist - 1];
                if (bigTop.containsKey(out)) {
                    remove(out, bigTop);
                    bigTopSize--;
                    sum -= out;
                } else {
                    remove(out, smallTop);
                }

                int in = nums[i];
                if (bigTop.lastKey() >= in) {
                    add(in, bigTop);
                    sum += in;
                    bigTopSize++;
                } else {
                    add(in, smallTop);
                }

                // 确保小顶堆是最小的 k-1 个数字
                if (bigTopSize < k - 1) {
                    small2Big();
                }else if  (bigTopSize > k - 1) {
                    big2Small();
                }
                ans = Math.min(ans, sum);
            }
            return ans;
        }

        TreeMap<Integer, Integer> bigTop = new TreeMap<>();// 大顶堆,保存最小的 k - 1 个数字
        TreeMap<Integer, Integer> smallTop = new TreeMap<>();// 小顶堆，保存剩下的
        int bigTopSize = 0;
        long sum;

        private void big2Small() {
            Map.Entry<Integer, Integer> lasted = bigTop.lastEntry();
            remove(lasted.getKey(), bigTop);
            add(lasted.getKey(), smallTop);
            bigTopSize--;
            sum -= lasted.getKey();
        }

        private void small2Big() {
            Map.Entry<Integer, Integer> firsted = smallTop.firstEntry();
            remove(firsted.getKey(), smallTop);
            add(firsted.getKey(), bigTop);
            bigTopSize++;
            sum += firsted.getKey();
        }

        private void remove(int num, TreeMap<Integer, Integer> map) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        private void add(int num, TreeMap<Integer, Integer> map) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}