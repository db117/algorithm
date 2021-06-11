// 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 190 👎 0


package cn.db117.leetcode.solution8;

/**
 * 845.数组中的最长山脉.longest-mountain-in-array
 *
 * @author db117
 * @since 2021-06-11 17:15:20
 **/

public class Solution_845 {
    public static void main(String[] args) {
        Solution solution = new Solution_845().new Solution();
        System.out.println(solution.longestMountain(new int[]{
                0, 1, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMountain(int[] arr) {
            if (arr.length < 3) {
                return 0;
            }
            int left = 0, right = 0, ans = 0;

            while (right < arr.length - 1) {
                // 去掉重复值
                while (left + 1 < arr.length && arr[left] == arr[left + 1]) {
                    left++;
                }

                right = left;
                // 找到最高点
                while (right + 1 < arr.length && arr[right] < arr[right + 1]) {
                    right++;
                }
                // 最高点
                int top = right;
                // 找到最低点
                while (right + 1 < arr.length && arr[right] > arr[right + 1]) {
                    right++;
                }

                // 判断是否符合山脉特征
                if (right - left >= 2 &&
                        right != top /* 防止 right 是最大值*/ &&
                        left != top/* 防止 left 是最大值*/) {

                    // B.length >= 3
                    ans = Math.max(right - left + 1, ans);
                }

                // 下一段的起点是这一段的终点
                left = right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}