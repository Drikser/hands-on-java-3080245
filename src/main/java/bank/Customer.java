package bank;

public class Customer {

  private int id; // private = can't be accessed outside of this class (=encapsulation)
  private String name;
  private String username;
  private String password;
  private int accountId;
  private boolean authenticated;

  // constructor
  public Customer(int id, String name, String username, String password, int accountId) {

    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccountId(accountId);
    setAuthenticated(false);
  }

  // setters and getters
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public boolean isAuthenticated() {
    return this.authenticated;
  }

  // For a boolean, we usually use the "is" method, so we can comment the "get"
  // method out
  // public boolean getAuthenticated() {
  // return this.authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

}
