package com.pm05.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.pm05.Model.Category;
import com.pm05.Model.Product;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		DBCrub db = new DBCrub();
		
	    String search = request.getParameter("txt");
	    Connection conn = MySQLConnection.getMySQLConnection();
	    List<Product> ListName = db.getProductByName(search,conn);
	    List<Category> listcate =db.getAllCategory(conn);
	    MySQLConnection.closeConnection(conn);
	    request.setAttribute("ListP", ListName);
	    request.setAttribute("ListCate",listcate );
	    request.setAttribute("txtS", search);
	    request.getRequestDispatcher("/WEB-INF/view/Home.jsp").forward(request, response);
	}




}
