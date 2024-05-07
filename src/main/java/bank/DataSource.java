package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("*** We're connected ***");
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return connection;
  }

  // New method to create a customer
  public static Customer getCustomer(String username) {
    String sql = "select * from Customers where username = ?";

    Customer customer = null;

    // Try with resources allows us to specify a set of parentheses and inside of
    // the parentheses
    // we can declare a closable resource.
    // Java will automatically close that resource for us after the try block has
    // been completed.
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {

      // Now we need to set the values for the placeholders within our query.
      // Prepared statement has a setter method that enables us to do so because
      // username's type
      // is a string, we can call set string.
      statement.setString(1, username);
      // To execute the query we'll use:
      try (ResultSet resultSet = statement.executeQuery()) {
        customer = new Customer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return customer;
  }

  // New method to create an account
  public static Account getAccount(int accountId) {

    String sql = "select * from accounts where id = ?";
    Account account = null;

    // Try with resources allows us to specify a set of parentheses and inside of
    // the parentheses
    // we can declare a closable resource.
    // Java will automatically close that resource for us after the try block has
    // been completed.
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {

      // Now we need to set the values for the placeholders within our query.
      // Prepared statement has a setter method that enables us to do so because
      // username's type
      // is a string, we can call set string.
      statement.setInt(1, accountId);
      // To execute the query we'll use:
      try (ResultSet resultSet = statement.executeQuery()) {
        account = new Account(
            resultSet.getInt("id"),
            resultSet.getString("type"),
            resultSet.getDouble("balance"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return account;

  }

  public static void main(String args[]) {
    // connect();
    Customer customer = getCustomer("ggallaherhm@newsvine.com");
    Account account = getAccount(customer.getAccountId());
    System.out.println(customer.getName());
    System.out.println(account.getBalance());
  }

}
