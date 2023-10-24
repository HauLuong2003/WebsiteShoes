package com.pm05.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pm05.Model.ConectionDB.DBCrub;

/**
 * Servlet implementation class DeleteAccountServlet
 */
@WebServlet("/deleteaccount")
public class DeleteAccountServlet  extends HttpServlet{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String aid = req.getParameter("aid");
	int id = Integer.parseInt(aid);
	DBCrub db = new DBCrub();
	db.DeleteAccount(id);
	resp.sendRedirect("managertk");
	
}
}
