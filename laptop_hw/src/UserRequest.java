import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRequest {
        @SuppressWarnings("resource")
        public static void userRequest(Set<Laptop> laptops) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Наименование фирмы");
        System.out.println("2 - Наименование модели");
        System.out.println("3 - Процессор");
        System.out.println("4 - Объем памяти SSD/HDD");
        System.out.println("5 - Видеокарта");
        System.out.println("6 - Объем оперативной памяти");
        System.out.println("7 - Операционная система");
        System.out.println("8 - Тип матрицы");
        System.out.println("9 - Цвет");

        int criteria = scan.nextInt();
        scan.nextLine(); 

        Map<String, Object> filterCriteria = new HashMap<>();

        switch (criteria) {
            case 1:
                System.out.println("Введите желаемую фирму производителя ноутбука:");
                Set<String> allFirms = getAllFirms(laptops);
                System.out.println("Все фирмы производители: " + allFirms);
                String firm = scan.nextLine();
                filterCriteria.put("firm", firm);
                break;
            case 2:
                System.out.println("Введите желаемую модель ноутбука:");
                Set<String> allModels = getAllModels(laptops);
                System.out.println("Все модели: " + allModels);
                String name = scan.nextLine();
                filterCriteria.put("name", name);
                break;
            case 3:
                System.out.println("Введите желаемый процессор:");
                Set<String> allCpu = getAllCpu(laptops);
                System.out.println("Все модели: " + allCpu);
                String cpu = scan.nextLine();
                filterCriteria.put("cpu", cpu);
                break;
            case 4:
                System.out.println("Введите минимальный объем памяти SSD/HDD:");
                Set<Integer> allROMMemory = getAllROMMemory(laptops);
                System.out.println("Все модели: " + allROMMemory);
                int minROMMemory = scan.nextInt();
                filterCriteria.put("rom memory", minROMMemory);
                break;
            case 5:
                System.out.println("Введите желаемую видеокарту:");
                Set<String> allGpu = getAllGpu(laptops);
                System.out.println("Все модели: " + allGpu);
                String gpu = scan.nextLine();
                filterCriteria.put("gpu", gpu);
                break;
            case 6:
                System.out.println("Введите минимальный объем оперативной памяти:");
                Set<Integer> allRAMMemory = getAllRAMMemory(laptops);
                System.out.println("Все модели: " + allRAMMemory);
                int minRAMMemory = scan.nextInt();
                filterCriteria.put("ram memory", minRAMMemory);
                break;
            case 7:
                System.out.println("Введите желаемую операционную систему:");
                Set<String> allOs = getAllOs(laptops);
                System.out.println("Все модели: " + allOs);
                String os = scan.nextLine();
                filterCriteria.put("os", os);
                break;
            case 8:
                System.out.println("Введите желаемый тип матрицы:");
                Set<String> allTypeMatrix = getAllTypeMatrix(laptops);
                System.out.println("Все модели: " + allTypeMatrix);
                String matrix = scan.nextLine();
                filterCriteria.put("type matrix", matrix);
                break;
            case 9:
                System.out.println("Введите желаемый цвет:");
                Set<String> allColor = getAllColor(laptops);
                System.out.println("Все модели: " + allColor);
                String color = scan.nextLine();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия.");
                return;
        }

        scan.close();

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Laptop laptop : laptops) {
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case "firmName":
                        if (!laptop.getFirmName().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "modelName":
                        if (!laptop.getModelName().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "cpu":
                        if (!laptop.getCpu().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "romMemory":
                        if (laptop.getROMMemory() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "gpu":
                        if (!laptop.getGpu().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "ramMemory":
                        if (laptop.getRAMMemory() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "typeMatrix":
                        if (!laptop.getTypeMatrix().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                }
            }
        }

        return filteredLaptops;
    }

    public static Set<String> getAllFirms(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getFirmName)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllModels(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getModelName)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllCpu(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getCpu)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<Integer> getAllROMMemory(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getROMMemory)
                .distinct()
                .sorted()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllGpu(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getGpu)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<Integer> getAllRAMMemory(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getRAMMemory)
                .distinct()
                .sorted()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllOs(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getOs)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllTypeMatrix(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getTypeMatrix)
                .distinct()
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllColor(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getColor)
                .distinct()
                .collect(Collectors.toSet());
    }


}
