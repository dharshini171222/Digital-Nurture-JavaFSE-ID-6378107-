public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");

        System.out.println("First call to display():");
        image1.display(); // Loads image from server

        System.out.println("\nSecond call to display():");
        image1.display(); // Uses cached image

        // Simulate another image
        System.out.println("\nLoading another image:");
        Image image2 = new ProxyImage("landscape.png");
        image2.display();
    }
}
