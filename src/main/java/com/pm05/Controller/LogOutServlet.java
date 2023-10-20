package com.pm05.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogOutServlet  extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html; charset = UTF-8");
	HttpSession ses = req.getSession();
	ses.removeAttribute("acc");
	resp.sendRedirect("home");
}
}
