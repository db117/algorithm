

//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：barcodes = [1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 
//输入：barcodes = [1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 103 👎 0


package cn.db117.leetcode.solution10;

import cn.db117.leetcode.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1054.距离相等的条形码.distant-barcodes
 *
 * @author db117
 * @since 2023-05-12 15:08:47
 **/

public class Solution_1054 {
    public static void main(String[] args) {
        Solution solution = new Solution_1054().new Solution();
        System.out.println(Arrays.toString(solution.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getKey() - o1.getKey());
            // 题目保证有答案，那么最多的数字肯定没有超过呀一半
            // 记录每个数字出现的次数
            int[] arr = new int[10001];
            for (int barcode : barcodes) {
                arr[barcode]++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    queue.add(new Pair<>(arr[i], i));
                }
            }

            for (int i = 0; i < barcodes.length; i++) {
                // 剩余最多的
                Pair<Integer, Integer> first = queue.poll();
                if (i - 1 >= 0 && first.getValue().equals(barcodes[i - 1])) {
                    // 前面有一样的数据，那就找第二多的
                    Pair<Integer, Integer> second = queue.poll();
                    barcodes[i] = second.getValue();
                    if (second.getKey() > 1) {
                        queue.add(new Pair<>(second.getKey() - 1, second.getValue()));
                    }
                    // 把第一多的在放回去
                    queue.add(first);
                } else {
                    barcodes[i] = first.getValue();
                    if (first.getKey() > 1) {
                        queue.add(new Pair<>(first.getKey() - 1, first.getValue()));
                    }
                }
            }
            return barcodes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}