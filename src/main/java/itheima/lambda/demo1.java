package itheima.lambda;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class demo1 {
    public static void main(String[] args) {
       Integer[] arr = {1,2,4,5,6};
        Stream<Integer> stream = Arrays.stream(arr);
        stream
                .filter(integer -> integer > 2)
                .forEach(integer -> System.out.println(integer));

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"123");
        map.put(2,"123");
        map.put(3,"1233");
        map.put(4,"1234");
        Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream();
        stream1
//                .filter(entry -> entry.getKey() > 2)
//                .forEach(entry -> System.out.println(entry.getValue()));
                .filter(entry -> entry.getValue().equals("1233"))
                .forEach(entry -> System.out.println(entry.getKey()));


    }
}
