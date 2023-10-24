package com.pm05.Controller;

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
@WebServlet("/loadProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List <Category>cateList =null;
		String pid = request.getParameter("pid");
		int id = Integer.parseInt(pid);
		DBCrub db = new DBCrub();
		Product product = db.getProductByID(id );
		cateList = db.getAllCategory();
	    request.setAttribute("listCC", cateList);

		request.setAttribute("detail", product);
		request.getRequestDispatcher("/WEB-INF/view/Edit.jsp").forward(request, response);
		
	}

}
