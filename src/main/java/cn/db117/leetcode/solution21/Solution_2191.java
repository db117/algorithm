

//给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 
//。 
//
// 一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。 
//
// 另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。 
//
// 注意： 
//
// 
// 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。 
// nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。 
// 
//
// 
//
// 示例 1： 
//
// 输入：mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
//输出：[338,38,991]
//解释：
//将数字 991 按照如下规则映射：
//1. mapping[9] = 6 ，所有数位 9 都会变成 6 。
//2. mapping[1] = 9 ，所有数位 1 都会变成 8 。
//所以，991 映射的值为 669 。
//338 映射为 007 ，去掉前导 0 后得到 7 。
//38 映射为 07 ，去掉前导 0 后得到 7 。
//由于 338 和 38 映射后的值相同，所以它们的前后顺序保留原数组中的相对位置关系，338 在 38 的前面。
//所以，排序后的数组为 [338,38,991] 。
// 
//
// 示例 2： 
//
// 输入：mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]
//输出：[123,456,789]
//解释：789 映射为 789 ，456 映射为 456 ，123 映射为 123 。所以排序后数组为 [123,456,789] 。
// 
//
// 
//
// 提示： 
//
// 
// mapping.length == 10 
// 0 <= mapping[i] <= 9 
// mapping[i] 的值 互不相同 。 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] < 10⁹ 
// 
// Related Topics 排序 数组 👍 6 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2191.将杂乱无章的数字排序.sort-the-jumbled-numbers
 *
 * @author db117
 * @since 2022-03-07 11:29:55
 **/

public class Solution_2191 {
    public static void main(String[] args) {
        Solution solution = new Solution_2191().new Solution();

        System.out.println(Arrays.toString(solution.sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6},
                new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(solution.sortJumbled(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{789, 456, 123})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            int[][] arr = new int[nums.length][];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = new int[]{helper(mapping, nums[i]), nums[i]};
            }

            // Java 默认用TimSort 为稳定排序
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int[] ans = new int[nums.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = arr[i][1];
            }

            return ans;
        }

        private int helper(int[] mapping, int in) {
            int ans = 0;
            char[] chars = Integer.toString(in).toCharArray();
            for (char aChar : chars) {
                ans *= 10;
                ans += mapping[aChar - '0'];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}