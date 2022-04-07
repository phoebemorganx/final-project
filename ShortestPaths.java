package finalProject;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class ShortestPaths 

{
	public double busMatrix[][] = new double[12479][12479];


	public void buildBusMatrix() throws FileNotFoundException
	{
		
		for(int i = 0; i < 12479; i++)
		{
			for(int j = 0; j < 12479; j++) 
			{
				if(i != j)
				{

					busMatrix[i][j] = Math.pow(1.7*10,308);

				}
				else {
					busMatrix[i][j] = 0;
				}
			}
		}
	}
	
	
	File stopTimesTxt = new File("stop_times.txt");

	Scanner stopTimesFile = new Scanner(stopTimesTxt);
	stopTimesFile.useDelimiter(",")

	stopTimesFile.nextLine();
	
	int start = 0, end =0, lastID = 0, currentID = 0;
	double cost = 1, shortestTime = 0;
    String lineCurrent;

	while(stopTimesFile.hasNextLine()) 
	{
		lastID = currentID;
		currentID = stopTimesFile.nextInt();
		stopTimesFile.next(); 
		stopTimesFile.next();
		start = end;
		end = stopTimesFile.nextInt();

		if (lastID == currentID){
			busMatrix[start][end] = cost;
		}
		stopTimesFile.nextLine();
	}
	stopTimesFile.close();

}
}