public class PostageCalculator {
    private static final double BASE_COST = 3.75;
    private static final double OVERSIZE_COST_PER_INCH = 0.10;
    private static final double OVERWEIGHT_COST_PER_TENTH_POUND = 0.10;
    private static final int OVERSIZE_LIMIT = 36;
    private static final double OVERWEIGHT_LIMIT = 40.0;

    public static double calculatePostage(int sourceZip, int destinationZip, double weight, double length, double height, double width) {
        int countyCodeDifference = Math.abs(getCountyCode(sourceZip) - getCountyCode(destinationZip));
        double postage = BASE_COST + ((weight * 10) * 0.05); // Base cost plus 5 cents for each tenth of a pound
        postage += countyCodeDifference / 100.0; // Adding the difference in county codes

        // Check if the package is oversize
        double totalSize = length + height + width;
        if (totalSize > OVERSIZE_LIMIT) {
            postage += (totalSize - OVERSIZE_LIMIT) * OVERSIZE_COST_PER_INCH; // Adding oversize cost
        }

        // Check if the package is overweight
        if (weight > OVERWEIGHT_LIMIT) {
            double overweightCharge = (weight - OVERWEIGHT_LIMIT) * 10 * OVERWEIGHT_COST_PER_TENTH_POUND; // Calculate overweight charge
            postage += overweightCharge; // Adding overweight charge
        }

        return roundToTwoDecimals(postage); // Round to two decimal places
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static double calculatePostage(Address originAddress, Address destinationAddress, double weight, double length, double height, double width) {
        try {
            int originZip = Integer.parseInt(originAddress.getZipCode().substring(0, 3));
            int destZip = Integer.parseInt(destinationAddress.getZipCode().substring(0, 3));
            return calculatePostage(originZip, destZip, weight, length, height, width);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid zip code format");
            return -1; // Or handle the error in an appropriate way
        }
    }

    public static double calculatePostage(Package pkg) {
        return calculatePostage(pkg.getOriginAddress(), pkg.getDestinationAddress(), pkg.getWeight(), pkg.getLength(), pkg.getHeight(), pkg.getWidth());
    }

    private static int getCountyCode(int zipCode) {
        return zipCode / 100;
    }
}
