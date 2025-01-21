

//给你一个由 正整数 组成的数组 nums。 
//
// 如果一个数组 arr 满足 prod(arr) == lcm(arr) * gcd(arr)，则称其为 乘积等价数组 ，其中： 
//
// 
// prod(arr) 表示 arr 中所有元素的乘积。 
// gcd(arr) 表示 arr 中所有元素的最大公因数 (GCD)。 
// lcm(arr) 表示 arr 中所有元素的最小公倍数 (LCM)。 
// 
//
// 返回数组 nums 的 最长 乘积等价 子数组 的长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,1,2,1,1,1] 
// 
//
// 输出： 5 
//
// 解释： 
//
// 最长的乘积等价子数组是 [1, 2, 1, 1, 1]，其中 prod([1, 2, 1, 1, 1]) = 2， gcd([1, 2, 1, 1, 1]
//) = 1，以及 lcm([1, 2, 1, 1, 1]) = 2。 
//
// 示例 2： 
//
// 
// 输入： nums = [2,3,4,5,6] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 最长的乘积等价子数组是 [3, 4, 5]。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,2,3,1,4,5,1] 
// 
//
// 输出： 5 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 10 
// 
//
// Related Topics 数组 数学 枚举 数论 滑动窗口 👍 5 👎 0


package cn.db117.leetcode.solution34;

/**
 * 3411.最长乘积等价子数组.maximum-subarray-with-equal-products
 *
 * @author db117
 * @since 2025-01-20 18:16:17
 **/

public class Solution_3411 {
    public static void main(String[] args) {
        Solution solution = new Solution_3411().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxLength(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int pord = nums[i];
                int arrGcd = nums[i];
                int arrLcm = nums[i];
                for (int j = i + 1; j < n; j++) {
                    arrGcd = gcd(arrGcd, nums[j]);
                    arrLcm = lcm(arrLcm, nums[j]);
                    pord = pord * nums[j];
                    if (pord == arrGcd * arrLcm) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }

            return ans;
        }


        // 最大公约数
        public static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }

            return gcd(b, a % b);
        }

        public static int lcm(int x, int y) {
            if (x == 0) {
                return y;
            } else if (y == 0) {
                return x;
            }

            return x * y / gcd(x, y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}