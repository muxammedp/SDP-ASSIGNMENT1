package builder.pattern;

public class Computer {
    private final String cpu;
    private final int ramSizeGB;
    private final String storageType;
    private final int storageSizeGB;
    private final String gpu;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;
    private final String operatingSystem;
    private final double weightKg;

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