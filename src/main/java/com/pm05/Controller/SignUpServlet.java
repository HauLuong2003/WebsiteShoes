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
	resp.setContentType("text/html; charset =UTF-8");
	String user = req.getParameter("user");
	String pass = req.getParameter("pass");
	String re_pass = req.getParameter("repass");
	DBCrub db = new DBCrub();
	if(!pass.equals(re_pass)) {
		req.setAttribute("mess1", "password and repeat password in correct");
		resp.sendRedirect("login");
	}
	else {
		Account acc = db.CheckAccountExist(user);
		if (acc == null) {
			db.SignUp(user, pass);
			resp.sendRedirect("login");
		}
		else {
			req.setAttribute("mess1", "username exist");
			resp.sendRedirect("login");
		}
	}
	}
}
