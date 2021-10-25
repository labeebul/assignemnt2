package mavi1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Passenger {
		String name,gender,address,Destination;
		int age,passportID,planeType,seatsToBook;
		double amount;
		double price;
		Passenger(){
			//Destination=org;
		};
		Passenger(String org,double f){
			Destination=org;
			price=f;
		};
		Passenger(String n,int a,String add,String Gen,int PT,String Des,int PassID)
		{
			name=n;
			age=a;
			address=add;
			gender=Gen;
			planeType=PT;
			Destination=Des;
			passportID=PassID;
		}
		void printTicket()
		{
			System.out.println("ticket Details ");
			System.out.println("Name:"+name);
			System.out.println("Age:"+age);
			System.out.println("Gender:"+gender);
			if(planeType==1)
			{
				System.out.println("Paackage TYpe: economy");
			}
			else if(planeType==2)
			{
				System.out.println("Paackage TYpe: First CLass");
			}
			else if(planeType==3)
			{
				System.out.println("Paackage TYpe: Business Class");
			}
			System.out.println("Destination:"+Destination);
			System.out.println("passportID:"+passportID);
			System.out.println("SEats:"+seatsToBook);
			
			System.out.println("Fare:"+calculateFare(price));
		}
		void setDestination(String org) {
			Destination=org;
		}
		@SuppressWarnings("resource")
		void getDetails() throws IOException {
			Scanner scanStr=new Scanner(System.in);
			Scanner scan=new Scanner(System.in);
			
			//System.out.print("Enter your name : ");
			//name=scanStr.nextLine();
			System.out.println("Instruction:Enter Only first NAME all in CAPITAL letter.");
			while(true)
			{
				System.out.print("Enter the your NAME : ");
				name=scanStr.nextLine();
				if(name.matches("[A-Z]+"))
				{
					String [] array = name.trim().split(" ");
					if(array.length==1){
							break;
					}else{
						 System.out.println("please onle enter one word");
						
					}

				}
				else 
				{
					 System.out.println("plaese correct the input");
				}
			}
			
			
			System.out.println("Instruction:Specify Your gender using only 'F' or 'M'. THhey must be in Capital");
			while(true)
			{
				System.out.print("Enter Your Gender : ");
				gender=scanStr.nextLine();
				if(gender.matches("[M]+")|| gender.matches("[F]+"))
				{
					String [] array = gender.trim().split(" ");
					if(array.length==1){
							break;
					}else{
						 System.out.println("please onle enter one word");
						
					}

				}
				else 
				{
					 System.out.println("plaese correct the input");
				}
			}
			
			
			System.out.print("The class you want to travel by (Economy=1,First Class=2 or Business Class=3): ");
			
		//	planeType=scanStr.nextByte();
			while( true)
			{
				//System.out.print("Enter the Flight ID : ");
			//	ID=Scanotr.nextByte();
				System.out.print("Enter the Flight Type you want : ");
		       // @SuppressWarnings("resource")
				//Scanner scanner= new Scanner(System.in);
		        try{
		             planeType=Integer.parseInt(scanStr.next());
		             if(planeType==1|| planeType==2||planeType==3)
						{
							
							
									break;
							

						}
						else 
						{
							 System.out.println("plaese correct the input");
						}
		            
		             
		        }catch (NumberFormatException ex) {
		            System.out.println("Flight Type must be a number ");
		        }
			}
			
			//System.out.print("Enter your age : ");
			//age=scan.nextByte();
			while( true)
			{
				//System.out.print("Enter the Flight ID : ");
			//	ID=Scanotr.nextByte();
				System.out.print("enter your age : ");
		       // @SuppressWarnings("resource")
				//Scanner scanner= new Scanner(System.in);
		        try{
		             age=Integer.parseInt(scanStr.next());
		             if(age>0)
						{
							
							
									break;
							

						}
						else 
						{
							 System.out.println("plaese correct the input");
						}
		            
		             
		        }catch (NumberFormatException ex) {
		            System.out.println("age must be a number ");
		        }
			}
			
			while( true)
			{
				
				System.out.print("Enter your Passport ID : ");
		       
		        try{
		             passportID=Integer.parseInt(scanStr.next());
		             if(passportID>0)
						{
							
							
									break;
							

						}
						else 
						{
							 System.out.println("plaese correct the input");
						}
		            
		             
		        }catch (NumberFormatException ex) {
		            System.out.println("age must be a number ");
		        }
			}
			System.out.print("Enter no. of seats you want to book : ");
			seatsToBook=scan.nextInt();
			 //WriteFile();
		}
		double calculateFare(double Norm) {
			if(planeType==2) {
				amount = (Norm*1.25)*seatsToBook;
			}
			if(planeType==3) {
				amount= (Norm*1.5)*seatsToBook;
			}
			else {
				amount=Norm*seatsToBook;
			}
			return amount;
		}
		@SuppressWarnings("resource")
		boolean payment() {
			System.out.print("press 1 for payment through credit card\npress 2 for payment through Debit card\n");
			System.out.print("press 3 for payment through Online platforms\n");
			Scanner scan=new Scanner(System.in);
			int s=scan.nextByte();
			if(s==1) {
				System.out.print("Enter the PIN :");
				@SuppressWarnings("unused")
				String PIN;
				PIN=scan.next();
				System.out.print("\n\nPayment Successful\n\n");
				
				return true;
			}
			else {
				throw new PaymentFail("\nplease enter the correct value!\n");
			}
		}
		void WriteFile() throws IOException {
			FileWriter myobj=new FileWriter("Passengers.txt",true);
			BufferedWriter bw = new BufferedWriter(myobj);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(name+","+gender+","+address+","+Destination+","+age+","+passportID+","+planeType+","+seatsToBook+","+calculateFare(price));
			//myobj.write(ID+","+origin+","+Destination+","+oDate+","+timing+","+seats+","+fare+"\n");
			pw.close();
			bw.close();
			myobj.close();
			printTicket();
			//System.out.print("Written Successfully");
		}
		
		
}

