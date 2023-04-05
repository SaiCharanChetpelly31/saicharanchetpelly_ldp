package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "frog");

        Map<Integer, List<String>> groups = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groups);
    }
}

