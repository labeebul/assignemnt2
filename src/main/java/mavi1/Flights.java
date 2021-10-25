package mavi1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class Flights {
	private String origin,Destination,oDate,timing;
	private int seats,ID;
	private double fare;
	
	
	void setOrigin(String org) {
		origin=org;
	}
	void setDestination(String org) {
		Destination=org;
	}
	void setDate(String org) {
		oDate=org;
	}
	void setTiming(String org) {
		timing=org;
	}
	void setSeats(int org) {
		seats=org;
	}
	void setID(int id) {
		ID=id;
	}
	int getID() {
		return ID;
	}
	void setFare(double org) {
		fare=org;
	}
	
	String getOrigin() {
		return origin;
	}
	String getDes()
	{
		return Destination;
	}
	String getDate(){
		return oDate;
	}
	String getTime() {
		return timing;
	}
	int getSeats() {
		return seats;
	}
	double getFare() {
		return fare;
	}
	void addNew() throws Exception {
		@SuppressWarnings("resource")
		Scanner ScanStr=new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner Scanotr=new Scanner(System.in);
		while( true)
		{
			//System.out.print("Enter the Flight ID : ");
		//	ID=Scanotr.nextByte();
			System.out.print("Enter the Flight ID number : ");
	       // @SuppressWarnings("resource")
			//Scanner scanner= new Scanner(System.in);
	        try{
	             ID=Integer.parseInt(ScanStr.next());
	             break;
	             
	        }catch (NumberFormatException ex) {
	            System.out.println("Flight Id must be a number ");
	        }
		}
		
		System.out.println("Instruction: Enter only only word abreviations for cities. And it must be Capital");
		while(true)
		{
			System.out.print("Enter the Origin of the flight : ");
			origin=ScanStr.nextLine();
			if(origin.matches("[A-Z]+"))
			{
				String [] array = origin.trim().split(" ");
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
		System.out.println("Instruction: Enter only only word abreviations for cities.And it must be Capital");
		while(true)
		{
			System.out.print("Enter the Destination of the flight : ");
			Destination=ScanStr.nextLine();
			if(Destination.matches("[A-Z]+"))
			{
				String [] array = origin.trim().split(" ");
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
		
		while(true)
		{
			System.out.println("Correct date formae : dd-MM-yyyy ");
			System.out.print("Enter the Date of the flight : ");
			
			SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yy");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			String strDate = input.nextLine();

			try
			{
				Date date = dateInput.parse(strDate);
				oDate=new SimpleDateFormat("dd-MM-yy").format(date);
				break;
			} 
			catch (ParseException e) 
			{
				System.out.println("Parce Exception");
		   
			}
		}
		while(true)
		{
			System.out.println("Correct time format : hh:mm ");
			System.out.print("Enter the Time of the flight : ");
			
			SimpleDateFormat dateInput = new SimpleDateFormat("hh:mm");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);

			String strDate = input.nextLine();

			try
			{
				Date date = dateInput.parse(strDate);
				timing=new SimpleDateFormat("hh:mm").format(date);
				break;
			} 
			catch (ParseException e) 
			{
				System.out.println("Parce Exception");
		   
			}
		}
	//	System.out.print("Enter the Date of the flight :  "+ oDate);
		//oDate=ScanStr.nextLine();
		//System.out.print("Enter the time of departure of the flight : "+timing);
		
		System.out.print("Enter the no. of seats in the flight : ");
		while(true)
		{
			seats=Scanotr.nextByte();
		
		  try
		  {
			
			if (seats>60) {
				System.out.println("\"Maximum number of seats in the plane is 60.");
				 throw new ArithmeticException("Maximum number of seats in the plane is 60. Enter again");
			}
			break;
		  }
		  catch(ArithmeticException e)
		  {
			System.out.print("Enter the no. of seats in the flight : ");
		  }
		}
		System.out.print("Enter the fare of the flight : ");
		while(true)
		{
			fare=Scanotr.nextDouble();
		
		  try
		  {
			
			if (fare<0.0) {
				System.out.println("Fare Can't be negative.");
				 throw new ArithmeticException("Fare Can't be negative");
			}
			break;
		  }
		  catch(ArithmeticException e)
		  {
			System.out.print("Enter the no. of seats in the flight : ");
		  }
		}
		
		
		try {
			writeToFile();
		} catch (IOException e) {
			
		}
	}
	void FlightDetails() {
		System.out.print("the Flight ID  : "+ID+"\n");
		System.out.print("the origin of flight  : "+origin+"\n");
		System.out.print("the Destination offlight  : "+Destination+"\n");
		System.out.print("the Date of flight  : "+oDate+"\n");
		System.out.print("the timing of  flight  : "+timing+"\n");
		System.out.print("the Seats in the flight  : "+seats+"\n");
		System.out.print("the normal fare of the flight  : "+fare+"\n");
		
	}
	void writeToFile() throws IOException {
		FileWriter myobj=new FileWriter("Flights.txt",true);
		BufferedWriter bw = new BufferedWriter(myobj);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println(ID+","+origin+","+Destination+","+oDate+","+timing+","+seats+","+fare);
		//myobj.write(ID+","+origin+","+Destination+","+oDate+","+timing+","+seats+","+fare+"\n");
		pw.close();
		bw.close();
		myobj.close();
		
		
		System.out.print("Written Successfully");
		FlightDetails();
	}

	void FlightDetailsMenu(){
		System.out.print(ID+"\t|"+origin+"|"+Destination+"|"+oDate+"|"+timing+"|"+seats+"|"+fare+"\n");
	}
	
	void FlightDetailsSearch() {
		System.out.print("ID : "+ID+"| Origin : "+origin+"|Destination"+Destination+"|date: "+oDate+"|time : "+timing+"|seats available: "+seats+"\n");
	}
}
