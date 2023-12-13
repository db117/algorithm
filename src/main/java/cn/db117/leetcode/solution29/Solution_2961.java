

//给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 
//。 
//
// 如果满足以下公式，则下标 i 是 好下标： 
//
// 
// 0 <= i < variables.length 
// ((aibi % 10)ci) % mi == target 
// 
//
// 返回一个由 好下标 组成的数组，顺序不限 。 
//
// 
//
// 示例 1： 
//
// 
//输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
//输出：[0,2]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(2³ % 10)³ % 10 = 2 。
//2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(3³ % 10)³ % 1 = 0 。
//3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(6¹ % 10)¹ % 4 = 2 。
//因此，返回 [0,2] 作为答案。
// 
//
// 示例 2： 
//
// 
//输入：variables = [[39,3,1000,1000]], target = 17
//输出：[]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(39³ % 10)¹⁰⁰⁰ % 1000 = 1 。
//因此，返回 [] 作为答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= variables.length <= 100 
// variables[i] == [ai, bi, ci, mi] 
// 1 <= ai, bi, ci, mi <= 10³ 
// 0 <= target <= 10³ 
// 
//
// Related Topics 数组 数学 模拟 👍 1 👎 0


package cn.db117.leetcode.solution29;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 2961.双模幂运算.double-modular-exponentiation
 *
 * @author db117
 * @since 2023-12-13 11:06:27
 **/

public class Solution_2961 {
    public static void main(String[] args) {
        Solution solution = new Solution_2961().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < variables.length; i++) {
                int[] variable = variables[i];
                if (check(variable, target)) {
                    ans.add(i);
                }
            }
            return ans;

        }

        private boolean check(int[] variable, int target) {
            BigInteger a = BigInteger.valueOf(variable[0]);
            BigInteger b = BigInteger.valueOf(variable[1]);
            BigInteger c = BigInteger.valueOf(variable[2]);
            BigInteger m = BigInteger.valueOf(variable[3]);
            BigInteger pow = a.pow(b.intValue());
            BigInteger mod = pow.mod(BigInteger.TEN);
            BigInteger pow1 = mod.pow(c.intValue());
            pow1 = pow1.mod(m);
            return pow1.intValue() == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}