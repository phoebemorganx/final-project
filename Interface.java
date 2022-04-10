// 4. Provide front interface enabling selection between the above features or an option to exit the programme, and enabling 
// required user input. It does not matter if this is command-line or graphical UI, as long as functionality/error checking is provided.

package finalProject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.princeton.cs.algs4.TST;
public class Interface {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to the Vancouver bus system.\n");
		String bus = 
		".-------------------------------------------------------------.\n"
		+ "'------..-------------..----------..----------..----------..--.|\n"
		+ "|       \\\\            ||          ||          ||          ||  ||\n"
		+ "|        \\\\           ||          ||          ||          ||  ||\n"
		+ "|    ..   ||  _    _  ||    _   _ || _    _   ||    _    _||  ||\n"
		+ "|    ||   || //   //  ||   //  // ||//   //   ||   //   //|| /||\n"
		+ "|_.------\"''----------''----------''----------''----------''--'|\n"
		+ "|)|      |       |       |       |    |         |      ||==|  |\n"
		+ "| |      |  _-_  |       |       |    |  .-.    |      ||==| C|\n"
		+ "| |  __  |.'.-.' |   _   |   _   |    |.'.-.'.  |  __  | \"__=='\n"
		+ "'---------'|( )|'----------------------'|( )|'----------\"\"\n"
		+ "            '-'  VANCOUVER BUS SYSTEM    '-'\n"
		+ "";
		System.out.print(bus);
		String menu =
		" \nEnter 1 to search routes between stops \n"
		+"Enter 2 to search for stop information by stop\n"
		+"Enter 3 to search by arrival time \n"
		+ "(Or enter any other key to quit) \n";
		System.out.print(menu);
		String option = input.next();
		switch (option) 
		{
		// case "1":
	// 	 try 
		// {
			
	//	 }
		// catch exceptions
		 // break;
		case"2":
		{ 
			try 
		   { System.out.print("Enter stop name or start of stop name \n"); 
		    String key = input.next();
		    key = key.toUpperCase();
		    TST<Integer> tst = stopSearch.createSystem();
		    Iterable<String> matches = tst.keysWithPrefix(key);
		    int count = 0;
		    for(String s: matches ) {
		    	System.out.print(s+"\n\n");
		    	count++;
		    }
		    if(count == 0)
		    	System.out.print("No bus stops in our data base begin with "+key);
		    } 
		   catch(FileNotFoundException e) { }
		}
		break;
	    case"3":
			  {
	        try {
			System.out.print("Enter arrival time in form 'hh:mm:dd' \n");
			String arrivalTime = input.next();
					
					
			ArrayList<String> trips = searchArrivalTime.findArrivalTime(arrivalTime);
		    for (String s : trips) {
			System.out.print( s + "\n");
				    }
	        }
	        catch(FileNotFoundException e) {}
									
			}
		 break;	  
			  
		 default: 
				  System.out.print("Goodbye :)");
		   }
		
		
		input.close();
	}

}

