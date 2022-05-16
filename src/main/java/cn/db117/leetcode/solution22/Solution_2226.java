

//给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆
// ，但 无法 再将两堆合并到一起。 
//
// 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。 
//
// 返回每个小孩可以拿走的 最大糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：candies = [5,8,6], k = 3
//输出：5
//解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分
//别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：candies = [2,5], k = 11
//输出：0
//解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 
//。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candies.length <= 10⁵ 
// 1 <= candies[i] <= 10⁷ 
// 1 <= k <= 10¹² 
// 
// Related Topics 数组 二分查找 👍 21 👎 0


package cn.db117.leetcode.solution22;

import java.util.Arrays;

/**
 * 2226.每个小孩最多能分到多少糖果.maximum-candies-allocated-to-k-children
 *
 * @author db117
 * @since 2022-04-07 17:06:29
 **/

public class Solution_2226 {
    public static void main(String[] args) {
        Solution solution = new Solution_2226().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 标准二分
        public int maximumCandies(int[] candies, long k) {
            int left = 0, right = Arrays.stream(candies).max().getAsInt();

            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (check(candies, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        private boolean check(int[] candies, long k, long n) {
            for (int candy : candies) {
                k -= candy / n;
                if (k <= 0) {
                    return true;
                }
            }

            return k <= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}