package com.pm05.Model.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pm05.Model.Account;
import com.pm05.Model.Category;
import com.pm05.Model.Product;

public class DBCrub {
	 static PreparedStatement ps = null;
	 static ResultSet rs = null;
	 public  List<Product> getAllProduct( Connection conn) {
		    
	        List<Product> productlist = new ArrayList<>();
	        String sql = "SELECT * FROM product";
	   
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
	    		  String describe =rs.getString("description");
	    		  String title =rs.getString("title");
	    		  Product product = new Product(id,name,image,price,describe,title);
	    		  productlist.add(product);
	    	   }
	       }
	       catch(Exception e1) {
	            e1.printStackTrace();

	       }       
	       finally {
	            try {
	                ps.close();
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        }
	       return productlist;
	 }
	public  List<Category>getAllCategory(Connection conn){
		List<Category>cateList = new ArrayList<>();
		String sql ="SELECT * FROM category";
		
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
		 finally {
	            try {
	                ps.close();
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        }
		return cateList;
		
	}
	public List<Product> getProductCateID(int cateID,Connection conn){
		List<Product> listCate = new ArrayList<>();
		String sql = "SELECT * FROM product where cateID = ?";
		try {
			new MySQLConnection();
		    conn = MySQLConnection.getMySQLConnection(); 
		    ps = conn.prepareStatement(sql);
		    ps.setInt(1,cateID);
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	 int id = rs.getInt("id");
	    		  String name = rs.getString("name");
	    		  String image = rs.getString("image");
	    		  Double price = rs.getDouble("price");
	    		  String describe =rs.getString("description");
	    		  String title =rs.getString("title");
	    		  Product product = new Product(id,name,image,price,describe,title);   
	    		  listCate.add(product);
		    }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		 finally {
	            try {
	                ps.close();
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        }
		return listCate;
		
	}
	//ket noi database lay san pham theo id
	
    public Product getProductByID(int ID ) {
		String sql ="SELECT * FROM product where id =?";
		  Product product = null;
		try {
			new MySQLConnection();
			Connection  conn = MySQLConnection.getMySQLConnection(); 
		    ps =conn.prepareStatement(sql);
            ps.setInt(1, ID);
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	  int id = rs.getInt("id");
	    		  String name = rs.getString("name");
	    		  String image = rs.getString("image");
	    		  Double price = rs.getDouble("price");
	    		  String describe =rs.getString("description");
	    		  String title =rs.getString("title");
	    		  product=  new Product(id,name,image,price,describe,title);
		    }
		}
    	catch(Exception e3) {
    		e3.printStackTrace();
    	}
		 finally {
	            try {
	                ps.close();
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        }
    	return product;

    	
    }
    // ket noi database lay ten san pham tim kiem
	public List<Product> getProductByName(String search,Connection conn){
		List<Product> listName = new ArrayList<>();
		String sql = "SELECT * FROM product where name like ?";
		try {
		   new MySQLConnection();
		   conn = MySQLConnection.getMySQLConnection();
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, "%"+search+"%");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   int id = rs.getInt("id");
	    		  String name = rs.getString("name");
	    		  String image = rs.getString("image");
	    		  Double price = rs.getDouble("price");
	    		  String describe =rs.getString("description");
	    		  String title =rs.getString("title");
	    		  Product  product =  new Product(id,name,image,price,describe,title);
	    		listName.add(product);
		   }
		}
		catch(Exception e4) {
			e4.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
			}
			catch(SQLException  e) {
				
			}
		}
		return listName;
				
	}
	
	// ket noi database account
    public Account login (String user, String pass,Connection conn) {
    	Account acc =null;
		String sql = "SELECT * FROM account where user = ? and pass =?";
		try {
			//new MySQLConnection();
		    conn = MySQLConnection.getMySQLConnection();
		    ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idAccount");
				String users = rs.getString("user");
				String pass1 = rs.getString("pass");
				int customer = rs.getInt("customer");
				int ad = rs.getInt("admin");
				acc= new Account (id,users,pass1,customer,ad);
					
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
			ps.close();
			rs.close();
			}
			catch(SQLException e) {				
			}			
		}		
    	return acc; 	
    }
    public void SignUp(String user, String pass, Connection conn)
    {
    	
    	String sql ="INSERT INTO account  values(?,?,1,0)";
    	try {
    		conn = MySQLConnection.getMySQLConnection();
    		ps = conn.prepareStatement(sql);
    		ps.setString(1,user);
    		ps.setString(2, pass);
    	     ps.executeUpdate();
    		
    	}
    	catch(Exception e1) {
    		
    	}finally {
    		try {
    			ps.close();
    		}
    		catch(SQLException e1) {
    			
    		}
    	}
 
}
    public Account CheckAccountExist(String user, Connection conn) {
    	Account acc = null;
    	String sql = "SELECT * FROM  account where user =?";
    	try {
    		conn = MySQLConnection.getMySQLConnection();
    		ps = conn.prepareStatement(sql);
    		ps.setString(1, "user");
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			int id = rs.getInt("idAccount");
				String users = rs.getString("user");
				String pass1 = rs.getString("pass");
				int customer = rs.getInt("customer");
				int ad = rs.getInt("admin");
				 new Account (id,users,pass1,customer,ad);
    		}
    	}
    	catch(Exception e1) {
    		e1.printStackTrace();
    	}
    	return acc;
    }
    public void DeleteProduct(int pid, Connection conn) {
    	String sql ="DELETE FROM product where id =?";
    	
    	try {
//    		 conn = MySQLConnection.getMySQLConnection();
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1, pid);
    		ps.execute();
    	}
    	catch(Exception e1) {
    		e1.printStackTrace();
    	}
    }
     public void InsertProduct(String name, String image, String price, 
    		 String title, String description ,String category) {
    	 String  sql ="INSERT INTO product (name,image,price,title,description,cateID)values(?,?,?,?,?,?)";
    	 try {
    		 new MySQLConnection();
			Connection conn = MySQLConnection.getMySQLConnection();
    		 ps = conn.prepareStatement(sql);
    		 ps.setString(1,name);
    		 ps.setString(2,image);
    		 ps.setString(3,price);
    		 ps.setString(4,title);
    		 ps.setString(5,description);
    		 ps.setString(6,category);
             ps.executeUpdate();
    		 
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     public void UpdateProduct(String name, String image, String price, 
    		 String title, String description ,String category, String pid) {
    	 String sql ="UPDATE product SET name = ?, image = ?, price = ?, title = ?, description =?, cateID = ? where id =?";
    	 
    	 try {
    		 new MySQLConnection();
    		 Connection conn = MySQLConnection.getMySQLConnection();
    		 ps = conn.prepareStatement(sql);
    		 ps.setString(1,name);
    		 ps.setString(2,image);
    		 ps.setString(3,price);
    		 ps.setString(4,title);
    		 ps.setString(5,description);
    		 ps.setString(6,category);
    		 ps.setString(7,pid);
             ps.executeUpdate();
    		 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
}
