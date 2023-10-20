package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.pm05.Model.Category;
import com.pm05.Model.Product;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   @SuppressWarnings("static-access")
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=UTF-8");
       DBCrub crub = new DBCrub();
       Connection conn = null;
       List <Category>cateList =null;
       List<Product> productList = null;
       conn = MySQLConnection.getMySQLConnection();    
       productList = crub.getAllProduct(conn);
       cateList = crub.getAllCategory(conn);
       MySQLConnection.closeConnection(conn);
       //set data to jsp
       req.setAttribute("ListP", productList);
       req.setAttribute("ListCate", cateList);
       req.getRequestDispatcher("/WEB-INF/view/Home.jsp").forward(req, resp);


}
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       super.doPost(req, resp);
   }

 
}

