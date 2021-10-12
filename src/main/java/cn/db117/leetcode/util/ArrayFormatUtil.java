package cn.db117.leetcode.util;

import java.util.Scanner;

/**
 * 数组格式转换
 * 把 [] 转换为 {}
 *
 * @author db117
 * @date 2021/10/12
 */
public class ArrayFormatUtil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(s
                .replace("[", "{")
                .replace("]", "}")
        );
    }
}
