package basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Filter out odd numbers
        Stream<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0);

// Square each even number
        Stream<Integer> squaredNumbers = evenNumbers.map(n -> n * n);

// Sum the squared even numbers
        int sum = squaredNumbers.reduce(0, Integer::sum);

        System.out.println(sum); // Output: 20


    }
}
