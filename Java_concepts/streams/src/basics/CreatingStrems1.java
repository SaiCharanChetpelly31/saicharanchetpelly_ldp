package basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStrems1 {

        public static void main(String[] args) {

            // Create a stream from a collection
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            Stream<Integer> stream1 = numbers.stream();

            // Create a stream from an array
            Integer[] array = {1, 2, 3, 4, 5};
            Stream<Integer> stream2 = Arrays.stream(array);

            // Create an empty stream
            Stream<Integer> stream3 = Stream.empty();

            // Create a stream with a single element
            Stream<Integer> stream4 = Stream.of(1);

            // Create a stream with multiple elements
            Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);

            // Create a stream of random numbers
            Stream<Double> stream6 = Stream.generate(Math::random).limit(5);

            // Create a stream of repeated values
            Stream<String> stream7 = Stream.generate(() -> "hello").limit(5);

            // Create a stream from a string
            String str = "hello world";
            Stream<String> stream8 = str.chars()
                    .mapToObj(c -> Character.toString((char)c));

            Stream<Integer> wholeNumbers = Stream.iterate(1,i->i+1);
            /*wholeNumbers.forEach(System.out::println);*/
            // Print out each stream
            stream1.forEach(System.out::println);
            stream2.forEach(System.out::println);
            stream3.forEach(System.out::println);
            stream4.forEach(System.out::println);
            stream5.forEach(System.out::println);
            stream6.forEach(System.out::println);
            stream7.forEach(System.out::println);
            stream8.forEach(System.out::println);
        }

}
