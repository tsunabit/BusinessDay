package bar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Validation {
	final Logger logger = Logger.getLogger (Validation.class);
	
	public boolean checkNullString(String keyWord , String strInput) {
		if(strInput == null || strInput.length() == 0) {
			logger.error(keyWord + " is nullstring");
			return false;
		}
		return true;
	}
	
	public boolean checkInputPattern(String keyWord , String strInput) {
		
        //判定するパターンを生成
//        Pattern p = Pattern.compile("^[0-9]*$");
		Pattern p = Pattern.compile("[0-9]* | \"-\"");
        Matcher m = p.matcher(strInput);
        
        if(m.find()) {
        	return true;
        }else {
        	return false;
        }
	}
	
}
