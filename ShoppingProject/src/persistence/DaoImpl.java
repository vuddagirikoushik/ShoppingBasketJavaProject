package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import entity.Customer;

public class DaoImpl implements Dao {

	@Override
	public int createCustomerId(Customer customer) {
		PreparedStatement preparedStatement=null;
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiley233","root","wiley")){
			Class.forName("com.mysql.cj.jdbc.Driver");

			preparedStatement=connection.prepareStatement("insert into customer values(?,?,?,?,?)");
			preparedStatement.setInt(1,customer.getCustomerId());
			preparedStatement.setString(2,customer.getCustomerName());
			preparedStatement.setString(3,customer.getAddress());
			preparedStatement.setString(4,customer.getCustomerNumber());
			preparedStatement.setString(5,customer.getPassword());
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

	@Override
	public Optional<Customer> checkCustomer(int customerId) {
		PreparedStatement preparedStatement=null;
		Customer customer=null;
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiley233","root","wiley")){
			Class.forName("com.mysql.cj.jdbc.Driver");

			preparedStatement=connection.prepareStatement("select * from customer where customerId=?");
			preparedStatement.setInt(1,customerId);
			ResultSet result=preparedStatement.executeQuery();
			if(result.next()) {
				int id=result.getInt(1);
				String name=result.getString(2);
				String address=result.getString(3);
				String number=result.getString(4);
				String pass=result.getString(5);
				customer=new Customer(id, name, address, number,pass);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Optional<Customer> optional=Optional.ofNullable(customer);
		return optional;
	}

	
	
}
