package Utils;

import java.util.Scanner;


public class SpeakUtil {

	public static void speak(int para,String content) {
		//1:一般對話 2:接收選項
		if(para==1) {
			 System.out.println(content);
			 Scanner sc = new Scanner(System.in);	        
		     String nextLine = sc.nextLine();		        
		     while(!nextLine.equals("")) {
		            nextLine = sc.nextLine();
		        }
		}else {
			 System.out.println(content);
		}
		
	    
		
		//WaitUtil.wait(1000);		
//		System.out.println(content);
//		Scanner sc = new Scanner(System.in);
//		if(sc.NextLine().equals(""));
		

		//pressAnyKeyToContinue();
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

}
