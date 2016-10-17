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
			
			//開始日と終了日をDate型へ変換する
			LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
			LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
			
			int count = 0;
			while(endDate.compareTo(startDate) >= 0) {
				if(!startDate.getDayOfWeek().toString().equals("SUNDAY") && 
				   !startDate.getDayOfWeek().toString().equals("SATURDAY")) {
					count = count + 1;
				}
				startDate = startDate.plusDays(1);
			}
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
