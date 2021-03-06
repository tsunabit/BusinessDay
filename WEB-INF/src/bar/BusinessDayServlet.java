package bar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BusinessDayServlet extends HttpServlet {
	final Logger logger = Logger.getLogger (Validation.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// Nothing
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Validation vali = new Validation();
			//check the null String about form input
			if(!vali.checkNullString("startDate", request.getParameter("startDate"))){
				request.setAttribute("InputError", "Start");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}else if(!vali.checkNullString("endDate", request.getParameter("endDate"))){
				request.setAttribute("InputError", "End");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			if(!vali.checkInputPattern("startDate", request.getParameter("startDate")) || 
					!vali.checkInputPattern("startDate", request.getParameter("endDate"))) {
				request.setAttribute("InputError", "FormatError");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}
//			}else if(!vali.checkInputPattern("startDate", request.getParameter("endDate"))) {
//				request.setAttribute("InputError", "FormatError");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
//				dispatcher.forward(request, response);
//				return;
//			}
			
			//開始日と終了日をDate型へ変換する
			LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
			logger.trace("input startDate : " + LocalDate.parse(request.getParameter("startDate")));
			LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
			logger.trace("input endDate   : " + LocalDate.parse(request.getParameter("endDate")));
			
			int count = 0;
			ArrayList<String> arrayWeekend = new ArrayList<String>();
			
			while(endDate.compareTo(startDate) >= 0) {
				//土曜日と日曜日をskipして日数をカウント
				if(!startDate.getDayOfWeek().toString().equals("SUNDAY") && 
				   !startDate.getDayOfWeek().toString().equals("SATURDAY")) {
					count = count + 1;
				}else {
					logger.trace("skip = " + startDate.toString() + " " + startDate.getDayOfWeek().toString());
					arrayWeekend.add(startDate.toString() + " " + startDate.getDayOfWeek().toString());
				}
				startDate = startDate.plusDays(1);
			}
			
			request.setAttribute("dayDiff", count);
			logger.trace("Business day count = " + count);
			
			StringBuilder buff = new StringBuilder();
			for(String skip : arrayWeekend){
				buff.append(skip + ",");
			}
			
			request.setAttribute("arrayWkd", arrayWeekend);
			logger.trace("skip = " + buff.toString());
			
			//取得した日数の総時間を計算
			Calculator cal = new Calculator();
			int totalOperatingTime = cal.multiply(count, 8);
			request.setAttribute("totalOperatingTime", totalOperatingTime);
			
		}catch (DateTimeParseException e) {
			logger.fatal(e.getMessage());
			logger.fatal(e.getStackTrace());
		}catch (Exception e) {
			logger.fatal(e.getMessage());
			logger.fatal(e.getStackTrace());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
	
	public void destory() {
		//Nothing
	}
	
}
