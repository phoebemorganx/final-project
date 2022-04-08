// test for stopSearch class
package finalProject;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.TST;

public class test {

	public static void main(String[] args) throws FileNotFoundException
	{
	    System.out.print("Enter stop name or start of stop name \n"); 
	    Scanner input = new Scanner(System.in);
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

	    input.close();
	 }
}