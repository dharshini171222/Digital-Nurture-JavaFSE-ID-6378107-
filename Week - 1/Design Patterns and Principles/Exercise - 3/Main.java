public class Main {
    public static void main(String[] args) {
        // Basic configuration
        Computer basicPC = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println(basicPC);

        System.out.println("\n------------------------------\n");

        // Advanced gaming configuration
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11 Pro")
                .build();

        System.out.println(gamingPC);
    }
}
