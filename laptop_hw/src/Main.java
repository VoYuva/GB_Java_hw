import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // String name, String cpu, String memory, String gpu, String ram, String os,
        // String color
        Laptop laptop1 = new Laptop("Acer", "Swift X1", "AMD Ryzen 7 5800U", 512, "NVIDIA GeForce GTX 1650",
                16, "Windows 11", "IPS", "Mystic Black");
        Laptop laptop2 = new Laptop("Dell", "Inspiron 14 Pro", "Intel Core i5-1135G7", 256,
                "Intel Iris Xe Graphics", 8, "Ubuntu Linux", "TN", "Silver");
        Laptop laptop3 = new Laptop("HP", "Spectre X360", "Intel Core i7-1165G7", 1024, "Intel Iris Xe",
                32, "Windows 10", "TN", "Poseidon Blue");
        Laptop laptop4 = new Laptop("ASUS", "ROG Zephyrus G14", "AMD Ryzen 9 5900HS", 1024, "NVIDIA RTX 3060",
                32, "Windows 11", "OLED", "Eclipse Gray");
        Laptop laptop5 = new Laptop("Lenovo", "Yoga Slim 7", "AMD Ryzen 5 5600U", 512, "AMD Radeon Graphics",
                16, "Windows 10", "IPS", "Slate Grey");

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5));

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        UserRequest.userRequest(laptops);
    }

}