package vn.iotstar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ForgetCotroller
 */
@WebServlet("/forget")
public class ForgetCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/forget.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String alertMsg = "";
		String email_or_phone = request.getParameter("email_or_phone");
		if (service.checkExistEmail(email_or_phone) || service.checkExistPhone(email_or_phone)) {
			User user = service.get(email_or_phone);
			if (user != null) {
			String username = user.getUserName();
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/reset");
			}
		}
		else {
			alertMsg = "Email hoặc phone không tồn tại";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/forget.jsp").forward(request, response);
			return;
		}
	}

}
