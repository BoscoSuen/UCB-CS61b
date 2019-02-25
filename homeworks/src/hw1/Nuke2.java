package hw1;

import java.net.*;
import java.io.*;

public class Nuke2 {

	public static void main(String[] args) throws Exception {
		BufferedReader keyboard;
		String str;
		
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("type a string from your keyboard:");
	    System.out.flush();        /* Make sure the line is printed immediately. */
	    
	    str = keyboard.readLine();   //when encounter error, add "throw Exception" at the method declaration part
	    
	    StringBuffer strbuff = new StringBuffer(str);
	    strbuff.delete(1,2);      //remove the second character

	    System.out.println("Now remove the second character:");
	    System.out.println(strbuff);
	    

	}

}
