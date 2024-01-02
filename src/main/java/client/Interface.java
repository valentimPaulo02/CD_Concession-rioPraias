package client;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import objects.*;


public class Interface {
	
	// for scanner work
	private static Scanner scanner = new Scanner(System.in);
	
	// for rest and soap work
	private static boolean isRest = true;
	private static int userId = -1;
	
	// for static work
	private static boolean choiceInput = true;
	private static boolean running = true;
	private static boolean menuInput = true;
	private static boolean loggedIn = false;
	private static boolean logInInput = true;
	
	public static void main(String[] args) throws JSONException {
		
		System.out.println("Escolha se quer usar Rest ou Soap!");
		System.out.println("1. Rest");
		System.out.println("2. Soap");
		
		while(choiceInput) {
			System.out.print("-> ");
			String input = scanner.nextLine();
			
			switch(input) {
				case "1":
					choiceInput = false;
					isRest = true;
					System.out.println("O programa irá utilizar Rest.");
					break;
				case "2":
					choiceInput = false;
					isRest = false;
					System.out.println("O programa irá utilizar Soap.");
					break;
				default:
					System.out.println("Opção inválida, insira novamente.");
			}
		}
		
		while(running) {
			//separate
			System.out.println();
			for (int i = 0; i < 70; i++) {
	            System.out.print("-");
	        }
			System.out.print("\n");
			System.out.println();
			//separate
			
			System.out.println("Aplicação Concessionario_Praias, Sol, Mar e Sombrinhas!");
			System.out.println("1. Login");
			System.out.println("2. Registar Utilizador");
			System.out.println("x. Sair");
			System.out.println();
			System.out.println("Insira a opção que pretende:");
			
			menuInput = true;
			
			while(menuInput) {
				System.out.print("-> ");
				String input = scanner.nextLine();
				
				switch(input) {
					case "1":
						login();
						menuInput = false;
						loggedIn= true;
						break;
					case "2":
						registarUtilizador();
						menuInput = false;
						break;
					case "x":
						System.out.println("Adeus...");
						menuInput = false;
						running=false;
						break;
					default:
						System.out.println("Opção inválida, insira novamente.");
				}
			}
			
			while(loggedIn) {
				//separate
				System.out.println();
				for (int i = 0; i < 70; i++) {
		            System.out.print("-");
		        }
				System.out.print("\n");
				System.out.println();
				//separate
				
				System.out.println("Bem-vindo, aqui está a lista de funcionalidades.");
				System.out.println("1. Listar Sombrinhas");
				System.out.println("2. Reservar Sombrinhas");
				System.out.println("3. Cancelar Sombrinha");
				System.out.println("x. Voltar ao menu");
				System.out.println();
				System.out.println("Insira a opção que pretende:");
				
				logInInput = true;
				
				while(logInInput) {
					System.out.print("-> ");
					String input = scanner.nextLine();
					
					switch(input) {
						case "1":
							listarSombrinhas();
							logInInput = false;
							break;
						case "2":
							reservarSombrinha();
							logInInput = false;
							break;
						case "3":
							cancelarSombrinha();
							logInInput = false;
							break;
						case "x":
							System.out.println("Retornando ao menu...");
							menuInput = true;
							logInInput = false;
							loggedIn = false;
							break;
						default:
							System.out.println("Opção inválida, insira novamente.");
					}
				}
			}
		}	
	}
	
	
	//missing SOAP implementation
	private static void listarSombrinhas() throws JSONException {
		String beachId = "";
		boolean beachIdInput = true;
		
		String date="";
		
		int startTime = 0;
		boolean startTimeInput = true;
		
		int endingTime = 0;
		boolean endingTimeInput = true;
		//variables
		
		//separate
		System.out.println();
		for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
		System.out.print("\n");
		System.out.println();
		//separate
		
		System.out.println("Notas Listar_Sombrinhas:");
		System.out.println("- Esta função vai listar todas as sombrinhas disponíveis na praia, na data e hora introduzida");
		System.out.println("- As reservas começam as 8:00 e terminam as 20:00 por períodos de 1 hora");
		System.out.println();
		
		//verify beachId input
		System.out.println("Introduza o id da praia que pretende (ex. A, B, C)");
		while(beachIdInput) {
			System.out.print("-> ");
			beachId = scanner.nextLine();
			
			if(!beachId.equals("A") && !beachId.equals("B") && !beachId.equals("C")) {
				System.out.println("Opção inválida");
			}else {
				beachIdInput = false;
			}
		}
		
		//verify date input
		System.out.println("Introduza a data que pretende (ex. aaaa-mm-dd)");
		System.out.print("-> ");
		date = scanner.nextLine();
		
		//verify startTime input
		System.out.println("Introduza a hora a que começaria pretendida (ex. 8, 10, 11)");
		while(startTimeInput) {
			System.out.print("-> ");
			startTime = scanner.nextInt();
			
			if(startTime<8 || startTime>19) {
				System.out.println("Opção inválida");
			}else {
				startTimeInput = false;
			}
		}
		
		//verify endingTime input
		System.out.println("Introduza a hora a que acabaria pretendida (ex. 15, 16, 17)");
		while(endingTimeInput) {
			System.out.print("-> ");
			endingTime = scanner.nextInt();	
			
			if(endingTime<9 || endingTime>20 || endingTime<=startTime) {
				System.out.println("Opção inválida");
			}else {
				endingTimeInput = false;
			}
		}
		
		System.out.println();
		System.out.println("Aqui está a lista de sombrinhas disponíveis para os dados introduzidos:");
		
		if(isRest) {
			InterfaceRestHelper.listarSombrinhas(beachId, startTime, endingTime, date);
		}else {
			InterfaceSoapHelper.listarSombrinhas(beachId, startTime, endingTime, date);
		}
		scanner.nextLine();
		
	}

	private static void reservarSombrinha() throws JSONException {

		String beachId = "";
		boolean beachIdInput = true;
		
		String date="";
		
		int startTime = 0;
		boolean startTimeInput = true;
		
		int endingTime = 0;
		boolean endingTimeInput = true;
		
		int nbrOfPeople = 0;
		boolean nbrOfPeopleInput = true;
		
		String service = "";
		boolean serviceInput = true;
		//variables
		
		//separate
		System.out.println();
		for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
		System.out.print("\n");
		System.out.println();
		//separate
		
		System.out.println("Notas Reservar_Sombrinha:");
		System.out.println("- Esta função vai listar todas as sombrinhas disponíveis na praia, na data e hora introduzida");
		System.out.println("- Depois de listar vai perdir o número de pessoas para a reserva e vai permitir o utilizador reservar várias"
				+ "sombrinhas até que as pessoas se possam todas sentar");
		System.out.println("- As reservas começam as 8:00 e terminam as 20:00 por períodos de 1 hora");
		System.out.println();
		
		//verify beachId input
		System.out.println("Introduza o id da praia da reserva (ex. A, B, C)");
		while(beachIdInput) {
			System.out.print("-> ");
			beachId = scanner.nextLine();
			
			if(!beachId.equals("A") && !beachId.equals("B") && !beachId.equals("C")) {
				System.out.println("Opção inválida");
			}else {
				beachIdInput = false;
			}
		}
		
		//verify date input
		System.out.println("Introduza a data da reserva (ex. aaaa-mm-dd)");
		System.out.print("-> ");
		date = scanner.nextLine();
		
		//verify startTime input
		System.out.println("Introduza a hora a que começaria a reserva (ex. 8, 10, 11)");
		while(startTimeInput) {
			System.out.print("-> ");
			startTime = scanner.nextInt();
			
			if(startTime<8 || startTime>19) {
				System.out.println("Opção inválida");
			}else {
				startTimeInput = false;
			}
		}
		
		//verify endingTime input
		System.out.println("Introduza a hora a que acabaria a reserva (ex. 15, 16, 17)");
		while(endingTimeInput) {
			System.out.print("-> ");
			endingTime = scanner.nextInt();	
			
			if(endingTime<9 || endingTime>20 || endingTime<=startTime) {
				System.out.println("Opção inválida");
			}else {
				endingTimeInput = false;
			}
		}
		
		//verify nbrOfPeople input
		System.out.println("Introduza o numero de pessoas da reserva (ex. 5, 6, 9)");
		while(nbrOfPeopleInput) {
			System.out.print("-> ");
			nbrOfPeople = scanner.nextInt();	
			
			if(nbrOfPeople<1 || nbrOfPeople>10) {
				System.out.println("Opção inválida");
			}else {
				nbrOfPeopleInput = false;
			}
		}
		
		System.out.println();
		System.out.println("Aqui está a lista de sombrinhas disponíveis para os dados introduzidos:");
		
		
		ArrayList<String> serviceIds = new ArrayList<>();
		if(isRest) {
			serviceIds = InterfaceRestHelper.listarSombrinhas(beachId, startTime, endingTime, date);
		}else {
			serviceIds = InterfaceSoapHelper.listarSombrinhas(beachId, startTime, endingTime, date);
		}
				
		scanner.nextLine();
		System.out.println();
		
		if(!isRest) {
			System.out.println("Apesar de estar o a usar soap, esta função é executada com Rest,");
			System.out.println("devido à existência de um erro que não fomos capazes de corrigir");
			System.out.println();
		}
		
		while(nbrOfPeople>0) {
			
			System.out.println("Insira o ID da sombrinha que pretende reservar:");
			serviceInput = true;
			
			while(serviceInput) {
				System.out.print("-> ");
				service = scanner.nextLine();
				
				if(!serviceIds.contains(service)) {
					System.out.println("Opção inválida");
				}else {
					
					if(isRest) {
						nbrOfPeople -= InterfaceRestHelper.reservarSombrinhas(beachId, startTime, endingTime, date, userId, service);
					}else {
						nbrOfPeople -= InterfaceRestHelper.reservarSombrinhas(beachId, startTime, endingTime, date, userId, service);
					}
					serviceInput = false;
					
					if(nbrOfPeople > 0) {
						System.out.println("Ainda faltam sentar "+ nbrOfPeople +" pessoas.");
						System.out.println();
					}else {
						System.out.println("A sua reserva foi concluida obrigado.");
					}
				}
			}
		}
	}
	
	private static void cancelarSombrinha() throws JSONException {
		
		int bookingId = 0;
		boolean bookingIdInput = true;
		//variables
		
		//separate
		System.out.println();
		for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
		System.out.print("\n");
		System.out.println();
		//separate
		
		System.out.println("Notas Cancelar_Sombrinha:");
		System.out.println("- Esta função vai listar todas as reservas feitas pelo utilizador");
		System.out.println("- Depois de listar vai perdir o id da sombrinha, cujo o utilizador pretende cancelar");
		System.out.println();
		
		System.out.println("Aqui está a sua lista de reservas:");
		
		
		ArrayList<Integer> bookingIds = new ArrayList<>();
		if(isRest) {
			bookingIds = InterfaceRestHelper.listarReservas(userId);
		}else {
			bookingIds = InterfaceSoapHelper.listarReservas(userId);
		}
		
		if(bookingIds.size()==0) {
			System.out.println();
			System.out.println("Voce não tem reservas.");
			bookingIdInput = false;
		}else {
			System.out.println();
			System.out.println("Inisira o id da reserva que pretende cancelar:");
			
			while(bookingIdInput) {
				System.out.print("-> ");
				bookingId = scanner.nextInt();
				
				if(!bookingIds.contains(bookingId)) {
					System.out.println("Opção inválida");
				}else {
					if(isRest) {
						InterfaceRestHelper.cancerlarReserva(bookingId);
					}else {
						InterfaceSoapHelper.cancerlarReserva(bookingId);
					}
					
					scanner.nextLine();
					bookingIdInput = false;
				}
			}
		}
	}
	
	private static void login() throws JSONException {
		
		String username = "";
		String password = "";
		boolean loggingIn = true;
		
		//separate
		System.out.println();
		for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
		System.out.print("\n");
		System.out.println();
		//separate
		
		System.out.println("Notas Login:");
		System.out.println("- Para efetuar o login não pode introduzir nos inputs");
		System.out.println();
		
		while(loggingIn) {
			System.out.println("Insira o username:");
			System.out.print("-> ");
			username = scanner.nextLine();
			
			System.out.println("Insira a password:");
			System.out.print("-> ");
			password = scanner.nextLine();
			
			
			int value = -1; 				
			if(isRest) {
				value = InterfaceRestHelper.login(username, password);
			}else {
				value = InterfaceSoapHelper.login(username, password);
			}
			
			if(value>0) {
				userId = value;
				loggingIn = false;
				
				System.out.println("Login efetuado com sucesso");
			}else {
				System.out.println("Os dados introduzidos não são válidos");
				System.out.println();
			}	
		}
	}
	
	private static void registarUtilizador() throws JSONException {
		String username = "";
		String password = "";
		String repeatPassword = "";
		boolean repeatPasswordInput = true;
		boolean loggingIn = true;
		
		//separate
		System.out.println();
		for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
		System.out.print("\n");
		System.out.println();
		//separate
		
		System.out.println("Notas Registar_Utilizador:");
		System.out.println("- Para efetuar o registo não pode introduzir espaços nos inputs");
		System.out.println("- Terá que inserir duas passwords identicas para ser possível realizar o registo");
		System.out.println();
		
		while(loggingIn) {
			System.out.println("Insira o username:");
			System.out.print("-> ");
			username = scanner.nextLine();
			
			System.out.println("Insira a password:");
			System.out.print("-> ");
			password = scanner.nextLine();
			
			System.out.println("Repita a password:");
			repeatPasswordInput = true;
			while(repeatPasswordInput) {
				System.out.print("-> ");
				repeatPassword = scanner.nextLine();
				
				if(repeatPassword.equals(password)) {
					repeatPasswordInput = false;
				}else {
					System.out.println("As passwords não correspondem. Insira novamente");
				}
			}
			
			boolean valid = true;
			if(isRest) {
				valid = InterfaceRestHelper.registarUtilizador(username, password);	
			}else {
				valid = InterfaceSoapHelper.registarUtilizador(username, password);
			}			
			
			if(valid) {
				System.out.println("Utilizador registado com sucesso.");
				loggingIn = false;
			}else {
				System.out.println("Os dados introduzidos não são válidos");
				System.out.println();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}