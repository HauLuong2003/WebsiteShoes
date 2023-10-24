package com.pm05.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.pm05.Model.Account;
import com.pm05.Model.ConectionDB.DBCrub;
import com.pm05.Model.ConectionDB.MySQLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/managertk")
public class ManagerAccount extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		DBCrub crub = new DBCrub();
	       Connection conn = null;
		   List<Account>accountlist = null;
           conn = MySQLConnection.getMySQLConnection();    
           accountlist = crub.getAllAccounts(conn);
	       MySQLConnection.closeConnection(conn);
	       //set data to jsp   
           req.setAttribute("listacc", accountlist);
		   req.getRequestDispatcher("/WEB-INF/view/ManagerAccount.jsp").forward(req, resp);
    }
}