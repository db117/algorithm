

//首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。 
//
// 第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的： 
//
// 
// 假如一个元素小于它的左右邻居，那么该元素自增 1。 
// 假如一个元素大于它的左右邻居，那么该元素自减 1。 
// 首、尾元素 永不 改变。 
// 
//
// 过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：[6,2,3,4]
//输出：[6,3,3,4]
//解释：
//第一天，数组从 [6,2,3,4] 变为 [6,3,3,4]。
//无法再对该数组进行更多操作。
// 
//
// 示例 2： 
//
// 输入：[1,6,3,4,3,5]
//输出：[1,4,4,4,4,5]
//解释：
//第一天，数组从 [1,6,3,4,3,5] 变为 [1,5,4,3,4,5]。
//第二天，数组从 [1,5,4,3,4,5] 变为 [1,4,4,4,4,5]。
//无法再对该数组进行更多操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 100 
// 
// Related Topics 数组 模拟 👍 18 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1243.数组变换.array-transformation
 *
 * @author db117
 * @since 2022-05-27 15:21:34
 **/

public class Solution_1243 {
    public static void main(String[] args) {
        Solution solution = new Solution_1243().new Solution();
        // 2,2,1,1,1,2,2,1
        System.out.println(solution.transformArray(new int[]{2, 1, 2, 1, 1, 2, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> transformArray(int[] arr) {
            while (true) {
                boolean flag = true;
                // 需要备份一个，防止中间发生数据变更影响操作
                int[] tmp = arr.clone();
                for (int i = 1; i < arr.length - 1; i++) {
                    if (tmp[i - 1] < tmp[i] && tmp[i] > tmp[i + 1]) {
                        arr[i]--;
                        flag = false;
                    }
                    if (tmp[i - 1] > tmp[i] && tmp[i] < tmp[i + 1]) {
                        arr[i]++;
                        flag = false;
                    }
                }

                if (flag) {
                    break;
                }
            }

            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}