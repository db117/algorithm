

//请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。 
//
// 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。 
//
// 请你实现 RangeFreqQuery 类： 
//
// 
// RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。 
// int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频
//率 。 
// 
//
// 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续
//元素。 
//
// 
//
// 示例 1： 
//
// 输入：
//["RangeFreqQuery", "query", "query"]
//[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
//输出：
//[null, 1, 2]
//
//解释：
//RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 
//33, 22, 12, 34, 56]);
//rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
//rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], value <= 10⁴ 
// 0 <= left <= right < arr.length 
// 调用 query 不超过 10⁵ 次。 
// 
// Related Topics 数组 二分查找 👍 16 👎 0


package cn.db117.leetcode.solution20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2080.区间内查询数字的频率.range-frequency-queries
 *
 * @author db117
 * @since 2021-11-23 17:18:53
 **/

public class Solution_2080 {
    public static void main(String[] args) {
        RangeFreqQuery solution = new Solution_2080().new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(solution.query(1, 2, 4));
        System.out.println(solution.query(0, 11, 33));


        RangeFreqQuery solution1 = new Solution_2080().new RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
        System.out.println(solution1.query(0, 3, 5));
        System.out.println(solution1.query(5, 6, 2));
        System.out.println(solution1.query(6, 8, 4));
        System.out.println(solution1.query(2, 8, 3));
        System.out.println(solution1.query(4, 5, 1));
        System.out.println(solution1.query(2, 4, 2));


        // 解答失败: 测试用例:["RangeFreqQuery","query","query","query","query","query","query"] [[[8,4,2,5,4,5,8,6,2,3]],
        // [0,3,5],[5,6,2],[6,8,4],[2,8,3],[4,5,1],[2,4,2]] 测试结果:[null,1,0,3,0,0,1] 期望结果:[null,1,0,0,0,0,1] stdo
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RangeFreqQuery {
        // 缓存每一个数字出现的位置
        Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) {
                return 0;
            }
            // 找 value 在范围的最小位置
            int min = bsRightMin(list, left);
            // 在范围内的最大位置
            int max = bsLeftMax(list, right);

            if (max == -1 || min == -1) {
                // 在范围内没有找到
                return 0;
            }

            return max - min + 1;
        }

        public int bsRightMin(List<Integer> list, int target) {
            // 找到大于等于目标的最小值
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int mid = (right + left) / 2;

                if (target <= list.get(mid)) {
                    // 可能是要找的索引
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return list.get(right) >= target ? right : -1;
        }

        public int bsLeftMax(List<Integer> list, int target) {
            // 找小于等于目标的最大值
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int mid = (right + left + 1) / 2;

                if (list.get(mid) <= target) {
                    // 可能是要找的索引
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return list.get(left) <= target ? left : -1;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}