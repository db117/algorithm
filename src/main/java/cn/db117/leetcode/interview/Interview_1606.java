//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
//
// 
//
// 示例： 
//
// 
//输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出：3，即数值对(11, 8)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 100000 
// -2147483648 <= a[i], b[i] <= 2147483647 
// 正确结果在区间 [0, 2147483647] 内 
// 
// Related Topics 数组 双指针 
// 👍 35 👎 0


package cn.db117.leetcode.interview;

import java.util.Arrays;

/**
 * 面试题 16.06.最小差.smallest-difference-lcci
 *
 * @author db117
 * @since 2021-06-24 11:22:23
 **/

public class Interview_1606 {
    public static void main(String[] args) {
        Solution solution = new Interview_1606().new Solution();

        System.out.println(solution.smallestDifference(new int[]{
                1, 3, 15, 11, 2
        }, new int[]{
                23, 127, 235, 19, 8
        }));
        System.out.println(solution.smallestDifference(new int[]{
                -2147483648, 1
        }, new int[]{
                2147483647, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            int indexA = 0, indexB = 0;
            // 转为 long 防止溢出
            long min = Math.abs((long) a[0] - b[0]);

            while (indexA < a.length && indexB < b.length) {
                // 保持 a < b 并比较绝对值
                while (indexA < a.length && a[indexA] < b[indexB]) {
                    indexA++;
                }

                if (indexA < a.length) {
                    min = Math.min(min, Math.abs((long) b[indexB] - a[indexA]));
                }
                if (indexA > 0) {
                    min = Math.min(min, Math.abs((long) b[indexB] - a[indexA - 1]));
                }
                if (indexA == a.length) {
                    break;
                }

                while (indexB < b.length && a[indexA] > b[indexB]) {
                    indexB++;
                }

                if (indexB > 0) {
                    min = Math.min(min, Math.abs((long) b[indexB - 1] - a[indexA]));
                }
                if (indexB < b.length) {
                    min = Math.min(min, Math.abs((long) b[indexB] - a[indexA]));
                }

                if (min == 0) {
                    // 有相等的直接结束
                    return 0;
                }
            }
            return (int) min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}