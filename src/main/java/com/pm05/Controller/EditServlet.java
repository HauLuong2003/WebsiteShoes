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
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	    
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String category = request.getParameter("category"); 
		String id = request.getParameter("id");
		DBCrub db = new DBCrub();
		
		db.UpdateProduct(name, image, price, title, description, category, id);
		response.sendRedirect("manager");
	}

}
