package com.worker.bee.solution;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 打印工具类
 */
public class PrintUtils {

    public static void print(Object object) {
        System.out.print(object.toString());
    }

    public static void println(Object object) {
        System.out.println(object.toString());
    }

    public static <T> void printList(List<T> lists) {
        println(Arrays.toString(lists.toArray()));
    }

    public static <T> void printDoubleList(List<List<T>> lists) {
        if (lists == null || lists.isEmpty()) {
            println("data is null");
            return;
        }
        for (List<T> list : lists) {
            println(Arrays.toString(list.toArray()));
        }
    }
}
