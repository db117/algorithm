

//给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。 
//
// 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 +
// (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。 
//
// 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//输出：[1,0,0,0,0]
//解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：arr1 = [0], arr2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：arr1 = [0], arr2 = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// arr1[i] 和 arr2[i] 都是 0 或 1 
// arr1 和 arr2 都没有前导0 
// 
//
// Related Topics 数组 数学 👍 90 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1073.负二进制数相加.adding-two-negabinary-numbers
 *
 * @author db117
 * @since 2023-05-18 13:50:46
 **/

public class Solution_1073 {
    public static void main(String[] args) {

        Solution solution = new Solution_1073().new Solution();
        // [1,1,1,1,1]
        //arr2 =
        //[1,0,1]

        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int n1 = arr1.length;
            int n2 = arr2.length;
            int max = Math.max(n1, n2);
            // 最左边是最小位数
            int[] arr = new int[max + 5];

            for (int i = 0; i < n1; i++) {
                arr[n1 - i - 1] += arr1[i];
            }
            for (int i = 0; i < n2; i++) {
                arr[n2 - i - 1] += arr2[i];
            }

            // 开始进位
            // 向下一位进 -1
            // 如果存在 -1 则相当于 当前位和下一位设为 1


            for (int i = 0; i < arr.length - 2; i++) {
                int num = arr[i];
                if (num == 0 || num == 1) {
                    continue;
                }

                if (num == -1) {
                    // 当前位的 -1 处理掉
                    arr[i] = 1;
                    arr[i + 1]++;
                } else {
                    // 进位了
                    arr[i] -= 2;
                    arr[i + 1]--;
                }
            }

            // 转换答案
            int len = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1) {
                    len = j + 1;
                }
            }

            int[] ans = new int[len];
            for (int i = len - 1; i >= 0; i--) {
                ans[len - 1 - i] = arr[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}