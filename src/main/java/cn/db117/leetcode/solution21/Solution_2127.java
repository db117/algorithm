

//一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。 
//
// 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会 
//是他自己。 
//
// 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。 
//
//
// 
//
// 示例 1： 
//
// 
//
// 输入：favorite = [2,2,1,2]
//输出：3
//解释：
//上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
//没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
//注意，公司也可以邀请员工 1，2 和 3 参加会议。
//所以最多参加会议的员工数目为 3 。
// 
//
// 示例 2： 
//
// 输入：favorite = [1,2,0]
//输出：3
//解释：
//每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
//座位安排同图 1 所示：
//- 员工 0 坐在员工 2 和 1 之间。
//- 员工 1 坐在员工 0 和 2 之间。
//- 员工 2 坐在员工 1 和 0 之间。
//参与会议的最多员工数目为 3 。
// 
//
// 示例 3： 
//
// 
//
// 输入：favorite = [3,0,1,4,1]
//输出：4
//解释：
//上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
//员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
//所以公司只能不邀请员工 2 。
//参加会议的最多员工数目为 4 。
// 
//
// 
//
// 提示： 
//
// 
// n == favorite.length 
// 2 <= n <= 10⁵ 
// 0 <= favorite[i] <= n - 1 
// favorite[i] != i 
// 
//
// Related Topics 深度优先搜索 图 拓扑排序 👍 116 👎 0


package cn.db117.leetcode.solution21;

import java.util.*;

/**
 * 2127.参加会议的最多员工数.maximum-employees-to-be-invited-to-a-meeting
 *
 * @author db117
 * @since 2023-11-01 09:55:34
 **/

public class Solution_2127 {
    public static void main(String[] args) {
        Solution solution = new Solution_2127().new Solution();
        // [2,2,1,2]
//        System.out.println(solution.maximumInvitations(new int[]{
//                2, 2, 1, 2
//        }));
        // 1,0,0,2,1,4,7,8,9,6,7,10,8
        // 6
        System.out.println(solution.maximumInvitations(new int[]{
                1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumInvitations(int[] favorite) {
            int n = favorite.length;
            int ans = 0;
            // 基环树

            Map<Integer, List<Integer>> map = new HashMap<>();
            // 记录入度
            int[] in = new int[n];
            for (int j : favorite) {
                in[j]++;
            }

            // 去掉所有的入度为 0 的节点，最后剩下的就是环
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < in.length; i++) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                // 建反图
                map.computeIfAbsent(favorite[poll], k -> new ArrayList<>()).add(poll);// 后面找最长链有用
                if (--in[favorite[poll]] == 0) {
                    queue.offer(favorite[poll]);
                }
            }

            // 剩下的就是环

            int ringMax = 0;
            int sumTow = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == 0) {
                    continue;
                }

                in[i] = 0;
                int ringSize = 1;
                int cur = favorite[i];
                while (cur != i) {
                    ringSize++;
                    in[cur] = 0;
                    cur = favorite[cur];
                }

                if (ringSize == 2) {
                    // 两个节点比较特殊,需要找到他们的最长链条
                    // 所有两个节点的都可以连接到一起
                    sumTow += dfs(map, i) + dfs(map, favorite[i]);
                } else {
                    // 如果环的大小大于 2 环上的节点都可以参加会议
                    ringMax = Math.max(ringMax, ringSize);
                }
            }

            return Math.max(ringMax, sumTow);
        }

        private int dfs(Map<Integer, List<Integer>> map, int index) {
            List<Integer> list = map.get(index);
            if (list == null) {
                return 1;
            }

            int ans = 0;
            for (Integer i : list) {
                ans = Math.max(ans, dfs(map, i));
            }
            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}