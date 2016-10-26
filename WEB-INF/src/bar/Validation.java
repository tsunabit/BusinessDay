package bar;

import org.apache.log4j.Logger;

public class Validation {
	final Logger logger = Logger.getLogger (Validation.class);
	
	public boolean checkKaramoji(String strInput) {
		
		if(strInput.equals("")) {
			logger.error("strInputが空文字");
			return false;
		}
		return true;
	}
}
