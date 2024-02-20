public class Address {
    private String houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;

    // Constructor with separate pieces of the address
    public Address(String houseNumber, String streetName, String city, String state, String zipCode, String code) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Constructor with Address object
    public Address(Address address) {
        this.houseNumber = address.houseNumber;
        this.streetName = address.streetName;
        this.city = address.city;
        this.state = address.state;
        this.zipCode = address.zipCode;
    }

    // Constructor with Address as a full String
    public Address(String fullAddress) {
        String[] parts = fullAddress.split(",");
        this.houseNumber = parts[0].trim();
        this.streetName = parts[1].trim();
        this.city = parts[2].trim();
        this.state = parts[3].trim();
        this.zipCode = parts[4].trim();
    }

    // Accessor and mutator methods
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // toString method
    @Override
    public String toString() {
        return houseNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;
    }
}
