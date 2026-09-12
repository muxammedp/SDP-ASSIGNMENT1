package builder.pattern;

/**
 * Product class representing a complex object being built.
 * In this case, a Computer with various components.
 * This class is immutable - all fields are final and set only via constructor.
 */
public class Computer {
    // Required components
    private final String cpu;
    private final int ramSizeGB;
    private final String storageType;
    private final int storageSizeGB;

    // Optional components
    private final String gpu;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;
    private final String operatingSystem;
    private final double weightKg;

    /**
     * Constructor - package private so only builders in same package can instantiate.
     * All fields are final to ensure immutability.
     */
    Computer(String cpu, int ramSizeGB, String storageType, int storageSizeGB,
             String gpu, boolean hasWiFi, boolean hasBluetooth,
             String operatingSystem, double weightKg) {
        this.cpu = cpu;
        this.ramSizeGB = ramSizeGB;
        this.storageType = storageType;
        this.storageSizeGB = storageSizeGB;
        this.gpu = gpu;
        this.hasWiFi = hasWiFi;
        this.hasBluetooth = hasBluetooth;
        this.operatingSystem = operatingSystem;
        this.weightKg = weightKg;
    }

    // Getters for all fields (no setters - immutable object)
    public String getCpu() {
        return cpu;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

    public String getStorageType() {
        return storageType;
    }

    public int getStorageSizeGB() {
        return storageSizeGB;
    }

    public String getGpu() {
        return gpu;
    }

    public boolean hasWiFi() {
        return hasWiFi;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ramSizeGB=" + ramSizeGB +
                ", storageType='" + storageType + '\'' +
                ", storageSizeGB=" + storageSizeGB +
                ", gpu='" + gpu + '\'' +
                ", hasWiFi=" + hasWiFi +
                ", hasBluetooth=" + hasBluetooth +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", weightKg=" + weightKg +
                '}';
    }
}