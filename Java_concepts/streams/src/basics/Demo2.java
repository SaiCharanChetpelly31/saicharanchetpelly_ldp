package basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Intermediate Operations
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Filtering " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Mapping " + n))
                .collect(Collectors.toList());
        System.out.println("Filtered and mapped numbers: " + filteredNumbers);

        // Terminal Operations
        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Count of even numbers: " + count);

        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sum);

        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("Are all numbers even? " + allEven);

        boolean anyEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println("Are any numbers even? " + anyEven);

        boolean noneEven = numbers.stream()
                .noneMatch(n -> n % 2 == 0);
        System.out.println("Are no numbers even? " + noneEven);
    }
}
