

//给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。 
//
// 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。 
//
// 请按身高 降序 顺序返回对应的名字数组 names 。 
//
// 
//
// 示例 1： 
//
// 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
//输出：["Mary","Emma","John"]
//解释：Mary 最高，接着是 Emma 和 John 。
// 
//
// 示例 2： 
//
// 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
//输出：["Bob","Alice","Bob"]
//解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
// 
//
// 
//
// 提示： 
//
// 
// n == names.length == heights.length 
// 1 <= n <= 10³ 
// 1 <= names[i].length <= 20 
// 1 <= heights[i] <= 10⁵ 
// names[i] 由大小写英文字母组成 
// heights 中的所有值互不相同 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 6 👎 0


package cn.db117.leetcode.solution24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2418.按身高排序.sort-the-people
 *
 * @author db117
 * @since 2022-09-27 17:28:13
 **/

public class Solution_2418 {
    public static void main(String[] args) {
        Solution solution = new Solution_2418().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < names.length; i++) {
                list.add(new Node(names[i], heights[i]));
            }

            list.sort(Comparator.comparing(node -> node.height));


            for (int i = 0; i < list.size(); i++) {
                names[names.length - 1 - i] = list.get(i).name;
            }

            return names;
        }

        class Node {
            String name;
            Integer height;

            public Node(String name, Integer height) {
                this.name = name;
                this.height = height;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}