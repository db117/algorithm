

//给你一个正整数数组 grades ，表示大学中一些学生的成绩。你打算将 所有 学生分为一些 有序 的非空分组，其中分组间的顺序满足以下全部条件： 
//
// 
// 第 i 个分组中的学生总成绩 小于 第 (i + 1) 个分组中的学生总成绩，对所有组均成立（除了最后一组）。 
// 第 i 个分组中的学生总数 小于 第 (i + 1) 个分组中的学生总数，对所有组均成立（除了最后一组）。 
// 
//
// 返回可以形成的 最大 组数。 
//
// 
//
// 示例 1： 
//
// 输入：grades = [10,6,12,7,3,5]
//输出：3
//解释：下面是形成 3 个分组的一种可行方法：
//- 第 1 个分组的学生成绩为 grades = [12] ，总成绩：12 ，学生数：1
//- 第 2 个分组的学生成绩为 grades = [6,7] ，总成绩：6 + 7 = 13 ，学生数：2
//- 第 3 个分组的学生成绩为 grades = [10,3,5] ，总成绩：10 + 3 + 5 = 18 ，学生数：3 
//可以证明无法形成超过 3 个分组。
// 
//
// 示例 2： 
//
// 输入：grades = [8,8]
//输出：1
//解释：只能形成 1 个分组，因为如果要形成 2 个分组的话，会导致每个分组中的学生数目相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grades.length <= 10⁵ 
// 1 <= grades[i] <= 10⁵ 
// 
//
// 👍 13 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2358.分组的最大数量.maximum-number-of-groups-entering-a-competition
 *
 * @author db117
 * @since 2022-08-01 14:46:35
 **/

public class Solution_2358 {
    public static void main(String[] args) {
        Solution solution = new Solution_2358().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGroups(int[] grades) {
            // 第一个条件没有用,或者说能满足第二个条件,第一个条件自然满足
            if (grades.length < 3) {
                return 1;
            }
            int left = 0, right = grades.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (helper(grades, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public boolean helper(int[] grades, int count) {
            int length = grades.length;
            int n = 0;
            for (int i = 0; i <= count; i++) {
                n += i;
            }
            return n <= length;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}