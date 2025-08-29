package vn.iotstar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.User;

import java.io.IOException;

/**
 * Servlet implementation class WaitingController
 */
@WebServlet("/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WaitingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null)
			if (session != null && session.getAttribute("account") != null) {
				User u = (User) session.getAttribute("account");
				request.setAttribute("username", u.getUserName());
				if (u.getRoleid() == 1) {
					response.sendRedirect(request.getContextPath() + "/admin/home");
				} else if (u.getRoleid() == 2) {
					response.sendRedirect(request.getContextPath() + "/manager/home");
				} else {
					String username = request.getAttribute("username").toString();
					session.setAttribute("username", username);
					response.sendRedirect(request.getContextPath() + "/home");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
