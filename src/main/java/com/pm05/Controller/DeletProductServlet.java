package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeletProductServlet  extends HttpServlet{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pid = req.getParameter("pid");
	int id = Integer.parseInt(pid);
	Connection conn = MySQLConnection.getMySQLConnection();	
	DBCrub db = new DBCrub();
	db.DeleteProduct(id,conn);
	MySQLConnection.closeConnection(conn);
	resp.sendRedirect("manager");
	
}
}
