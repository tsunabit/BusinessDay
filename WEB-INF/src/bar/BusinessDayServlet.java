package bar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date startDate = null;
		Date endDate = null;
		
		try {
			if(request.getParameter("startDate").equals("")) {
				System.out.println("error start");
				
				request.setAttribute("InputError", "Start");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}else if(request.getParameter("endDate").equals("")) {
				System.out.println("error end");
				request.setAttribute("InputError", "End");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/InputError.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			
			//---------------------
			startDate = sdf.parse(request.getParameter("startDate"));
			System.out.println("startDate = " + startDate);
			endDate   = sdf.parse(request.getParameter("endDate"));
			System.out.println("endDate = " + endDate);
			
			
			//1970/01/01 00:00:00 GMTからの経過ミリ秒数に変換
			long dateTimeStart = startDate.getTime();
			long dateTimeEnd   = endDate.getTime();
			
			//HACK:
			//取得したミリ秒の差を日数に変更
			long dayDiff = ( dateTimeEnd - dateTimeStart  ) / (1000 * 60 * 60 * 24 ) + 1;
			Long ln = new Long(dayDiff);
			request.setAttribute("dayDiff", ln);
			
			//取得した日数の総時間を計算
			long totalOperatingTime = dayDiff * 8;
			request.setAttribute("totalOperatingTime", totalOperatingTime);
			
		} catch (ParseException e) {
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
