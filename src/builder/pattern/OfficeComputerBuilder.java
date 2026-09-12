package builder.pattern;

/**
 * Concrete Builder for creating an Office Computer representation.
 * Implements the ComputerBuilder interface with method chaining.
 * Holds the computer specifications as fields and builds the Computer object at the end.
 */
public class OfficeComputerBuilder implements ComputerBuilder {
    // Fields to hold computer specifications
    private String cpu;
    private int ramSizeGB;
    private String storageType;
    private int storageSizeGB;
    private String gpu;
    private boolean hasWiFi;
    private boolean hasBluetooth;
    private String operatingSystem;
    private double weightKg;

    /**
     * Constructor initializes with default values for an office computer.
     */
    public OfficeComputerBuilder() {
        reset();
    }

    /**
     * Resets the builder to start building a fresh computer.
     * Sets default values appropriate for an office computer.
     */
    public void reset() {
        this.cpu = "Intel Core i5-13400";
        this.ramSizeGB = 16;
        this.storageType = "SSD";
        this.storageSizeGB = 512;
        this.gpu = "Integrated Graphics";
        this.hasWiFi = true;
        this.hasBluetooth = true;
        this.operatingSystem = "Windows 11";
        this.weightKg = 2.5;
    }

    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setRamSizeGB(int ramSizeGB) {
        this.ramSizeGB = ramSizeGB;
        return this;
    }

    @Override
    public ComputerBuilder setStorageType(String storageType) {
        this.storageType = storageType;
        return this;
    }

    @Override
    public ComputerBuilder setStorageSizeGB(int storageSizeGB) {
        this.storageSizeGB = storageSizeGB;
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
        return this;
    }

    @Override
    public ComputerBuilder setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
        return this;
    }

    @Override
    public ComputerBuilder setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    @Override
    public ComputerBuilder setWeightKg(double weightKg) {
        this.weightKg = weightKg;
        return this;
    }

    @Override
    public Computer build() {
        // Validate required fields
        if (cpu == null || cpu.isEmpty()) {
            throw new IllegalStateException("CPU cannot be null or empty");
        }
        if (ramSizeGB <= 0) {
            throw new IllegalStateException("RAM size must be positive");
        }
        if (storageType == null || storageType.isEmpty()) {
            throw new IllegalStateException("Storage type cannot be null or empty");
        }
        if (storageSizeGB <= 0) {
            throw new IllegalStateException("Storage size must be positive");
        }
        if (weightKg <= 0) {
            throw new IllegalStateException("Weight must be positive");
        }

        // Create and return the Computer object
        return new Computer(cpu, ramSizeGB, storageType, storageSizeGB,
                           gpu, hasWiFi, hasBluetooth, operatingSystem, weightKg);
    }
}