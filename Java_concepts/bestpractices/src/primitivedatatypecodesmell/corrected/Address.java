package primitivedatatypecodesmell.corrected;

public class Address {
    private final String name;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zipCode;

    public Address(String name, String streetAddress, String city, String state, String zipCode) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters for all fields go here
}

