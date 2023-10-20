package com.pm05.Controller;

import java.io.IOException;

import com.pm05.Model.Product;
import com.pm05.Model.ConectionDB.DBCrub;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset = UTF-8");
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String category = req.getParameter("category");
		
		DBCrub db = new DBCrub();
	    db.InsertProduct(name, image, price, title, description, category);
	    resp.sendRedirect("manager");
	}
}
