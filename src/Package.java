public class Package {
    private Address originAddress;
    private Address destinationAddress;
    private double weight;
    private double length;
    private double height;
    private double width;

    // Constructor
    public Package(Address originAddress, Address destinationAddress, double weight, double length, double height, double width) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    // Accessor methods
    public Address getOriginAddress() {
        return originAddress;
    }

    public Address getDestinationAddress() {
        return destinationAddress;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
