package Utils;

import java.util.regex.Pattern;

public class CheckType {
	public static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();     
	}
}
