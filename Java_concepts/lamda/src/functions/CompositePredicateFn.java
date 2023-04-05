package functions;

import java.util.function.Predicate;

public class CompositePredicateFn {
    Predicate<String> lengthIsFive = s -> s.length() == 5;
    Predicate<String> startsWithA = s -> s.startsWith("a");
    Predicate<String> lengthIsFiveAndStartsWithA = lengthIsFive.and(startsWithA);
    Predicate<String> lengthIsThree = s -> s.length() == 3;
    Predicate<String> startsWithB = s -> s.startsWith("b");
    Predicate<String> lengthIsThreeOrStartsWithB = lengthIsThree.or(startsWithB);

    Predicate<String> doesNotStartWithA = startsWithA.negate();

}
