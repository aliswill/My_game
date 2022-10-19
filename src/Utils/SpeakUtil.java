package Utils;

import java.util.Scanner;


public class SpeakUtil {

	public static void speak(String content) {
		WaitUtil.wait(1500);
		//pressAnyKeyToContinue();
		System.out.println(content);						
	}
	
	private static void pressAnyKeyToContinue()
	 { 	       
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	
	public static void main(String[] args) {
		speak("ddd");
	
	}
}
