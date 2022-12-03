package cn.db117.template;

import java.util.*;

public class Other {


    /**
     * 列表排序需要次数
     *
     * @param list 列表
     * @return int 排序需要次数
     */
    private int listSortCount(List<Integer> list) {
        int ans = 0;
        List<Integer> tmp = new ArrayList<>(list);
        Collections.sort(tmp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.size(); i++) {
            map.put(tmp.get(i), i);
        }
        for (int i = 0; i < tmp.size(); i++) {
            if (Objects.equals(tmp.get(i), list.get(i))) {
                continue;
            }

            while (!Objects.equals(tmp.get(i), list.get(i))) {
                Integer integer = list.set(map.get(list.get(i)), list.get(i));
                list.set(i, integer);
                ans++;
            }

        }

        return ans;
    }
}
