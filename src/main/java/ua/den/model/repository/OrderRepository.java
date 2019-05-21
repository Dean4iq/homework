package ua.den.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.den.model.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM user_order " +
            "WHERE status = ?1 " +
            "ORDER BY order_date ASC;", nativeQuery = true)
    List<Order> findByStatusOrderByOrderDateAsc(Byte status);
    List<Order> findAllByUserLoginOrderByOrderDateAsc(String login);
}
