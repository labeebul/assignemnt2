package mavi1;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Admin {
	private String name;
//	String password;
	
	Admin(){
	};
	Admin(String n){
		name=n;
	}
	void setName(String n) {
		name=n;
	}
	void menu() throws Exception {
		int choice;
		System.out.print("Admin: "+name+"\n");
		System.out.print("choose an option : \n");
		//System.out.print("press 1 to add a flight : \n");		
		@SuppressWarnings("resource")
		Scanner adminreader=new Scanner(System.in);
		choice=adminreader.nextByte();
		
		while( true)
		{
			//System.out.print("Enter the Flight ID : ");
		//	ID=Scanotr.nextByte();
			System.out.print("press 1 to add a flight : ");
	       // @SuppressWarnings("resource")
			//Scanner scanner= new Scanner(System.in);
	        try{
	             choice=Integer.parseInt(adminreader.next());
	             if(choice==1)
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
		//return choice;
		if (choice==1) {
			AddFlight();
		}
	}
	
	void AddFlight() throws Exception {
		Flights obj1=new Flights();
		obj1.addNew();
		
	}
	
}
