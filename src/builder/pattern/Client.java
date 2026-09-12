package builder.pattern;

/**
 * Client class that demonstrates the Builder pattern.
 * Exercises the builders and shows the resulting products.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===\n");

        // Demonstrate using concrete builders directly
        System.out.println("1. Using Concrete Builders Directly:");
        System.out.println("   Building a Gaming Computer:");
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Computer gamingComputer = gamingBuilder.build();
        System.out.println("   " + gamingComputer);
        System.out.println();

        System.out.println("   Building an Office Computer:");
        OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Computer officeComputer = officeBuilder.build();
        System.out.println("   " + officeComputer);
        System.out.println();

        // Demonstrate method chaining (fluent API)
        System.out.println("2. Using Method Chaining (Fluent API):");
        System.out.println("   Customizing a Gaming Computer:");
        Computer customGaming = new GamingComputerBuilder()
                .setCpu("AMD Ryzen 9 7950X")
                .setRamSizeGB(64)
                .setStorageType("NVMe SSD")
                .setStorageSizeGB(4000)
                .setGpu("AMD Radeon RX 7900 XTX")
                .setHasWiFi(true)
                .setHasBluetooth(true)
                .setOperatingSystem("Linux Ubuntu 22.04")
                .setWeightKg(3.8)
                .build();
        System.out.println("   " + customGaming);
        System.out.println();

        // Demonstrate using Director
        System.out.println("3. Using Director for Known Configurations:");
        ComputerDirector director = new ComputerDirector();

        System.out.println("   High-End Gaming Computer (via Director):");
        Computer highEndGaming = director.buildHighEndGamingComputer(
                new GamingComputerBuilder());
        System.out.println("   " + highEndGaming);
        System.out.println();

        System.out.println("   Budget Office Computer (via Director):");
        Computer budgetOffice = director.buildBudgetOfficeComputer(
                new OfficeComputerBuilder());
        System.out.println("   " + budgetOffice);
        System.out.println();

        System.out.println("   Portable Laptop (via Director):");
        Computer laptop = director.buildPortableLaptop(
                new OfficeComputerBuilder()); // Using office builder as base
        System.out.println("   " + laptop);
        System.out.println();

        System.out.println("=== Demo Complete ===");
    }
}