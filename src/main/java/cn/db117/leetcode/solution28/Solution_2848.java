

//给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 
//starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。 
//
// 返回数轴上被车 任意部分 覆盖的整数点的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [[3,6],[1,5],[4,7]]
//输出：7
//解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [[1,3],[5,8]]
//输出：7
//解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// nums[i].length == 2 
// 1 <= starti <= endi <= 100 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 15 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2848.与车相交的点.points-that-intersect-with-cars
 *
 * @author db117
 * @since 2024-04-10 17:01:37
 **/

public class Solution_2848 {
    public static void main(String[] args) {
        Solution solution = new Solution_2848().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            int n = nums.size();
            int[] sum = new int[102];
            // 差分数组
            for (List<Integer> list : nums) {
                sum[list.get(0)]++;
                sum[list.get(1) + 1]--;
            }

            int ans = 0;
            int s = 0;
            for (int i = 1; i <= 100; i++) {
                s += sum[i];
                if (s > 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}