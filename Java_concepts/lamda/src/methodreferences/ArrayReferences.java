package methodreferences;

public class ArrayReferences {
    // Interface creating an array of Strings
    interface StringArray {
        String[] create(int size);
    }

    // Lambda without references
    StringArray sArrayLambda = (size) -> new String[size];

    StringArray sArrayLambdaMethodRef = String[]::new;

    // Trades array
}
