package bar;

import org.apache.log4j.Logger;

public class Validation {
	final Logger logger = Logger.getLogger (Validation.class);
	
	public boolean checkNullString(String keyWord , String strInput){
		if(strInput == null || strInput.length() == 0) {
			logger.error(keyWord + " is nullstring");
			return false;
		}
		
		return true;
	}
	
}
