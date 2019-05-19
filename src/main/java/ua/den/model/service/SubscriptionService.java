package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.entity.Subscription;
import ua.den.model.repository.SubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void addNewSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    public List<Subscription> getSubscriporsByCarId(Long carId) {
        return subscriptionRepository.findAllByCarId(carId);
    }

    public List<Subscription> getSubscriptionsByUser(String login) {
        return subscriptionRepository.findAllByUserLogin(login);
    }
}
