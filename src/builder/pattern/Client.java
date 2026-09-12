package builder.pattern;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Computer Builder ===");
            System.out.println("1. Build a computer");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            System.out.flush();
            String choice = scanner.nextLine();
            if (choice.equals("2")) {
                exit = true;
            } else if (choice.equals("1")) {
                buildComputer(scanner);
            } else {
                System.out.println("Invalid option. Please try again.");
                System.out.flush();
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
        System.out.flush();
    }

    private static void buildComputer(Scanner scanner) {
        // Choose type
        System.out.println("\nSelect computer type:");
        System.out.println("1. Gaming PC");
        System.out.println("2. Office PC");
        System.out.println("3. Laptop");
        System.out.print("Enter choice (1-3): ");
        System.out.flush();
        String typeChoice = scanner.nextLine();
        ComputerBuilder builder;
        String typeName;
        String laptopChoice = null; // for laptop subchoice

        switch (typeChoice) {
            case "1":
                builder = new GamingComputerBuilder();
                typeName = "Gaming PC";
                break;
            case "2":
                builder = new OfficeComputerBuilder();
                typeName = "Office PC";
                break;
            case "3":
                // Laptop submenu
                System.out.println("\nSelect laptop type:");
                System.out.println("1. High end laptop");
                System.out.println("2. Office laptop");
                System.out.println("3. Macbook");
                System.out.print("Enter choice (1-3): ");
                System.out.flush();
                laptopChoice = scanner.nextLine();
                switch (laptopChoice) {
                    case "1":
                        builder = new GamingComputerBuilder();
                        typeName = "High end laptop";
                        break;
                    case "2":
                        builder = new OfficeComputerBuilder();
                        typeName = "Office laptop";
                        break;
                    case "3":
                        builder = new OfficeComputerBuilder();
                        typeName = "Macbook";
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to Office laptop.");
                        System.out.flush();
                        builder = new OfficeComputerBuilder();
                        typeName = "Office laptop";
                }
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Office PC.");
                System.out.flush();
                builder = new OfficeComputerBuilder();
                typeName = "Office PC";
        }

        // Choose mode
        System.out.println("\nSelect build mode for " + typeName + ":");
        System.out.println("1. Predefined configuration");
        System.out.println("2. Custom configuration");
        System.out.print("Enter choice (1-2): ");
        System.out.flush();
        String modeChoice = scanner.nextLine();

        if (modeChoice.equals("1")) {
            // Use director for predefined
            ComputerDirector director = new ComputerDirector();
            Computer computer;
            // Determine which director method to call based on original typeChoice and laptopChoice
            if (typeChoice.equals("1")) {
                computer = director.buildHighEndGamingComputer(builder);
            } else if (typeChoice.equals("2")) {
                computer = director.buildBudgetOfficeComputer(builder);
            } else { // laptop
                if (laptopChoice == null) {
                    laptopChoice = "2"; // default
                }
                switch (laptopChoice) {
                    case "1": // high end laptop
                        computer = director.buildHighEndGamingComputer(builder);
                        break;
                    case "2": // office laptop
                        computer = director.buildBudgetOfficeComputer(builder);
                        break;
                    case "3": // macbook
                        computer = director.buildPortableLaptop(builder);
                        break;
                    default:
                        // fallback
                        computer = director.buildBudgetOfficeComputer(builder);
                }
            }
            System.out.println("\nYour " + typeName + ":");
            System.out.println(computer);
            System.out.flush();
        } else if (modeChoice.equals("2")) {
            // Custom build
            // Note: The builder is already in the reset state from the constructor
            System.out.println("\n--- Customizing " + typeName + " ---");
            System.out.println("(Press enter to keep the current value)");
            System.out.flush();

            // For each field, show current value and ask for new value
            // CPU
            System.out.print("CPU [" + builder.getCpu() + "]: ");
            System.out.flush();
            String input = scanner.nextLine();
            if (!input.isEmpty()) builder.setCpu(input);

            // RAM
            System.out.print("RAM (GB) [" + builder.getRamSizeGB() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                try {
                    int ram = Integer.parseInt(input);
                    builder.setRamSizeGB(ram);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Keeping current value.");
                    System.out.flush();
                }
            }

            // Storage Type
            System.out.print("Storage Type [" + builder.getStorageType() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) builder.setStorageType(input);

            // Storage Size
            System.out.print("Storage Size (GB) [" + builder.getStorageSizeGB() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                try {
                    int size = Integer.parseInt(input);
                    builder.setStorageSizeGB(size);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Keeping current value.");
                    System.out.flush();
                }
            }

            // GPU
            System.out.print("GPU [" + builder.getGpu() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) builder.setGpu(input);

            // Has WiFi
            System.out.print("Has WiFi? (y/n) [" + (builder.isHasWiFi() ? "y" : "n") + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    builder.setHasWiFi(true);
                } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    builder.setHasWiFi(false);
                } else {
                    System.out.println("Invalid input. Keeping current value.");
                    System.out.flush();
                }
            }

            // Has Bluetooth
            System.out.print("Has Bluetooth? (y/n) [" + (builder.isHasBluetooth() ? "y" : "n") + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    builder.setHasBluetooth(true);
                } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    builder.setHasBluetooth(false);
                } else {
                    System.out.println("Invalid input. Keeping current value.");
                    System.out.flush();
                }
            }

            // Operating System
            System.out.print("Operating System [" + builder.getOperatingSystem() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) builder.setOperatingSystem(input);

            // Weight
            System.out.print("Weight (kg) [" + builder.getWeightKg() + "]: ");
            System.out.flush();
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                try {
                    double weight = Double.parseDouble(input);
                    builder.setWeightKg(weight);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Keeping current value.");
                    System.out.flush();
                }
            }

            // Build and show
            try {
                Computer computer = builder.build();
                System.out.println("\nYour custom " + typeName + ":");
                System.out.println(computer);
                System.out.flush();
            } catch (IllegalStateException e) {
                System.out.println("Error building computer: " + e.getMessage());
                System.out.flush();
            }
        } else {
            System.out.println("Invalid mode choice. Please try again.");
            System.out.flush();
        }
    }
}