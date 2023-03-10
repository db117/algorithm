

//给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。 
//
// 示例: 
//
// 输入:
//v1 = [1,2]
//v2 = [3,4,5,6] 
//
//输出: [1,3,2,4,5,6]
//
//解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
//     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。 
//
// 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢? 
//
// 拓展声明： “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如： 
//
// 输入:
//[1,2,3]
//[4,5,6,7]
//[8,9]
//
//输出: [1,4,8,2,5,9,3,6,7].
// 
//
// Related Topics 设计 队列 数组 迭代器 👍 61 👎 0


package cn.db117.leetcode.solution2;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 281.锯齿迭代器.zigzag-iterator
 *
 * @author db117
 * @since 2023-03-06 15:24:06
 **/

public class Solution_281 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ZigzagIterator {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            // 优先队列
            for (int i = 0; i < v1.size(); i++) {
                queue.add(new int[]{i, 1, v1.get(i)});
            }
            for (int i = 0; i < v2.size(); i++) {
                queue.add(new int[]{i, 2, v2.get(i)});
            }
        }

        public int next() {
            return queue.poll()[2];
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}