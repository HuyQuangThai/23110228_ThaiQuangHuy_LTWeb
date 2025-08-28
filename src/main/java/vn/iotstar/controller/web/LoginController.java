package vn.iotstar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.servive.impl.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if (session != null && session.getAttribute("account") != null) {
    	response.sendRedirect(request.getContextPath()+ "/waiting");
    	return;
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
		 request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 boolean isRememberMe = false;
		 String remember = request.getParameter("remember");

		 if("on".equals(remember)){
		 isRememberMe = true;
		 }
		 String alertMsg="";
		 if(username.isEmpty() || password.isEmpty()){
			 alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			  request.setAttribute("alert", alertMsg);
			  request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			  return;
			  }
			  UserService service = new UserServiceImpl();
			  User user = service.login(username, password);
			 if(user!=null){
			  HttpSession session = request.getSession(true);
			  session.setAttribute("account", user);
			  if(isRememberMe){
			  saveRememberMe(response, username);
			  }
			  response.sendRedirect(request.getContextPath()+"/waiting");
			  }else{
			  alertMsg =
			 "Tài khoản hoặc mật khẩu không đúng";
			  request.setAttribute("alert", alertMsg);
			  request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			  }
		}
		private void saveRememberMe(HttpServletResponse response, String username) {
			Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
					 cookie.setMaxAge(30*60);
					 response.addCookie(cookie);
					 }
		}
