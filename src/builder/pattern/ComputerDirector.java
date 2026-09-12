package builder.pattern;

/**
 * Director class that orchestrates the build sequence for known/reusable configurations.
 * This is optional but encouraged as per the assignment requirements.
 */
public class ComputerDirector {
    /**
     * Constructs a high-end gaming computer using the provided builder.
     * @param builder the builder to use for construction
     * @return the built computer
     */
    public Computer buildHighEndGamingComputer(ComputerBuilder builder) {
        builder.setCpu("Intel Core i9-14900K")
               .setRamSizeGB(64)
               .setStorageType("NVMe SSD")
               .setStorageSizeGB(4000)
               .setGpu("NVIDIA RTX 4090")
               .setHasWiFi(true)
               .setHasBluetooth(true)
               .setOperatingSystem("Windows 11 Pro")
               .setWeightKg(4.0);
        return builder.build();
    }

    /**
     * Constructs a budget office computer using the provided builder.
     * @param builder the builder to use for construction
     * @return the built computer
     */
    public Computer buildBudgetOfficeComputer(ComputerBuilder builder) {
        builder.setCpu("AMD Ryzen 5 5600G")
               .setRamSizeGB(8)
               .setStorageType("SSD")
               .setStorageSizeGB(256)
               .setGpu("Integrated Graphics")
               .setHasWiFi(true)
               .setHasBluetooth(false)
               .setOperatingSystem("Windows 11 Home")
               .setWeightKg(2.0);
        return builder.build();
    }

    /**
     * Constructs a portable laptop using the provided builder.
     * @param builder the builder to use for construction
     * @return the built computer
     */
    public Computer buildPortableLaptop(ComputerBuilder builder) {
        builder.setCpu("Apple M2 Pro")
               .setRamSizeGB(16)
               .setStorageType("SSD")
               .setStorageSizeGB(1000)
               .setGpu("Integrated 16-core GPU")
               .setHasWiFi(true)
               .setHasBluetooth(true)
               .setOperatingSystem("macOS Ventura")
               .setWeightKg(1.8);
        return builder.build();
    }
}