package cli;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean loggedIn = false;
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {
    	//username and password test
    	usernames.add("teste");
    	passwords.add("teste");
    	
        while (true) {
        	displayMenuMain();
            int option = scanner.nextInt();
            scanner.nextLine(); // clean buffer

            if (!loggedIn) {
            	processOptionNotAuthenticated(option);
            } else {
            	processOptionAuthenticated(option);
            }
        }
    }

    private static void displayMenuMain() {
        if (!loggedIn) {
            System.out.println("Bem-vindo! Por favor, escolha uma opção:");
            System.out.println("1. Login");
            System.out.println("2. Registrar novo utilizador");
            System.out.println("0. Sair");
        } else {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Reservar sombrinha");
            System.out.println("2. Cancelar reserva de sombrinha");
            System.out.println("3. Listar as sombrinhas disponíveis");
            System.out.println("0. Sair");
        }
    }

    private static void processOptionNotAuthenticated(int option) {
        switch (option) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 0:
                System.out.println("Leaving...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option. Try again!");
        }
    }

    private static void processOptionAuthenticated(int option) {
        switch (option) {
            case 1:
                bookUmbrella();
                break;
            case 2:
                cancelReservedUmbrella();
                break;
            case 3:
                listAvailableUmbrellas();
                break;
            case 0:
                System.out.println("Leaving...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option. Try again!");
        }
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Type the password:");
        String password = scanner.nextLine();

        int userIndex = usernames.indexOf(username);
        if (userIndex != -1 && passwords.get(userIndex).equals(password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Try again!");
        }
    }

    private static void register() {
        System.out.println("Enter a new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter a new password:");
        String newPassword = scanner.nextLine();

        //checks if the new user already exists
        if (usernames.contains(newUsername)) {
            System.out.println("Username already exists. Choose another.");
        } else {
            //adding a new username and password pair
            usernames.add(newUsername);
            passwords.add(newPassword);
            System.out.println("User registered successfully");
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////

    private static void bookUmbrella() {
        System.out.println("Choose the beach (A, B or C):");
        String beach = scanner.nextLine();
        System.out.println("Choose the number of people (2, 3 or 4):");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine(); //clean buffer

        //check the chosen beach and availability of umbrellas
        switch (beach.toUpperCase()) {
            case "A":
                if (numberOfPeople == 2) {
                    bookUmbrellaForTwoAtBeachA();
                } else if (numberOfPeople == 3) {
                    bookUmbrellaForThreeAtBeachA();
                } else if (numberOfPeople == 4) {
                    bookUmbrellaForFourAtBeachA();
                } else {
                    System.out.println("Invalid number of people for beach A!");
                }
                break;
            case "B":
                if (numberOfPeople == 2) {
                    bookUmbrellaForTwoAtBeachB();
                } else if (numberOfPeople == 3) {
                    bookUmbrellaForThreeAtBeachB();
                } else if (numberOfPeople == 4) {
                    bookUmbrellaForFourAtBeachB();
                } else {
                    System.out.println("Invalid number of people for beach B!");
                }
                break;
            case "C":
                if (numberOfPeople == 2) {
                    bookUmbrellaForTwoAtBeachC();
                } else {
                    System.out.println("Invalid number of people for beach C!");
                }
                break;
            default:
                System.out.println("Invalid beach!");
        }
    }

    private static void bookUmbrellaForTwoAtBeachA() {
        int availableUmbrellasForTwoAtBeachA = 10; 
        if (availableUmbrellasForTwoAtBeachA > 0) {
            availableUmbrellasForTwoAtBeachA--;
            System.out.println("Booking umbrella in A for 2 people...");
            System.out.println("Reservation made successfully!");
        } else {
            System.out.println("There are no umbrellas available for 2 people on beach A.");
        }
    }

    // Funções similares para os outros casos na praia A (3 e 4 pessoas)
    private static void bookUmbrellaForThreeAtBeachA() {
        int availableUmbrellasForThreeAtBeachA = 5;
        if (availableUmbrellasForThreeAtBeachA > 0) {
        	availableUmbrellasForThreeAtBeachA--;
            System.out.println("Booking umbrella in A for 3 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 3 people on beach A.");
        }
    }

    private static void bookUmbrellaForFourAtBeachA() {
        int availableUmbrellasForFourAtBeachA = 4;
        if (availableUmbrellasForFourAtBeachA > 0) {
        	availableUmbrellasForFourAtBeachA--;
            System.out.println("Booking umbrella in A for 4 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 4 people on beach A.");
        }
    }
    private static void bookUmbrellaForTwoAtBeachB() {
        int availableUmbrellasForTwoAtBeachB = 5;
        if (availableUmbrellasForTwoAtBeachB > 0) {
        	availableUmbrellasForTwoAtBeachB--;
            System.out.println("Booking an umbrella in B for 2 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 2 people on beach B.");
        }
    }

    private static void bookUmbrellaForThreeAtBeachB() {
        int availableUmbrellasForThreeAtBeachB = 4;
        if (availableUmbrellasForThreeAtBeachB > 0) {
        	availableUmbrellasForThreeAtBeachB--;
            System.out.println("Booking an umbrella in B for 3 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 3 people on beach B.");
        }
    }

    private static void bookUmbrellaForFourAtBeachB() {
        int availableUmbrellasForFourAtBeachB = 1;
        if (availableUmbrellasForFourAtBeachB > 0) {
        	availableUmbrellasForFourAtBeachB--;
            System.out.println("Booking an umbrella in B for 4 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 4 people on beach B.");
        }
    }

    private static void bookUmbrellaForTwoAtBeachC() {
        int availableUmbrellasForTwoAtBeachC = 10;
        if (availableUmbrellasForTwoAtBeachC > 0) {
        	availableUmbrellasForTwoAtBeachC--;
            System.out.println("Booking an umbrella in C for 2 people...");
            System.out.println("Reservation made successfully!");
        } else {
        	System.out.println("There are no umbrellas available for 2 people on beach C.");
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////

  //A IMPLEMENTAR ALGO MAIS COMPLEXO DEPOIS

    private static void cancelReservedUmbrella() {
        System.out.println("Enter the ID of the umbrella to be cancelled:");
        String umbrellaID = scanner.nextLine();

        System.out.println("Umbrella reservation " + umbrellaID + " canceled successfully!");
    }

    private static void listAvailableUmbrellas() {
        System.out.println("List available umbrellas...");

  
        System.out.println("Beach A:");
        System.out.println("Available for 2 people: 7 umbrellas");
        System.out.println("Available for 3 people: 4 umbrellas");
        System.out.println("Available for 4 people: 3 umbrellas");

        System.out.println("Beach B:");
        System.out.println("Available for 2 people: 5 umbrellas");
        System.out.println("Available for 3 people: 2 umbrellas");
        System.out.println("Available for 4 people: 1 umbrella");

        System.out.println("Beach C:");
        System.out.println("Available for 2 people: 8 umbrellas");
    }
}

