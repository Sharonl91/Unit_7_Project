import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PackageSimulator {
    private List<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<>();
    }

    public void generatePackages(int amount) {
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            String originZip = generateRandomZipCode();
            String destinationZip = generateRandomZipCode();
            double weight = 1 + random.nextDouble() * 10; // Generate weight between 1 and 11 lbs
            double length = 2 + random.nextDouble() * 8; // Generate length between 2 and 10 inches
            double height = 2 + random.nextDouble() * 8; // Generate height between 2 and 10 inches
            double width = 2 + random.nextDouble() * 8; // Generate width between 2 and 10 inches

            Address originAddress = new Address(generateRandomHouseNumber(), "Random Street", "", "Random City", generateRandomZipCode(), originZip);
            Address destinationAddress = new Address(generateRandomHouseNumber(), "Random Street", "", "Random City", generateRandomZipCode(), destinationZip);
            Package pkg = new Package(originAddress, destinationAddress, weight, length, height, width);
            packages.add(pkg);
        }
    }

    public double generateTotalCost() {
        double totalCost = 0;
        for (Package pkg : packages) {
            totalCost += PostageCalculator.calculatePostage(pkg);
        }
        return totalCost;
    }

    public StringBuilder getSimulationInfo() {
        StringBuilder info = new StringBuilder();
        if (packages.isEmpty()) {
            info.append("No packages simulated.");
        } else {
            for (int i = 0; i < packages.size(); i++) {
                info.append("Package ").append(i + 1).append(":\n");
                info.append("Source Zip: ").append(packages.get(i).getOriginAddress().getZipCode()).append("\n");
                info.append("Destination Zip: ").append(packages.get(i).getDestinationAddress().getZipCode()).append("\n");
                info.append("Weight: ").append(packages.get(i).getWeight()).append(" lbs\n");
                info.append("Length: ").append(packages.get(i).getLength()).append(" inches\n");
                info.append("Height: ").append(packages.get(i).getHeight()).append(" inches\n");
                info.append("Width: ").append(packages.get(i).getWidth()).append(" inches\n");
                info.append("Total Cost: $").append(String.format("%.2f", PostageCalculator.calculatePostage(packages.get(i)))).append("\n");
                info.append("-------------");
            }
        }
        return info;
    }

    public void resetSimulation() {
        packages.clear();
    }

    private String generateRandomZipCode() {
        Random random = new Random();
        int zip = 10000 + random.nextInt(90000); // Generate random 5-digit zip code
        return Integer.toString(zip);
    }

    private String generateRandomHouseNumber() {
        Random random = new Random();
        int number = random.nextInt(1000); // Generate random house number
        return Integer.toString(number);
    }
}
