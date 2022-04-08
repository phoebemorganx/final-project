// 2. Searching for a bus stop by full name or by the first few characters in the name, using a ternary search tree (TST), 
// returning the full stop information for each stop matching the search criteria (which can be zero, one or more stops)
// In order for this to provide meaningful search functionality please move keywords flagstop, wb, nb, sb, eb from the 
// start of the names to the end of the names of the stops when reading the file into a TST 
// (eg “WB HASTINGS ST FS HOLDOM AVE” becomes “HASTINGS ST FS HOLDOM AVE WB”)
package finalProject;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;
import edu.princeton.cs.algs4.TST;

public class stopSearch {
		
	public static TST<Integer> createSystem() throws FileNotFoundException 
	{
		// creates TST
		TST<Integer> tst1 = new TST<Integer>();
		File stopsFile = new File("stops.txt");
		Scanner stopsSc = new Scanner(stopsFile);
		int lineCount=2;
		stopsSc.nextLine();
		while(stopsSc.hasNextLine()) {
			String stopName = getName(stopsSc.nextLine());
			tst1.put(stopName, lineCount);
			lineCount++;
		}
		stopsSc.close();
		return tst1;
	}	
		
		
	
	/// function to move keyword from start of name to end 
	public static String getName(String input) 
	{
		String[] splitString = input.split(",");
		String name = splitString[2];
		String[] splitName = name.split(" ");
		String key = splitName[0];
		if (key.equalsIgnoreCase("flagstop") || key.equalsIgnoreCase("wb") ||
	                key.equalsIgnoreCase("nb") || key.equalsIgnoreCase("sb") ||
	                key.equalsIgnoreCase("eb"))
		{
			for (int i = 0; i <= splitName.length - 2; i++) 
			{
                splitName[i] = splitName[i + 1];
            }
			splitName[splitName.length - 1] = key;	
			name = Arrays.toString(splitName);
            name = name.replace(",", "").replace("[", "").replace("]", "");
		}
		String[] splitName2 = name.split(" ");
		String key2 = splitName2[0];
		if (key2.equalsIgnoreCase("flagstop") || key2.equalsIgnoreCase("wb") ||
                key2.equalsIgnoreCase("nb") || key2.equalsIgnoreCase("sb") ||
                key2.equalsIgnoreCase("eb"))
	    {
		for (int i = 0; i <= splitName2.length - 2; i++) 
		{
            splitName2[i] = splitName2[i + 1];
        }
		splitName2[splitName2.length - 1] = key2;	
		name = Arrays.toString(splitName2);
        name = name.replace(",", "").replace("[", "").replace("]", "");
	    }
		
		name = name+", Stop ID: "+ splitString[0] + ", Stop Code: "+ splitString[1]
				+ ", Stop Desc: "+splitString[3]+", Longitude:"+splitString[4]+", Latitude"
				+splitString[5]+", ZoneID: "+splitString[6]+", Location Type:"+splitString[8];
        
        
		return name;

    }
}

