

//给你一个整数 n 表示数轴上的房屋数量，编号从 0 到 n - 1 。 
//
// 另给你一个二维整数数组 offers ，其中 offers[i] = [starti, endi, goldi] 表示第 i 个买家想要以 goldi 枚
//金币的价格购买从 starti 到 endi 的所有房屋。 
//
// 作为一名销售，你需要有策略地选择并销售房屋使自己的收入最大化。 
//
// 返回你可以赚取的金币的最大数目。 
//
// 注意 同一所房屋不能卖给不同的买家，并且允许保留一些房屋不进行出售。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]]
//输出：3
//解释：
//有 5 所房屋，编号从 0 到 4 ，共有 3 个购买要约。
//将位于 [0,0] 范围内的房屋以 1 金币的价格出售给第 1 位买家，并将位于 [1,3] 范围内的房屋以 2 金币的价格出售给第 3 位买家。
//可以证明我们最多只能获得 3 枚金币。 
//
// 示例 2： 
//
// 
//输入：n = 5, offers = [[0,0,1],[0,2,10],[1,3,2]]
//输出：10
//解释：有 5 所房屋，编号从 0 到 4 ，共有 3 个购买要约。
//将位于 [0,2] 范围内的房屋以 10 金币的价格出售给第 2 位买家。
//可以证明我们最多只能获得 10 枚金币。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= offers.length <= 10⁵ 
// offers[i].length == 3 
// 0 <= starti <= endi <= n - 1 
// 1 <= goldi <= 10³ 
// 
//
// 👍 26 👎 0


package cn.db117.leetcode.solution28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2830.销售利润最大化.maximize-the-profit-as-the-salesman
 *
 * @author db117
 * @since 2023-08-22 10:39:25
 **/

public class Solution_2830 {
    public static void main(String[] args) {
        Solution solution = new Solution_2830().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            int size = offers.size();
            int[] f = new int[n + 1];// f[i]表示i-1 左边的最大值
            // 按照结束位置分组,记录开始位置和价格 ,按照结束位置排序
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (List<Integer> offer : offers) {
                map.putIfAbsent(offer.get(1), new ArrayList<>());
                map.get(offer.get(1)).add(new int[]{offer.get(0), offer.get(2)});
            }

            for (int i = 0; i < n; i++) {
                // 防止没有这个位置的价格
                f[i + 1] = f[i];
                List<int[]> ints = map.get(i);
                if (ints == null) {
                    continue;
                }
                // 当前位置结束的最大值，等于开始位置的最大值加上当前价格
                for (int[] anInt : ints) {
                    int start = anInt[0];
                    int price = anInt[1];
                    f[i + 1] = Math.max(f[i + 1], f[start] + price);
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}