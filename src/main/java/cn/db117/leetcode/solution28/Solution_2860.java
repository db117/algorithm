

//给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生： 
//
// 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心： 
//
// 
// 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。 
// 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。 
// 
//
// 返回能够满足让所有学生保持开心的分组方法的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1]
//输出：2
//解释：
//有两种可行的方法：
//班主任没有选中学生。
//班主任选中所有学生形成一组。 
//如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
// 
//
// 示例 2： 
//
// 
//输入：nums = [6,0,3,3,6,7,2,7]
//输出：3
//解释：
//存在三种可行的方法：
//班主任选中下标为 1 的学生形成一组。
//班主任选中下标为 1、2、3、6 的学生形成一组。
//班主任选中所有学生形成一组。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] < nums.length 
// 
//
// 👍 6 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2860.让所有学生保持开心的分组方法数.happy-students
 *
 * @author db117
 * @since 2023-09-18 11:14:10
 **/

public class Solution_2860 {
    public static void main(String[] args) {
        Solution solution = new Solution_2860().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countWays(List<Integer> nums) {
            int n = nums.size();
            int ans = 0;
            // 计数
            int[] counter = new int[n];
            // 前缀和
            int[] pre = new int[n + 1];
            for (Integer integer : nums) {
                counter[integer]++;
            }
            for (int i = 1; i <= counter.length; i++) {
                pre[i] = counter[i - 1] + pre[i - 1];
            }

            // 相同数字要么都选中,要么都不选中
            // 当前数字选中,则后面的都不能选(算一种方法)
            int min = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                if (counter[i] == 0) {
                    continue;
                }
                // 选中当前学生,则后面的都不能选
                if (i < pre[i + 1] && pre[i + 1] < min) {
                    ans++;
                }
                min = Math.min(min, i);
            }

            // 如果没有 0 则可以全部都不选
            if (counter[0] == 0) {
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}