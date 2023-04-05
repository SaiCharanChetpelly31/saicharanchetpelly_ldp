package primitivedatatypecodesmell.violation;

public class OrderValidator {

    public boolean validate(String name, String address, String city, String state, String zip) {
        // validation logic goes here
        return true;
    }
}
//Code duplication: If other parts of the code need to work with shipping addresses, they may need to
// duplicate this same parameter list, leading to code bloat and maintenance issues.
