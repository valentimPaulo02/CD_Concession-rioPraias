package frontend;
import java.util.*;
import objects.*;


public class Interface {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		// for rest and soap work
		boolean isRest = true;
		int userId = 0;
		
		// for static work
		int turn=1;
		boolean running = true;
		boolean menuInput = true;
		boolean loggedIn = false;
		boolean logInInput = true;
		
		while(running) {
			if(turn!=1) {
				for (int i = 0; i < 10; i++) {
		            System.out.println();
		        }
			}
			else {
				turn++;
			}
			
			System.out.println("Aplicação Concessionario_Praias, Sol, Mar e Sombrinhas!");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("x. Sair");
			System.out.println();
			System.out.println("Insira a opção que pretende:");
			
			menuInput = true;
			
			while(menuInput) {
				System.out.print("-> ");
				String input = scanner.nextLine();
				
				switch(input) {
					case "1":
						System.out.println("Going for login");
						menuInput = false;
						loggedIn= true;
						break;
					case "2":
						System.out.println("Going for register");
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
				for (int i = 0; i < 10; i++) {
		            System.out.println();
		        }
				
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
							System.out.println("Going for Listar Sombrinhas");
							logInInput = false;
							break;
						case "2":
							System.out.println("Going for Reservar Sombrinhas");
							logInInput = false;
							break;
						case "3":
							System.out.println("Going for Cancelar Sombrinha");
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

}
