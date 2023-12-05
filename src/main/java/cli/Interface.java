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

    private static void bookUmbrella() {
        //umbrella reservation logic - do later
        System.out.println("Booking an unbrella");
    }

    private static void cancelReservedUmbrella() {
        //umbrella reservation cancellation logic
        System.out.println("Canceling umbrella reservation...");
    }

    private static void listAvailableUmbrellas() {
        //logic for listing available umbrellas
        System.out.println("Listing available umbrellas...");
    }
}

