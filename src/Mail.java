import java.util.Scanner;

public class Mail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostageCalculator packageCostCalculator = new PostageCalculator();

        int choice;
        do {
            System.out.println("Welcome to the Package Shipping Simulator!");
            System.out.println("What would you like todo?");
            System.out.println("---------------------------------------");
            System.out.println("1. Calculate the cost of one package");
            System.out.println("2. Simulate some number of packages");
            System.out.println("3. Explanation of package cost calculation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateCostOfOnePackage(scanner, packageCostCalculator);
                    break;
                case 2:
                    simulatePackages();
                    break;
                case 3:
                    showExplanation();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private static void calculateCostOfOnePackage(Scanner scanner, PostageCalculator packageCostCalculator) {
        System.out.println("Calculating the cost of one package:");
        System.out.print("Enter the source zip code: ");
        int sourceZip = scanner.nextInt();
        System.out.print("Enter the destination zip code: ");
        int destinationZip = scanner.nextInt();
        System.out.print("Enter the weight of the package (in pounds): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter the length of the package (in inches): ");
        double length = scanner.nextDouble();
        System.out.print("Enter the height of the package (in inches): ");
        double height = scanner.nextDouble();
        System.out.print("Enter the width of the package (in inches): ");
        double width = scanner.nextDouble();

        double cost = packageCostCalculator.calculatePostage(sourceZip, destinationZip, weight, length, height, width);
        System.out.println("The cost of shipping this package is: $" + cost);
    }

    private static void simulatePackages() {
        PackageSimulator pack = new PackageSimulator();
        PostageCalculator packageCostCalculator = new PostageCalculator();
        System.out.println("Enter the number of packages to simulate: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        pack.generatePackages(amount);
        StringBuilder simulationInfo = pack.getSimulationInfo();
        System.out.println(simulationInfo.toString());
    }

    private static void showExplanation() {
        System.out.println("Explanation of package cost calculation:");
        System.out.println("1) All shipping will be charged a base value of $3.75.");
        System.out.println("2) 5 cents will be charged for 1/10 of a pound.");
        System.out.println("3) Take the zip codes of the original zip code and the destination zip code.");
        System.out.println("4) Using only the first 3 digits, find the difference and divide it by 100.");
        System.out.println("5) Add the resulting value to the total cost of shipping.");
        System.out.println("6) If a package exceeds a combined size of 36 inches, each extra inch will be charged 10 cents.");
        System.out.println("7) If a package weighs more than 40 pounds, each extra pound will be charged 10 cents.");

    }
}
