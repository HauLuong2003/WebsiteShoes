package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.Model.Account;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {     
    	RequestDispatcher requestD =req.getRequestDispatcher("/WEB-INF/view/Login.jsp");
    	requestD.forward(req, resp);
    }
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   String user = req.getParameter("user");
           String pass = req.getParameter("pass");
           Connection conn = MySQLConnection.getMySQLConnection();
           DBCrub db = new DBCrub();
           Account acc = db.login(user, pass, conn);
           MySQLConnection.closeConnection(conn);
           if(acc == null) {
        	   req.setAttribute("mess", "User or password is incorrect");
        	   req.getRequestDispatcher("/WEB-INF/view/Login.jsp").forward(req, resp);;
           }
           else {
        	   HttpSession ses = req.getSession();
        	   ses.setAttribute("acc", acc);
        	  // ses.setMaxInactiveInterval(0);
        	   resp.sendRedirect("home");
           }
           
    }
}
