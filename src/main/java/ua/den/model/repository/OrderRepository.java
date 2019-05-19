package ua.den.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.den.model.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatusOrderOrderByOrderDateAsc(boolean status);
    List<Order> findAllByUserLoginOrderByOrderDateAsc(String login);
}
