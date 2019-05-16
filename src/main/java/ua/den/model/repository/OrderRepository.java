package ua.den.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.den.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
