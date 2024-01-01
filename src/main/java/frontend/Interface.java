package frontend;
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
	private static int userId = 69;
	
	// for static work
	private static int turn=1;
	private static boolean running = true;
	private static boolean menuInput = true;
	private static boolean loggedIn = false;
	private static boolean logInInput = true;
	
	public static void main(String[] args) throws JSONException {
		
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
		
		for (int i = 0; i < 10; i++) {
            System.out.println();
        }
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
			
			try {
				URL url = new URL("http://localhost:8080/CD_Project/rest/LISTAR_SOMBRINHAS");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
	
				String input = "{\"Booking\":{"
						+ "\"beachId\":\""+beachId+"\","
						+ "\"date\":\""+date+"\","
						+ "\"startTime\":\""+startTime+"\","
						+ "\"endingTime\":\""+endingTime+"\""
						+ "}}";
	
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();
	
				Scanner scanner;
			    if (conn.getResponseCode() != 200) {
			    	  scanner = new Scanner(conn.getErrorStream());
			    } else {
			    	  scanner = new Scanner(conn.getInputStream());
			    }
		      	scanner.useDelimiter("\\Z");
		      	
		      	String jsonResponse = scanner.next();
		      	JSONObject jsonObject = new JSONObject(jsonResponse);
		        JSONArray serviceArray = jsonObject.getJSONArray("Service");

		        // Iterate through the array and print the information
		        for (int i = 0; i < serviceArray.length(); i++) {
		            JSONObject service = serviceArray.getJSONObject(i);
		            String id = service.getString("id");
		            int nbrOfSeats = service.getInt("nbrOfSeats");
		            
		            System.out.println("Id da Sombrinha: "+id+" | Lugares: "+nbrOfSeats);
		        }
		      	
		      	scanner.close();
		      	conn.disconnect();
		      
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			scanner.nextLine();
			
		}else {
			//SOAP IMPLEMENTATION
		}

		
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
		
		for (int i = 0; i < 10; i++) {
            System.out.println();
        }
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
		
		
		if(isRest) {
			
			ArrayList<String> serviceIds = new ArrayList<>();
			
			try {
				URL url = new URL("http://localhost:8080/CD_Project/rest/LISTAR_SOMBRINHAS");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
	
				String input = "{\"Booking\":{"
						+ "\"beachId\":\""+beachId+"\","
						+ "\"date\":\""+date+"\","
						+ "\"startTime\":\""+startTime+"\","
						+ "\"endingTime\":\""+endingTime+"\""
						+ "}}";
	
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();
	
				Scanner scanner;
			    if (conn.getResponseCode() != 200) {
			    	  scanner = new Scanner(conn.getErrorStream());
			    } else {
			    	  scanner = new Scanner(conn.getInputStream());
			    }
		      	scanner.useDelimiter("\\Z");
		      	
		      	String jsonResponse = scanner.next();
		      	JSONObject jsonObject = new JSONObject(jsonResponse);
		        JSONArray serviceArray = jsonObject.getJSONArray("Service");

		        // Iterate through the array and print the information
		        for (int i = 0; i < serviceArray.length(); i++) {
		            JSONObject object = serviceArray.getJSONObject(i);
		            String id = object.getString("id");
		            int nbrOfSeats = object.getInt("nbrOfSeats");
		            
		            System.out.println("Id da Sombrinha: "+id+" | Lugares: "+nbrOfSeats);
		            serviceIds.add(id);
		        }
		      	
		      	scanner.close();
		      	conn.disconnect();
		      
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			scanner.nextLine();
			System.out.println();
			
			while(nbrOfPeople>0) {
				
				System.out.println("Insira o ID da sombrinha que pretende reservar:");
				serviceInput = true;
				
				while(serviceInput) {
					System.out.print("-> ");
					service = scanner.nextLine();
					
					if(!serviceIds.contains(service)) {
						System.out.println("Opção inválida");
					}else {
						
						try {
							URL url = new URL("http://localhost:8080/CD_Project/rest/RESERVAR_SOMBRINHA");
							HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							conn.setDoOutput(true);
							conn.setRequestMethod("POST");
							conn.setRequestProperty("Content-Type", "application/json");
				
							String input = "{\"Booking\":{"
									+ "\"beachId\":\""+beachId+"\","
									+ "\"date\":\""+date+"\","
									+ "\"startTime\":\""+startTime+"\","
									+ "\"userId\":\""+userId+"\","
									+ "\"endingTime\":\""+endingTime+"\","
									+ "\"serviceId\":\""+service+"\""
									+ "}}";
				
							OutputStream os = conn.getOutputStream();
							os.write(input.getBytes());
							os.flush();
				
							Scanner scanner;
						    if (conn.getResponseCode() != 200) {
						    	  scanner = new Scanner(conn.getErrorStream());
						    } else {
						    	  scanner = new Scanner(conn.getInputStream());
						    }
					      	scanner.useDelimiter("\\Z");
					      	
					      	nbrOfPeople -= Integer.parseInt(scanner.next());
					      	
					      	scanner.close();
					      	conn.disconnect();
					      
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
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
				
		}else {
			//SOAP IMPLEMENTATION
		}
	}
	
	private static void cancelarSombrinha() throws JSONException {
		
		ArrayList<Integer> bookingIds = new ArrayList<>();
		
		int bookingId = 0;
		boolean bookingIdInput = true;
		//variables
		
		for (int i = 0; i < 10; i++) {
            System.out.println();
        }
		
		System.out.println("Notas Cancelar_Sombrinha:");
		System.out.println("- Esta função vai listar todas as reservas feitas pelo utilizador");
		System.out.println("- Depois de listar vai perdir o id da sombrinha, cujo o utilizador pretende cancelar");
		System.out.println();
		
		System.out.println("Aqui está a sua lista de reservas:");
		
		if(isRest) {
			
			try {
				URL url = new URL("http://localhost:8080/CD_Project/rest/LISTAR_RESERVAS");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
	
				String input = "{\"User\":{"
						+ "\"id\":\""+userId+"\""
						+ "}}";
	
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();
	
				Scanner scanner;
			    if (conn.getResponseCode() != 200) {
			    	  scanner = new Scanner(conn.getErrorStream());
			    } else {
			    	  scanner = new Scanner(conn.getInputStream());
			    }
		      	scanner.useDelimiter("\\Z");
		      	
		      	String jsonResponse = scanner.next();
		      	JSONObject jsonObject = new JSONObject(jsonResponse);
		        JSONArray serviceBooking = jsonObject.getJSONArray("Booking");

		        // Iterate through the array and print the information
		        for (int i = 0; i < serviceBooking.length(); i++) {
		            JSONObject booking = serviceBooking.getJSONObject(i);
		            int id = booking.getInt("id");
		            int startTime = booking.getInt("startTime");
		            int endingTime = booking.getInt("endingTime");
		            String date = booking.getString("date");
		            String serviceId = booking.getString("serviceId");
		            
		            System.out.println("Id da Reserva: "+id+" | Id da Sombrinha: "+serviceId+" | "+date+" das "+startTime+" às "+endingTime);
		            bookingIds.add(id);
		        }
		      	
		      	scanner.close();
		      	conn.disconnect();
		      
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			System.out.println("Inisira o id da reserva que pretende cancelar:");
			
			while(bookingIdInput) {
				System.out.print("-> ");
				bookingId = scanner.nextInt();
				
				if(!bookingIds.contains(bookingId)) {
					System.out.println("Opção inválida");
				}else {
					try {
						URL url = new URL("http://localhost:8080/CD_Project/rest/CANCELAR_SOMBRINHA");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setDoOutput(true);
						conn.setRequestMethod("POST");
						conn.setRequestProperty("Content-Type", "application/json");
			
						String input = "{\"Booking\":{"
								+ "\"id\":\""+bookingId+"\""
								+ "}}";
			
						OutputStream os = conn.getOutputStream();
						os.write(input.getBytes());
						os.flush();
			
						Scanner scanner;
					    if (conn.getResponseCode() != 200) {
					    	  scanner = new Scanner(conn.getErrorStream());
					    } else {
					    	  scanner = new Scanner(conn.getInputStream());
					    }
				      	scanner.useDelimiter("\\Z");
				      	
				      	System.out.println(scanner.next());
				      	
				      	scanner.close();
				      	conn.disconnect();
				      
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					scanner.nextLine();
					bookingIdInput = false;
				}
			}
			
		}else {
			//SOAP IMPLEMENTATION
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}













