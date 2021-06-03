// 给你两个长度相等的整数数组，返回下面表达式的最大值：
//
// |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j| 
//
// 其中下标 i，j 满足 0 <= i, j < arr1.length。 
//
// 
//
// 示例 1： 
//
// 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
//输出：13
// 
//
// 示例 2： 
//
// 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
//输出：20 
//
// 
//
// 提示： 
//
// 
// 2 <= arr1.length == arr2.length <= 40000 
// -10^6 <= arr1[i], arr2[i] <= 10^6 
// 
// Related Topics 位运算 数学 
// 👍 46 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1131.绝对值表达式的最大值.maximum-of-absolute-value-expression
 *
 * @author db117
 * @since 2021-06-01 15:16:49
 **/

public class Solution_1131 {
    public static void main(String[] args) {
        Solution solution = new Solution_1131().new Solution();
        // [1,2,3,4]
        //				[-1,4,5,6] 13

        System.out.println(solution.maxAbsValExpr(new int[]{
                1, 2, 3, 4
        }, new int[]{
                -1, 4, 5, 6
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsValExpr(int[] arr1, int[] arr2) {
            // i j 可以替换
            // 一个四种可能性
            // (a1i-a2i-i)
            // (a1i-a2+i)
            // (a1i+a2i-i)
            // (a1i+a2i+i)


            int aMax = Integer.MIN_VALUE;//(a1i-a2i-i)
            int aMin = Integer.MAX_VALUE;

            int bMax = Integer.MIN_VALUE;//(a1i-a2+i)
            int bMin = Integer.MAX_VALUE;

            int cMax = Integer.MIN_VALUE;//(a1i+a2i-i)
            int cMin = Integer.MAX_VALUE;

            int dMax = Integer.MIN_VALUE;//(a1i+a2i+i)
            int dMin = Integer.MAX_VALUE;

            // 分别找到这4个表达式的最大值-最小值
            for (int i = 0; i < arr1.length; i++) {
                aMax = Math.max(aMax, arr1[i] - arr2[i] - i);
                aMin = Math.min(aMin, arr1[i] - arr2[i] - i);

                bMax = Math.max(bMax, arr1[i] - arr2[i] + i);
                bMin = Math.min(bMin, arr1[i] - arr2[i] + i);

                cMax = Math.max(cMax, arr1[i] + arr2[i] - i);
                cMin = Math.min(cMin, arr1[i] + arr2[i] - i);

                dMax = Math.max(dMax, arr1[i] + arr2[i] + i);
                dMin = Math.min(dMin, arr1[i] + arr2[i] + i);
            }

            // 取最大值
            return Math.max(aMax - aMin, Math.max(bMax - bMin, Math.max(cMax - cMin, dMax - dMin)));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}