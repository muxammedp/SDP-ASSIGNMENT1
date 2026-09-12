package builder.pattern;

/**
 * Builder interface declaring the construction steps for a Computer.
 * Each setter returns the builder itself to allow method chaining (fluent API).
 */
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
}