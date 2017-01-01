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
		Pattern p = Pattern.compile("^[0-9]{4}+-[0-9]{2}+-[0-9]{2}+");
        Matcher m = p.matcher(strInput);
        
        if(m.find()) {
        	//logger.error(keyWord + " is RFC3339 format error");
        	return true;
        }else {
        	logger.error(keyWord + " is RFC3339 format error");
        	return false;
        }
	}
	
}
