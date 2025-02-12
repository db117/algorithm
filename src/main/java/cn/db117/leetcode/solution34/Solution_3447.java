

//给你一个整数数组 groups，其中 groups[i] 表示第 i 组的大小。另给你一个整数数组 elements。 
//
// 请你根据以下规则为每个组分配 一个 元素： 
//
// 
// 如果 groups[i] 能被 elements[j] 整除，则元素 j 可以分配给组 i。 
// 如果有多个元素满足条件，则分配下标最小的元素 j 。 
// 如果没有元素满足条件，则分配 -1 。 
// 
//
// 返回一个整数数组 assigned，其中 assigned[i] 是分配给组 i 的元素的索引，若无合适的元素，则为 -1。 
//
// 注意：一个元素可以分配给多个组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： groups = [8,4,3,2,4], elements = [4,2] 
// 
//
// 输出： [0,0,-1,1,0] 
//
// 解释： 
//
// 
// elements[0] = 4 被分配给组 0、1 和 4。 
// elements[1] = 2 被分配给组 3。 
// 无法为组 2 分配任何元素，分配 -1 。 
// 
//
// 示例 2： 
//
// 
// 输入： groups = [2,3,5,7], elements = [5,3,3] 
// 
//
// 输出： [-1,1,0,-1] 
//
// 解释： 
//
// 
// elements[1] = 3 被分配给组 1。 
// elements[0] = 5 被分配给组 2。 
// 无法为组 0 和组 3 分配任何元素，分配 -1 。 
// 
//
// 示例 3： 
//
// 
// 输入： groups = [10,21,30,41], elements = [2,1] 
// 
//
// 输出： [0,1,0,1] 
//
// 解释： 
//
// elements[0] = 2 被分配给所有偶数值的组，而 elements[1] = 1 被分配给所有奇数值的组。 
//
// 
//
// 提示： 
//
// 
// 1 <= groups.length <= 10⁵ 
// 1 <= elements.length <= 10⁵ 
// 1 <= groups[i] <= 10⁵ 
// 1 <= elements[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 2 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3447.将元素分配给有约束条件的组.assign-elements-to-groups-with-constraints
 *
 * @author db117
 * @since 2025-02-12 10:47:04
 **/

public class Solution_3447 {
    public static void main(String[] args) {
        Solution solution = new Solution_3447().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] assignElements(int[] groups, int[] elements) {
            int[] ans = new int[groups.length];

            int max = 0;
            // 存储每个数对应的下标
            for (int group : groups) {
                max = Math.max(max, group);
            }

            // 每个数字对应的最小下标
            int[] target = new int[max + 1];
            Arrays.fill(target, -1);

            for (int i = 0; i < elements.length; i++) {
                int k = elements[i];
                if (k > max || target[k] != -1) {
                    // 已经分配过或者大于最大值
                    continue;
                }

                for (int j = k; j <= max; j += k) {
                    if (target[j] == -1) {
                        // 把所有的能被k整除的数都分配给当前元素
                        target[j] = i;
                    }
                }
            }

            for (int i = 0; i < groups.length; i++) {
                ans[i] = target[groups[i]];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}