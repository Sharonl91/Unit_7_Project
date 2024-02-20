public class PackageCostCalculator {
    // Constants for shipping cost calculation
    private static final double BASE_COST = 5.0; // Base shipping cost
    private static final double WEIGHT_COST_RATE = 0.5; // Cost per pound
    private static final double DIMENSION_COST_RATE = 0.1; // Cost per cubic inch
    private static final double DISTANCE_COST_RATE = 0.01; // Cost per mile

    public double calculateCost(Package packageInput) {
        double weightCost = packageInput.getWeight() * WEIGHT_COST_RATE;
        double dimensionCost = packageInput.getLength() * packageInput.getHeight() *
                packageInput.getWidth() * DIMENSION_COST_RATE;
        double distanceCost = calculateDistanceCost(packageInput);

        return BASE_COST + weightCost + dimensionCost + distanceCost;
    }

    // Dummy method to calculate distance cost (placeholder)
    private double calculateDistanceCost(Package packageInput) {
        // Placeholder implementation, you should replace this with actual distance calculation
        return packageInput.getOrigin().getZipCode().charAt(0) - '0'; // Just a placeholder calculation
    }
}
