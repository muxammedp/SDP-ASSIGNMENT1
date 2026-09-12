# Builder Pattern Assignment - Computer Builder

### Overview
This project implements the Builder creational design pattern in Java to construct Computer objects with different representations (Gaming Computer, Office Computer, etc.). The Builder pattern allows for step-by-step construction of complex objects and provides a clean API for creating objects with many optional parameters.

### Project Structure
```
src/
└── builder/pattern/
    ├── Computer.java           // Product class
    ├── ComputerBuilder.java    // Builder interface
    ├── GamingComputerBuilder.java  // Concrete Builder 1
    ├── OfficeComputerBuilder.java  // Concrete Builder 2
    ├── ComputerDirector.java   // Director (optional, encourages reuse)
    └── Client.java             // Demo class showcasing the pattern
```

### How to Build Each Representation

#### 1. Using Concrete Builders Directly
```java
// Gaming Computer
GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
Computer gamingComputer = gamingBuilder.build();

// Office Computer
OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
Computer officeComputer = officeBuilder.build();
```

#### 2. Using Method Chaining (Fluent API)
```java
Computer customComputer = new GamingComputerBuilder()
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
```

#### 3. Using Director for Known Configurations
```java
ComputerDirector director = new ComputerDirector();

// High-end gaming computer
Computer highEndGaming = director.buildHighEndGamingComputer(
    new GamingComputerBuilder());

// Budget office computer
Computer budgetOffice = director.buildBudgetOfficeComputer(
    new OfficeComputerBuilder());

// Portable laptop
Computer laptop = director.buildPortableLaptop(
    new OfficeComputerBuilder());
```

### How to Run the Demo
1. Compile the Java files:
   ```bash
   javac src/builder/pattern/*.java
   ```
2. Run the Client class:
   ```bash
   java -cp src builder.pattern.Client
   ```

### Clean Code Principles Applied

1. **Meaningful, Intention-Revealing Names**
   - Class names like `GamingComputerBuilder`, `OfficeComputerBuilder` clearly indicate their purpose
   - Method names like `setCpu()`, `setRamSizeGB()` are descriptive and follow JavaBean conventions

2. **Small Methods, Each Doing One Thing**
   - Each setter method in the builders does exactly one thing: sets a specific field and returns the builder
   - The `build()` method focuses solely on validation and object creation
   - Director methods each build a specific computer configuration

3. **No Duplicated Construction Logic**
   - The actual Computer construction logic is centralized in the Computer constructor
   - Builders only collect parameters; validation happens in build()
   - Director methods reuse builder methods rather than duplicating field-setting logic

4. **Minimal, Purposeful Comments**
   - Comments explain why certain design decisions were made (e.g., immutability, validation)
   - Code is self-explanatory through clear naming; comments add value beyond what the code shows

5. **Consistent Formatting and Small, Focused Classes**
   - Consistent indentation and brace placement throughout
   - Each class has a single, well-defined responsibility:
     - Computer: immutable product
     - ComputerBuilder: interface defining construction steps
     - Concrete builders: implement specific configurations
     - Director: encapsulates common construction sequences
     - Client: demonstrates usage

6. **Validated Construction**
   - The `build()` method in concrete builders validates required fields before creating the Computer
   - Clear exceptions are thrown with descriptive messages for invalid states
   - Ensures that Computer objects are always in a valid state upon creation

7. **No Magic Numbers/Strings**
   - Default values in builders are meaningful constants (e.g., 32GB RAM for gaming)
   - Configuration values in Director methods are descriptive and context-appropriate

### UML Class Diagram
```
+----------------+       +------------------+       +-------------------------+
|    Computer    |<>-----|  ComputerBuilder |       |  GamingComputerBuilder  |
+----------------+       +------------------+       +-------------------------+
| -cpu: String   |       | +setCpu(): CB    |       | +setCpu(): CB           |
| -ramSizeGB: int|       | +setRamSizeGB(): CB|     | +setRamSizeGB(): CB     |
| -storageType:  |       | +setStorageType(): CB|   | +setStorageType(): CB   |
|   String       |       | +setStorageSizeGB(): CB| | +setStorageSizeGB(): CB |
| -storageSizeGB:int|    | +setGpu(): CB      |     | +setGpu(): CB           |
| -gpu: String   |       | +setHasWiFi(): CB  |     | +setHasWiFi(): CB       |
| -hasWiFi: bool |       | +setHasBluetooth():CB|   | +setHasBluetooth():CB   |
| -hasBluetooth:bool|   | +setOperatingSystem():CB| | +setOperatingSystem():CB|
| -os: String    |       | +setWeightKg(): CB |     | +setWeightKg(): CB      |
| -weightKg: double|    | +build(): Computer |     | +build(): Computer      |
+----------------+       +------------------+       +-------------------------+
        ^                         ^                         ^
        |                         |                         |
        |                         |                         |
+----------------+       +------------------+       +-------------------------+
|OfficeComputerBuilder|       | ComputerDirector |       |         Client        |
+----------------+       +------------------+       +-------------------------+
| +setCpu(): CB    |       | +buildHighEndGamingComputer(): Computer |
| +setRamSizeGB(): CB|       | +buildBudgetOfficeComputer(): Computer|
| +setStorageType(): CB|     | +buildPortableLaptop(): Computer      |
| +setStorageSizeGB(): CB|                          |
| +setGpu(): CB      |                          |
| +setHasWiFi(): CB    |                          |
| +setHasBluetooth():CB|                          |
| +setOperatingSystem():CB|                      |
| +setWeightKg(): CB   |                          |
| +build(): Computer   |                          |
+----------------+       +------------------+       +-------------------------+

Note: CB = ComputerBuilder return type for fluent API
```

### Conclusion

**Pros Encountered:**
- The Builder pattern effectively handles object construction with many parameters
- Method chaining provides a fluent, readable API
- Immutability of the Product (Computer) ensures thread-safety and prevents inconsistent states
- Director pattern encapsulates common configurations for reuse
- Clear separation of concerns: builders handle construction, product represents the entity

**Cons Encountered:**
- Requires creating multiple builder classes (though this improves organization)
- Slightly more code upfront compared to telescoping constructors
- Mutable builders can lead to issues if not properly reset between uses (addressed by reset() methods)

The Builder pattern proves invaluable when dealing with objects that have numerous optional parameters or when multiple representations of an object are needed, as demonstrated with the different computer configurations.