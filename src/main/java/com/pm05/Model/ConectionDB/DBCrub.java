package com.pm05.Model.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pm05.Model.Category;
import com.pm05.Model.Product;

public class DBCrub {
	 public static List<Product> getAllProduct( Connection conn) {
		    
	        List<Product> productlist = null;
	        String sql = "SELECT * FROM product";
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        productlist = new ArrayList<>();
	   
	       try {
	    	   new MySQLConnection();
			conn = MySQLConnection.getMySQLConnection();//mo ket noi sql
	    	   ps = conn.prepareStatement(sql);
	    	   rs = ps.executeQuery();
	    	   while(rs.next()) {
	    		  int id = rs.getInt("id");
	    		  String name = rs.getString("name");
	    		  String image = rs.getString("image");
	    		  Double price = rs.getDouble("price");
	    		  Product product = new Product(id,name,image,price);
	    		  productlist.add(product);
	    	   }
	       }
	       catch(Exception e1) {
	            e1.printStackTrace();

	       }       
	       return productlist;
	 }
	public static List<Category>getAllCategory(Connection conn){
		List<Category>cateList = new ArrayList<>();
		String sql ="SELECT * FROM category";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			new MySQLConnection();
			conn = MySQLConnection.getMySQLConnection();
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
	    while(rs.next()) {
	    	int cid =rs.getInt("cid");
	    	String cname =rs.getString("cname");
	    	Category cate = new Category(cid,cname);
	    	cateList.add(cate);
	    }
		}
		catch(Exception e2) {
            e2.printStackTrace();

		}
		return cateList;
		
	}
	
}
