


//给定两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// 
//
// 
// 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/ 
//
// Related Topics 数组 哈希表 计数排序 排序 👍 31 👎 0


package cn.db117.leetcode.office;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 剑指 Offer II 075.数组相对排序.0H97ZC
 *
 * @author db117
 * @since 2022-07-27 15:13:46
 **/

public class Offer_II075 {
    public static void main(String[] args) {
        Solution solution = new Offer_II075().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] ans = new int[arr1.length];
            // 计数排序
            int[] hash = new int[1001];
            // 在 arr2 中存在的数字
            boolean[] flag = new boolean[1001];
            for (int i : arr2) {
                flag[i] = true;
            }
            // 不在 arr2 中出现
            List<Integer> other = new ArrayList<>();
            for (int i : arr1) {
                hash[i]++;
                if (!flag[i]) {
                    other.add(i);
                }
            }
            other.sort(Comparator.naturalOrder());

            int index = 0;
            for (int i : arr2) {
                for (int j = 0; j < hash[i]; j++) {
                    ans[index++] = i;
                }
            }
            for (Integer i : other) {
                ans[index++] = i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}