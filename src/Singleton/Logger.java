package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
	private static Logger instance;
	
	private Logger() {}
	
	public static Logger getInstance() {
		if(instance != null) {
			return instance;
		}else {
			return new Logger();
		}
	}
	
	
	public void logToFile(String msg) {
		try(
				FileWriter fw = new FileWriter("log.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.append("[" + new Date().toString() + "] -> " + msg +"\n");
			} catch (IOException e) {
			    System.out.println("Error Occured While Logging");
			}
	}
}
