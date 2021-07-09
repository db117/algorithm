// 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
//
// 现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。 
//
// 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。 
//
// 示例： 
//
// 输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,1
//5,20,25,30]],[3],[12],[25],[15],[24],[8]]
//输出：[null,0,1,1,0,0,1]
//解释：
//时间为 3，票数分布情况是 [0]，编号为 0 的候选人领先。
//时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。
//时间为 25，票数分布情况是 [0,1,1,0,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。
//在时间 15、24 和 8 处继续执行 3 个查询。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= persons.length = times.length <= 5000 
// 0 <= persons[i] <= persons.length 
// times 是严格递增的数组，所有元素都在 [0, 10^9] 范围中。 
// 每个测试用例最多调用 10000 次 TopVotedCandidate.q。 
// TopVotedCandidate.q(int t) 被调用时总是满足 t >= times[0]。 
// 
// Related Topics 设计 数组 哈希表 二分查找 
// 👍 39 👎 0


package cn.db117.leetcode.solution9;

import java.util.HashMap;
import java.util.Map;

/**
 * 911.在线选举.online-election
 *
 * @author db117
 * @since 2021-07-09 10:34:54
 **/

public class Solution_911 {
    public static void main(String[] args) {
        TopVotedCandidate solution = new Solution_911().new TopVotedCandidate(new int[]{
                0, 1, 1, 0, 0, 1, 0
        }, new int[]{
                0, 5, 10, 15, 20, 25, 30
        });
// [3],[12],[25],[15],[24],[8]
        System.out.println(solution.q(3));
        System.out.println(solution.q(12));
        System.out.println(solution.q(25));
        System.out.println(solution.q(15));
        System.out.println(solution.q(24));
        System.out.println(solution.q(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TopVotedCandidate {
        // 对应每一个 time 对应的答案
        private int[] max;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            max = new int[times.length];
            this.times = times;
            // 人 -》 票数
            Map<Integer, Integer> hash = new HashMap<>();
            // 最多票数
            int maxCount = -1;
            // 当前得票最多的人
            int maxPerson = -1;
            for (int i = 0; i < persons.length; i++) {

                Integer count = hash.getOrDefault(persons[i], 0);
                count++;
                hash.put(persons[i], count);

                if (count >= maxCount) {
                    // 当前人是的票最多的人
                    maxCount = count;
                    maxPerson = persons[i];
                }

                // 当前时间得票最多的人
                max[i] = maxPerson;
            }
        }

        public int q(int t) {
            return max[bs(t)];
        }

        private int bs(int target) {
            // 在 times 中找到 小于等于 target 的最大值
            int left = 0, right = max.length - 1;

            while (left < right) {
                // 选择右边的
                int mid = left + (right - left + 1) / 2;
                if (times[mid] == target) {
                    return mid;
                } else if (times[mid] < target) {
                    left = mid;
                } else {
                    // mid 选择的是右边的
                    // 找到的必须小于等于 target
                    right = mid - 1;
                }

            }
            return right;
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}