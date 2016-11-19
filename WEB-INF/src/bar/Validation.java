package bar;

import org.apache.log4j.Logger;

public class Validation {
	final Logger logger = Logger.getLogger (Validation.class);
	
	public boolean checkNullString(String keyWord , String strInput){
		if(strInput.equals("")) {
			logger.error(keyWord + " is nullstring");
			return false;
		}
		return true;
	}
	
	public boolean checkKaramoji(String strInput) {
		
		if(strInput.equals("")) {
			logger.error("strInput is nullstring");
			return false;
		}
		return true;
	}
}
