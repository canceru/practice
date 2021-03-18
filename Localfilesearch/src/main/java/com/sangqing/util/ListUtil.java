package com.sangqing.util;

import com.sangqing.model.FileMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {
    // 写一个泛型方法
    // list1 - list2
    public static <E> List<E> differenceSet(List<E> list1, List<E> list2) {
        List<E> resultList = new ArrayList<>();

        for (E item : list1) {
            if (!list2.contains(item)) {    // E 类型必须正确地支持 equals 方法
                resultList.add(item);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<FileMeta> list1 = Arrays.asList(
                new FileMeta(new File("D:\\install\\1.txt")),
                new FileMeta(new File("D:\\install\\2.txt")),
                new FileMeta(new File("D:\\install\\3.txt"))
        );


        List<FileMeta> list2 = Arrays.asList(
                new FileMeta(new File("D:\\install\\2.txt")),
                new FileMeta(new File("D:\\install\\3.txt")),
                new FileMeta(new File("D:\\install\\4.txt"))
        );

        for (FileMeta fm : differenceSet(list1, list2)) {    // 1
            System.out.println(fm);
        }
        System.out.println("=============================");
        for (FileMeta fm : differenceSet(list2, list1)) {    // 4
            System.out.println(fm);
        }
    }
}
