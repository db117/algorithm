


//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 658 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer 51.数组中的逆序对.shu-zu-zhong-de-ni-xu-dui-lcof
 *
 * @author db117
 * @since 2022-03-17 15:28:55
 **/

public class Offer_51 {
    public static void main(String[] args) {
        Solution solution = new Offer_51().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public int reversePairs(int[] nums) {
            // 归并排序
            margeSort(nums, 0, nums.length - 1);
            return count;
        }

        public void margeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                // 先排左边
                margeSort(arr, left, mid);
                // 在排右边
                margeSort(arr, mid + 1, right);
                // 合并排序
                marge(arr, left, mid, right);
            }
        }

        private void marge(int[] arr, int left, int mid, int right) {
            // 缓存数组
            int[] tmp = new int[right - left + 1];
            int i1 = left, i2 = mid + 1, i = 0;

            while (i1 <= mid && i2 <= right) {
                // 选这最小的数字放进缓存中
                if (arr[i1] <= arr[i2]) {
                    tmp[i++] = arr[i1++];
                } else {
                    // 和标准归并排序唯一的区别
                    // i1 以及后面所有的数字都比当前数字大,即符合题意
                    count += mid - i1 + 1;
                    tmp[i++] = arr[i2++];
                }
            }

            // 放剩余的数字
            while (i1 <= mid) {
                tmp[i++] = arr[i1++];
            }
            while (i2 <= right) {
                tmp[i++] = arr[i2++];
            }

            // 把缓存中的数字放入到原始数组中去
            System.arraycopy(tmp, 0, arr, left, tmp.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}