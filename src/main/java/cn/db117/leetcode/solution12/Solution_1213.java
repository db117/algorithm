

//给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。 
//
// 
//
// 示例 1： 
//
// 
//输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//输出: [1,5]
//解释: 只有 1 和 5 同时在这三个数组中出现.
// 
//
// 示例 2: 
//
// 
//输入: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [52
//1,682,1337,1395,1764]
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length, arr3.length <= 1000 
// 1 <= arr1[i], arr2[i], arr3[i] <= 2000 
// 
// Related Topics 数组 哈希表 二分查找 计数 👍 34 👎 0


package cn.db117.leetcode.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1213.三个有序数组的交集.intersection-of-three-sorted-arrays
 *
 * @author db117
 * @since 2022-03-26 22:23:55
 **/

public class Solution_1213 {
    public static void main(String[] args) {
        Solution solution = new Solution_1213().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> ans = new ArrayList<>();
            int[] arr = new int[2001];

            for (int i : arr1) {
                arr[i]++;
            }
            for (int i : arr2) {
                arr[i]++;
            }
            for (int i : arr3) {
                arr[i]++;
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 3) {
                    ans.add(j);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}