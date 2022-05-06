package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import entity.Book;
import entity.Cd;
import entity.Cosmetics;
import entity.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Optional<Product> getProduct(int category, int typeOfCategory) {
		PreparedStatement preparedStatement=null;
		Product product=null;
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiley233","root","wiley")){
			Class.forName("com.mysql.cj.jdbc.Driver");

			preparedStatement=connection.prepareStatement("select productId,productName,noOfItems,price from product where category=? and typeOfcategory=?");
			preparedStatement.setInt(1,category);
			preparedStatement.setInt(2, typeOfCategory);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next()) {
				int id=result.getInt(1);
				String name=result.getString(2);
				int quantity=result.getInt(3);
				double price=result.getDouble(4);
				switch(category) {
				case 1:product=new Book(id,name, quantity, price);break;
				case 2:product=new Cd(id,name, quantity, price);break;
				case 3:product=new Cosmetics(id,name, quantity, price);break;
				default:System.out.println("Not available");break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Optional<Product> optional=Optional.ofNullable(product);
		return optional;

	}

	@Override
	public int updateProductInventory(int category,int typeOfCategory,int updatedQuantity) {
		PreparedStatement preparedStatement=null;
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiley233","root","wiley")){
			Class.forName("com.mysql.cj.jdbc.Driver");

			preparedStatement=connection.prepareStatement("update product set noOfItems=? where category=? and typeOfCategory=?");
			preparedStatement.setInt(1,updatedQuantity);
			preparedStatement.setInt(2,category);
			preparedStatement.setInt(3,typeOfCategory);
			int rows=preparedStatement.executeUpdate();
			return rows;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
