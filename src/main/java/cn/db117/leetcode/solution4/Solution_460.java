

//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// 最多调用 2 * 10⁵ 次 get 和 put 方法 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 711 👎 0


package cn.db117.leetcode.solution4;

import java.util.HashMap;
import java.util.Map;

/**
 * 460.LFU 缓存.lfu-cache
 *
 * @author db117
 * @since 2023-09-25 10:58:06
 **/

public class Solution_460 {
    public static void main(String[] args) {
        // ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //			[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        LFUCache lfu = new Solution_460().new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        Map<Integer, Node> freqMap = new HashMap<>();
        Map<Integer, Node> keyMap = new HashMap<>();
        int minFreq = 0;


        int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = getNode(key);
            if (node == null) {
                return -1;
            }
            return node.value;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
                return;
            }
            if (keyMap.size() >= capacity) {
                // 删除最小频率的
                Node mock = freqMap.get(minFreq);
                Node removed = mock.pre;
                keyMap.remove(removed.key);

                removeNode(removed);

                if (mock.pre == mock) {
                    // 如果是最后一个节点
                    freqMap.remove(mock.count);
                }
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            addFreqNode(newNode);
            minFreq = 1;// 新加入的节点频率为1
        }

        void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        Node getNode(int key) {
            Node node = keyMap.get(key);
            if (node == null) {
                return null;
            }
            // 从原来的频率中删除
            removeNode(node);
            Node mock = freqMap.get(node.count);
            if (mock.pre == mock) {
                // 如果是最后一个节点
                freqMap.remove(node.count);
                if (node.count == minFreq) {
                    // 如果是最小频率
                    minFreq++;
                }
            }
            node.count++;
            // 加入新的频率
            addFreqNode(node);
            return node;
        }

        private void addFreqNode(Node node) {

            freqMap.computeIfAbsent(node.count, k -> {
                // 哨兵节点
                Node node1 = new Node(-1, -1);
                node1.next = node1;
                node1.pre = node1;
                return node1;
            });
            Node mock = freqMap.get(node.count);
            // 加入到频率链表哨兵节点的后面
            node.next = mock.next;
            node.pre = mock;
            mock.next.pre = node;
            mock.next = node;
        }
    }

    class Node {
        int key;
        int value;
        int count = 1;// 访问次数

        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}