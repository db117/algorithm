// 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
//
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 贪心 数组 哈希表 堆（优先队列） 
// 👍 314 👎 0


package cn.db117.leetcode.solution6;

import java.util.HashMap;
import java.util.Map;

/**
 * 659.分割数组为连续子序列.split-array-into-consecutive-subsequences
 *
 * @author db117
 * @since 2021-06-28 17:19:26
 **/

public class Solution_659 {
    public static void main(String[] args) {
        Solution solution = new Solution_659().new Solution();

        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            // 每一个数字出现的次数
            Map<Integer, Integer> count = new HashMap<>();
            // 以当前数字结尾 -> 前面有的数字数量
            Map<Integer, Integer> endNum = new HashMap<>();

            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            for (int num : nums) {
                if (count.getOrDefault(num, 0) <= 0) {
                    // 数字已经用掉了
                    continue;
                }

                // 存在上一个数字结尾的序列
                if (endNum.getOrDefault(num - 1, 0) > 0) {
                    update(count, num, -1);
                    // 上一个数字结尾的数量 -1
                    update(endNum, num - 1, -1);
                    // 当前数字结尾的数量 +1
                    update(endNum, num, 1);

                    continue;
                }

                // 当前为第一个数字的情况
                if (count.getOrDefault(num + 1, 0) <= 0 || count.getOrDefault(num + 2, 0) <= 0) {
                    // 后面没有两个数字,不符合题意
                    return false;
                }
                // 三个数字都减去
                update(count, num, -1);
                update(count, num + 1, -1);
                update(count, num + 2, -1);
                // 以第三个数字结尾的次数 +1
                update(endNum, num + 2, 1);
            }
            return true;
        }

        private void update(Map<Integer, Integer> map, int key, int n) {
            map.put(key, map.getOrDefault(key, 0) + n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}