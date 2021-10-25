package mavi1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {

	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner sac1=new Scanner(System.in);
		Scanner sac2=new Scanner(System.in);
		boolean available=false;
		int FlightID;
		int flight_count=0,totall=0;
		String line="";
		String Desti,date;
		Flights[] ArF=new Flights[100];
		Flights art = null;
		Passenger[] ArP=new Passenger[100];
		for(int i=0;i<100;i++) {
			ArF[i]=new Flights();
		}
		for(int i=0;i<100;i++) {
			ArP[i]=new Passenger();
		}
		String passw;
		System.out.println("welcome\n\n");
		String adminPass="w";
		Admin ad1=new Admin("LAbeeb(19i-0609)");
		char cont='y';
		while(cont=='y'||cont=='Y') {
			
			int choice;
			while( true)
			{
				//System.out.print("Enter the Flight ID : ");
			//	ID=Scanotr.nextByte();
				System.out.println("admin press 1");
				System.out.println("customer press 2");
				System.out.println("Choose an option");
				
		       // @SuppressWarnings("resource")
				//Scanner scanner= new Scanner(System.in);
		        try{
		        	choice=Integer.parseInt(sac1.next());
		             if(choice==1|| choice==2)
						{
							
							
									break;
							

						}
						else 
						{
							 System.out.println("plaese correct the input");
						}
		            
		             
		        }catch (NumberFormatException ex) {
		            System.out.println("must be a number ");
		        }
			}
			switch(choice) {
			
			
			//admin operations
			
			case 1:
				System.out.println("password:w ");
				System.out.print("Enter the password: ");
				while(true)
				{
				passw=sac2.next();
				try {
				if(passw.compareTo(adminPass)==0) {
					ad1.menu();
				}
				else {
					System.out.println("Wrong PAssword! ");
					throw new ArithmeticException("You are not an authentic user : Password did not match\n");
				}
				break;
				}
				catch(ArithmeticException e)
				{
					System.out.print("Enter the password: ");
				}
				
				}
				//user operations
			case 2:
				try {
					BufferedReader readFile=new BufferedReader(new FileReader("Flights.txt"));
					while((line=readFile.readLine())!=null) {
						String[] str=line.split(",");
						ArF[flight_count].setID(Integer.parseInt(str[0]));
						ArF[flight_count].setOrigin(str[1]);
						ArF[flight_count].setDestination(str[2]);
						ArF[flight_count].setDate(str[3]);
						ArF[flight_count].setTiming(str[4]);
						ArF[flight_count].setSeats(Integer.parseInt(str[5]));
						ArF[flight_count].setFare(Double.parseDouble(str[6]));
						flight_count++;
					}

					System.out.println("Press 1 to see the schedule");
					System.out.println("Press 2 to search for a flight by destination");
					System.out.println("Press 3 to search a flight by date and destination");
					System.out.println("press 4 for cancellation");
					choice=sac1.nextByte();
					switch(choice) {
					case 1:
						System.out.print("FlightID|Origin|Destination|Date|Timing|seats|fare\n");
						for(int i=0;i<flight_count;i++) {
							ArF[i].FlightDetailsMenu();
						}
						break;
					case 2:
						System.out.print("Availbale Destinations ");
						for(int i=0;i<flight_count;i++) {
							
							System.out.println(ArF[i].getDes());
						}
						System.out.print("\nEnter the Destination: ");
						Desti=sac2.nextLine();
						
						for(int i=0;i<flight_count;i++) {
							if(Desti.compareToIgnoreCase(ArF[i].getDes())==0) {
								ArF[i].FlightDetailsSearch();
								art=ArF[i];
								available=true;
							}
						}
						if(available==false) {
							System.out.print("\t\t\t\tNo Flights Found!!!\n\n\n");
						}
						Flights temp1=new Flights();
						System.out.print("press to 1 make a booking\n");
						choice=sac1.nextByte();
						if(choice==1) {
							System.out.print("Enter the Flight Id: ");
							FlightID=sac1.nextInt();
							System.out.print("Please fill in the details : \n");
							Passenger p=new Passenger(art.getDes(),art.getFare()); 
							
							
							@SuppressWarnings("unused")
							boolean check=false;
							for(int i=0;i<flight_count;i++) {
								if(FlightID==ArF[i].getID()) {
									temp1=ArF[i];
									check=true;
									break;
								}
							}
							if(check==true) {
								p.getDetails();
								if(p.seatsToBook>temp1.getSeats()){
									throw new SeatsExceedLimit("There are not enough seats in the plane");	
								}
								else {
									p.calculateFare(FlightID);
									boolean paid=p.payment();
									if(paid==true) {
										p.WriteFile();
										for(int i=0;i<flight_count;i++) {
											if(temp1.getID()==ArF[i].getID()) {
												ArF[i].setSeats(ArF[i].getSeats()-p.seatsToBook);
												break;
											}
										}
									}
								}
							
							}
							else {
								System.out.print("No Flights with such ID available");
							}

						}
						break;
					case 3:
						System.out.println("Availbale destinations And Dates ");
							for(int i=0;i<flight_count;i++) {
							
							System.out.print(ArF[i].getDes()+ "   ");
							System.out.println(ArF[i].getDate());
						}
						System.out.print("\nEnter the Destination: ");

						Desti=sac2.nextLine();
						System.out.print("\nEnter the date(format: dd-mm-yyyy): ");
						date=sac2.nextLine();
						for(int i=0;i<flight_count;i++) {
							if((Desti.compareToIgnoreCase(ArF[i].getDes())==0)&&(date.compareToIgnoreCase(ArF[i].getDate())==0)) {
								//System.out.print("");
								ArF[i].FlightDetailsSearch();
								available=true;
							}
						}
						if(available==false) {
							System.out.print("\t\t\t\tNo Flights Found!!!\n\n\n");
							break;
						}
						Flights temp=new Flights();
						System.out.print("To make a booking press 1 else press any other button\n");
						choice=sac1.nextByte();
						if(choice==1) {
							System.out.print("Enter the Flight Id: ");
							FlightID=sac1.nextInt();
							System.out.print("Please fill in the details : \n");
							Passenger p=new Passenger(art.getDes(),art.getFare()); 
							
							
							boolean check=false;
							for(int i=0;i<flight_count;i++) {
								if(FlightID==ArF[i].getID()) {
									temp=ArF[i];
									check=true;
									break;
								}
							}
							if(check==true) {
								p.getDetails();
								if(p.seatsToBook>temp.getSeats()){
									throw new SeatsExceedLimit("There are not enough seats in the plane");	
								}
								else {
									p.calculateFare(FlightID);
									boolean paid=p.payment();
									if(paid==true) {
										p.WriteFile();
										for(int i=0;i<flight_count;i++) {
											if(temp.getID()==ArF[i].getID()) {
												ArF[i].setSeats(ArF[i].getSeats()-p.seatsToBook);
												break;
											}
										}
									}
								}
							
							}
							else {
								System.out.print("No Flights with such ID available");
							}
						}
						break;
					case 4:
						BufferedReader readFile1=new BufferedReader(new FileReader("Passengers.txt"));
						while((line=readFile1.readLine())!=null) {
							String[] str=line.split(",");
							ArP[totall].name=str[0];
							ArP[totall].gender=str[1];
							ArP[totall].address=str[2];
							ArP[totall].Destination=str[3];
							ArP[totall].age=Integer.parseInt(str[4]);
							ArP[totall].passportID=Integer.parseInt(str[5]);
							ArP[totall].planeType=Integer.parseInt(str[6]);
							ArP[totall].seatsToBook=Integer.parseInt(str[7]);
							ArP[totall].amount=Double.parseDouble(str[8]);
							totall++;
						}
						int pid=sac1.nextInt();
						int recSeats;
						break;
						default:
							System.out.print("Wrong input");
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.print("wrong option selected!!\n");
			}
			System.out.print("If you want to continue press 'y'\n");
			cont=sac2.nextLine().charAt(0);
			available=false;
		}
	}


}
