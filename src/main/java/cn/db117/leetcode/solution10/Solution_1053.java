

//给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 
//arr 的最大排列。 
//
// 如果无法这么操作，就请返回原数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,2,1]
//输出：[3,1,2]
//解释：交换 2 和 1
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,5]
//输出：[1,1,5]
//解释：已经是最小排列
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,9,4,6,7]
//输出：[1,7,4,6,9]
//解释：交换 9 和 7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 48 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1053.交换一次的先前排列.previous-permutation-with-one-swap
 *
 * @author db117
 * @since 2023-04-02 23:55:09
 **/

public class Solution_1053 {
    public static void main(String[] args) {
        Solution solution = new Solution_1053().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int n = arr.length;
            for (int i = n - 2; i >= 0; i--) {
                int suf = -1;
                int sufMax = -1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        // 从后往前进行比对，发现第一个可以交换的数字
                        // 如果当前数字比后面大，交换后整个数组会变小
                        // 从后面找到最大的数字
                        if (arr[j] > sufMax) {
                            sufMax = arr[j];
                            suf = j;
                        }
                    }
                }
                if (sufMax != -1) {
                    int tmp = arr[i];
                    arr[i] = arr[suf];
                    arr[suf] = tmp;
                    return arr;
                }
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}