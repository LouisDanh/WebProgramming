package models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {
    private static final long serialVersionUID = -8145256353326935319L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "TOTAL_AMOUNT", nullable = false)
    private Double totalAmount;

    // Ánh xạ với bảng ORDER_DETAILS
    @OneToOne
    @JoinColumn(name = "ORDER_DETAILS_ID")
    private OrderDetails orderDetails;

    // Ánh xạ với bảng CUSTOMER
    @ManyToOne
    @JoinColumn(name = "CUS_ID", nullable = false, insertable = false, updatable = false) // Sử dụng insertable = false và updatable = false
    private Customer customer;

    // Getter và Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
  
}
