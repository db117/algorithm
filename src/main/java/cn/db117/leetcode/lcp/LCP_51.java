


//欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
//
//勇者背包内共有编号为 `0 ~ 4` 的五种食材，其中 `materials[j]` 表示第 `j` 种食材的数量。通过这些食材可以制作若干料理，`
//cookbooks[i][j]` 表示制作第 `i` 种料理需要第 `j` 种食材的数量，而 `attribute[i] = [x,y]` 表示第 `i` 道料理的美味
//度 `x` 和饱腹感 `y`。
//
//在饱腹感不小于 `limit` 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 `-1`。
//
//**注意：**
//- 每种料理只能制作一次。
//
//
//**示例 1：**
//>输入：`materials = [3,2,4,1,2]`
//>`cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]`
//>`attribute = [[3,2],[2,4],[7,6]]`
//>`limit = 5`
//>
//>输出：`7`
//>
//>解释：
//>食材数量可以满足以下两种方案：
//>方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2
//>方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7
//>因此在满足饱腹感的要求下，可获得最高美味度 7
//
//**示例 2：**
//>输入：`materials = [10,10,10,10,10]`
//>`cookbooks = [[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]`
//>`attribute = [[5,5],[6,6],[10,10]]`
//>`limit = 1`
//>
//>输出：`11`
//>
//>解释：通过制作料理 0 和 1，可满足饱腹感，并获得最高美味度 11
//
//**提示：**
//+ `materials.length == 5`
//+ `1 <= cookbooks.length == attribute.length <= 8`
//+ `cookbooks[i].length == 5`
//+ `attribute[i].length == 2`
//+ `0 <= materials[i], cookbooks[i][j], attribute[i][j] <= 20`
//+ `1 <= limit <= 100`
// Related Topics 位运算 数组 回溯 枚举 👍 9 👎 0


package cn.db117.leetcode.lcp;

/**
 * LCP 51.烹饪料理.UEcfPD
 *
 * @author db117
 * @since 2022-07-19 16:19:51
 **/

public class LCP_51 {
    public static void main(String[] args) {
        Solution solution = new LCP_51().new Solution();
//        System.out.println(solution.perfectMenu(new int[]{3, 2, 4, 1, 2},
//                new int[][]{{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}},
//                new int[][]{{3, 2}, {2, 4}, {7, 6}},
//                5));

        // [10,10,10,10,10]
        //[[1,1,1,1,1],[3,3,3,3,3],[10,10,10,10,10]]
        //[[5,5],[6,6],[10,10]]
        //1
        // 11
//        System.out.println(solution.perfectMenu(new int[]{10, 10, 10, 10, 10},
//                new int[][]{{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {10, 10, 10, 10, 10}},
//                new int[][]{{5, 5}, {6, 6}, {10, 10}},
//                1));


        // [17,9,18,1,16]
        //[[13,20,10,0,13],[20,14,17,16,18],[1,11,9,12,2],[14,5,0,1,7],[2,3,3,17,12]]
        //[[9,20],[1,8],[13,8],[15,13],[20,14]]
        //57
        // -1
        System.out.println(solution.perfectMenu(new int[]{17, 9, 18, 1, 16},
                new int[][]{{13, 20, 10, 0, 13}, {20, 14, 17, 16, 18}, {1, 11, 9, 12, 2}, {14, 5, 0, 1, 7}, {2, 3, 3, 17, 12}},
                new int[][]{{9, 20}, {1, 8}, {13, 8}, {15, 13}, {20, 14}},
                57));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
            // 使用 bit 标记选中的可能
            int count = (1 << attribute.length) - 1;
            int ans = -1;
            for (int i = 1; i <= count; i++) {
                int[] tmp = materials.clone();
                int cur = 0;
                int curLimit = 0;
                // 是否能达标
                boolean flag = true;
                for (int k = 0, cookbooksLength = cookbooks.length; k < cookbooksLength; k++) {
                    if ((1 << k & i) == 0) {
                        // 当前有没有选择
                        continue;
                    }
                    int[] cookbook = cookbooks[k];
                    int[] attr = attribute[k];
                    for (int j = 0; j < 5; j++) {
                        if (tmp[j] < cookbook[j]) {
                            flag = false;
                            break;
                        } else {
                            tmp[j] -= cookbook[j];
                        }
                    }
                    if (!flag) {
                        break;
                    }
                    cur += attr[0];
                    curLimit += attr[1];
                }
                if (curLimit < limit) {
                    continue;
                }
                if (flag) {
                    ans = Math.max(ans, cur);
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}