package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DATE")
public class OrderDate implements Serializable {
  

	

	@Override
	public String toString() {
		return "OrderDate [id=" + id + ", date=" + date + ", orderState=" + orderState + ", orderDetails="
				+ orderDetails + "]";
	}

	private static final long serialVersionUID = -8948402251618130891L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "STATE_ID", nullable = false)
    private OrderState orderState;

  
    @ManyToOne
    @JoinColumn(name = "DETAILS_ID")  
    private OrderDetails orderDetails;

    // Getter và Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return  Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
