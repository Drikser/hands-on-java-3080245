package bank;

public class Account {

  private int id; // private = can't be accessed outside of this class (=encapsulation)
  private String type;
  private double balance;

  // constructor
  public Account(int id, String type, double balance) {
    // And in the constructor, we call the set methods
    setId(id);
    setType(type);
    setBalance(balance);
  }

  // getters and setters
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

}
