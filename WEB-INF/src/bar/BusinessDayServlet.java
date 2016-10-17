package bar;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BusinessDayServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// Nothing
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Validation vali = new Validation();
			//check the form input
			if(!vali.checkKaramoji(request.getParameter("startDate"))) {
				request.setAttribute("InputError", "Start");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}else if(!vali.checkKaramoji(request.getParameter("endDate"))) {
				request.setAttribute("InputError", "End");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}
			//check the form input DateeSoukan
//			if(!vali.checkDateeSoukan(startDate, endDate)) {
//				request.setAttribute("InputError", "SoukanCheck");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
//				dispatcher.forward(request, response);
//				return;
//			}
			
			
			//---------------------
			LocalDate start = LocalDate.parse(request.getParameter("startDate"));
			LocalDate end = LocalDate.parse(request.getParameter("endDate"));
			
			int count = 0;
			while(end.compareTo(start) >= 0) {
				if(!start.getDayOfWeek().toString().equals("SUNDAY") && !start.getDayOfWeek().toString().equals("SATURDAY")) {
					count = count + 1;
				}
				start = start.plusDays(1);
//				System.out.println("***start*** = " + start);
			}
			System.out.println("***count*** = " + count);
			request.setAttribute("dayDiff", count);
			
			//取得した日数の総時間を計算
			long totalOperatingTime = count * 8;
			request.setAttribute("totalOperatingTime", totalOperatingTime);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}
	
	public void destory() {
		//Nothing
	}
}
