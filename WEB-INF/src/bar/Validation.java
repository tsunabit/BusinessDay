package bar;

import java.util.Date;
import org.apache.log4j.Logger;

public class Validation {
	
	public boolean checkKaramoji(String strInput) {
		final Logger logger = Logger.getLogger (Validation.class);
		logger.error("aaaa");
		
		if(strInput.equals("")) {
			System.out.println("error start");
			return false;
		}
		return true;
	}
	
	public boolean checkDateeSoukan(Date startDate, Date endDate) {
		//1970/01/01 00:00:00 GMTからの経過ミリ秒数に変換
		long dateTimeStart = startDate.getTime();
		long dateTimeEnd   = endDate.getTime();
		
		if(dateTimeStart > dateTimeEnd) {
			return false;
		}else {
			return true;
		}
	}

}
