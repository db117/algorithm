

//新一轮的「力扣杯」编程大赛即将启动，为了动态显示参赛者的得分数据，需要设计一个排行榜 Leaderboard。 
//
// 请你帮忙来设计这个 Leaderboard 类，使得它有如下 3 个函数： 
//
// 
// addScore(playerId, score)： 
// 
//
// 
// 假如参赛者已经在排行榜上，就给他的当前得分增加 score 点分值并更新排行。 
// 假如该参赛者不在排行榜上，就把他添加到榜单上，并且将分数设置为 score。 
// 
// 
// top(K)：返回前 K 名参赛者的 得分总和。 
// reset(playerId)：将指定参赛者的成绩清零（换句话说，将其从排行榜中删除）。题目保证在调用此函数前，该参赛者已有成绩，并且在榜单上。 
//
//
// 请注意，在初始状态下，排行榜是空的。 
//
// 
//
// 示例 1： 
//
// 
//输入： 
//["Leaderboard","addScore","addScore","addScore","addScore","addScore","top",
//"reset","reset","addScore","top"]
//[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
//输出：
//[null,null,null,null,null,null,73,null,null,null,141]
//
//解释： 
//Leaderboard leaderboard = new Leaderboard ();
//leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5
//,4]];
//leaderboard.top(1);           // returns 73;
//leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
// 
//
// 
//
// 提示： 
//
// 
// 1 <= playerId, K <= 10000 
// 题目保证 K 小于或等于当前参赛者的数量 
// 1 <= score <= 100 
// 最多进行 1000 次函数调用 
// 
//
// Related Topics 设计 哈希表 排序 👍 42 👎 0


package cn.db117.leetcode.solution2;

import java.util.*;

/**
 * 1244.力扣排行榜.design-a-leaderboard
 *
 * @author db117
 * @since 2023-03-16 16:07:17
 **/

public class Solution_1244 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Leaderboard {
        // 人 -> 分数
        Map<Integer, Integer> playerMap = new HashMap<>();
        // 分数 -》 当前分数的人
        TreeMap<Integer, Set<Integer>> scoreMap = new TreeMap<>(Comparator.reverseOrder());// 倒序

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int old = playerMap.getOrDefault(playerId, 0);
            if (old > 0) {
                // 以前分数要去掉
                scoreMap.get(old).remove(playerId);
            }
            score += old;
            playerMap.put(playerId, score);
            // 加到新分数上
            scoreMap.putIfAbsent(score, new HashSet<>());
            scoreMap.get(score).add(playerId);
        }

        public int top(int k) {
            int ans = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : scoreMap.entrySet()) {
                Integer score = entry.getKey();
                Set<Integer> set = entry.getValue();
                // k 有可能比 set 小
                ans += score * (Math.min(k, set.size()));
                k -= set.size();
                if (k <= 0) {
                    break;
                }
            }
            return ans;
        }

        public void reset(int playerId) {
            Integer socre = playerMap.remove(playerId);
            scoreMap.get(socre).remove(playerId);
        }
    }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}