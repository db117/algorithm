

//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按
// 任意 顺序排列。
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
// 👍 2 👎 0


package cn.db117.leetcode.solution20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2032.至少在两个数组中出现的值.two-out-of-three
 *
 * @author db117
 * @since 2021-10-12 11:32:30
 **/

public class Solution_2032 {
    public static void main(String[] args) {
        Solution solution = new Solution_2032().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] tmp = new int[105];
            Arrays.stream(nums1).distinct().forEach(i -> tmp[i]++);
            Arrays.stream(nums2).distinct().forEach(i -> tmp[i]++);
            Arrays.stream(nums3).distinct().forEach(i -> tmp[i]++);

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] > 1) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}