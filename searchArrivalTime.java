//3. Searching for all trips with a given arrival time, returning full details of all trips matching the criteria (zero, one or more), 
//  sorted by trip id
//  Arrival time should be provided by the user as hh:mm:ss. When reading in stop_times.txt file you will need to 
// remove all invalid times, e.g., there are times in the file that start at 27/28 hours, so are clearly invalid. 
// Maximum time allowed is 23:59:59.



package finalProject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class searchArrivalTime {
	
	public static String formatTime(String time)
	{
        time =  time.replaceAll(" ", "0");
        String[] splitTime = time.split(":");
        for(int a=0; a<3; a++)
        {
        if(splitTime[a].length() == 1)
            splitTime[a] = "0" + splitTime[a];
        }
        time = splitTime[0] + ":" + splitTime[1] + ":" + splitTime[2];
        return time;
     }
    static boolean isValid(String time)
     {
	        String[] splitTime = time.split(":");
	        if(Integer.parseInt(splitTime[0]) < 24 )
	        {
	        	if(Integer.parseInt(splitTime[1]) < 60)
	        	{
	        		if(Integer.parseInt(splitTime[2]) < 60)
	        		{
	        			return true;
	        		}
	        		else return false;
	        	}
	        	else 
	            return false;
	        }
	        else
	        { 
	        	if(Integer.parseInt(splitTime[1]) ==0 && Integer.parseInt(splitTime[2]) ==0)
	        	return true;
	        	else return false;
	        }
	  }
	public static ArrayList<String> formatData(ArrayList<String> tripsWithArrivalTime, String arrivalTime) 
	{

		ArrayList<String> output = new ArrayList<String>();

		for (int index = 0; index < tripsWithArrivalTime.size(); index++) {

			String data = tripsWithArrivalTime.get(index);
			String[] splitData = data.split("\\,");
			String outputString = "Trip ID: " + splitData[0] + ", Arrival Time: " + splitData[1]
					+ ", DepartureTime: " + splitData[2] + ", Stop ID: " + splitData[3]
					+ ", Stop sequence: " + splitData[4] + ", Stop headsign: " + splitData[5]
					+ ", Pickup Type: " + splitData[6] + ", Drop off type: " + splitData[7];

			if (data.split("\\,").length == 8) {

				output.add(outputString);
			}

			else {
				outputString += ", Distance: " + data.split("\\,")[8];
				output.add(outputString);
			}
		}

		return output;

	}
	public static HashMap<String, ArrayList<String>> createSystem() throws FileNotFoundException {

			Scanner inputScanner = new Scanner(new File("stop_times.txt"));
			inputScanner.nextLine();
			HashMap<String, ArrayList<String>> busTrips = new HashMap<String, ArrayList<String>>();

			while (inputScanner.hasNextLine()) 
			{
				String data = inputScanner.nextLine();
				String time = data.split("\\,")[1];
				time = formatTime(time);

				if (isValid(time)) 
				{
					if (busTrips.containsKey(time)) 
					{
						busTrips.get(time).add(data);
					} 
					else
					{
						ArrayList<String> infoArray = new ArrayList<String>();
						infoArray.add(data);
						busTrips.put(time, infoArray);
					}

				}
			}
			inputScanner.close();
			return busTrips;
		}
	public static ArrayList<String> findArrivalTime(String arrivalTime) throws FileNotFoundException 
	{
		
		HashMap<String, ArrayList<String>> busTrips = createSystem();
		
		ArrayList<String> tripsArrivalTime = new ArrayList<String>();

		if (isValid(arrivalTime)) 
		{
			if (busTrips.containsKey(arrivalTime)) 
			{
				tripsArrivalTime = busTrips.get(arrivalTime);
				sortID(tripsArrivalTime);
			} 
			else 
				tripsArrivalTime.add("No buses in our database arrive at "+ arrivalTime);
		}
		else 
			tripsArrivalTime.add(arrivalTime + " is not a valid time");

		if (tripsArrivalTime.contains("No buses in our database arrive at "+ arrivalTime) 
				|| tripsArrivalTime.contains(arrivalTime + " is not a valid time")) 
			return tripsArrivalTime;
		else 
			return formatData(tripsArrivalTime, arrivalTime);
	}

	// using insertion sort
	public static void sortID(ArrayList<String> tripsWithArrivalTime) {

		int[] sortedID = new int[tripsWithArrivalTime.size()];

		for (int i = 0; i < tripsWithArrivalTime.size(); i++) {

			String stringID = tripsWithArrivalTime.get(i).split("\\,")[0];
			int numberID  = Integer.parseInt(stringID);

			sortedID[i] = numberID;
		}

		int i = 0;

		for (int counter = 0; counter < sortedID.length; counter++) {

			i = 0;

			do {

				if (sortedID[i] > sortedID[i + 1]) {

					String data = tripsWithArrivalTime.get(i + 1);

					sortedID[i + 1] = sortedID[i];

					tripsWithArrivalTime.set(i + 1, tripsWithArrivalTime.get(i));

					tripsWithArrivalTime.set(i, data);
				}

				i++;
			} while (i + 1 != sortedID.length);

		}

	}

}
