

//你需要设计一个文件系统，你可以创建新的路径并将它们与不同的值关联。 
//
// 路径的格式是一个或多个连接在一起的字符串，形式为： / ，后面跟着一个或多个小写英文字母。例如， " /leetcode" 和 "/leetcode/
//problems" 是有效路径，而空字符串 "" 和 "/" 不是。 
//
// 实现 FileSystem 类: 
//
// 
// 
// bool createPath(string path, int value) 创建一个新的 path ，并在可能的情况下关联一个 value ，然后返回
// true 。如果路径已经存在或其父路径不存在，则返回 false 。 
// int get(string path) 返回与 path 关联的值，如果路径不存在则返回 -1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入： 
//["FileSystem","create","get"]
//[[],["/a",1],["/a"]]
//输出： 
//[null,true,1]
//解释： 
//FileSystem fileSystem = new FileSystem();
//
//fileSystem.create("/a", 1); // 返回 true
//fileSystem.get("/a"); // 返回 1
// 
//
// 示例 2： 
//
// 
//输入： 
//["FileSystem","createPath","createPath","get","createPath","get"]
//[[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
//输出： 
//[null,true,true,2,false,-1]
//解释：
//FileSystem fileSystem = new FileSystem();
//
//fileSystem.createPath("/leet", 1); // 返回 true
//fileSystem.createPath("/leet/code", 2); // 返回 true
//fileSystem.get("/leet/code"); // 返回 2
//fileSystem.createPath("/c/d", 1); // 返回 false 因为父路径 "/c" 不存在。
//fileSystem.get("/c"); // 返回 -1 因为该路径不存在。
// 
//
// 
//
// 提示： 
//
// 
// 对两个函数的调用次数加起来小于等于 
// 10⁴ 
// 2 <= path.length <= 100 
// 1 <= value <= 10⁹ 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 34 👎 0


package cn.db117.leetcode.solution11;

import java.util.HashMap;
import java.util.Map;

/**
 * 1166.设计文件系统.design-file-system
 *
 * @author db117
 * @since 2023-10-30 11:07:40
 **/

public class Solution_1166 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FileSystem {
        Map<String, Integer> map = new HashMap<>();

        public FileSystem() {

        }

        public boolean createPath(String path, int value) {
            if (map.containsKey(path)) {
                return false;
            }
            int lastIndexOf = path.lastIndexOf("/");
            if (lastIndexOf != 0) {
                String parent = path.substring(0, lastIndexOf);
                if (!map.containsKey(parent)) {
                    // 父路径不存在
                    return false;
                }
            }
            map.put(path, value);
            return true;
        }

        public int get(String path) {
            return map.getOrDefault(path, -1);
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
//leetcode submit region end(Prohibit modification and deletion)

}