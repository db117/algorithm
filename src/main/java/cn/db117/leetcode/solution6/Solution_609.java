//
// 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。
// 一组重复的文件至少包括二个具有完全相同内容的文件。
//
// 输入列表中的单个目录信息字符串的格式如下： 
//
// "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_conten
//t)" 
//
// 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_co
//ntent）在目录 root/d1/d2/.../dm 下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。 
//
// 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串： 
//
// "directory_path/file_name.txt" 
//
// 示例 1： 
//
// 输入：
//["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)
//", "root 4.txt(efgh)"]
//输出：  
//[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"
//]]
// 
//
// 
//
// 注： 
//
// 
// 最终输出不需要顺序。 
// 您可以假设目录名、文件名和文件内容只有字母和数字，并且文件内容的长度在 [1，50] 的范围内。 
// 给定的文件数量在 [1，20000] 个范围内。 
// 您可以假设在同一目录中没有任何文件或目录共享相同的名称。 
// 您可以假设每个给定的目录信息代表一个唯一的目录。目录路径和文件信息用一个空格分隔。 
// 
//
// 
//
// 超越竞赛的后续行动： 
//
// 
// 假设您有一个真正的文件系统，您将如何搜索文件？广度搜索还是宽度搜索？ 
// 如果文件内容非常大（GB级别），您将如何修改您的解决方案？ 
// 如果每次只能读取 1 kb 的文件，您将如何修改解决方案？ 
// 修改后的解决方案的时间复杂度是多少？其中最耗时的部分和消耗内存的部分是什么？如何优化？ 
// 如何确保您发现的重复文件不是误报？ 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 68 👎 0


package cn.db117.leetcode.solution6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 609.在系统中查找重复文件.find-duplicate-file-in-system
 *
 * @author db117
 * @since 2021-07-01 11:53:17
 **/

public class Solution_609 {
    public static void main(String[] args) {
        Solution solution = new Solution_609().new Solution();
        // ["root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"]
        System.out.println(solution.findDuplicate(new String[]{
                "root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> map = new HashMap<>();
            for (String path : paths) {

                String[] split = path.split(" ");

                for (int i = 1; i < split.length; i++) {

                    // 找到括号的位置
                    int left = split[i].lastIndexOf('(');


                    String key = split[i].substring(left);
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }

                    map.get(key).add(split[0] + "/" + split[i].substring(0, left));
                }
            }

            return map.values()
                    .stream()
                    .filter(list -> list.size() > 1)
                    .collect(Collectors.toList());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}