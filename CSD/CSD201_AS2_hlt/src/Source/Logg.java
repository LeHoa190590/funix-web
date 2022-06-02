package Source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logg {	
	    public static void log(String message) throws IOException { 
	      PrintWriter out = new PrintWriter(new FileWriter("console_output.txt", true));
	      System.out.print(message);
	      out.write(message);
	      out.close();
	    }	
}
