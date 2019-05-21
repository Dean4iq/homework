package ua.den.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Car car;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return getUser().equals(that.getUser()) &&
                getCar().equals(that.getCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getCar());
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "user=" + user +
                ", car=" + car +
                '}';
    }
}
