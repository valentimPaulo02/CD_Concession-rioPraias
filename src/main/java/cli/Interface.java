package cli;

import java.util.Scanner;

public class Interface {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean loggedIn = false;

    public static void main(String[] args) {
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
            System.out.println("2. Registrar novo usuário");
            System.out.println("0. Sair");
        } else {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Reservar sombrinha");
            System.out.println("2. Cancelar reserva de sombrinha");
            System.out.println("3. Listar sombrinhas disponíveis");
            System.out.println("0. Sair");
        }
    }

    private static void processOptionNotAuthenticated(int option) {
        switch (option) {
            case 1:
                login();
                break;
            case 2:
                registerNewUser();
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
        //login logic - do later
        loggedIn = true;
        System.out.println("Login successfully!");
    }

    private static void registerNewUser() {
        //new user registration logic - do later
        System.out.println("Registering new user...");
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

