

//我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还
//会给出两个整数 numWanted 和 useLimit 。 
//
// 从 n 个元素中选择一个子集 s : 
//
// 
// 子集 s 的大小 小于或等于 numWanted 。 
// s 中 最多 有相同标签的 useLimit 项。 
// 
//
// 一个子集的 分数 是该子集的值之和。 
//
// 返回子集 s 的最大 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 
//输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length == labels.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= values[i], labels[i] <= 2 * 10⁴ 
// 1 <= numWanted, useLimit <= n 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 👍 30 👎 0


package cn.db117.leetcode.solution10;

import cn.db117.leetcode.util.Pair;

import java.util.*;

/**
 * 1090.受标签影响的最大值.largest-values-from-labels
 *
 * @author db117
 * @since 2023-05-22 17:49:28
 **/

public class Solution_1090 {
    public static void main(String[] args) {
        Solution solution = new Solution_1090().new Solution();
        // values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            int ans = 0;
            for (int i = 0; i < values.length; i++) {
                list.add(new Pair<>(values[i], labels[i]));
            }
            // 按照价值逆序排序
            list.sort(Comparator.comparing(pair -> -pair.getKey()));

            // 统计 label 数量
            Map<Integer, Integer> counter = new HashMap<>();

            for (Pair<Integer, Integer> pair : list) {
                if (numWanted == 0) {
                    break;
                }
                Integer label = pair.getValue();
                Integer value = pair.getKey();
                Integer count = counter.getOrDefault(label, 0);
                if (count >= useLimit) {// 当前 label 已经满了
                    continue;
                }
                ans += value;
                counter.put(label, count + 1);
                numWanted--;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}