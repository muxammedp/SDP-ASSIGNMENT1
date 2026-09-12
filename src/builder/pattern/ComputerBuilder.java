package builder.pattern;

public interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setRamSizeGB(int ramSizeGB);
    ComputerBuilder setStorageType(String storageType);
    ComputerBuilder setStorageSizeGB(int storageSizeGB);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setHasWiFi(boolean hasWiFi);
    ComputerBuilder setHasBluetooth(boolean hasBluetooth);
    ComputerBuilder setOperatingSystem(String operatingSystem);
    ComputerBuilder setWeightKg(double weightKg);
    Computer build();

    // Getters for current state
    String getCpu();
    int getRamSizeGB();
    String getStorageType();
    int getStorageSizeGB();
    String getGpu();
    boolean isHasWiFi();
    boolean isHasBluetooth();
    String getOperatingSystem();
    double getWeightKg();
}