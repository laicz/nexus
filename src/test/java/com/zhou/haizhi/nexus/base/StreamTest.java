package com.zhou.haizhi.nexus.base;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream测试类
 * Create by zhoumingbing on 2020-03-16
 */
public class StreamTest {

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "c", "d", "e"};
        Stream.of(strings).forEach(System.out::println);

        Stream.generate(() -> 1).limit(10).forEach(System.out::println);

        //创建一个范围集合Stream
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(200).forEach(System.out::println);

        Stream<Integer> stream1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream();
        int sum = stream1.filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        String str = "11,22,3,4,4,665,34,2";
        System.out.println(
                Stream.of(str.split(","))
                        .filter(StringUtils::isNotBlank)
                        .mapToInt(Integer::valueOf).sum()
        );

        List<List<String>> doubleLevelList = new ArrayList<>();
        List<String> oneList = new ArrayList<>();
        oneList.add("one_1");
        oneList.add("one_2");
        oneList.add("one_3");
        oneList.add("one_4");

        List<String> twoList = new ArrayList<>();
        twoList.add("two_1");
        twoList.add("two_2");
        twoList.add("two_3");
        twoList.add("two_4");

        doubleLevelList.add(oneList);
        doubleLevelList.add(twoList);

        System.out.println(oneList.stream().map(x -> x.split("")).collect(Collectors.toList()));


        System.out.println("---------------map----------------");
        System.out.println(doubleLevelList.stream().map(x -> x).distinct().collect(Collectors.toList()));

        System.out.println("---------------flatMap----------------");
        System.out.println(doubleLevelList.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList()));

    }

}
