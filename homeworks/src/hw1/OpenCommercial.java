package hw1;

/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();

    /* Replace this comment with your solution.  */
    URL U = new URL("https://www." + inputLine + ".com");   //http://www.W.com and https://www.X.com have different outputs
    InputStream ins = U.openStream();
    InputStreamReader inr = new InputStreamReader(ins);
    BufferedReader comp = new BufferedReader(inr);

// solution 1: if I have not learned loop yet.
    String str0 = new String();
    String str1 = new String();
    String str2 = new String();
    String str3 = new String();
    String str4 = new String();
    
    str0 = comp.readLine();
    str1 = comp.readLine();   
    str2 = comp.readLine();
    str3 = comp.readLine();
    str4 = comp.readLine();
    
    System.out.println(str4);
    System.out.println(str3);
    System.out.println(str2);
    System.out.println(str1);
    System.out.println(str0);
    
/* solution 2 -- loop
    String[] str = new String[5];
    for(int i=0; i<5; i++) {
    	str[i] = comp.readLine();
    }
    for(int i=4; i>=0; i--) {
    	System.out.println(str[i]);
    }
*/
  }
}
