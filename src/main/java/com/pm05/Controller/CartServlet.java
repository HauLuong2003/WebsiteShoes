package com.pm05.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pm05.Model.Cart;
import com.pm05.Model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/GioHangServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private List<Cart> cart = new ArrayList<Cart>();

	@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	  
		doPost(req, resp);  
  }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String command = request.getParameter("command");
	        String id = request.getParameter("id");
	        String productname = request.getParameter("name");
	        String productprice = request.getParameter("price");
	        String img = request.getParameter("image");

	        double price = 0.0;
	        if (productprice != null && !productprice.trim().isEmpty()) {
	            price = Double.parseDouble(productprice);
	        }

	        if (command != null) {
	            if (command.equals("addCart")) {
	                Product p = new Product(Integer.parseInt(id), productname, img, price, "", "");
	                addToCart(p);
	                HttpSession session = request.getSession();
	                System.out.println(cart.size());
	                session.setAttribute("cart", cart);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Cart.jsp");
	                dispatcher.forward(request, response);
	            }
	            else if(command.equals("removeFromCart")){
	                Product p = new Product(Integer.parseInt(id),productname,img,price,"","");
	                removeFromCart(p);
	                HttpSession session = request.getSession();
	                session.setAttribute("cart", cart);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Cart.jsp");
	                dispatcher.forward(request, response);
	            }
	            else if(command.equals("deleteCart")){
	                Product p = new Product(Integer.parseInt(id),productname,img,price,"","");
	                deleteFromCart(p);
	                HttpSession session = request.getSession();
	                System.out.println(cart.size());
	                session.setAttribute("cart", cart);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Cart.jsp");
	                dispatcher.forward(request, response);
	            }
	            else if(command.equals("setCart")){
	                Product p = new Product(Integer.parseInt(id),productname,img,price,"","");
	                setCart(p,Integer.parseInt((String)request.getParameter("soluong")));
	                HttpSession session = request.getSession();
	                session.setAttribute("cart", cart);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/Cart.jsp");
	                dispatcher.forward(request, response);
	            }
	        }
	    }

	    private void addToCart(Product p) {
	        for (Cart item : cart) {
	            if (item.getP().getId() == p.getId()) {
	                item.setQuantity(item.getQuantity() + 1);
	                return; // Kết thúc phương thức ở đây, không cần trả về bất kỳ giá trị nào.
	            }
	        }
	        Cart c = new Cart();
	        c.setP(p);
	        c.setQuantity(1);
	        cart.add(c);
	    }
	    private String removeFromCart(Product p) {
	        for(Cart item: cart){
	            if(item.getP().getId() == p.getId()){
	            cart.remove(item);
	            return "cart";
	            }
	        }
	        return "cart";
	    }
	    private void setCart(Product p, int s) {
	        boolean isFound = false;
	        for(Cart item: cart){
	            if(item.getP().getId() == p.getId()){
	                item.setQuantity(item.getQuantity() + s);
	                isFound = true;
	                break;
	            }
	        }
	        if(!isFound){
	        Cart c = new Cart();
	        c.setP(p);
	        c.setQuantity(s);
	        cart.add(c);
	        }
	}
	public String deleteFromCart(Product p) {
	    for (Cart item : cart) {
	        if (item.getP().getId() == p.getId() && item.getQuantity()>1) {
	            item.setQuantity(item.getQuantity() - 1);
	            return "cart";
	        }
	    }
	    return "cart";
	}
	}
