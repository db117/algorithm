

//给你两个整数 n 和 k 。 
//
// 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。 
//
// 返回长度为 n 的 k-avoiding 数组的可能的最小总和。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, k = 4
//输出：18
//解释：设若 k-avoiding 数组为 [1,2,4,5,6] ，其元素总和为 18 。
//可以证明不存在总和小于 18 的 k-avoiding 数组。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 6
//输出：3
//解释：可以构造数组 [1,2] ，其元素总和为 3 。
//可以证明不存在总和小于 3 的 k-avoiding 数组。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 50 
// 
//
// 👍 9 👎 0


package cn.db117.leetcode.solution28;

import java.util.HashSet;
import java.util.Set;

/**
 * 2829.k-avoiding 数组的最小总和.determine-the-minimum-sum-of-a-k-avoiding-array
 *
 * @author db117
 * @since 2023-08-22 10:31:41
 **/

public class Solution_2829 {
    public static void main(String[] args) {
        Solution solution = new Solution_2829().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int n, int k) {
            int ans = 0;
            Set<Integer> set = new HashSet<>();

            // 模拟，从小到大，把不能用的数字放到set中
            for (int i = 1; i < 1000 && n > 0; i++) {
                if (set.contains(i)) {
                    continue;
                }
                ans += i;
                if (k > i) {
                    set.add(k - i);
                }
                n--;
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}