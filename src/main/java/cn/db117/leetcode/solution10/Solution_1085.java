

//给你一个正整数的数组 A。 
//
// 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。 
//
// 最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。 
//
// 
//
// 示例 1: 
//
// 
//输入：[34,23,1,24,75,33,54,8]
//输出：0
//解释：
//最小元素为 1 ，该元素各个数位上的数字之和 S = 1 ，是奇数所以答案为 0 。
// 
//
// 示例 2： 
//
// 
//输入：[99,77,33,66,55]
//输出：1
//解释：
//最小元素为 33 ，该元素各个数位上的数字之和 S = 3 + 3 = 6 ，是偶数所以答案为 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i] <= 100 
// 
// Related Topics 数组 数学 👍 7 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1085.最小元素各数位之和.sum-of-digits-in-the-minimum-number
 *
 * @author db117
 * @since 2022-05-16 20:05:34
 **/

public class Solution_1085 {
    public static void main(String[] args) {
        Solution solution = new Solution_1085().new Solution();
        System.out.println(solution.sumOfDigits(new int[]{34, 23, 1, 24, 75, 33, 54, 8}));
        System.out.println(solution.sumOfDigits(new int[]{99, 77, 33, 66, 55}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfDigits(int[] nums) {
            int[] arr = new int[101];
            for (int num : nums) {
                arr[num]++;
            }
            for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
                if (arr[i] != 0) {
                    int ans = 1;
                    int num = i;
                    while (num > 0) {
                        ans += num % 10;
                        num /= 10;
                    }
                    return ans % 2;
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}