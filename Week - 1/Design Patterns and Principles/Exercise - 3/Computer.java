public class Computer {
    // Required components
    private String CPU;
    private String RAM;

    // Optional components
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Private constructor, called from Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Getters (optional) or toString for display
    @Override
    public String toString() {
        return "Computer Config:\n" +
                "CPU: " + CPU + "\n" +
                "RAM: " + RAM + "\n" +
                "Storage: " + (storage != null ? storage : "Not included") + "\n" +
                "Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not included") + "\n" +
                "OS: " + (operatingSystem != null ? operatingSystem : "Not included");
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
