package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.Model.Account;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("txt/html; charset =UTF-8");
	String user = req.getParameter("user");
	String pass = req.getParameter("pass");
	String re_pass = req.getParameter("repass");
	if(!pass.equals(re_pass)) {
		resp.sendRedirect("home");
	}
	else {
		DBCrub db = new DBCrub();
		Connection conn = MySQLConnection.getMySQLConnection();
		Account acc = db.CheckAccountExist(user, conn);
		if (acc == null) {
			db.SignUp(user, pass, conn);
			resp.sendRedirect("home");
		}
		else {
			resp.sendRedirect("/WEB-INF/view/Login.jsp");
		}
	}
	}
}
