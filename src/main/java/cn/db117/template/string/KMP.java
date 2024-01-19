package cn.db117.template.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速找到字符串匹配的位置
 *
 * @author db117
 * @since 2024/1/19
 */
public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.KMPSearch("ababababca", "abababca"));
    }

    private int[] computePrefixFunction(char[] pattern) {
        int[] pi = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[j] != pattern[i]) {
                j = pi[j - 1];
            }
            if (pattern[j] == pattern[i]) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();
        int[] pi = computePrefixFunction(patternArr);
        int j = 0;
        for (int i = 0; i < textArr.length; i++) {
            while (j > 0 && textArr[i] != patternArr[j]) {
                j = pi[j - 1];
            }
            if (textArr[i] == patternArr[j]) {
                j++;
            }
            if (j == patternArr.length) {
                result.add(i - (j - 1));
                j = pi[j - 1];
            }
        }
        return result;
    }
}
