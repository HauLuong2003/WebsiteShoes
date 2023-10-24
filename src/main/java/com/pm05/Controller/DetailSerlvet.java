package com.pm05.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pm05.Model.Category;
import com.pm05.Model.Product;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

/**
 * Servlet implementation class DetailSerlvet
 */
@WebServlet("/detail")
public class DetailSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id = request.getParameter("pid");
     int Id = Integer.parseInt(id);
     DBCrub db = new DBCrub();
     Product product = db.getProductByID(Id);
     List<Category> listcate = db.getAllCategory();
     request.setAttribute("detail", product);
     request.setAttribute("ListCate", listcate);
     request.getRequestDispatcher("/WEB-INF/view/Detail.jsp").forward(request, response);
	}


}
