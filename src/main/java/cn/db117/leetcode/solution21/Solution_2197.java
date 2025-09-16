

//给你一个整数数组 nums 。请你对数组执行下述操作： 
//
// 
// 从 nums 中找出 任意 两个 相邻 的 非互质 数。 
// 如果不存在这样的数，终止 这一过程。 
// 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。 
// 只要还能找出两个相邻的非互质数就继续 重复 这一过程。 
// 
//
// 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。 
//
// 生成的测试用例可以保证最终数组中的值 小于或者等于 10⁸ 。 
//
// 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。 
//
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [6,4,3,2,7,6,2]
//输出：[12,7,6]
//解释：
//- (6, 4) 是一组非互质数，且 LCM(6, 4) = 12 。得到 nums = [12,3,2,7,6,2] 。
//- (12, 3) 是一组非互质数，且 LCM(12, 3) = 12 。得到 nums = [12,2,7,6,2] 。
//- (12, 2) 是一组非互质数，且 LCM(12, 2) = 12 。得到 nums = [12,7,6,2] 。
//- (6, 2) 是一组非互质数，且 LCM(6, 2) = 6 。得到 nums = [12,7,6] 。
//现在，nums 中不存在相邻的非互质数。
//因此，修改后得到的最终数组是 [12,7,6] 。
//注意，存在其他方法可以获得相同的最终数组。
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [2,2,1,1,3,3,3]
//输出：[2,1,1,3]
//解释：
//- (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3,3] 。
//- (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3] 。
//- (2, 2) 是一组非互质数，且 LCM(2, 2) = 2 。得到 nums = [2,1,1,3] 。
//现在，nums 中不存在相邻的非互质数。 
//因此，修改后得到的最终数组是 [2,1,1,3] 。 
//注意，存在其他方法可以获得相同的最终数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 生成的测试用例可以保证最终数组中的值 小于或者等于 10⁸ 。 
// 
//
// Related Topics 栈 数组 数学 数论 👍 54 👎 0


package cn.db117.leetcode.solution21;

import java.util.LinkedList;
import java.util.List;

/**
 * 2197.替换数组中的非互质数.replace-non-coprime-numbers-in-array
 *
 * @author db117
 * @since 2025-09-16 19:52:31
 **/

public class Solution_2197 {
    public static void main(String[] args) {
        Solution solution = new Solution_2197().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int num : nums) {
                while (!queue.isEmpty() && gcd(queue.getLast(), num) > 1) {// 存在非公因数
                    num = lcm(queue.removeLast(), num);
                }
                queue.add(num);
            }
            return queue;
        }

        // 最大公约数
        private int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }

        // 最小公倍数
        private int lcm(int a, int b) {
            // 先除再乘。防止溢出
            return a / gcd(a, b) * b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}