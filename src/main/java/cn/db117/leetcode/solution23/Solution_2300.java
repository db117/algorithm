

//给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[
//j] 表示第 j 瓶药水的能量强度。 
//
// 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。 
//
// 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。 
//
// 
//
// 示例 1： 
//
// 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//输出：[4,0,3]
//解释：
//- 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
//- 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
//- 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
//所以返回 [4,0,3] 。
// 
//
// 示例 2： 
//
// 输入：spells = [3,1,2], potions = [8,5,8], success = 16
//输出：[2,0,2]
//解释：
//- 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
//- 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
//- 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
//所以返回 [2,0,2] 。
// 
//
// 
//
// 提示： 
//
// 
// n == spells.length 
// m == potions.length 
// 1 <= n, m <= 10⁵ 
// 1 <= spells[i], potions[i] <= 10⁵ 
// 1 <= success <= 10¹⁰ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 68 👎 0


package cn.db117.leetcode.solution23;

import java.util.Arrays;

/**
 * 2300.咒语和药水的成功对数.successful-pairs-of-spells-and-potions
 *
 * @author db117
 * @since 2023-11-10 17:25:48
 **/

public class Solution_2300 {
    public static void main(String[] args) {
        Solution solution = new Solution_2300().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length;
            int m = potions.length;
            int[] ans = new int[n];
            Arrays.sort(potions);

            // 二分查找
            for (int i = 0; i < n; i++) {
                int left = 0, right = m - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if ((long) spells[i] * potions[mid] >= success) {
                        right = mid;// 可能是答案
                    } else {
                        left = mid + 1;// 肯定不是
                    }
                }

                if ((long) spells[i] * potions[right] >= success) {// 可能都不满足
                    ans[i] = m - right;
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}