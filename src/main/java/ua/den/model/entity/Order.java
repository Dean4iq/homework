package ua.den.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private Integer price;
    private Timestamp orderDate;
    private Timestamp purchasingDate;
    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(Timestamp purchasingDate) {
        this.purchasingDate = purchasingDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!user.equals(order.user)) return false;
        if (!car.equals(order.car)) return false;
        if (!price.equals(order.price)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        if (!purchasingDate.equals(order.purchasingDate)) return false;
        return status.equals(order.status);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + car.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + purchasingDate.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", price=" + price +
                ", orderDate=" + orderDate +
                ", purchasingDate=" + purchasingDate +
                ", status=" + status +
                '}';
    }
}
