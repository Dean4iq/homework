package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.entity.Order;
import ua.den.model.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getListOfUnresolvedOrders() {
        return orderRepository.findAllByStatusOrderOrderByOrderDateAsc(false);
    }

    public List<Order> getOrdersListForUser(String login) {
        return orderRepository.findAllByUserLoginOrderByOrderDateAsc(login);
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }
}
