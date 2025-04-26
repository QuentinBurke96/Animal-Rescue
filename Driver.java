import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String selection = "";

        initializeDogList();
        initializeMonkeyList();

        while (true) {
            displayMenu();
            selection = scnr.next().toLowerCase();
            if (selection.equals("q")) {
                System.out.println("Exiting application.");
                break;
            }
            switch (selection) {
                case "1":
                    scnr.nextLine();
                    intakeNewDog(scnr);
                    break;
                case "2":
                    scnr.nextLine();
                    intakeNewMonkey(scnr);
                    break;
                case "3":
                    scnr.nextLine();
                    reserveAnimal(scnr);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
        scnr.close();
    }

    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection:");
    }

    public static void initializeDogList() {
        dogList.add(new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States"));
        dogList.add(new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States"));
        dogList.add(new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada"));
    }

    public static void initializeMonkeyList() {
        monkeyList.add(new Monkey("Lily", "Female", "3", "25.6", "05-12-2019", "United States", "intake", false, "United States", "5", "20", "3", "Capuchin"));
        monkeyList.add(new Monkey("Phil", "Male", "5", "27.1", "05-12-2019", "United States", "intake", false, "United States", "5", "20", "3", "Guenon"));
        monkeyList.add(new Monkey("Anna", "Female", "2", "21.5", "05-12-2019", "United States", "intake", false, "United States", "5", "20", "3", "Tamarin"));
    }

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog d : dogList) {
            if (d.getName().equalsIgnoreCase(name)) {
                System.out.println("This dog is already in our system\n");
                return;
            }
        }
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acquisition date?");
        String acqDate = scanner.nextLine();
        System.out.println("What is the dog's acquisition country?");
        String acqCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String status = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false)");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("What is the dog's in-service country?");
        String inService = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, status, reserved, inService);
        dogList.add(newDog);
        System.out.println("New dog added: " + name);
    }

    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey m : monkeyList) {
            if (m.getName().equalsIgnoreCase(name)) {
                System.out.println("This monkey is already in our system\n");
                return;
            }
        }
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the monkey's acquisition date?");
        String acqDate = scanner.nextLine();
        System.out.println("What is the monkey's acquisition country?");
        String acqCountry = scanner.nextLine();
        System.out.println("What is the monkey's training status?");
        String status = scanner.nextLine();
        System.out.println("Is the monkey reserved? (true/false)");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("What is the monkey's in-service country?");
        String inService = scanner.nextLine();
        System.out.println("What is the monkey's tail length?");
        String tailLength = scanner.nextLine();
        System.out.println("What is the monkey's height?");
        String height = scanner.nextLine();
        System.out.println("What is the monkey's body length?");
        String bodyLength = scanner.nextLine();
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        Monkey newMonkey = new Monkey(name, gender, age, weight, acqDate, acqCountry, status, reserved, inService, tailLength, height, bodyLength, species);
        monkeyList.add(newMonkey);
        System.out.println("New monkey added: " + name);
    }

    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type (dog/monkey):");
        String type = scanner.next().toLowerCase();
        System.out.println("Enter country in service:");
        String country = scanner.next();

        if (type.equals("dog")) {
            for (Dog d : dogList) {
                if (!d.getReserved() && d.getTrainingStatus().equalsIgnoreCase("in service") && d.getInServiceLocation().equalsIgnoreCase(country)) {
                    d.setReserved(true);
                    System.out.println("Dog " + d.getName() + " reserved.");
                    return;
                }
            }
        } else if (type.equals("monkey")) {
            for (Monkey m : monkeyList) {
                if (!m.getReserved() && m.getTrainingStatus().equalsIgnoreCase("in service") && m.getInServiceLocation().equalsIgnoreCase(country)) {
                    m.setReserved(true);
                    System.out.println("Monkey " + m.getName() + " reserved.");
                    return;
                }
            }
        } else {
            System.out.println("Unknown animal type.");
            return;
        }

        System.out.println("No " + type + " available in " + country + ".");
    }

    public static void printAnimals(String listType) {
        if (listType.equalsIgnoreCase("dog")) {
            System.out.println("Listing all dogs:");
            for (Dog d : dogList) {
                d.printAll();
                System.out.println(", Breed: " + d.getBreed() + ", Reserved: " + d.getReserved());
            }
        } else if (listType.equalsIgnoreCase("monkey")) {
            System.out.println("Listing all monkeys:");
            for (Monkey m : monkeyList) {
                m.printAll();
                System.out.println(", Species: " + m.getSpecies() + ", Reserved: " + m.getReserved());
            }
        } else if (listType.equalsIgnoreCase("available")) {
            System.out.println("Listing all available animals in service:");
            for (Dog d : dogList) {
                if (!d.getReserved() && d.getTrainingStatus().equalsIgnoreCase("in service")) {
                    d.printAll();
                    System.out.println(", Breed: " + d.getBreed());
                }
            }
            for (Monkey m : monkeyList) {
                if (!m.getReserved() && m.getTrainingStatus().equalsIgnoreCase("in service")) {
                    m.printAll();
                    System.out.println(", Species: " + m.getSpecies());
                }
            }
        } else {
            System.out.println("Invalid list type.");
        }
    }
}
