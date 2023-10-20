package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.pm05.Model.Category;
import com.pm05.Model.Product;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset= UTF-8");
	//lay category 
	String cateID = req.getParameter("cid");
     int id = Integer.parseInt(cateID);
     Connection conn = null;
     DBCrub crub =new DBCrub();
     conn  = MySQLConnection.getMySQLConnection();   
     List <Category>cateList =crub.getAllCategory(conn);
   	 List<Product> list = crub.getProductCateID( id,conn);  
    
     MySQLConnection.closeConnection(conn);
     //set data to jsp
     req.setAttribute("ListP", list);
     req.setAttribute("ListCate", cateList);
     
     req.getRequestDispatcher("/WEB-INF/view/Home.jsp").forward(req, resp);

	 
}
}
