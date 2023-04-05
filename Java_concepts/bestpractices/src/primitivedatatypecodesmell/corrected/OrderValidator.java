package primitivedatatypecodesmell.corrected;

public class OrderValidator {

    public boolean validate(Address address) {
        // validation logic goes here
        return true;
    }
}
//Reduced code duplication: Other parts of the code that work with shipping addresses can now
// use the Address class instead of duplicating the string parameter list.

