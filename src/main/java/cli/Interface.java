package cli;
import java.util.*;

public class Interface {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean loggedIn = false;
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, Beach> beaches = new HashMap<>();
    private static HashMap<String, ArrayList<ArrayList<String>>> userUmbrellaReservations = new HashMap<>();

    public static void main(String[] args) {
        // Add a test user
        users.put("test", "test");

        // Add beach information
        initializeBeaches();

        while (true) {
            displayWelcomeScreen();
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (option) {
                case 1:
                    if (!loggedIn) {
                        login();
                    } else {
                        System.out.println("You are already logged in!");
                    }
                    break;
                case 2:
                    register();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again!");
            }

            while (loggedIn) {
                displayHomeScreen();
                option = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer

                switch (option) {
                    case 1:
                        reserveUmbrella();
                        break;
                    case 2:
                        cancelReservedUmbrella();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        loggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again!");
                }
            }
        }
    }
    
    private static void displayWelcomeScreen() {
        System.out.println("Welcome! Please choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
    }

    private static void displayHomeScreen() {
        System.out.println("Home Screen - Choose an option:");
        System.out.println("1. Reserve Umbrella");
        System.out.println("2. Cancel Reserved Umbrella");
        System.out.println("0. Logout");
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again!");
        }
    }

    private static void register() {
        System.out.println("Enter a new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter a new password:");
        String newPassword = scanner.nextLine();

        if (users.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose another one.");
        } else {
            users.put(newUsername, newPassword);
            loggedIn = true;
            System.out.println("User registered successfully and logged in!");
        }
    }
    
    private static String getCurrentUser() {
        return "test";
    }

    private static void initializeBeaches() {
        // Beach A
        HashMap<String, Integer> beachAUmbrellas = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            if (i <= 10) {
                beachAUmbrellas.put("A" + i, 2); // 2-person umbrellas A1-A10
            } else if (i <= 15 && i>10) {
                beachAUmbrellas.put("A" + i, 3); // 3-person umbrellas A11-A15
            } else {
                beachAUmbrellas.put("A" + i, 4); // 4-person umbrellas A16-A20
            }
        }
        Beach beachA = new Beach("A", beachAUmbrellas);
        beaches.put("A", beachA);

        // Beach B
        HashMap<String, Integer> beachBUmbrellas = new HashMap<>();
        for (int i = 1; i <= 11; i++) {
            if (i <= 5) {
                beachBUmbrellas.put("B" + i, 2); // 2-person umbrellas B1-B5
            } else if (i <= 10 && i>5) {
                beachBUmbrellas.put("B" + i, 3); // 3-person umbrellas B6-B10
            } else {
                beachBUmbrellas.put("B" + i, 4); // 4-person umbrella B11
            }
        }
        Beach beachB = new Beach("B", beachBUmbrellas);
        beaches.put("B", beachB);

        // Beach C
        HashMap<String, Integer> beachCUmbrellas = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            beachCUmbrellas.put("C" + i, 2); // 2-person umbrellas C1-C10
        }
        Beach beachC = new Beach("C", beachCUmbrellas);
        beaches.put("C", beachC);
    }

    
    private static void reserveUmbrella() {
        System.out.println("Enter the beach ID (A, B, or C):");
        String beach = scanner.nextLine().toUpperCase();

        Beach selectedBeach = beaches.get(beach);
        if (selectedBeach == null) {
            System.out.println("Invalid beach!");
            return;
        }

        System.out.println("Enter date (DD-MM-YYYY):");
        String date = scanner.nextLine();
        System.out.println("Enter time (HH:MM):");
        String time = scanner.nextLine();
        System.out.println("Enter number of people:");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        listAvailableUmbrellas(beach, date, time, numberOfPeople);

        HashMap<String, Integer> umbrellasForBeach = new HashMap<>(selectedBeach.getUmbrellas());

        if (umbrellasForBeach.isEmpty()) {
            System.out.println("No umbrellas available for this beach!");
            return;
        }

        ArrayList<String> selectedUmbrellas = new ArrayList<>();
        int remainingCapacity = numberOfPeople;

        while (remainingCapacity > 0) {
            System.out.println("Enter the Umbrella ID to reserve (0 to finish):");
            String selectedId = scanner.nextLine();

            if (selectedId.equals("0")) {
                break;
            }

            if (umbrellasForBeach.containsKey(selectedId)) {
                int capacity = umbrellasForBeach.get(selectedId);

                if (capacity >= remainingCapacity) {
                    selectedUmbrellas.add(selectedId);
                    umbrellasForBeach.put(selectedId, capacity - remainingCapacity);
                    remainingCapacity = 0;
                } else {
                    selectedUmbrellas.add(selectedId);
                    remainingCapacity -= capacity;
                    umbrellasForBeach.remove(selectedId);
                }
            } else {
                System.out.println("Invalid Umbrella ID. Please try again!");
            }
        }

        if (remainingCapacity == 0) {
            ArrayList<ArrayList<String>> userRes = userUmbrellaReservations.get(getCurrentUser());
            if (userRes == null) {
                userRes = new ArrayList<>();
            }


            selectedBeach.setUmbrellas(umbrellasForBeach);

           
            ArrayList<ArrayList<String>> updatedReservations = new ArrayList<>();
            for (ArrayList<String> res : userRes) {
                if (!(res.get(0).equals(beach) && res.get(1).equals("0") && res.get(2).equals("0"))) {
                    updatedReservations.add(res);
                }
            }
            userUmbrellaReservations.put(getCurrentUser(), updatedReservations);


            ArrayList<String> reservationDetails = new ArrayList<>(Arrays.asList(beach, date, time, String.valueOf(numberOfPeople), String.join(",", selectedUmbrellas)));
            userRes.add(reservationDetails);
            userUmbrellaReservations.put(getCurrentUser(), userRes);

            System.out.println("Umbrella(s) reserved successfully!");
        } else {
            System.out.println("Insufficient umbrella capacity to accommodate all people.");
        }
    }

    private static void cancelReservedUmbrella() {
        String currentUser = getCurrentUser();
        ArrayList<ArrayList<String>> userRes = userUmbrellaReservations.get(currentUser);
        boolean foundReservation = false;

        System.out.println("User: " + currentUser + " - Reserved Umbrellas:");

        for (ArrayList<String> res : userRes) {
            System.out.println(res);
            String date = res.get(1);
            String time = res.get(2);

            if (!date.equals("0") && !time.equals("0")) {
                foundReservation = true;
                break;
            }
        }

        if (!foundReservation) {
            System.out.println("You have no reserved umbrellas.");
            return;
        }

        System.out.println("Your reserved umbrellas:");

        for (ArrayList<String> res : userRes) {
            String beach = res.get(0);
            String date = res.get(1);
            String time = res.get(2);

            if (!date.equals("0") && !time.equals("0")) {
                System.out.println("Beach: " + beach + " - Date: " + date + " - Time: " + time);
            }
        }

        System.out.println("Enter the Umbrella ID to cancel reservation:");
        String umbrellaID = scanner.nextLine();

        boolean found = false;

        for (ArrayList<String> res : userRes) {
            if (res.size() >= 5 && res.contains(umbrellaID)) {
                String beach = res.get(0);

                Beach selectedBeach = beaches.get(beach);

                if (selectedBeach != null) {
                    HashMap<String, Integer> umbrellasForBeach = new HashMap<>(selectedBeach.getUmbrellas());
                    String[] reservedUmbrellas = res.get(res.size() - 1).split(",");

                    for (String umbrella : reservedUmbrellas) {
                        String[] parts = umbrella.split(":");
                        if (parts.length == 2 && parts[0].equals(umbrellaID)) {
                            int capacity = Integer.parseInt(parts[1]);
                            int currentCapacity = umbrellasForBeach.getOrDefault(umbrellaID, 0);
                            umbrellasForBeach.put(umbrellaID, currentCapacity + capacity);
                        }
                    }

                    selectedBeach.setUmbrellas(umbrellasForBeach);
                    res.set(1, "0"); // Set date to "0" to mark the reservation as canceled
                    res.set(2, "0"); // Set time to "0" to mark the reservation as canceled
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            userUmbrellaReservations.put(currentUser, userRes);
            System.out.println("Umbrella reservation " + umbrellaID + " canceled successfully!");
        } else {
            System.out.println("Invalid Umbrella ID or no reservation found!");
        }
    }
    
    private static void listAvailableUmbrellas(String beach, String date, String time, int numberOfPeople) {
        Beach selectedBeach = beaches.get(beach);

        if (selectedBeach == null) {
            System.out.println("Invalid beach!");
            return;
        }

        // Logic to list available umbrellas
        HashMap<String, Integer> umbrellasForBeach = selectedBeach.getUmbrellas();

        if (umbrellasForBeach.isEmpty()) {
            System.out.println("No umbrellas available for this beach!");
            return;
        }

        System.out.println("Available umbrellas for " + beach + " at " + date + ", " + time + ":");

        for (Map.Entry<String, Integer> entry : umbrellasForBeach.entrySet()) {
            String umbrellaId = entry.getKey();
            int capacity = entry.getValue();

            if (capacity >= numberOfPeople) {
                System.out.println("Umbrella ID: " + umbrellaId + " - Capacity: " + capacity);
            }
        }
    }


    private static class Beach {
        private String beachId;
        private HashMap<String, Integer> umbrellas;

        public Beach(String beachId, HashMap<String, Integer> umbrellas) {
            this.beachId = beachId;
            this.umbrellas = umbrellas;
        }

        public String getBeachId() {
            return beachId;
        }

        public HashMap<String, Integer> getUmbrellas() {
            return umbrellas;
        }
        
        public void setUmbrellas(HashMap<String, Integer> updatedUmbrellas) {
            this.umbrellas = updatedUmbrellas;
        }
    }
}
