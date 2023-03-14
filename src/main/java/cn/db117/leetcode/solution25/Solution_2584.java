

//给你一个长度为 n 的整数数组 nums ，下标从 0 开始。 
//
// 如果在下标 i 处 分割 数组，其中 0 <= i <= n - 2 ，使前 i + 1 个元素的乘积和剩余元素的乘积互质，则认为该分割 有效 。 
//
// 
// 例如，如果 nums = [2, 3, 3] ，那么在下标 i = 0 处的分割有效，因为 2 和 9 互质，而在下标 i = 1 处的分割无效，因为 6
// 和 3 不互质。在下标 i = 2 处的分割也无效，因为 i == n - 1 。 
// 
//
// 返回可以有效分割数组的最小下标 i ，如果不存在有效分割，则返回 -1 。 
//
// 当且仅当 gcd(val1, val2) == 1 成立时，val1 和 val2 这两个值才是互质的，其中 gcd(val1, val2) 表示 
//val1 和 val2 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [4,7,8,15,3,5]
//输出：2
//解释：上表展示了每个下标 i 处的前 i + 1 个元素的乘积、剩余元素的乘积和它们的最大公约数的值。
//唯一一个有效分割位于下标 2 。 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [4,7,15,8,3,5]
//输出：-1
//解释：上表展示了每个下标 i 处的前 i + 1 个元素的乘积、剩余元素的乘积和它们的最大公约数的值。
//不存在有效分割。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 哈希表 数学 数论 👍 22 👎 0


package cn.db117.leetcode.solution25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2584.分割数组使乘积互质.split-the-array-to-make-coprime-products
 *
 * @author db117
 * @since 2023-03-13 11:06:40
 **/

public class Solution_2584 {
    public static void main(String[] args) {
        Solution solution = new Solution_2584().new Solution();
//        System.out.println(solution.findValidSplit(new int[]{4, 7, 15, 8, 3, 5}));
        System.out.println(solution.findValidSplit(new int[]{4, 7, 8, 15, 3, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findValidSplit(int[] nums) {
            int n = nums.length;
            // 找到某个质数出现的最左和最右边，分隔点必须在这个区间外
            // 某个质数出现的最左边
            Map<Integer, Integer> left = new HashMap<>();
            // 以 i 为起点的区间的右端点
            int[] right = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                // 分解质数
                for (int d = 2; d * d <= num; d++) {
                    if (num % d == 0) {// 质数
                        left.putIfAbsent(d, i);// 记录左端点
                        right[left.get(d)] = i;// 记录当前区间的右边界
                    }
                    while (num % d == 0) {// 把当前质数除完了
                        num /= d;
                    }
                }
                if (num > 1) {
                    // 最后还剩个质数
                    left.putIfAbsent(num, i);// 记录左端点
                    right[left.get(num)] = i;// 记录当前区间的右边界
                }
            }

            // 找出第一个点，不在区间内
            // 遍历出第一个左端点不在区间类的位置
            int maxR = 0;
            for (int i = 0; i < n; i++) {
                if (i > maxR) {// 当前左端点大于前面所欲的右端点
                    return maxR;
                }
                maxR = Math.max(maxR, right[i]);// 记录到当前位置时右端点的最大值
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}