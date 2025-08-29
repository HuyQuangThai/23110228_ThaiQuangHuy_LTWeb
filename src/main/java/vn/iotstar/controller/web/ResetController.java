package vn.iotstar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ResetController
 */
@WebServlet("/reset")
public class ResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/reset.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String new_password = request.getParameter("password");
		String new_confirm_password = request.getParameter("confirm_password");
		String alertMsg="";
		if (!new_password.equals(new_confirm_password)) {
			alertMsg = "Mật khẩu không khớp nhau";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/reset.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		UserService service = new UserServiceImpl();
		service.reset(username, new_password);
		alertMsg = "Reset mật khẩu thành công";
		request.setAttribute("alert", alertMsg);
		response.sendRedirect(request.getContextPath() + "/login");
	}
	
}
