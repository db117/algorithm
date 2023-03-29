

//这是一个交互问题。 
//
// 您有一个升序整数数组，其长度未知。您没有访问数组的权限，但是可以使用 ArrayReader 接口访问它。你可以调用 ArrayReader.get(i)
//: 
//
// 
// 返回数组第iᵗʰ个索引(0-indexed)处的值(即secret[i])，或者 
// 如果 i 超出了数组的边界，则返回 2³¹ - 1 
// 
//
// 你也会得到一个整数 target。 
//
// 如果存在secret[k] == target，请返回索引 k 的值；否则返回 -1 
//
// 你必须写一个时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入: secret = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 存在在 nums 中，下标为 4
// 
//
// 示例 2： 
//
// 
//输入: secret = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不在数组中所以返回 -1 
//
// 
//
// 提示： 
//
// 
// 1 <= secret.length <= 10⁴ 
// -10⁴ <= secret[i], target <= 10⁴ 
// secret 严格递增 
// 
//
// Related Topics 数组 二分查找 交互 👍 63 👎 0


package cn.db117.leetcode.solution7;

/**
 * 702.搜索长度未知的有序数组.search-in-a-sorted-array-of-unknown-size
 *
 * @author db117
 * @since 2023-03-29 11:33:40
 **/

public class Solution_702 {
    public static void main(String[] args) {
        Solution solution = new Solution_702().new Solution();
        System.out.println(solution.search(new ArrayReader(), 5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int search(ArrayReader reader, int target) {
            // 简单二分
            int left = 0, right = (int) 10e4;
            while (left < right) {
                int mid = (left + right) / 2;
                int num = reader.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ArrayReader {
        //        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int[] arr = new int[]{2, 5};

        public int get(int index) {
            if (arr.length <= index) {
                return Integer.MAX_VALUE;
            }
            return arr[index];
        }

        ;
    }
}