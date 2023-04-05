package advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultilevelPartitioningExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "frog");

        Map<Boolean, Map<Integer, List<String>>> partitionedWords = words.stream()
                .collect(Collectors.partitioningBy(word -> word.length() % 2 == 0,
                        Collectors.groupingBy(String::length)));

        System.out.println(partitionedWords);
    }
}
