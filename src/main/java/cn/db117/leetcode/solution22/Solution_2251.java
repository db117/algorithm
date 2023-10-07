

//给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 
//starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。 
//
// 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//输出：[1,2,2,2]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：flowers = [[1,10],[3,3]], people = [3,3,2]
//输出：[2,2,1]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowers.length <= 5 * 10⁴ 
// flowers[i].length == 2 
// 1 <= starti <= endi <= 10⁹ 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 93 👎 0


package cn.db117.leetcode.solution22;

import java.util.*;

/**
 * 2251.花期内花的数目.number-of-flowers-in-full-bloom
 *
 * @author db117
 * @since 2023-09-28 10:54:07
 **/

public class Solution_2251 {
    public static void main(String[] args) {
        Solution solution = new Solution_2251().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            int n = people.length;
            int[] ans = new int[n];
            // 差分数组
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int[] flower : flowers) {
                int add = flower[0];
                int sub = flower[1] + 1;
                map.putIfAbsent(add, 0);
                map.putIfAbsent(sub, 0);
                map.put(add, map.get(add) + 1);
                map.put(sub, map.get(sub) - 1);
            }

            // 弄成list 好操作
            List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().toList();
            Integer[] id = new Integer[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            // 按照到达时间排序
            Arrays.sort(id, Comparator.comparingInt(o -> people[o]));

            // 把差分数组变成前缀和
            int idx = 0;
            int sum = 0;
            for (Integer i : id) {
                int time = people[i];// 到达时间
                // 找到第一个大于等于到达时间的
                while (idx < list.size() && time >= list.get(idx).getKey()) {
                    sum += list.get(idx).getValue();
                    idx++;
                }
                ans[i] = sum;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}