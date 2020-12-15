package accounts.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent account entity with JPA markup. Accounts are stored in an H2
 * relational database.
 *
 * @author Paul Chapman
 */
@Entity
@Table(name = "T_ACCOUNT")
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final AtomicLong nextId = new AtomicLong(0L);

  @Id
  private Long id;

  private String number;

  @Column(name = "name")
  private String owner;

  private BigDecimal balance;

  /**
   * Default constructor for JPA only.
   */
  protected Account() {
    balance = BigDecimal.ZERO;
  }

  public Account(String number, String owner) {
    id = getNextId();
    this.number = number;
    this.owner = owner;
    balance = BigDecimal.ZERO;
  }

  private static Long getNextId() {
    return nextId.addAndGet(1L);
  }

  public long getId() {
    return id;
  }

  /**
   * Set JPA id - for testing and JPA only. Not intended for normal use.
   *
   * @param id The new id.
   */
  protected void setId(long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  protected void setNumber(String accountNumber) {
    this.number = accountNumber;
  }

  public String getOwner() {
    return owner;
  }

  protected void setOwner(String owner) {
    this.owner = owner;
  }

  public BigDecimal getBalance() {
    return balance.setScale(2, RoundingMode.HALF_EVEN);
  }

  public void withdraw(BigDecimal amount) {
    balance = balance.subtract(amount);
  }

  public void deposit(BigDecimal amount) {
    balance = balance.add(amount);
  }

  @Override
  public String toString() {
    return number + " [" + owner + "]: $" + balance;
  }

}
