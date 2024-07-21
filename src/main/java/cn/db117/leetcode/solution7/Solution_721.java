

//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", 
//"johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], [
//"Mary", "mary@mail.com"]]
//输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']
//,  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 示例 2： 
//
// 
//输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
//"Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
//"Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.
//co","Fern1@m.co","Fern0@m.co"]]
//输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co",
//"Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],[
//"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.
//co","Fern5@m.co"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= accounts.length <= 1000 
// 2 <= accounts[i].length <= 10 
// 1 <= accounts[i][j].length <= 30 
// accounts[i][0] 由英文字母组成 
// accounts[i][j] (for j > 0) 是有效的邮箱地址 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 排序 👍 517 👎 0


package cn.db117.leetcode.solution7;

import java.util.*;

/**
 * 721.账户合并.accounts-merge
 *
 * @author db117
 * @since 2024-07-15 19:23:40
 **/

public class Solution_721 {
    public static void main(String[] args) {
        Solution solution = new Solution_721().new Solution();
        // [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        System.out.println(solution.accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int size = accounts.size();
            List<List<String>> ans = new ArrayList<>();
            // 邮箱-》所有账户
            Map<String, List<Integer>> accountsMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                List<String> account = accounts.get(i);
                for (int j = 1; j < account.size(); j++) {// 不算第一个的名字
                    String s = account.get(j);
                    accountsMap.putIfAbsent(s, new ArrayList<>());
                    accountsMap.get(s).add(i);
                }
            }

            // 标记是否访问
            boolean[] flag = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (flag[i]) {
                    continue;
                }
                flag[i] = true;

                // bfs
                Deque<Integer> queue = new ArrayDeque<>();
                List<String> cur = new ArrayList<>();
                cur.add(accounts.get(i).get(0));
                ans.add(cur);
                queue.offerLast(i);
                Set<String> email = new HashSet<>();
                while (!queue.isEmpty()) {
                    Integer index = queue.poll();
                    List<String> strings = accounts.get(index);
                    for (int k = 1; k < strings.size(); k++) {
                        String string = strings.get(k);
                        email.add(string);
                        // 找到所有相同的邮箱
                        if (accountsMap.containsKey(string)) {
                            for (Integer j : accountsMap.get(string)) {
                                if (flag[j]) {
                                    continue;
                                }
                                flag[j] = true;
                                queue.offerLast(j);
                            }
                        }
                    }
                }
                // 排序
                ArrayList<String> emailList = new ArrayList<>(email);
                emailList.sort(Comparator.naturalOrder());
                cur.addAll(emailList);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}