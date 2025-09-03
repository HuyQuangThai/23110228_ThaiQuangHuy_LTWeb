package vn.iotstar.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CategoryCatroller
 */
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add",
		"/admin/category/insert","/admin/category/edit","/admin/category/update",
		"/admin/category/delete","/admin/category/search"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ICategoryService cateService = new CategoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (url.contains("categories")) {
			List<CategoryModel> list = cateService.findAll();
			request.setAttribute("listcate", list);
			request.getRequestDispatcher("/views/admin/category-list.jsp").forward(request, response);
		} else if (url.contains("add")) {
			request.getRequestDispatcher("/views/admin/category-add.jsp").forward(request, response);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryModel category = cateService.findById(id);
			request.setAttribute("cate", category);
			request.getRequestDispatcher("/views/admin/category-edit.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			cateService.delete(id);
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (url.contains("insert")) {
			String categoryname = request.getParameter("categoryname");
			String status = request.getParameter("status");
			int statuss = Integer.parseInt(status);
			String images = "https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_9__4_103.png";
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setImages(images);
			category.setStatus(statuss);
			cateService.insert(category);
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		} else if (url.contains("update")) {
			int categoryid = Integer.parseInt(request.getParameter("categoryid"));
			String categoryname = request.getParameter("categoryname");
			String status = request.getParameter("status");
			int statuss = Integer.parseInt(status);
			String images = "https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/e/text_ng_n_9__4_103.png";
			CategoryModel category = new CategoryModel();
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setImages(images);
			category.setStatus(statuss);
			cateService.update(category);
			response.sendRedirect(request.getContextPath() + "/admin/categories");
		}
	}

}
