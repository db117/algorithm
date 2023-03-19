

//给定一个由整数数组组成的数组arrays，其中arrays[i]是严格递增排序的，返回一个表示所有数组之间的最长公共子序列的整数数组。 
//
// 子序列是从另一个序列派生出来的序列，删除一些元素或不删除任何元素，而不改变其余元素的顺序。 
//
// 示例1: 
//
// 
//输入: arrays = [[1,3,4],
//               [1,4,7,9]]
//输出: [1,4]
//解释: 这两个数组中的最长子序列是[1,4]。
// 
//
// 示例 2: 
//
// 
//输入: arrays = [[2,3,6,8],
//               [1,2,3,5,6,7,10],
//               [2,3,4,6,9]]
//输出: [2,3,6]
//解释: 这三个数组中的最长子序列是[2,3,6]。
// 
//
// 示例 3: 
//
// 
//输入: arrays = [[1,2,3,4,5],
//               [6,7,8]]
//输出: []
//解释: 这两个数组之间没有公共子序列。
// 
//
// 
//
// 限制条件: 
//
// 
// 2 <= arrays.length <= 100 
// 1 <= arrays[i].length <= 100 
// 1 <= arrays[i][j] <= 100 
// arrays[i] 是严格递增排序. 
// 
//
// Related Topics 数组 哈希表 计数 👍 5 👎 0


package cn.db117.leetcode.solution19;

import java.util.ArrayList;
import java.util.List;

/**
 * 1940.排序数组之间的最长公共子序列.longest-common-subsequence-between-sorted-arrays
 *
 * @author db117
 * @since 2023-03-16 15:32:56
 **/

public class Solution_1940 {
    public static void main(String[] args) {
        Solution solution = new Solution_1940().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> longestCommonSubsequence(int[][] arrays) {
            List<Integer> ans = new ArrayList<>();
            int n = arrays.length;
            for (int i = 1; i <= 100; i++) {
                boolean flag = true;
                // 所有数组中都有值就是公共子序列
                for (int[] array : arrays) {
                    if (!bs(array, i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(i);
                }
            }
            return ans;
        }

        // 二分判断数组中是否有某个值
        private boolean bs(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                int num = arr[mid];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return arr[left] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}