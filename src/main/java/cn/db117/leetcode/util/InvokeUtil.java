package cn.db117.leetcode.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author db117
 * @since 2022/8/31 11:07
 **/
public class InvokeUtil {
    public static void main(String[] args) {
        // [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
        System.out.println(invoke("111\n" +
                "[1,2,3]", InvokeUtil.class.getMethods()[2], new InvokeUtil()));
    }

    public boolean canFinish(int numCourses, int[] prerequisites) {
        return true;
    }

    public static Object invoke(String args, Method method, Object o) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramArray = new Object[parameterTypes.length];
        List<String> params = args.lines()
                .limit(parameterTypes.length)
                .toList();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            paramArray[i] = paramHandle(params.get(i), parameterType);
        }
        try {
            return method.invoke(o, paramArray);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> Object paramHandle(String s, Class c) {
        try {
            // 字符串
            if (c.equals(String.class)) {
                return s;
            }
            // 基本数据类型
            if (c.isPrimitive()) {
                return switch (c.getSimpleName()) {
                    case "int" -> Integer.parseInt(s);
                    case "long" -> Long.parseLong(s);
                    case "double" -> Double.parseDouble(s);
                    case "short" -> Short.parseShort(s);
                    case "byte" -> Byte.parseByte(s);
                    case "float" -> Float.parseFloat(s);
                    case "char" -> s.charAt(0);
                    default -> null;
                };
            }
            // 链表
            if (c.equals(ListNode.class)) {
                return ListNodeUtil.builder(s);
            }
            // 二叉树
            if (c.equals(TreeNode.class)) {
                return TreeNodeUtil.build(s);
            }
            // 数组
            if (c.isArray()) {
                Class arrayClass = c.getComponentType();
                if (arrayClass.isArray()) {
                    // 二维数组

                }
                if (arrayClass.isPrimitive()) {
                    String[] split = s.replace("[", "")
                            .replace("]", "")
                            .split(",");
                    return switch (arrayClass.getSimpleName()) {
                        case "int" -> Arrays.stream(split)
                                .map(Integer::parseInt)
                                .mapToInt(value -> value)
                                .toArray();
                        case "long" -> Arrays.stream(split)
                                .map(Long::parseLong)
                                .mapToLong(value -> value)
                                .toArray();
                        case "double" -> Arrays.stream(split)
                                .map(Double::parseDouble)
                                .mapToDouble(value -> value)
                                .toArray();
//                        case "short" -> Short.parseShort(s);
//                        case "byte" -> Byte.parseByte(s);
//                        case "float" -> Float.parseFloat(s);
//                        case "char" -> s.charAt(0);
                        default -> throw new IllegalArgumentException();
                    };
                }
            }

            return c.getTypeName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
